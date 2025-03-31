package ru.volnenko.maven.plugin.databasedoc.api;

import lombok.NonNull;

public interface IDocumentGenerator extends IGenerator {

    @NonNull
    IDocumentGenerator entityRelationDiagramEnabled(@NonNull Boolean entityRelationDiagramEnabled);

    @NonNull
    IDocumentGenerator entityRelationDiagramInclude(@NonNull Boolean entityRelationDiagramInclude);

    @NonNull
    IDocumentGenerator headerFirstEnabled(@NonNull Boolean headerFirstEnabled);

    @NonNull
    IDocumentGenerator tableOfContentsEnabled(@NonNull Boolean tableOfContentsEnabled);

    @NonNull
    IDocumentGenerator headerSecondEnabled(@NonNull Boolean headerSecondEnabled);

    @NonNull
    IDocumentGenerator serviceName(@NonNull String serviceName);

}
