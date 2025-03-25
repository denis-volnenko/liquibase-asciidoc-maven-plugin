package ru.volnenko.maven.plugin.databasedoc.api;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.builder.ChangeBuilder;
import ru.volnenko.maven.plugin.databasedoc.builder.CreateTableBuilder;
import ru.volnenko.maven.plugin.databasedoc.model.Change;

public interface IChangeBuilder extends IRootBuilder {

    @NonNull
    CreateTableBuilder createTable();

    @NonNull
    Change change();

    @NonNull
    ChangeBuilder and();

}
