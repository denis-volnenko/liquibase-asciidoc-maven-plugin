package ru.volnenko.maven.plugin.databasedoc.api;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.generator.CreateTableDocumentGenerator;
import ru.volnenko.maven.plugin.databasedoc.model.Root;

import java.util.List;

public interface ICreateTableDocumentGenerator {

    @NonNull
    CreateTableDocumentGenerator serviceName(@NonNull String serviceName);

    @NonNull
    CreateTableDocumentGenerator dataBaseInfo(@NonNull String dataBaseInfo);

    @NonNull
    CreateTableDocumentGenerator roots(@NonNull List<Root> roots);

}
