package ru.volnenko.maven.plugin.databasedoc.generator;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.model.CreateTable;

public interface ICreateTableGenerator extends IGenerator {

    @NonNull
    ICreateTableGenerator createTable(@NonNull CreateTable createTable);

    @NonNull
    ICreateTableGenerator serviceName(@NonNull String serviceName);

    @NonNull
    ICreateTableGenerator dataBaseInfo(@NonNull String dataBaseInfo);

}
