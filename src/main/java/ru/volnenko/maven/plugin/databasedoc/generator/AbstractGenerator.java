package ru.volnenko.maven.plugin.databasedoc.generator;

import lombok.NonNull;

public abstract class AbstractGenerator<M> {

    private M model;

    public abstract String generate(@NonNull M model);

    public abstract void append(@NonNull M model, @NonNull StringBuilder builder);

}
