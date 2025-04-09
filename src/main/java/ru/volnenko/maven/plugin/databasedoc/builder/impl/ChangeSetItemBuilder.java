package ru.volnenko.maven.plugin.databasedoc.builder.impl;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.builder.IChangeSetItemBuilder;
import ru.volnenko.maven.plugin.databasedoc.model.impl.ChangeSet;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Root;

public final class ChangeSetItemBuilder implements IChangeSetItemBuilder {

    @NonNull
    private final ChangeSetBuilder changeSetBuilder;

    @NonNull
    private final ChangeSet changeSet = new ChangeSet();

    public ChangeSetItemBuilder(@NonNull final ChangeSetBuilder changeSetBuilder) {
        this.changeSetBuilder = changeSetBuilder;
        changeSetBuilder.databaseChangeLog().setChangeSet(changeSet);
    }

    @NonNull
    @Override
    public ChangeSetItemBuilder id(final String id) {
        changeSet.setId(id);
        return this;
    }

    @NonNull
    @Override
    public ChangeSetItemBuilder author(final String author) {
        changeSet.setAuthor(author);
        return this;
    }

    @NonNull
    @Override
    public ChangeBuilder change() {
        return new ChangeBuilder(this);
    }

    @Override
    @NonNull
    public ChangeSet changeSet() {
        return changeSet;
    }

    @NonNull
    @Override
    public Root root() {
        return changeSetBuilder.root();
    }

}
