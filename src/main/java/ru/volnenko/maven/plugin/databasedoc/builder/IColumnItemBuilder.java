package ru.volnenko.maven.plugin.databasedoc.builder;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.ChangeBuilder;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.ColumnItemBuilder;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.ConstraintsBuilder;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Column;

public interface IColumnItemBuilder extends IRootBuilder {

    @NonNull
    ColumnItemBuilder add();

    @NonNull
    ConstraintsBuilder constraints();

    @NonNull
    ColumnItemBuilder name(String name);

    @NonNull
    ColumnItemBuilder type(String type);

    @NonNull
    ColumnItemBuilder remarks(String remarks);

    @NonNull
    ColumnItemBuilder autoIncrement(Boolean autoIncrement);

    @NonNull
    Column column();

    @NonNull
    ChangeBuilder change();

}
