package ru.volnenko.maven.plugin.databasedoc.api;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.builder.ChangeBuilder;
import ru.volnenko.maven.plugin.databasedoc.builder.ColumnBuilder;
import ru.volnenko.maven.plugin.databasedoc.builder.CreateTableBuilder;
import ru.volnenko.maven.plugin.databasedoc.model.CreateTable;

public interface ICreateTableBuilder extends IRootBuilder {

    @NonNull
    ColumnBuilder column();

    @NonNull
    CreateTableBuilder tablespace(@NonNull String tablespace);

    @NonNull
    CreateTableBuilder catalogName(@NonNull String catalogName);

    @NonNull
    CreateTableBuilder tableName(@NonNull String tableName);

    @NonNull
    CreateTableBuilder remarks(@NonNull String remarks);

    @NonNull
    CreateTable createTable();

    @NonNull
    ChangeBuilder change();

}
