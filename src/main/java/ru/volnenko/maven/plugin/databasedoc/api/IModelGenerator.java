package ru.volnenko.maven.plugin.databasedoc.api;

import lombok.NonNull;

public interface IModelGenerator {

    @NonNull
    String generate();

    @NonNull
    StringBuilder append(@NonNull StringBuilder builder);

}
