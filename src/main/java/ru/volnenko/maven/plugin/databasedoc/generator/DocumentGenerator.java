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
        return stringBuilder;
    }

}
