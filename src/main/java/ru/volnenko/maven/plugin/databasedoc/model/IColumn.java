package ru.volnenko.maven.plugin.databasedoc.model;

import ru.volnenko.maven.plugin.databasedoc.model.impl.Constraints;

public interface IColumn {

    String getName();

    void setName(String name);

    String getType();

    void setType(String type);

    String getRemarks();

    void setRemarks(String remarks);

    Boolean getAutoIncrement();

    void setAutoIncrement(Boolean autoIncrement);

    String getDefaultValue();

    void setDefaultValue(String defaultValue);

    String getDefaultValueComputed();

    void setDefaultValueComputed(String defaultValueComputed);

    Constraints getConstraints();

    void setConstraints(Constraints constraints);
    
}
