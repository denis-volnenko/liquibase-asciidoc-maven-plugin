package ru.volnenko.maven.plugin.databasedoc.exporter;

import lombok.Getter;
import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.exporter.impl.*;

public final class Exporters implements IExporters {

    @Getter
    @NonNull
    private final IExporter adoc = new ExporterAdoc();

    @Getter
    @NonNull
    private final IExporter svg = new ExporterSvg();

    @Getter
    @NonNull
    private final IExporter json = new ExporterJson();

    @Getter
    @NonNull
    private final IExporter yaml = new ExporterYaml();

    @Getter
    @NonNull
    private final IExporter puml = new ExporterPuml();

    @NonNull
    @Override
    public IExporter adoc() {
        return adoc;
    }

    @NonNull
    @Override
    public IExporter svg() {
        return svg;
    }

    @NonNull
    @Override
    public IExporter json() {
        return json;
    }

    @NonNull
    @Override
    public IExporter yaml() {
        return yaml;
    }

    @NonNull
    @Override
    public IExporter puml() {
        return puml;
    }

}
