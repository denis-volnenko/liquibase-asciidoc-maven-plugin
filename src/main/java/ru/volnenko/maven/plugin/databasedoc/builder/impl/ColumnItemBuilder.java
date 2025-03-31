package ru.volnenko.maven.plugin.databasedoc.builder.impl;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.builder.IColumnItemBuilder;
import ru.volnenko.maven.plugin.databasedoc.model.Column;
import ru.volnenko.maven.plugin.databasedoc.model.Root;

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
    public ColumnItemBuilder add() {
        return columnBuilder.add();
    }

    @NonNull
    public ConstraintsBuilder constraints() {
        return new ConstraintsBuilder(this);
    }

    @NonNull
    public ColumnItemBuilder name(final String name) {
        column.setName(name);
        return this;
    }

    @NonNull
    public ColumnItemBuilder type(final String type) {
        column.setType(type);
        return this;
    }

    @NonNull
    public ColumnItemBuilder remarks(final String remarks) {
        column.setRemarks(remarks);
        return this;
    }

    @NonNull
    public ColumnItemBuilder autoIncrement(final Boolean autoIncrement) {
        column.setAutoIncrement(autoIncrement);
        return this;
    }

    @NonNull
    public Column column() {
        return column;
    }

    @NonNull
    @Override
    public Root root() {
        return columnBuilder.root();
    }

    @NonNull
    public ChangeBuilder change() {
        return columnBuilder.change();
    }

}
