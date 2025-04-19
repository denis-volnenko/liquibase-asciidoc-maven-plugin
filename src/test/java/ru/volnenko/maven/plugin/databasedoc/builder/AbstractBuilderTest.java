package ru.volnenko.maven.plugin.databasedoc.builder;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.*;
import ru.volnenko.maven.plugin.databasedoc.model.impl.*;

import java.util.List;

public abstract class AbstractBuilderTest {

    @NonNull
    protected static final String FOREIGN_KEY_NAME = "ForeignKey name";

    @NonNull
    protected static final String EXPECTED_FOREIGN_KEY_NAME = "ForeignKey name";

    @NonNull
    protected static final String UNIQUE_CONSTRAINT_NAME = "Unique constraint name";

    @NonNull
    protected static final String EXPECTED_UNIQUE_CONSTRAINT_NAME = "Unique constraint name";

    @NonNull
    protected static final String NAME = "Name";

    @NonNull
    protected static final String EXPECTED_NAME = "Name";

    @NonNull
    protected static final String TYPE = "Type";

    @NonNull
    protected static final String EXPECTED_TYPE = "Type";

    @NonNull
    protected static final String REMARKS = "Remarks";

    @NonNull
    protected static final String EXPECTED_REMARKS = "Remarks";

    @NonNull
    protected static final String TABLE_NAME = "Table name";

    @NonNull
    protected static final String EXPECTED_TABLE_NAME = "Table name";

    @NonNull
    protected static final String CATALOG_NAME = "Catalog name";

    @NonNull
    protected static final String EXPECTED_CATALOG_NAME = "Catalog name";

    @NonNull
    protected static final String TABLESPACE = "Table space";

    @NonNull
    protected static final String EXPECTED_TABLESPACE = "Table space";

    @NonNull
    protected static final String TYPE_NAME = "Type name";

    @NonNull
    protected static final String EXPECTED_TYPE_NAME = "Type name";

    @NonNull
    protected static final String ID = "Id";

    @NonNull
    protected static final String EXPECTED_ID = "Id";

    @NonNull
    protected static final String AUTHOR = "Author";

    @NonNull
    protected static final String EXPECTED_AUTHOR = "Author";

    @NonNull
    protected static final Integer INTEGER_VALUE = 1;

    @NonNull
    protected static final String EXPECTED_INTEGER_TO_STRING_VALUE = "01";

    @NonNull
    protected static final String STRING_VALUE = "String value";

    @NonNull
    protected static final String EMPTY_STRING = "";

    @NonNull
    protected static final String CHECK_MARK = "✓";

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

    @NonNull
    public ValueBuilder valueBuilder() {
        return createTypeBuilder().value();
    }

    @NonNull ColumnItemBuilder columnItemBuilder() {
        return columnBuilder().add();
    }

    @NonNull ValueItemBuilder valueItemBuilder() {
        return valueBuilder().add();
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

    @NonNull
    public Value getValue(@NonNull final IRootBuilder builder) {
        return getFirstType(builder)
                .getValues()
                .get(0)
                .getValue();
    }

}
