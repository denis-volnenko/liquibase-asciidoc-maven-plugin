package ru.volnenko.maven.plugin.databasedoc.generator;

import lombok.NonNull;

public interface IGenerator {

    @NonNull
    String generate();

    @NonNull
    StringBuilder append(@NonNull StringBuilder builder);

}
