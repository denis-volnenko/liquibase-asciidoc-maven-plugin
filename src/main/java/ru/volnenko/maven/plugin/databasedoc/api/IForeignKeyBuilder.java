package ru.volnenko.maven.plugin.databasedoc.api;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.builder.ChangeBuilder;
import ru.volnenko.maven.plugin.databasedoc.builder.ColumnItemBuilder;
import ru.volnenko.maven.plugin.databasedoc.model.Root;

public interface IForeignKeyBuilder extends IRootBuilder {

    @NonNull
    ColumnItemBuilder add();

    @NonNull
    ChangeBuilder change();
}
