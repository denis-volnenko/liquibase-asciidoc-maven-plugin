package ru.volnenko.maven.plugin.databasedoc.api;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.model.Root;

public interface IRootBuilder {

    @NonNull
    Root root();

}
