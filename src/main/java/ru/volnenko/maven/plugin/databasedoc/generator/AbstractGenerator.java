package ru.volnenko.maven.plugin.databasedoc.generator;

import lombok.NonNull;

public abstract class AbstractGenerator {

    @NonNull
    public abstract String generate();

    public final void append(@NonNull StringBuilder builder) {
        builder.append(generate());
    }

}
