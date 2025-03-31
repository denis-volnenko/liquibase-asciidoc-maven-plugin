package ru.volnenko.maven.plugin.databasedoc.generator.impl;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.generator.IEntityRelationDiagramColumnWrapperGenerator;
import ru.volnenko.maven.plugin.databasedoc.model.ColumnWrapper;
import ru.volnenko.maven.plugin.databasedoc.model.CreateTable;
import ru.volnenko.maven.plugin.databasedoc.util.StringUtil;

import java.util.Collections;
import java.util.List;

public final class EntityRelationDiagramColumnWrapperGenerator extends AbstractGenerator implements IEntityRelationDiagramColumnWrapperGenerator {

    @NonNull
    private CreateTable createTable = new CreateTable();

    @NonNull
    private List<ColumnWrapper> columnWrappers = Collections.emptyList();

    @NonNull
    private final EntityRelationDiagramColumnGenerator entityRelationDiagramColumnGenerator = new EntityRelationDiagramColumnGenerator();

    @NonNull
    @Override
    public IEntityRelationDiagramColumnWrapperGenerator createTable(@NonNull final CreateTable createTable) {
        this.createTable = createTable;
        return this;
    }

    @NonNull
    @Override
    public IEntityRelationDiagramColumnWrapperGenerator stringBuilder(@NonNull final StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
        return this;
    }

    @NonNull
    @Override
    public IEntityRelationDiagramColumnWrapperGenerator columnWrappers(@NonNull final List<ColumnWrapper> columnWrappers) {
        this.columnWrappers = columnWrappers;
        return this;
    }

    @NonNull
    @Override
    public StringBuilder append(@NonNull final StringBuilder stringBuilder) {
        stringBuilder.append("entity \"" + StringUtil.format(createTable.getTableName()) + "\" {");
        stringBuilder.append("\n");
        for (final ColumnWrapper columnWrapper : columnWrappers) {
            entityRelationDiagramColumnGenerator
                    .column(columnWrapper.getColumn())
                    .append(stringBuilder);
        }
        stringBuilder.append("}");
        stringBuilder.append("\n");
        stringBuilder.append("\n");
        return stringBuilder;
    }

}
