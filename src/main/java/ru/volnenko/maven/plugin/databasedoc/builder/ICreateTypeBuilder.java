package ru.volnenko.maven.plugin.databasedoc.builder;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.ChangeBuilder;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.CreateTypeBuilder;
import ru.volnenko.maven.plugin.databasedoc.model.impl.CreateType;

public interface ICreateTypeBuilder extends IRootBuilder {

    @NonNull
    CreateTypeBuilder catalogName(String catalogName);

    @NonNull
    CreateTypeBuilder tablespace(String tablespace);

    @NonNull
    CreateTypeBuilder typeName(String typeName);

    @NonNull
    CreateTypeBuilder remarks(String remarks);

    @NonNull
    ChangeBuilder change();

    @NonNull
    CreateType createType();

}
