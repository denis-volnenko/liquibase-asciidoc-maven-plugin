package ru.volnenko.maven.plugin.databasedoc.generator.impl;

import lombok.NonNull;
import lombok.SneakyThrows;
import ru.volnenko.maven.plugin.databasedoc.generator.IEntityRelationDiagramDocumentGenerator;
import ru.volnenko.maven.plugin.databasedoc.model.impl.*;
import ru.volnenko.maven.plugin.databasedoc.util.ColumnUtil;
import ru.volnenko.maven.plugin.databasedoc.util.ForeignKeyUtil;
import ru.volnenko.maven.plugin.databasedoc.util.MapperUtil;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class EntityRelationDiagramDocumentGenerator extends AbstractGenerator implements IEntityRelationDiagramDocumentGenerator {

    @NonNull
    private EntityRelationDiagramColumnWrapperGenerator columnWrapperGenerator = new EntityRelationDiagramColumnWrapperGenerator();

    @NonNull
    private List<Root> roots = Collections.emptyList();

    private void generate(@NonNull StringBuilder stringBuilder, @NonNull final Root root) {
        final List<DatabaseChangeLog> databaseChangeLog = root.getDatabaseChangeLog();
        if (databaseChangeLog == null) return;
        for (DatabaseChangeLog item: databaseChangeLog) generate(stringBuilder, item);
    }

    private void generate(@NonNull StringBuilder stringBuilder, final DatabaseChangeLog databaseChangeLog) {
        if (databaseChangeLog == null) return;
        generate(stringBuilder, databaseChangeLog.getChangeSet());
    }

    private void generate(@NonNull StringBuilder stringBuilder, final ChangeSet changeSet) {
        if (changeSet == null) return;
        for (Change change : changeSet.getChanges()) generate(stringBuilder, change);
    }

    @NonNull
    private Set<PK> pks = new LinkedHashSet<>();

    @NonNull
    private Set<FK> fks = new LinkedHashSet<>();

    @NonNull
    private EntityRelationDiagramDocumentGenerator processFK(final Change change) {
        if (change == null) return this;
        if (change.getAddForeignKeyConstraint() == null) return this;
        final FK fk = ForeignKeyUtil.fk(change.getAddForeignKeyConstraint());
        if (fk != null) fks.add(fk);
        return this;
    }

    private void generate(@NonNull StringBuilder stringBuilder, final Change change) {
        processFK(change);

        if (change == null) return;
        final CreateTable createTable = change.getCreateTable();
        if (createTable == null) return;
        columnWrapperGenerator
                .createTable(createTable)
                .columnWrappers(createTable.getColumns())
                .append(stringBuilder);

        final String tableName = createTable.getTableName();
        if (tableName == null || tableName.isEmpty()) return;

        for (final ColumnWrapper columnWrapper: createTable.getColumns()) {
            final Column column = columnWrapper.getColumn();
            if (column == null) continue;
            final String name = ColumnUtil.getName(column);

            if (name != null && !name.isEmpty())
                if (column.getConstraints() != null)
                    if (column.getConstraints().getPrimaryKey() != null)
                        if (column.getConstraints().getPrimaryKey())
                            pks.add(new PK(tableName, name));

            final FK fk = ForeignKeyUtil.fk(tableName, column);
            if (fk == null) continue;
            fks.add(fk);
        }
    }

    @NonNull
    @Override
    public IEntityRelationDiagramDocumentGenerator roots(@NonNull final List<Root> roots) {
        this.roots = roots;
        return this;
    }

    @NonNull
    @Override
    @SneakyThrows
    public StringBuilder append(@NonNull StringBuilder stringBuilder) {
        stringBuilder.append("@startuml \n");
        stringBuilder.append("!pragma graphviz_dot jdot \n");
        stringBuilder.append("'!pragma layout smetana \n");
        for (@NonNull final Root root : roots) generate(stringBuilder, root);

        for (final FK fk: fks) {
            if (fk == null) continue;
            if (!pks.contains(fk.getPk())) continue;
            if (fk.getUnique()) {
                stringBuilder.append(fk.getTableName() + " ||--|| " + fk.getPk().getTableName() + "\n");
            } else {
                stringBuilder.append(fk.getTableName() + " }--|| " + fk.getPk().getTableName() + "\n");
            }
        }

        stringBuilder.append("\n");
        stringBuilder.append("@enduml");
        stringBuilder.append("\n");
        return stringBuilder;
    }

}
