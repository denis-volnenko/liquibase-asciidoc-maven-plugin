package ru.volnenko.maven.plugin.databasedoc.builder.impl;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.builder.IValueItemBuilder;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Root;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Value;

public class ValueItemBuilder implements IValueItemBuilder {

    @NonNull
    private final ValueBuilder valueBuilder;

    @NonNull
    private final Value value = new Value();

    public ValueItemBuilder(@NonNull ValueBuilder valueBuilder) {
        this.valueBuilder = valueBuilder;
        valueBuilder.createType().add(value);
    }

    @NonNull
    public ValueItemBuilder add() {
        return valueBuilder.add();
    }

    @NonNull
    public ValueItemBuilder name(final String name) {
        value.setName(name);
        return this;
    }

    @NonNull
    public ValueItemBuilder remarks(final String remarks) {
        value.setRemarks(remarks);
        return this;
    }

    @NonNull
    public Value value() {
        return value;
    }

    @NonNull
    public Root root() {
        return valueBuilder.root();
    }

    @NonNull
    public ChangeBuilder change() {
        return valueBuilder.change();
    }

}
