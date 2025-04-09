package ru.volnenko.maven.plugin.databasedoc.builder;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.ChangeBuilder;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.ColumnItemBuilder;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.ConstraintsBuilder;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.ForeignKeyBuilder;

public interface IConstraintsBuilder extends IRootBuilder {

    @NonNull
    ForeignKeyBuilder foreignKey();

    @NonNull
    ConstraintsBuilder primaryKey(Boolean primaryKey);

    @NonNull
    ConstraintsBuilder nullable(Boolean nullable);

    @NonNull
    ConstraintsBuilder unique(Boolean unique);

    @NonNull
    ConstraintsBuilder uniqueConstraintName(String uniqueConstraintName);

    @NonNull
    ConstraintsBuilder foreignKeyName(String foreignKeyName);

    @NonNull
    ColumnItemBuilder add();

    @NonNull
    ChangeBuilder change();

}
