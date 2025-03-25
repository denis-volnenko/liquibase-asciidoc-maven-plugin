package ru.volnenko.maven.plugin.databasedoc.builder;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.api.IChangeBuilder;
import ru.volnenko.maven.plugin.databasedoc.model.Change;
import ru.volnenko.maven.plugin.databasedoc.model.Root;

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
