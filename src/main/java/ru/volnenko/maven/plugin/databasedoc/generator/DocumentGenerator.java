package ru.volnenko.maven.plugin.databasedoc.generator;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.util.StringUtil;

public final class DocumentGenerator extends AbstractGenerator {

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
    public DocumentGenerator entityRelationDiagramEnabled(@NonNull final Boolean entityRelationDiagramEnabled) {
        this.entityRelationDiagramEnabled = entityRelationDiagramEnabled;
        return this;
    }

    @NonNull
    public DocumentGenerator entityRelationDiagramInclude(@NonNull final Boolean entityRelationDiagramInclude) {
        this.entityRelationDiagramInclude = entityRelationDiagramInclude;
        return this;
    }

    @NonNull
    public DocumentGenerator headerFirstEnabled(@NonNull final Boolean headerFirstEnabled) {
        this.headerFirstEnabled = headerFirstEnabled;
        return this;
    }

    @NonNull
    public DocumentGenerator tableOfContentsEnabled(@NonNull final Boolean tableOfContentsEnabled) {
        this.tableOfContentsEnabled = tableOfContentsEnabled;
        return this;
    }

    @NonNull
    public DocumentGenerator headerSecondEnabled(@NonNull final Boolean headerSecondEnabled) {
        this.headerSecondEnabled = headerSecondEnabled;
        return this;
    }

    @NonNull
    public DocumentGenerator serviceName(@NonNull final String serviceName) {
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
