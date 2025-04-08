package ru.volnenko.maven.plugin.databasedoc.generator.impl;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.generator.IColumnWrapperGenerator;
import ru.volnenko.maven.plugin.databasedoc.model.impl.ColumnWrapper;
import ru.volnenko.maven.plugin.databasedoc.model.impl.FK;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class ColumnWrapperGenerator extends AbstractGenerator implements IColumnWrapperGenerator {

    @NonNull
    private ColumnGenerator columnGenerator = new ColumnGenerator();

    @NonNull
    private Integer index = 1;

    @NonNull
    private String tableName = "";

    @NonNull
    private Set<FK> fks = Collections.emptySet();

    @NonNull
    private List<ColumnWrapper> columnWrappers = Collections.emptyList();

    @Override
    @NonNull
    public IColumnWrapperGenerator tableName(@NonNull final String tableName) {
        this.tableName = tableName;
        return this;
    }

    @Override
    @NonNull
    public IColumnWrapperGenerator fks(Set<FK> fks) {
        if (fks == null) return this;
        this.fks = fks;
        return this;
    }

    @NonNull
    @Override
    public IColumnWrapperGenerator stringBuilder(@NonNull final StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
        return this;
    }

    @NonNull
    @Override
    public IColumnWrapperGenerator index(@NonNull final Integer index) {
        this.index = index;
        return this;
    }

    @NonNull
    @Override
    public IColumnWrapperGenerator columnWrappers(@NonNull final List<ColumnWrapper> columnWrappers) {
        this.columnWrappers = columnWrappers;
        return this;
    }

    @NonNull
    @Override
    public StringBuilder append(@NonNull final StringBuilder stringBuilder) {
        stringBuilder.append("==== Описание полей\n");
        stringBuilder.append("\n");
        stringBuilder.append("[cols=\"0,20,20,20,5,5,5,5,5,10\"]\n");
        stringBuilder.append("|===\n");
        stringBuilder.append("\n");
        stringBuilder.append("^|*№*\n");
        stringBuilder.append("|*Физ. название*\n");
        stringBuilder.append("|*Тип*\n");
        stringBuilder.append("|*Лог. название*\n");
        stringBuilder.append("^|*PK*\n");
        stringBuilder.append("^|*UK*\n");
        stringBuilder.append("^|*FK*\n");
        stringBuilder.append("^|*AI*\n");
        stringBuilder.append("^|*NN*\n");
        stringBuilder.append("|*DEFAULT*\n");
        stringBuilder.append("\n");
        int index = 1;
        for (final ColumnWrapper columnWrapper : columnWrappers) {
            columnGenerator
                    .index(index)
                    .fks(fks)
                    .tableName(tableName)
                    .column(columnWrapper.getColumn())
                    .append(stringBuilder);
            index++;
        }
        stringBuilder.append("|===\n");
        stringBuilder.append("\n");
        return stringBuilder;
    }

}
