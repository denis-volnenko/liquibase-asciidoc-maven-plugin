package ru.volnenko.maven.plugin.databasedoc.model;

import ru.volnenko.maven.plugin.databasedoc.model.impl.CreateTable;
import ru.volnenko.maven.plugin.databasedoc.model.impl.CreateType;

public interface IChange {

    CreateTable getCreateTable();

    void setCreateTable(CreateTable createTable);

    CreateType getCreateType();

    void setCreateType(CreateType createType);

}
