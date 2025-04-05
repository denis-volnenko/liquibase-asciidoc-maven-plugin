package ru.volnenko.maven.plugin.databasedoc.model;

import ru.volnenko.maven.plugin.databasedoc.model.impl.Column;

public interface IColumnWrapper {
    Column getColumn();

    void setColumn(Column column);
}
