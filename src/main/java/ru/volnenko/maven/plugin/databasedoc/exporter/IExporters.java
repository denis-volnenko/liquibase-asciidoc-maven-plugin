package ru.volnenko.maven.plugin.databasedoc.exporter;

import lombok.NonNull;

public interface IExporters {

    @NonNull
    IExporter adoc();

    @NonNull
    IExporter svg();

    @NonNull
    IExporter json();

    @NonNull
    IExporter yaml();

    @NonNull
    IExporter puml();

}
