package ru.volnenko.maven.plugin.databasedoc.generator;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.model.*;

import java.util.Collections;
import java.util.List;

public final class EntityRelationDiagramDocumentGenerator extends AbstractGenerator {

    @NonNull
    private EntityRelationDiagramColumnWrapperGenerator columnWrapperGenerator = new EntityRelationDiagramColumnWrapperGenerator();

    @NonNull
    private List<Root> roots = Collections.emptyList();

    @NonNull
    public EntityRelationDiagramDocumentGenerator roots(@NonNull final List<Root> roots) {
        this.roots = roots;
        return this;
    }

    private void generate(@NonNull StringBuilder stringBuilder, @NonNull final Root root) {
        final DatabaseChangeLog databaseChangeLog = root.getDatabaseChangeLog();
        if (databaseChangeLog == null) return;
        final List<ChangeSet> changeSet = databaseChangeLog.getChangeSet();
        if (changeSet == null) return;
        for (final ChangeSet item : changeSet) generate(stringBuilder, item);
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
                .createTable(createTable)
                .columnWrappers(createTable.getColumns())
                .append(stringBuilder);
    }

    @NonNull
    @Override
    public StringBuilder append(@NonNull StringBuilder stringBuilder) {
        stringBuilder.append("@startuml \n");
        stringBuilder.append("!pragma graphviz_dot jdot \n");
        stringBuilder.append("'!pragma layout smetana \n");
        for (@NonNull final Root root : roots) generate(stringBuilder, root);
        stringBuilder.append("\n");
        stringBuilder.append("@enduml");
        stringBuilder.append("\n");
        return stringBuilder;
    }

}
