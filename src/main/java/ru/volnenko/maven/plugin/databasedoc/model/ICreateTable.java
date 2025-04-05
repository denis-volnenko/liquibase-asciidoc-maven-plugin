package ru.volnenko.maven.plugin.databasedoc.model;

import ru.volnenko.maven.plugin.databasedoc.model.impl.ColumnWrapper;

import java.util.List;

public interface ICreateTable {
    String getCatalogName();

    void setCatalogName(String catalogName);

    String getTablespace();

    void setTablespace(String tablespace);

    String getSchemaName();

    void setSchemaName(String schemaName);

    String getTableName();

    void setTableName(String tableName);

    String getRemarks();

    void setRemarks(String remarks);

    List<ColumnWrapper> getColumns();

    void setColumns(List<ColumnWrapper> columns);
}
