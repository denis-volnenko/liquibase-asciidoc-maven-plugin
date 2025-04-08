package ru.volnenko.maven.plugin.databasedoc.model.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import ru.volnenko.maven.plugin.databasedoc.model.IUK;

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

}
