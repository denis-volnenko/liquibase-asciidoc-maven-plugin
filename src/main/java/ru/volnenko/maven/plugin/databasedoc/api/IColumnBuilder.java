package ru.volnenko.maven.plugin.databasedoc.api;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.builder.ChangeBuilder;
import ru.volnenko.maven.plugin.databasedoc.model.CreateTable;

public interface IColumnBuilder extends IRootBuilder {

    @NonNull
    CreateTable createTable();

    @NonNull
    ChangeBuilder change();

}
