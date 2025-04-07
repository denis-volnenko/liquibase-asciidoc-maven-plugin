package ru.volnenko.maven.plugin.databasedoc.model;

import ru.volnenko.maven.plugin.databasedoc.model.impl.CreateType;
import ru.volnenko.maven.plugin.databasedoc.model.impl.ValueWrapper;

import java.util.List;

public interface ICreateType {
    String getCatalogName();

    void setCatalogName(String catalogName);

    String getSchemaName();

    void setSchemaName(String schemaName);

    String getTablespace();

    void setTablespace(String tablespace);

    String getTypeName();

    void setTypeName(String typeName);

    String getRemarks();

    void setRemarks(String remarks);

    List<ValueWrapper> getValues();

    void setValues(List<ValueWrapper> values);

}
