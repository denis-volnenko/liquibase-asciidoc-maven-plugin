package ru.volnenko.maven.plugin.databasedoc.builder;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.ChangeSetBuilder;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.DatabaseChangeLogBuilder;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.RootBuilder;

public abstract class AbstractBuilderTest {

    @NonNull
    private final RootBuilder rootBuilder = RootBuilder.create();

    @NonNull
    public RootBuilder rootBuilder() {
        return rootBuilder;
    }

    @NonNull
    public DatabaseChangeLogBuilder changeLogBuilder() {
        return rootBuilder.dsl();
    }

    @NonNull
    public ChangeSetBuilder changeSetBuilder() {
        return changeLogBuilder().changeSet();
    }

}
