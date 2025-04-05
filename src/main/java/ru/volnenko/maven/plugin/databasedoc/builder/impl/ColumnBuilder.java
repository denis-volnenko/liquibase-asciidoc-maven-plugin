package ru.volnenko.maven.plugin.databasedoc.builder.impl;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.builder.IColumnBuilder;
import ru.volnenko.maven.plugin.databasedoc.model.impl.CreateTable;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Root;

public final class ColumnBuilder implements IColumnBuilder {

    @NonNull
    private final CreateTableBuilder createTableBuilder;

    public ColumnBuilder(@NonNull final CreateTableBuilder createTableBuilder) {
        this.createTableBuilder = createTableBuilder;
    }

    @NonNull
    public ColumnItemBuilder add() {
        return new ColumnItemBuilder(this);
    }

    @Override
    @NonNull
    public CreateTable createTable() {
        return createTableBuilder.createTable();
    }

    @NonNull
    @Override
    public Root root() {
        return createTableBuilder.root();
    }

    @Override
    @NonNull
    public ChangeBuilder change() {
        return createTableBuilder.change();
    }

}
