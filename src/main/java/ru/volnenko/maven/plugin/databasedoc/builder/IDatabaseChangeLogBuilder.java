package ru.volnenko.maven.plugin.databasedoc.builder;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.ChangeSetBuilder;

public interface IDatabaseChangeLogBuilder extends IRootBuilder {

    @NonNull
    ChangeSetBuilder changeSet();

}
