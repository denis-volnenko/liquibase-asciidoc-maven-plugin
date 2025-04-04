package ru.volnenko.maven.plugin.databasedoc.exporter;

import lombok.NonNull;

public interface IExporter {

    @NonNull
    IExporter enable(boolean enable);

}
