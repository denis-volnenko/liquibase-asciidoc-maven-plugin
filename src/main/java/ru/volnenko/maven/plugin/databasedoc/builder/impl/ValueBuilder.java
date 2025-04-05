package ru.volnenko.maven.plugin.databasedoc.builder.impl;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.builder.IValueBuilder;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Root;

public final class ValueBuilder implements IValueBuilder {

    @NonNull
    @Override
    public Root root() {
        return null;
    }

}
