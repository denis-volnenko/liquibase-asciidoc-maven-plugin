package ru.volnenko.maven.plugin.databasedoc.model;

import ru.volnenko.maven.plugin.databasedoc.model.impl.ForeignKey;

public interface IConstraints {
    Boolean getPrimaryKey();

    void setPrimaryKey(Boolean primaryKey);

    Boolean getNullable();

    void setNullable(Boolean nullable);

    Boolean getUnique();

    void setUnique(Boolean unique);

    String getUniqueConstraintName();

    void setUniqueConstraintName(String uniqueConstraintName);

    String getForeignKeyName();

    void setForeignKeyName(String foreignKeyName);

    ForeignKey getForeignKey();

    void setForeignKey(ForeignKey foreignKey);
}
