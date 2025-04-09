package ru.volnenko.maven.plugin.databasedoc.builder.impl;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.builder.IChangeBuilder;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Change;
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

    @NonNull
    @Override
    public CreateTableBuilder createTable() {
        return new CreateTableBuilder(this);
    }

    @NonNull
    @Override
    public CreateTypeBuilder createType() {
        return new CreateTypeBuilder(this);
    }

    @NonNull
    @Override
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
