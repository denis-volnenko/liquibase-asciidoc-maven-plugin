package ru.volnenko.maven.plugin.databasedoc.model.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import ru.volnenko.maven.plugin.databasedoc.model.IUK;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public final class UK implements IUK {

    @NonNull
    private String tableName = "";

    @NonNull
    private String fieldName = "";

    @NonNull
    @Override
    public String getTableName() {
        return tableName;
    }

    @Override
    public void setTableName(@NonNull String tableName) {
        this.tableName = tableName;
    }

    @NonNull
    @Override
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
        UK uk = (UK) o;
        return tableName.equals(uk.tableName) && fieldName.equals(uk.fieldName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tableName, fieldName);
    }

}
