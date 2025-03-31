package ru.volnenko.maven.plugin.databasedoc.builder.impl;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.builder.IRootBuilder;
import ru.volnenko.maven.plugin.databasedoc.model.Root;

public final class RootBuilder implements IRootBuilder {

    @NonNull
    private final Root root;

    public RootBuilder() {
        root = new Root();
    }

    public RootBuilder(@NonNull final Root root) {
        this.root = root;
    }

    @NonNull
    public static RootBuilder create(@NonNull final Root root) {
        return new RootBuilder(root);
    }

    @NonNull
    public static RootBuilder create() {
        return new RootBuilder(new Root());
    }

    @NonNull
    public DatabaseChangeLogBuilder dsl() {
        return new DatabaseChangeLogBuilder(this);
    }

    @NonNull
    public Root root() {
        return root;
    }

}
