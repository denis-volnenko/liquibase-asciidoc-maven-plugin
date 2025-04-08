package ru.volnenko.maven.plugin.databasedoc.builder;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.*;

public abstract class AbstractBuilderTest {

    protected final String foreignKeyName = "ForeignKey name";
    protected final String uniqueConstraintName = "Unique constraint name";
    protected final String name = "Name";
    protected final String type = "Type";
    protected final String remarks = "Remarks";
    protected final String tableName = "Table name";
    protected final String catalogName = "Catalog name";
    protected final String tablespace = "Table space";
    protected final String typeName = "Type name";

    @NonNull
    private final RootBuilder rootBuilder = RootBuilder.create();

    @NonNull
    public DatabaseChangeLogBuilder changeLogBuilder() {
        return rootBuilder.dsl();
    }

    @NonNull
    public ChangeSetBuilder changeSetBuilder() {
        return changeLogBuilder().changeSet();
    }

    @NonNull
    public ForeignKeyBuilder foreignKeyBuilder() {
        return constraintsBuilder().foreignKey();
    }

    @NonNull
    public CreateTypeBuilder createTypeBuilder() {
        return changeBuilder()
                .createType();
    }

    @NonNull
    public CreateTableBuilder createTableBuilder() {
        return changeBuilder()
                .createTable();
    }

    @NonNull
    public ChangeBuilder changeBuilder() {
        return changeSetBuilder()
                .add()
                .change();
    }

    @NonNull
    public ColumnBuilder columnBuilder() {
        return createTableBuilder().column();
    }

    @NonNull ColumnItemBuilder columnItemBuilder() {
        return columnBuilder().add();
    }

    @NonNull
    public ConstraintsBuilder constraintsBuilder() {
        return columnItemBuilder().constraints();
    }

}
