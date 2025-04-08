package ru.volnenko.maven.plugin.databasedoc.model;

public interface IAddPrimaryKey {

    String getColumnNames();

    String getConstraintName();

    String getSchemaName();

    String getTableName();

    String getTablespace();

    void setColumnNames(String columnNames);

    void setConstraintName(String constraintName);

    void setSchemaName(String schemaName);

    void setTableName(String tableName);

    void setTablespace(String tablespace);

}
