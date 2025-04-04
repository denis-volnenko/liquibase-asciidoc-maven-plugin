package ru.volnenko.maven.plugin.databasedoc.exporter;

import lombok.NonNull;

public final class Exporters implements IExporters {

    @NonNull
    @Override
    public IExporter adoc() {
        return null;
    }

    @NonNull
    @Override
    public IExporter svg() {
        return null;
    }

    @NonNull
    @Override
    public IExporter json() {
        return null;
    }

    @NonNull
    @Override
    public IExporter yaml() {
        return null;
    }

    @NonNull
    @Override
    public IExporter puml() {
        return null;
    }

}
