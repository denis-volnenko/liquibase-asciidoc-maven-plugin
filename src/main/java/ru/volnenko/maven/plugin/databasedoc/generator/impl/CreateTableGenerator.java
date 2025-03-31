package ru.volnenko.maven.plugin.databasedoc.generator.impl;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.generator.ICreateTableGenerator;
import ru.volnenko.maven.plugin.databasedoc.model.CreateTable;
import ru.volnenko.maven.plugin.databasedoc.util.StringUtil;

public final class CreateTableGenerator extends AbstractGenerator implements ICreateTableGenerator {

    @NonNull
    private CreateTable createTable = new CreateTable();

    @NonNull
    private String serviceName = "";

    @NonNull
    private String dataBaseInfo = "";

    @NonNull
    @Override
    public ICreateTableGenerator createTable(@NonNull final CreateTable createTable) {
        this.createTable = createTable;
        return this;
    }

    @NonNull
    @Override
    public ICreateTableGenerator serviceName(@NonNull final String serviceName) {
        this.serviceName = serviceName;
        return this;
    }

    @NonNull
    @Override
    public ICreateTableGenerator dataBaseInfo(@NonNull final String dataBaseInfo) {
        this.dataBaseInfo = dataBaseInfo;
        return this;
    }

    @NonNull
    @Override
    public StringBuilder append(@NonNull final StringBuilder stringBuilder) {
        stringBuilder.append("=== Сущность \"" + StringUtil.format(createTable.getTableName()) + "\"\n");
        stringBuilder.append("\n");
        stringBuilder.append("==== Общие сведения\n");
        stringBuilder.append("\n");
        stringBuilder.append("[cols=\"20,80\"]\n");
        stringBuilder.append("|===\n");
        stringBuilder.append("\n");
        stringBuilder.append("|*Физ. название*:\n");
        stringBuilder.append("|" + StringUtil.format(createTable.getTableName()) + "\n");
        stringBuilder.append("\n");
        stringBuilder.append("|*Лог. название*:\n");
        stringBuilder.append("|" + StringUtil.format(createTable.getRemarks()) + "\n");
        stringBuilder.append("\n");
        stringBuilder.append("|*Сервис*:\n");
        stringBuilder.append("|" + StringUtil.format(serviceName) + "\n");
        stringBuilder.append("\n");
        stringBuilder.append("|*База данных*:\n");
        stringBuilder.append("|" + StringUtil.format(createTable.getCatalogName()) + "\n");
        stringBuilder.append("\n");
        stringBuilder.append("|*Доп. сведения*:\n");
        stringBuilder.append("|" + StringUtil.format(dataBaseInfo) + "\n");
        stringBuilder.append("\n");
        stringBuilder.append("|*Схема*:\n");
        stringBuilder.append("|" + StringUtil.format(createTable.getSchemaName()) + "\n");
        stringBuilder.append("\n");
        stringBuilder.append("|===\n");
        stringBuilder.append("\n");
        return stringBuilder;
    }

}
