package ru.volnenko.maven.plugin.databasedoc.builder;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.ChangeBuilder;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.CreateTableBuilder;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Change;

public interface IChangeBuilder extends IRootBuilder {

    @NonNull
    CreateTableBuilder createTable();

    @NonNull
    Change change();

    @NonNull
    ChangeBuilder and();

}
