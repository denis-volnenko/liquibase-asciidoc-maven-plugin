package ru.volnenko.maven.plugin.databasedoc.builder;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.ChangeSetItemBuilder;
import ru.volnenko.maven.plugin.databasedoc.model.impl.DatabaseChangeLog;

public interface IChangeSetBuilder extends IRootBuilder {

    @NonNull
    DatabaseChangeLog databaseChangeLog();

    @NonNull
    ChangeSetItemBuilder add();

}
