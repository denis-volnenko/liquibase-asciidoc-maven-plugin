package ru.volnenko.maven.plugin.databasedoc.model;

import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Objects;

@NoArgsConstructor
public final class FK {

    @NonNull
    private String tableName = "";

    @NonNull
    private String fieldName = "";

    @NonNull
    private Boolean unique = false;

    @NonNull
    private PK pk = new PK();

    @NonNull
    public PK getPk() {
        return pk;
    }

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

    @NonNull
    public Boolean getUnique() {
        return unique;
    }

    public void setUnique(@NonNull Boolean unique) {
        this.unique = unique;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FK fk = (FK) o;
        return tableName.equals(fk.tableName) && fieldName.equals(fk.fieldName) && pk.equals(fk.pk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tableName, fieldName, pk);
    }

}
