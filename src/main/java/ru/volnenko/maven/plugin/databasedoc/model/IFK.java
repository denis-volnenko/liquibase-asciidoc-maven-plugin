package ru.volnenko.maven.plugin.databasedoc.model;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.model.impl.PK;

public interface IFK {

    @NonNull PK getPk();

    void setPk(@NonNull PK pk);

    @NonNull Boolean getUnique();

    void setUnique(@NonNull Boolean unique);

    @NonNull String getTableName();

    void setTableName(@NonNull String tableName);

    @NonNull String getFieldName();

    void setFieldName(@NonNull String fieldName);

}
