package ru.volnenko.maven.plugin.databasedoc.builder.impl;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.builder.IValueBuilder;
import ru.volnenko.maven.plugin.databasedoc.model.impl.CreateType;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Root;

public final class ValueBuilder implements IValueBuilder {

    @NonNull
    private final CreateTypeBuilder createTypeBuilder;

    public ValueBuilder(@NonNull final CreateTypeBuilder createTypeBuilder) {
        this.createTypeBuilder = createTypeBuilder;
    }

    @NonNull
    public ValueItemBuilder add() {
        return new ValueItemBuilder(this);
    }

    @NonNull
    public CreateType createType() {
        return createTypeBuilder.createType();
    }

    @NonNull
    @Override
    public Root root() {
        return createTypeBuilder.root();
    }

    @NonNull
    public ChangeBuilder change() {
        return createTypeBuilder.change();
    }

}
