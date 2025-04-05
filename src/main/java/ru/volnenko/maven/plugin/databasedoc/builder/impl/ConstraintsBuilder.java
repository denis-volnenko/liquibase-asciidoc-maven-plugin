package ru.volnenko.maven.plugin.databasedoc.builder.impl;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.builder.IConstraintsBuilder;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Constraints;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Root;

public final class ConstraintsBuilder implements IConstraintsBuilder {

    @NonNull
    private final ColumnItemBuilder columnItemBuilder;

    @NonNull
    private final Constraints constraints = new Constraints();

    public ConstraintsBuilder(@NonNull final ColumnItemBuilder columnItemBuilder) {
        this.columnItemBuilder = columnItemBuilder;
        columnItemBuilder.column().setConstraints(constraints);
    }

    @NonNull
    public ForeignKeyBuilder foreignKey() {
        return new ForeignKeyBuilder(this);
    }

    @NonNull
    @Override
    public Root root() {
        return columnItemBuilder.root();
    }

    @NonNull
    public ConstraintsBuilder primaryKey(final Boolean primaryKey) {
        constraints.setPrimaryKey(primaryKey);
        return this;
    }

    @NonNull
    public ConstraintsBuilder nullable(final Boolean nullable) {
        constraints.setNullable(nullable);
        return this;
    }

    @NonNull
    public ConstraintsBuilder unique(final Boolean unique) {
        constraints.setUnique(unique);
        return this;
    }

    @NonNull
    public ConstraintsBuilder uniqueConstraintName(final String uniqueConstraintName) {
        constraints.setUniqueConstraintName(uniqueConstraintName);
        return this;
    }

    @NonNull
    public ConstraintsBuilder foreignKeyName(final String foreignKeyName) {
        constraints.setForeignKeyName(foreignKeyName);
        return this;
    }

    @NonNull
    public ColumnItemBuilder add() {
        return columnItemBuilder.add();
    }

    @NonNull
    public ChangeBuilder change() {
        return columnItemBuilder.change();
    }

}
