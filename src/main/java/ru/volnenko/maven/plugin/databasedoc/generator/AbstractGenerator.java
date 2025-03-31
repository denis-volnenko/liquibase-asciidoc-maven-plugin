package ru.volnenko.maven.plugin.databasedoc.generator;

import lombok.NonNull;

public abstract class AbstractGenerator {

    @NonNull
    protected StringBuilder stringBuilder = new StringBuilder();

    @NonNull
    public abstract StringBuilder append(@NonNull StringBuilder builder);

    @NonNull
    public StringBuilder stringBuilder() {
        return stringBuilder;
    }

    @NonNull
    public String generate() {
        return append(stringBuilder()).toString();
    }

}
