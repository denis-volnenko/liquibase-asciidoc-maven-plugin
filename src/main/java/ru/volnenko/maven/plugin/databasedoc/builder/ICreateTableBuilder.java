package ru.volnenko.maven.plugin.databasedoc.builder;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.ChangeBuilder;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.ColumnBuilder;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.CreateTableBuilder;
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
