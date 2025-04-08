package ru.volnenko.maven.plugin.databasedoc.generator.impl;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.generator.IDocumentGenerator;
import ru.volnenko.maven.plugin.databasedoc.util.StringUtil;

public final class DocumentGenerator extends AbstractGenerator implements IDocumentGenerator {

    @NonNull
    private Boolean headerFirstEnabled = true;

    @NonNull
    private Boolean tableOfContentsEnabled = true;

    @NonNull
    private Boolean headerSecondEnabled = true;

    @NonNull
    private String serviceName = "";

    @NonNull
    private Boolean entityRelationDiagramEnabled = true;

    @NonNull
    private Boolean entityRelationDiagramInclude = true;

    @NonNull
    public boolean entityRelationDiagramPhysicEnabled = true;

    @NonNull
    public boolean entityRelationDiagramLogicEnabled = true;

    @NonNull
    @Override
    public IDocumentGenerator entityRelationDiagramPhysicEnabled(@NonNull final Boolean entityRelationDiagramPhysicEnabled) {
        this.entityRelationDiagramPhysicEnabled = entityRelationDiagramPhysicEnabled;
        return this;
    }

    @NonNull

    @Override
    public IDocumentGenerator entityRelationDiagramLogicEnabled(@NonNull final Boolean entityRelationDiagramLogicEnabled) {
        this.entityRelationDiagramLogicEnabled = entityRelationDiagramLogicEnabled;
        return this;
    }

    @NonNull
    @Override
    public IDocumentGenerator entityRelationDiagramEnabled(@NonNull final Boolean entityRelationDiagramEnabled) {
        this.entityRelationDiagramEnabled = entityRelationDiagramEnabled;
        return this;
    }

    @NonNull
    @Override
    public IDocumentGenerator entityRelationDiagramInclude(@NonNull final Boolean entityRelationDiagramInclude) {
        this.entityRelationDiagramInclude = entityRelationDiagramInclude;
        return this;
    }

    @NonNull
    @Override
    public IDocumentGenerator headerFirstEnabled(@NonNull final Boolean headerFirstEnabled) {
        this.headerFirstEnabled = headerFirstEnabled;
        return this;
    }

    @NonNull
    @Override
    public IDocumentGenerator tableOfContentsEnabled(@NonNull final Boolean tableOfContentsEnabled) {
        this.tableOfContentsEnabled = tableOfContentsEnabled;
        return this;
    }

    @NonNull
    @Override
    public IDocumentGenerator headerSecondEnabled(@NonNull final Boolean headerSecondEnabled) {
        this.headerSecondEnabled = headerSecondEnabled;
        return this;
    }

    @NonNull
    @Override
    public IDocumentGenerator serviceName(@NonNull final String serviceName) {
        this.serviceName = serviceName;
        return this;
    }

    @NonNull
    @Override
    public StringBuilder append(@NonNull final StringBuilder stringBuilder) {
        if (headerFirstEnabled) {
            stringBuilder.append("= " + StringUtil.format(serviceName) + "\n");
            if (tableOfContentsEnabled) {
                stringBuilder.append(":toc-title: Оглавление\n");
                stringBuilder.append(":toc:\n");
            }
            stringBuilder.append("\n");
        }
        if (headerSecondEnabled) {
            stringBuilder.append("== Представление данных\n");
        }
        if (entityRelationDiagramEnabled) {
            if (entityRelationDiagramInclude) {
                stringBuilder.append("\n");
                stringBuilder.append("=== ER-диаграмма базы данных \n");
                stringBuilder.append("\n");
                stringBuilder.append("image::erd.svg[] \n");
                stringBuilder.append("\n");
            }
        }
        return stringBuilder;
    }

}
