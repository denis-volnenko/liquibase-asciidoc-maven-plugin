package ru.volnenko.maven.plugin.databasedoc.builder.impl;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.builder.IForeignKeyBuilder;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Root;

public final class ForeignKeyBuilder implements IForeignKeyBuilder {

    @NonNull
    private final ConstraintsBuilder constraintsBuilder;

    public ForeignKeyBuilder(@NonNull final ConstraintsBuilder constraintsBuilder) {
        this.constraintsBuilder = constraintsBuilder;
    }

    @NonNull
    @Override
    public Root root() {
        return constraintsBuilder.root();
    }

    @Override
    @NonNull
    public ColumnItemBuilder add() {
        return constraintsBuilder.add();
    }

    @Override
    @NonNull
    public ChangeBuilder change() {
        return constraintsBuilder.change();
    }

}
