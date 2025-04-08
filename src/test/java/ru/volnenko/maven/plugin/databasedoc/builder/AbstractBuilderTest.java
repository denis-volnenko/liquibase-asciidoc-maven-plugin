package ru.volnenko.maven.plugin.databasedoc.builder;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.*;
import ru.volnenko.maven.plugin.databasedoc.model.impl.*;

import java.util.List;

public abstract class AbstractBuilderTest {

    protected final String foreignKeyName = "ForeignKey name";
    protected final String expectedForeignKeyName = "ForeignKey name";

    protected final String uniqueConstraintName = "Unique constraint name";
    protected final String expectedUniqueConstraintName = "Unique constraint name";

    protected final String name = "Name";
    protected final String expectedName = "Name";

    protected final String type = "Type";
    protected final String expectedType = "Type";

    protected final String remarks = "Remarks";
    protected final String expectedRemarks = "Remarks";

    protected final String tableName = "Table name";
    protected final String expectedTableName = "Table name";

    protected final String catalogName = "Catalog name";
    protected final String expectedCatalogName = "Catalog name";

    protected final String tablespace = "Table space";
    protected final String expectedTablespace = "Table space";

    protected final String typeName = "Type name";
    protected final String expectedTypeName = "Type name";

    protected final String id = "id";
    protected final String expectedId = "id";

    protected final String author = "author";
    protected final String expectedAuthor = "author";

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
