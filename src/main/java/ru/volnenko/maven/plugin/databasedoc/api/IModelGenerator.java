package ru.volnenko.maven.plugin.databasedoc.api;

import lombok.NonNull;

public interface IModelGenerator {

    @NonNull
    String generate();

    void append(@NonNull StringBuilder builder);

}
