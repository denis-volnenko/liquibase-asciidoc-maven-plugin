package ru.volnenko.maven.plugin.databasedoc.generator;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.model.impl.ColumnWrapper;
import ru.volnenko.maven.plugin.databasedoc.model.impl.CreateTable;

import java.util.List;

public interface IEntityRelationDiagramColumnWrapperGenerator extends IGenerator {

    @NonNull
    IEntityRelationDiagramColumnWrapperGenerator createTable(@NonNull CreateTable createTable);

    @NonNull
    IEntityRelationDiagramColumnWrapperGenerator stringBuilder(@NonNull StringBuilder stringBuilder);

    @NonNull
    IEntityRelationDiagramColumnWrapperGenerator columnWrappers(@NonNull List<ColumnWrapper> columnWrappers);

}
