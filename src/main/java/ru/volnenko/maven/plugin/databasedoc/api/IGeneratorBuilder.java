package ru.volnenko.maven.plugin.databasedoc.api;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.builder.GeneratorBuilder;
import ru.volnenko.maven.plugin.databasedoc.builder.RootBuilder;

public interface IGeneratorBuilder {

    @NonNull
    RootBuilder root();

    @NonNull
    GeneratorBuilder serviceName();

}
