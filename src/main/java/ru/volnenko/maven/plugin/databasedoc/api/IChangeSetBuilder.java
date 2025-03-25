package ru.volnenko.maven.plugin.databasedoc.api;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.builder.ChangeSetItemBuilder;

public interface IChangeSetBuilder extends IRootBuilder {

    @NonNull
    ChangeSetItemBuilder add();

}
