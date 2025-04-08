package ru.volnenko.maven.plugin.databasedoc.model.impl;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.model.IFK;

import java.util.Objects;

@NoArgsConstructor
public final class FK implements IFK {

    @NonNull
    private String tableName = "";

    @NonNull
    private String fieldName = "";

    @NonNull
    private Boolean unique = false;

    @NonNull
    private PK pk = new PK();

    @Override
    @NonNull
    public PK getPk() {
        return pk;
    }

    @Override
    public void setPk(@NonNull PK pk) {
        this.pk = pk;
    }

    public FK(@NonNull String tableName, @NonNull String fieldName) {
        this.tableName = tableName;
        this.fieldName = fieldName;
    }

    public FK(@NonNull String tableName, @NonNull String fieldName, @NonNull Boolean unique) {
        this.tableName = tableName;
        this.fieldName = fieldName;
        this.unique = unique;
    }

    @Override
    @NonNull
    public Boolean getUnique() {
        return unique;
    }

    @Override
    public void setUnique(@NonNull Boolean unique) {
        this.unique = unique;
    }

    @Override
    @NonNull
    public String getTableName() {
        return tableName;
    }

    @Override
    public void setTableName(@NonNull String tableName) {
        this.tableName = tableName;
    }

    @Override
    @NonNull
    public String getFieldName() {
        return fieldName;
    }

    @Override
    public void setFieldName(@NonNull String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FK fk = (FK) o;
        return tableName.equals(fk.tableName) && fieldName.equals(fk.fieldName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tableName, fieldName);
    }

    @NonNull
    public UK toUK() {
        @NonNull final UK uk = new UK();
        uk.setTableName(tableName);
        uk.setFieldName(fieldName);
        return uk;
    }

}
