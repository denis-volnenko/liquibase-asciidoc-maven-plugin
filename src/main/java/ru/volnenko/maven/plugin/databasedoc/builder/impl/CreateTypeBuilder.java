package ru.volnenko.maven.plugin.databasedoc.builder.impl;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.builder.ICreateTypeBuilder;
import ru.volnenko.maven.plugin.databasedoc.model.impl.CreateType;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Root;

public final class CreateTypeBuilder implements ICreateTypeBuilder {

    @NonNull
    private final ChangeBuilder changeBuilder;

    @NonNull
    private final CreateType createType = new CreateType();

    public CreateTypeBuilder(@NonNull final ChangeBuilder changeBuilder) {
        this.changeBuilder = changeBuilder;
        changeBuilder.change().setCreateType(createType);
    }

    @NonNull
    @Override
    public CreateTypeBuilder catalogName(final String catalogName) {
        createType.setCatalogName(catalogName);
        return this;
    }

    @NonNull
    @Override
    public CreateTypeBuilder tablespace(final String tablespace) {
        createType.setTablespace(tablespace);
        return this;
    }

    @NonNull
    @Override
    public CreateTypeBuilder typeName(final String typeName) {
        createType.setTypeName(typeName);
        return this;
    }

    @NonNull
    @Override
    public CreateTypeBuilder remarks(final String remarks) {
        createType.setRemarks(remarks);
        return this;
    }

    @NonNull
    @Override
    public Root root() {
        return changeBuilder.root();
    }

    @NonNull
    @Override
    public ChangeBuilder change() {
        return changeBuilder.and();
    }

    @NonNull
    @Override
    public CreateType createType() {
        return createType;
    }

    @NonNull
    public ValueBuilder value() {
        return new ValueBuilder(this);
    }

}
