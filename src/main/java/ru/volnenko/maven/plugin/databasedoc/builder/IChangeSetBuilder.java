package ru.volnenko.maven.plugin.databasedoc.builder;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.ChangeSetItemBuilder;

public interface IChangeSetBuilder extends IRootBuilder {

    @NonNull
    ChangeSetItemBuilder add();

}
