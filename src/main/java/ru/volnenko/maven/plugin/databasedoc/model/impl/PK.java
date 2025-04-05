package ru.volnenko.maven.plugin.databasedoc.model.impl;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.model.IPK;

import java.util.Objects;

@NoArgsConstructor
public final class PK implements IPK {

    @NonNull
    private String tableName = "";

    @NonNull
    private String fieldName = "";

    @NonNull
    public String getTableName() {
        return tableName;
    }

    public void setTableName(@NonNull String tableName) {
        this.tableName = tableName;
    }

    @NonNull
    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(@NonNull String fieldName) {
        this.fieldName = fieldName;
    }

    public PK(@NonNull String tableName, @NonNull String fieldName) {
        this.tableName = tableName;
        this.fieldName = fieldName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PK pk = (PK) o;
        return tableName.equals(pk.tableName) && fieldName.equals(pk.fieldName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tableName, fieldName);
    }

}
