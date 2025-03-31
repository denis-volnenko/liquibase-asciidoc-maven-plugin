package ru.volnenko.maven.plugin.databasedoc.builder;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.ChangeBuilder;
import ru.volnenko.maven.plugin.databasedoc.model.CreateTable;

public interface IColumnBuilder extends IRootBuilder {

    @NonNull
    CreateTable createTable();

    @NonNull
    ChangeBuilder change();

}
