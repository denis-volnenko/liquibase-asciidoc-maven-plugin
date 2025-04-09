package ru.volnenko.maven.plugin.databasedoc.builder;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.ChangeSetBuilder;
import ru.volnenko.maven.plugin.databasedoc.model.impl.DatabaseChangeLog;

public interface IDatabaseChangeLogBuilder extends IRootBuilder {

    @NonNull
    DatabaseChangeLog databaseChangeLog();

    @NonNull
    ChangeSetBuilder changeSet();

}
