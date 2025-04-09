package ru.volnenko.maven.plugin.databasedoc.builder.impl;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.builder.IColumnItemBuilder;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Column;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Root;

public final class ColumnItemBuilder implements IColumnItemBuilder {

    @NonNull
    private final ColumnBuilder columnBuilder;

    @NonNull
    private final Column column = new Column();

    public ColumnItemBuilder(@NonNull final ColumnBuilder columnBuilder) {
        this.columnBuilder = columnBuilder;
        columnBuilder.createTable().add(column);
    }

    @NonNull
    @Override
    public ColumnItemBuilder add() {
        return columnBuilder.add();
    }

    @NonNull
    @Override
    public ConstraintsBuilder constraints() {
        return new ConstraintsBuilder(this);
    }

    @NonNull
    @Override
    public ColumnItemBuilder name(final String name) {
        column.setName(name);
        return this;
    }

    @NonNull
    @Override
    public ColumnItemBuilder type(final String type) {
        column.setType(type);
        return this;
    }

    @NonNull
    @Override
    public ColumnItemBuilder remarks(final String remarks) {
        column.setRemarks(remarks);
        return this;
    }

    @NonNull
    @Override
    public ColumnItemBuilder autoIncrement(final Boolean autoIncrement) {
        column.setAutoIncrement(autoIncrement);
        return this;
    }

    @NonNull
    @Override
    public Column column() {
        return column;
    }

    @NonNull
    @Override
    public Root root() {
        return columnBuilder.root();
    }

    @NonNull
    @Override
    public ChangeBuilder change() {
        return columnBuilder.change();
    }

}
