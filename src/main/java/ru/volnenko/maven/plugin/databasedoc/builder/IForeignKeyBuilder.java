package ru.volnenko.maven.plugin.databasedoc.builder;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.ChangeBuilder;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.ColumnItemBuilder;

public interface IForeignKeyBuilder extends IRootBuilder {

    @NonNull
    ColumnItemBuilder add();

    @NonNull
    ChangeBuilder change();
}
