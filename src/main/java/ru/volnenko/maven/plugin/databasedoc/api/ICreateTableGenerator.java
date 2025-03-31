package ru.volnenko.maven.plugin.databasedoc.api;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.generator.CreateTableGenerator;
import ru.volnenko.maven.plugin.databasedoc.model.CreateTable;

public interface ICreateTableGenerator extends IGenerator {

    @NonNull
    CreateTableGenerator createTable(@NonNull CreateTable createTable);

    @NonNull
    CreateTableGenerator serviceName(@NonNull String serviceName);

    @NonNull
    CreateTableGenerator dataBaseInfo(@NonNull String dataBaseInfo);

}
