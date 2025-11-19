package ru.volnenko.maven.plugin.databasedoc.model;

import ru.volnenko.maven.plugin.databasedoc.model.impl.Schema;

public interface ICreateModel {

    String getModelName();

    void setModelName(String modelName);

    String getCatalogName();

    void setCatalogName(String catalogName);

    String getSchemaName();

    void setSchemaName(String schemaName);

    String getRemarks();

    void setRemarks(String remarks);

    Schema getSchema();

    void setSchema(Schema schema);

}
