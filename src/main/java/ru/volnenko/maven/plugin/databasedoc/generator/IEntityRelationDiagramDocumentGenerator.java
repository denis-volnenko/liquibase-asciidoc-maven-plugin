package ru.volnenko.maven.plugin.databasedoc.generator;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Root;

import java.util.List;

public interface IEntityRelationDiagramDocumentGenerator extends IGenerator {

    @NonNull
    IEntityRelationDiagramDocumentGenerator roots(@NonNull List<Root> roots);

    @NonNull
    IEntityRelationDiagramDocumentGenerator internal();

    @NonNull
    IEntityRelationDiagramDocumentGenerator external();

}
