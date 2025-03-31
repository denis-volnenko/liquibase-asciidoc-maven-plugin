package ru.volnenko.maven.plugin.databasedoc.generator.impl;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.generator.IGenerator;

public abstract class AbstractGenerator implements IGenerator {

    @NonNull
    protected StringBuilder stringBuilder = new StringBuilder();

    @NonNull
    @Override
    public abstract StringBuilder append(@NonNull StringBuilder stringBuilder);

    @NonNull
    @Override
    public StringBuilder stringBuilder() {
        return stringBuilder;
    }

    @NonNull
    @Override
    public String generate() {
        return append(stringBuilder()).toString();
    }

}
