package ru.volnenko.maven.plugin.databasedoc.builder.impl;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.builder.ICreateTableBuilder;
import ru.volnenko.maven.plugin.databasedoc.model.impl.CreateTable;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Root;

public final class CreateTableBuilder implements ICreateTableBuilder {

    @NonNull
    private final ChangeBuilder changeBuilder;

    @NonNull
    private final CreateTable createTable = new CreateTable();

    public CreateTableBuilder(@NonNull ChangeBuilder changeBuilder) {
        this.changeBuilder = changeBuilder;
        changeBuilder.change().setCreateTable(createTable);
    }

    @NonNull
    @Override
    public ColumnBuilder column() {
        return new ColumnBuilder(this);
    }

    @NonNull
    @Override
    public CreateTableBuilder tablespace(@NonNull final String tablespace) {
        createTable.setTablespace(tablespace);
        return this;
    }

    @NonNull
    @Override
    public CreateTableBuilder catalogName(@NonNull final String catalogName) {
        createTable.setCatalogName(catalogName);
        return this;
    }

    @NonNull
    @Override
    public CreateTableBuilder tableName(@NonNull final String tableName) {
        createTable.setTableName(tableName);
        return this;
    }

    @NonNull
    @Override
    public CreateTableBuilder remarks(@NonNull final String remarks) {
        createTable.setRemarks(remarks);
        return this;
    }

    @NonNull
    @Override
    public CreateTable createTable() {
        return createTable;
    }

    @NonNull
    @Override
    public Root root() {
        return changeBuilder.root();
    }

    @NonNull
    @Override
    public ChangeBuilder change() {
        return changeBuilder.and();
    }

}
