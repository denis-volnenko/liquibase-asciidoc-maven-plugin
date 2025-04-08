package ru.volnenko.maven.plugin.databasedoc.generator;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.enumerated.ErdType;
import ru.volnenko.maven.plugin.databasedoc.generator.impl.EntityRelationDiagramColumnWrapperGenerator;
import ru.volnenko.maven.plugin.databasedoc.model.impl.ColumnWrapper;
import ru.volnenko.maven.plugin.databasedoc.model.impl.CreateTable;

import java.util.List;

public interface IEntityRelationDiagramColumnWrapperGenerator extends IGenerator {

    @NonNull ErdType erdType();

    @NonNull EntityRelationDiagramColumnWrapperGenerator erdType(@NonNull ErdType erdType);

    @NonNull
    IEntityRelationDiagramColumnWrapperGenerator createTable(@NonNull CreateTable createTable);

    @NonNull
    IEntityRelationDiagramColumnWrapperGenerator stringBuilder(@NonNull StringBuilder stringBuilder);

    @NonNull
    IEntityRelationDiagramColumnWrapperGenerator columnWrappers(@NonNull List<ColumnWrapper> columnWrappers);

}
