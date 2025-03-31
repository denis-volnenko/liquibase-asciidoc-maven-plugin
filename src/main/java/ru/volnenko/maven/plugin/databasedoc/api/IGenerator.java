package ru.volnenko.maven.plugin.databasedoc.api;

import lombok.NonNull;

public interface IGenerator {

    @NonNull
    String generate();

    @NonNull
    StringBuilder append(@NonNull StringBuilder builder);

}
