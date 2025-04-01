package ru.volnenko.maven.plugin.databasedoc.generator.impl;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.generator.IEntityRelationDiagramColumnWrapperGenerator;
import ru.volnenko.maven.plugin.databasedoc.model.ColumnWrapper;
import ru.volnenko.maven.plugin.databasedoc.model.CreateTable;
import ru.volnenko.maven.plugin.databasedoc.util.StringUtil;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

    private static final Predicate<ColumnWrapper> PK = new Predicate<ColumnWrapper>() {
        @Override
        public boolean test(ColumnWrapper columnWrapper) {
            if (columnWrapper == null) return false;
            if (columnWrapper.getColumn() == null) return false;
            if (columnWrapper.getColumn().getConstraints() == null) return false;
            if (columnWrapper.getColumn().getConstraints().getPrimaryKey() == null) return false;
            return columnWrapper.getColumn().getConstraints().getPrimaryKey();
        }
    };

    private static final Predicate<ColumnWrapper> NOT_PK = new Predicate<ColumnWrapper>() {
        @Override
        public boolean test(ColumnWrapper columnWrapper) {
            if (columnWrapper == null) return false;
            if (columnWrapper.getColumn() == null) return false;
            if (columnWrapper.getColumn().getConstraints() == null) return false;
            if (columnWrapper.getColumn().getConstraints().getPrimaryKey() == null) return false;
            return !columnWrapper.getColumn().getConstraints().getPrimaryKey();
        }
    };

    private boolean hasPK() {
        return columnWrappers.stream().anyMatch(PK);
    }

    @NonNull
    @Override
    public StringBuilder append(@NonNull final StringBuilder stringBuilder) {
        stringBuilder.append("entity \"" + StringUtil.format(createTable.getTableName()) + "\" {");
        stringBuilder.append("\n");

        if (hasPK()) {
            for (final ColumnWrapper columnWrapper: columnWrappers.stream().filter(PK).collect(Collectors.toList())) {
                entityRelationDiagramColumnGenerator.column(columnWrapper.getColumn()).append(stringBuilder);
            }
            stringBuilder.append("---\n");
        }
        for (final ColumnWrapper columnWrapper: columnWrappers.stream().filter(NOT_PK).collect(Collectors.toList())) {
            entityRelationDiagramColumnGenerator.column(columnWrapper.getColumn()).append(stringBuilder);
        }
        stringBuilder.append("}");
        stringBuilder.append("\n");
        stringBuilder.append("\n");
        return stringBuilder;
    }

}
