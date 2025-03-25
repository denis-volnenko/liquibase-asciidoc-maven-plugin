package ru.volnenko.maven.plugin.databasedoc.builder;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.api.ICreateTableBuilder;
import ru.volnenko.maven.plugin.databasedoc.api.ICreateTypeBuilder;
import ru.volnenko.maven.plugin.databasedoc.model.CreateType;
import ru.volnenko.maven.plugin.databasedoc.model.Root;

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
    public CreateTypeBuilder catalogName(final String catalogName) {
        createType.setCatalogName(catalogName);
        return this;
    }

    @NonNull
    public CreateTypeBuilder tablespace(final String tablespace) {
        createType.setTablespace(tablespace);
        return this;
    }

    @NonNull
    public CreateTypeBuilder typeName(final String typeName) {
        createType.setTypeName(typeName);
        return this;
    }

    @NonNull
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
    public ChangeBuilder change() {
        return changeBuilder.and();
    }

}
