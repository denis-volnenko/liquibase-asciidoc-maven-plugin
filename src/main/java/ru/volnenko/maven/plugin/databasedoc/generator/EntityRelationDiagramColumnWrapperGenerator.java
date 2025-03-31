package ru.volnenko.maven.plugin.databasedoc.generator;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.model.ColumnWrapper;

public final class EntityRelationDiagramColumnWrapperGenerator extends AbstractGenerator {

    @NonNull
    private ColumnWrapper[] columnWrappers = new ColumnWrapper[] {};

    @NonNull
    private EntityRelationDiagramColumnGenerator entityRelationDiagramColumnGenerator = new EntityRelationDiagramColumnGenerator();

    @NonNull
    public EntityRelationDiagramColumnWrapperGenerator stringBuilder(@NonNull final StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
        return this;
    }


    @NonNull
    public EntityRelationDiagramColumnWrapperGenerator columnWrappers(@NonNull final ColumnWrapper[] columnWrappers) {
        this.columnWrappers = columnWrappers;
        return this;
    }

    @NonNull
    @Override
    public StringBuilder append(@NonNull final StringBuilder stringBuilder) {
        for (final ColumnWrapper columnWrapper : columnWrappers) {
            entityRelationDiagramColumnGenerator
                    .column(columnWrapper.getColumn())
                    .append(stringBuilder);
        }
        return stringBuilder;
    }

}
