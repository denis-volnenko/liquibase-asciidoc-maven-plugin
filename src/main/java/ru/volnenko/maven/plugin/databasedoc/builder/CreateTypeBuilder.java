package ru.volnenko.maven.plugin.databasedoc.builder;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.api.ICreateTableBuilder;
import ru.volnenko.maven.plugin.databasedoc.model.Root;

public final class CreateTypeBuilder implements ICreateTableBuilder {

    @NonNull
    @Override
    public Root root() {
        return null;
    }

}
