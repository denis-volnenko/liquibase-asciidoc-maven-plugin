package ru.volnenko.maven.plugin.databasedoc.builder;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.ChangeBuilder;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.ColumnItemBuilder;
import ru.volnenko.maven.plugin.databasedoc.model.impl.CreateTable;

public interface IColumnBuilder extends IRootBuilder {

    @NonNull
    ColumnItemBuilder add();

    @NonNull
    CreateTable createTable();

    @NonNull
    ChangeBuilder change();

}
