package ru.volnenko.maven.plugin.databasedoc.builder.impl;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.builder.IChangeBuilder;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Change;
import ru.volnenko.maven.plugin.databasedoc.model.impl.CreateType;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Root;

public final class ChangeBuilder implements IChangeBuilder {

    @NonNull
    private final ChangeSetItemBuilder changeSetItemBuilder;

    @NonNull
    private final Change change = new Change();

    public ChangeBuilder(@NonNull ChangeSetItemBuilder changeSetItemBuilder) {
        this.changeSetItemBuilder = changeSetItemBuilder;
        changeSetItemBuilder.changeSet().add(change);
    }

    @Override
    @NonNull
    public CreateTableBuilder createTable() {
        return new CreateTableBuilder(this);
    }

    @NonNull
    public CreateTypeBuilder createType() {
        return new CreateTypeBuilder(this);
    }

    @Override
    @NonNull
    public Change change() {
        return change;
    }

    @NonNull
    @Override
    public Root root() {
        return changeSetItemBuilder.root();
    }

    @Override
    @NonNull
    public ChangeBuilder and() {
        return new ChangeBuilder(changeSetItemBuilder);
    }

}
