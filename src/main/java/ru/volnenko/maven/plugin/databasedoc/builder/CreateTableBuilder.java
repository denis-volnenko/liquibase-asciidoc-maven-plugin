package ru.volnenko.maven.plugin.databasedoc.builder;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.api.ICreateTableBuilder;
import ru.volnenko.maven.plugin.databasedoc.model.CreateTable;
import ru.volnenko.maven.plugin.databasedoc.model.Root;

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
    public ColumnBuilder column() {
        return new ColumnBuilder(this);
    }

    @NonNull
    public CreateTableBuilder tablespace(@NonNull final String tablespace) {
        createTable.setTablespace(tablespace);
        return this;
    }

    @NonNull
    public CreateTableBuilder catalogName(@NonNull final String catalogName) {
        createTable.setCatalogName(catalogName);
        return this;
    }

    @NonNull
    public CreateTableBuilder tableName(@NonNull final String tableName) {
        createTable.setTableName(tableName);
        return this;
    }

    @NonNull
    public CreateTableBuilder remarks(@NonNull final String remarks) {
        createTable.setRemarks(remarks);
        return this;
    }

    @NonNull
    public CreateTable createTable() {
        return createTable;
    }

    @NonNull
    @Override
    public Root root() {
        return changeBuilder.root();
    }

    @NonNull
    public ChangeBuilder change() {
        return changeBuilder.and();
    }

}
