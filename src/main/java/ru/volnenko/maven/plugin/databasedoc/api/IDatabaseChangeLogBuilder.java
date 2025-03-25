package ru.volnenko.maven.plugin.databasedoc.api;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.builder.ChangeSetBuilder;

public interface IDatabaseChangeLogBuilder extends IRootBuilder {

    @NonNull
    ChangeSetBuilder changeSet();

}
