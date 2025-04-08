package ru.volnenko.maven.plugin.databasedoc.generator.impl;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.generator.ICreateTableGenerator;
import ru.volnenko.maven.plugin.databasedoc.model.impl.CreateTable;
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
        {
            @NonNull final String name = StringUtil.format(serviceName);
            if (!name.isEmpty()) {
                stringBuilder.append("\n");
                stringBuilder.append("|*Сервис*:\n");
                stringBuilder.append("|" + name + "\n");
            }
        }
        {
            @NonNull final String name = StringUtil.format(createTable.getCatalogName());
            if (!name.isEmpty()) {
                stringBuilder.append("\n");
                stringBuilder.append("|*База данных*:\n");
                stringBuilder.append("|" + name + "\n");
            }
        }
        {
            @NonNull final String text = StringUtil.format(dataBaseInfo);
            if (!text.isEmpty()) {
                stringBuilder.append("\n");
                stringBuilder.append("|*Доп. сведения*:\n");
                stringBuilder.append("|" + text + "\n");
            }
        }
        {
            @NonNull final String name = StringUtil.format(createTable.getSchemaName());
            if (!name.isEmpty()) {
                stringBuilder.append("\n");
                stringBuilder.append("|*Схема*:\n");
                stringBuilder.append("|" + name + "\n");
            }
        }

        stringBuilder.append("\n");
        stringBuilder.append("|===\n");
        stringBuilder.append("\n");
        return stringBuilder;
    }

}
