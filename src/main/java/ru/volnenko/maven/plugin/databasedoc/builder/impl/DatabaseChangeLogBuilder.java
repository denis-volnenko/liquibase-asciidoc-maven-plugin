package ru.volnenko.maven.plugin.databasedoc.builder.impl;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.builder.IDatabaseChangeLogBuilder;
import ru.volnenko.maven.plugin.databasedoc.model.impl.DatabaseChangeLog;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Root;

public final class DatabaseChangeLogBuilder implements IDatabaseChangeLogBuilder {

    @NonNull
    private final RootBuilder rootBuilder;

    @NonNull
    private final DatabaseChangeLog databaseChangeLog = new DatabaseChangeLog();

    public DatabaseChangeLogBuilder(@NonNull final RootBuilder rootBuilder) {
        this.rootBuilder = rootBuilder;
        rootBuilder.root().getDatabaseChangeLog().add(databaseChangeLog);
    }

    @NonNull
    public DatabaseChangeLog databaseChangeLog() {
        return databaseChangeLog;
    }

    @NonNull
    @Override
    public Root root() {
        return rootBuilder.root();
    }

    @NonNull
    @Override
    public ChangeSetBuilder changeSet() {
        return new ChangeSetBuilder(this);
    }

}
