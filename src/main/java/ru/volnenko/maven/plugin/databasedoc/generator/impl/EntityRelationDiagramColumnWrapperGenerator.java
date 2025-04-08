package ru.volnenko.maven.plugin.databasedoc.generator.impl;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.enumerated.ErdType;
import ru.volnenko.maven.plugin.databasedoc.generator.IEntityRelationDiagramColumnWrapperGenerator;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Column;
import ru.volnenko.maven.plugin.databasedoc.model.impl.ColumnWrapper;
import ru.volnenko.maven.plugin.databasedoc.model.impl.CreateTable;
import ru.volnenko.maven.plugin.databasedoc.util.StringUtil;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class EntityRelationDiagramColumnWrapperGenerator extends AbstractGenerator implements IEntityRelationDiagramColumnWrapperGenerator {

    @NonNull
    private final EntityRelationDiagramColumnGenerator entityRelationDiagramColumnGenerator = new EntityRelationDiagramColumnGenerator();

    @NonNull
    private CreateTable createTable = new CreateTable();

    @NonNull
    private List<ColumnWrapper> columnWrappers = Collections.emptyList();

    @NonNull
    private ErdType erdType = ErdType.PHYSIC;

    @Override
    @NonNull
    public ErdType erdType() {
        return erdType;
    }

    @Override
    @NonNull
    public EntityRelationDiagramColumnWrapperGenerator erdType(@NonNull final ErdType erdType) {
        this.erdType = erdType;
        return this;
    }

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

    private static final Predicate<ColumnWrapper> PK_PREDICATE = new Predicate<ColumnWrapper>() {
        @Override
        public boolean test(ColumnWrapper columnWrapper) {
            if (columnWrapper == null) return false;
            if (columnWrapper.getColumn() == null) return false;
            if (columnWrapper.getColumn().getConstraints() == null) return false;
            if (columnWrapper.getColumn().getConstraints().getPrimaryKey() == null) return false;
            return columnWrapper.getColumn().getConstraints().getPrimaryKey();
        }
    };

    private static final Predicate<ColumnWrapper> NOT_PK_PREDICATE = new Predicate<ColumnWrapper>() {
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
        return columnWrappers.stream().anyMatch(PK_PREDICATE);
    }

    @NonNull
    private String tableName() {
        @NonNull final String tableName = StringUtil.format(createTable.getTableName());
        if (erdType.isPhysic()) return "\"" + tableName + "\"";
        if (erdType.isLogic()) {
            final String name = createTable.getRemarks();
            if (name == null || name.isEmpty()) return "\"" + tableName + "\"";
            return "\"" + name + "\" as " + tableName;
        }
        return "\"" + tableName + "\"";
    }

    @NonNull
    @Override
    public StringBuilder append(@NonNull final StringBuilder stringBuilder) {
        stringBuilder.append("entity " + tableName() + " {");
        stringBuilder.append("\n");
        if (hasPK()) {
            for (final ColumnWrapper columnWrapper: columnWrappers.stream().filter(PK_PREDICATE).collect(Collectors.toList())) {
                final Column column = columnWrapper.getColumn();
                if (column == null) continue;
                entityRelationDiagramColumnGenerator.erdType(erdType).column(column).append(stringBuilder);

            }
            stringBuilder.append("---\n");
        }
        for (final ColumnWrapper columnWrapper: columnWrappers.stream().filter(NOT_PK_PREDICATE).collect(Collectors.toList())) {
            final Column column = columnWrapper.getColumn();
            if (column == null) continue;
            entityRelationDiagramColumnGenerator.erdType(erdType).column(columnWrapper.getColumn()).append(stringBuilder);
        }
        stringBuilder.append("}");
        stringBuilder.append("\n");
        stringBuilder.append("\n");
        return stringBuilder;
    }

}
