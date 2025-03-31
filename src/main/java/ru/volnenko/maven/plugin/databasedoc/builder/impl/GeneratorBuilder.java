package ru.volnenko.maven.plugin.databasedoc.builder.impl;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.builder.IGeneratorBuilder;
import ru.volnenko.maven.plugin.databasedoc.model.Root;

public final class GeneratorBuilder implements IGeneratorBuilder {

    @NonNull
    private final Root root;

    public GeneratorBuilder(@NonNull final Root root) {
        this.root = root;
    }

    public GeneratorBuilder() {
        root = new Root();
    }

    @Override
    @NonNull
    public RootBuilder root() {
        return RootBuilder.create(root);
    }

    @Override
    @NonNull
    public GeneratorBuilder serviceName() {
        return this;
    }

}
