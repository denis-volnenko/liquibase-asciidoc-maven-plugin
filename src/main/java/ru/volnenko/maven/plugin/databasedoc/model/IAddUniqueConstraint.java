package ru.volnenko.maven.plugin.databasedoc.model;

public interface IAddUniqueConstraint {

    String getTablespace();

    String getSchemaName();

    String getColumnNames();

    String getCatalogName();

    String getForIndexName();

    String getConstraintName();

    String getTableName();

    Boolean getClustered();

    Boolean getDeferrable();

    Boolean getDisabled();

    Boolean getValidate();

    Boolean getInitiallyDeferred();

    void setTablespace(String tablespace);

    void setSchemaName(String schemaName);

    void setColumnNames(String columnNames);

    void setCatalogName(String catalogName);

    void setForIndexName(String forIndexName);

    void setConstraintName(String constraintName);

    void setTableName(String tableName);

    void setClustered(Boolean clustered);

    void setDeferrable(Boolean deferrable);

    void setDisabled(Boolean disabled);

    void setValidate(Boolean validate);

    void setInitiallyDeferred(Boolean initiallyDeferred);

}
