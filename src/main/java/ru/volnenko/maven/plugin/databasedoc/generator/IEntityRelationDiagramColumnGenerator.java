package ru.volnenko.maven.plugin.databasedoc.generator;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Column;

public interface IEntityRelationDiagramColumnGenerator extends IGenerator {

    @NonNull
    IEntityRelationDiagramColumnGenerator stringBuilder(@NonNull StringBuilder stringBuilder);

    @NonNull
    IEntityRelationDiagramColumnGenerator column(@NonNull Column column);

}
