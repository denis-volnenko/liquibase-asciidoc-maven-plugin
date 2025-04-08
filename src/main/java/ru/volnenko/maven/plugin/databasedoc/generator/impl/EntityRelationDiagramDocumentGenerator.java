package ru.volnenko.maven.plugin.databasedoc.generator.impl;

import lombok.NonNull;
import lombok.SneakyThrows;
import ru.volnenko.maven.plugin.databasedoc.enumerated.ErdRender;
import ru.volnenko.maven.plugin.databasedoc.enumerated.ErdType;
import ru.volnenko.maven.plugin.databasedoc.generator.IEntityRelationDiagramDocumentGenerator;
import ru.volnenko.maven.plugin.databasedoc.model.impl.*;
import ru.volnenko.maven.plugin.databasedoc.util.ForeignKeyUtil;
import ru.volnenko.maven.plugin.databasedoc.util.PrimaryKeyUtil;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class EntityRelationDiagramDocumentGenerator extends AbstractGenerator implements IEntityRelationDiagramDocumentGenerator {

    @NonNull
    private EntityRelationDiagramColumnWrapperGenerator columnWrapperGenerator = new EntityRelationDiagramColumnWrapperGenerator();

    @NonNull
    private List<Root> roots = Collections.emptyList();

    @NonNull
    private ErdType erdType = ErdType.PHYSIC;

    @Override
    @NonNull
    public EntityRelationDiagramDocumentGenerator erdType(@NonNull final ErdType erdType) {
        this.erdType = erdType;
        return this;
    }

    @Override
    @NonNull
    public ErdType erdType() {
        return erdType;
    }

    @Override
    @NonNull
    public EntityRelationDiagramDocumentGenerator physic() {
        this.erdType = ErdType.PHYSIC;
        return this;
    }

    @Override
    @NonNull
    public EntityRelationDiagramDocumentGenerator logic() {
        this.erdType = ErdType.LOGIC;
        return this;
    }

    private void generate(@NonNull StringBuilder stringBuilder, @NonNull final Root root) {
        final List<DatabaseChangeLog> databaseChangeLog = root.getDatabaseChangeLog();
        if (databaseChangeLog == null) return;
        for (DatabaseChangeLog item : databaseChangeLog) generate(stringBuilder, item);
    }

    private void generate(@NonNull StringBuilder stringBuilder, final DatabaseChangeLog databaseChangeLog) {
        if (databaseChangeLog == null) return;
        generate(stringBuilder, databaseChangeLog.getChangeSet());
    }

    private void generate(@NonNull StringBuilder stringBuilder, final ChangeSet changeSet) {
        if (changeSet == null) return;
        for (Change change : changeSet.getChanges()) generate(stringBuilder, change);
    }

    private void generate(@NonNull StringBuilder stringBuilder, final Change change) {
        if (change == null) return;
        final CreateTable createTable = change.getCreateTable();
        if (createTable == null) return;
        columnWrapperGenerator
                .erdType(erdType)
                .createTable(createTable)
                .columnWrappers(createTable.getColumns())
                .append(stringBuilder);
    }

    @NonNull
    @Override
    public IEntityRelationDiagramDocumentGenerator roots(@NonNull final List<Root> roots) {
        this.roots = roots;
        return this;
    }

    @NonNull
    private ErdRender erdRender = ErdRender.INTERNAL;

    @NonNull
    @Override
    public IEntityRelationDiagramDocumentGenerator internal() {
        erdRender = ErdRender.INTERNAL;
        return this;
    }

    @NonNull
    @Override
    public IEntityRelationDiagramDocumentGenerator external() {
        erdRender = ErdRender.EXTERNAL;
        return this;
    }

    @NonNull
    @Override
    @SneakyThrows
    public StringBuilder append(@NonNull StringBuilder stringBuilder) {
        @NonNull final Set<PK> pks = PrimaryKeyUtil.pks(roots);
        @NonNull final Set<FK> fks = ForeignKeyUtil.fks(roots);
        stringBuilder.append("@startuml \n");
        if (erdRender.isInternal()) {
            stringBuilder.append("!pragma graphviz_dot jdot \n");
            stringBuilder.append("'!pragma layout smetana \n");
        }
        if (erdRender.isExternal()) {
            stringBuilder.append("'!pragma graphviz_dot jdot \n");
            stringBuilder.append("!pragma layout smetana \n");
        }
        for (@NonNull final Root root : roots) generate(stringBuilder, root);

        for (final FK fk : fks) {
            if (fk == null) continue;
            if (!pks.contains(fk.getPk())) continue;
            if (fk.getUnique()) {
                stringBuilder.append("\"" + fk.getTableName() + "\"" + " ||--|| " + "\"" + fk.getPk().getTableName() + "\"" + "\n");
            } else {
                stringBuilder.append("\"" + fk.getTableName() + "\"" + " }--|| " + "\"" + fk.getPk().getTableName() + "\"" + "\n");
            }
        }
        stringBuilder.append("\n");
        stringBuilder.append("@enduml");
        stringBuilder.append("\n");
        return stringBuilder;
    }

}
