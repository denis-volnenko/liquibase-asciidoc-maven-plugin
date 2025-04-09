package ru.volnenko.maven.plugin.databasedoc.builder;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.*;
import ru.volnenko.maven.plugin.databasedoc.model.impl.*;

import java.util.List;

public abstract class AbstractBuilderTest {

    protected static final String FOREIGN_KEY_NAME          = "ForeignKey name";
    protected static final String EXPECTED_FOREIGN_KEY_NAME = "ForeignKey name";

    protected static final String UNIQUE_CONSTRAINT_NAME          = "Unique constraint name";
    protected static final String EXPECTED_UNIQUE_CONSTRAINT_NAME = "Unique constraint name";

    protected static final String NAME          = "Name";
    protected static final String EXPECTED_NAME = "Name";

    protected static final String TYPE          = "Type";
    protected static final String EXPECTED_TYPE = "Type";

    protected static final String REMARKS          = "Remarks";
    protected static final String EXPECTED_REMARKS = "Remarks";

    protected static final String TABLE_NAME          = "Table name";
    protected static final String EXPECTED_TABLE_NAME = "Table name";

    protected static final String CATALOG_NAME          = "Catalog name";
    protected static final String EXPECTED_CATALOG_NAME = "Catalog name";

    protected static final String TABLESPACE          = "Table space";
    protected static final String EXPECTED_TABLESPACE = "Table space";

    protected static final String TYPE_NAME          = "Type name";
    protected static final String EXPECTED_TYPE_NAME = "Type name";

    protected static final String ID          = "id";
    protected static final String EXPECTED_ID = "id";

    protected static final String AUTHOR          = "author";
    protected static final String EXPECTED_AUTHOR = "author";

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

    @NonNull
    public List<Change> getChanges(@NonNull final IRootBuilder builder) {
        return builder.root()
                .getDatabaseChangeLog()
                .get(0)
                .getChangeSet()
                .getChanges();
    }

    @NonNull
    public CreateType getFirstType(@NonNull final IRootBuilder builder) {
        return getChanges(builder)
                .get(0)
                .getCreateType();
    }

    @NonNull
    public CreateTable getFirstTable(@NonNull final IRootBuilder builder) {
        return getChanges(builder)
                .get(0)
                .getCreateTable();
    }

    @NonNull
    public Constraints getConstraints(@NonNull final IRootBuilder builder) {
        return getColumn(builder)
                .getConstraints();
    }

    @NonNull
    public Column getColumn(@NonNull final IRootBuilder builder) {
        return getFirstTable(builder)
                .getColumns()
                .get(0)
                .getColumn();
    }

}
