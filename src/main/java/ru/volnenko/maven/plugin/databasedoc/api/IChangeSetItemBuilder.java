package ru.volnenko.maven.plugin.databasedoc.api;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.builder.ChangeBuilder;
import ru.volnenko.maven.plugin.databasedoc.builder.ChangeSetItemBuilder;
import ru.volnenko.maven.plugin.databasedoc.model.ChangeSet;

public interface IChangeSetItemBuilder extends IRootBuilder {

    @NonNull
    ChangeSetItemBuilder id(String id);

    @NonNull
    ChangeSetItemBuilder author(String author);

    @NonNull
    ChangeBuilder change();

    @NonNull
    ChangeSet changeSet();

}
