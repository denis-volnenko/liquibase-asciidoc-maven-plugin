package ru.volnenko.maven.plugin.databasedoc.builder.impl;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.builder.IChangeSetBuilder;
import ru.volnenko.maven.plugin.databasedoc.model.impl.DatabaseChangeLog;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Root;

public final class ChangeSetBuilder implements IChangeSetBuilder {

    @NonNull
    private final DatabaseChangeLogBuilder databaseChangeLogBuilder;

    public ChangeSetBuilder(@NonNull final DatabaseChangeLogBuilder databaseChangeLogBuilder) {
        this.databaseChangeLogBuilder = databaseChangeLogBuilder;
    }

    @NonNull
    @Override
    public Root root() {
        return databaseChangeLogBuilder.root();
    }

    @Override
    @NonNull
    public DatabaseChangeLog databaseChangeLog() {
        return databaseChangeLogBuilder.databaseChangeLog();
    }

    @NonNull
    @Override
    public ChangeSetItemBuilder add() {
        return new ChangeSetItemBuilder(this);
    }

}
