package ru.volnenko.maven.plugin.databasedoc.builder;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Root;

public interface IRootBuilder {

    @NonNull
    Root root();

}
