package ru.volnenko.maven.plugin.databasedoc.exporter;

import lombok.NonNull;

public abstract class AbstractExporter implements IExporter {

    private boolean enable = false;

    @NonNull
    @Override
    public IExporter enable(boolean enable) {
        this.enable = enable;
        return this;
    }

}
