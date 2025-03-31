package ru.volnenko.maven.plugin.databasedoc.builder;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.GeneratorBuilder;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.RootBuilder;

public interface IGeneratorBuilder {

    @NonNull
    RootBuilder root();

    @NonNull
    GeneratorBuilder serviceName();

}
