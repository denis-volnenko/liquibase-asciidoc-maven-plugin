package ru.volnenko.maven.plugin.databasedoc.generator.impl;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.generator.ICreateTableDocumentGenerator;
import ru.volnenko.maven.plugin.databasedoc.model.*;

import java.util.Collections;
import java.util.List;

public final class CreateTableDocumentGenerator extends AbstractGenerator implements ICreateTableDocumentGenerator {

    @NonNull
    private final ColumnWrapperGenerator columnWrapperGenerator = new ColumnWrapperGenerator();

    @NonNull
    private final CreateTableGenerator createTableGenerator = new CreateTableGenerator();

    @NonNull
    private List<Root> roots = Collections.emptyList();

    @NonNull
    private String serviceName = "";

    @NonNull
    private String dataBaseInfo = "";

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
        createTableGenerator
                .dataBaseInfo(dataBaseInfo)
                .serviceName(serviceName)
                .createTable(createTable)
                .append(stringBuilder);
        columnWrapperGenerator
                .columnWrappers(createTable.getColumns())
                .append(stringBuilder);
    }

    @NonNull
    @Override
    public CreateTableDocumentGenerator dataBaseInfo(@NonNull final String dataBaseInfo) {
        this.dataBaseInfo = dataBaseInfo;
        return this;
    }

    @NonNull
    @Override
    public CreateTableDocumentGenerator serviceName(@NonNull final String serviceName) {
        this.serviceName = serviceName;
        return this;
    }

    @NonNull
    @Override
    public CreateTableDocumentGenerator roots(@NonNull final List<Root> roots) {
        this.roots = roots;
        return this;
    }

    @NonNull
    @Override
    public StringBuilder append(@NonNull final StringBuilder stringBuilder) {
        for (@NonNull final Root root : roots) generate(stringBuilder, root);
        return stringBuilder;
    }

}
