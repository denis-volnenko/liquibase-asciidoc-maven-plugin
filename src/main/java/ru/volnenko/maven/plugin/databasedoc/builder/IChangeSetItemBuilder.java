package ru.volnenko.maven.plugin.databasedoc.builder;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.ChangeBuilder;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.ChangeSetItemBuilder;
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
