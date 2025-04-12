package ru.volnenko.maven.plugin.databasedoc.util;

import lombok.NonNull;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.AbstractBuilderTest;
import ru.volnenko.maven.plugin.databasedoc.model.impl.*;

import java.util.*;

@Ignore
public class OldForeignKeyUtilTest extends AbstractBuilderTest {

    @NonNull
    private final Root root = new Root();

    private final Root rootNull = null;

    @NonNull
    final Root rootWithDCL = new Root();

    @NonNull
    private final Root rootWithDCLEmptyList = new Root();

    @NonNull
    private final Root rootWithDCLNull = new Root();

    @NonNull
    private final ChangeSet changeSetWithChanges = new ChangeSet();

    @NonNull
    private final List<DatabaseChangeLog> listOfDatabaseChangeLogs = Arrays.asList(new DatabaseChangeLog(), new DatabaseChangeLog());

    @NonNull
    private final List<DatabaseChangeLog> listOfOneDatabaseChangeLog = Arrays.asList(new DatabaseChangeLog());

    private final DatabaseChangeLog databaseChangeLogNull = null;

    @NonNull
    private final List<Change> changes = Arrays.asList(new Change(), new Change());

    private final List<Change> changesNull = null;

    private final Change changeNull = null;

    @NonNull
    private final Column column = new Column();

    @NonNull
    private final Constraints constraints = new Constraints();

    @NonNull
    private final ForeignKey foreignKey = new ForeignKey();

    @NonNull
    private final List<ColumnWrapper> wrappedColumns = Arrays.asList(
            new ColumnWrapper(column),
            new ColumnWrapper(column)
    );

    @NonNull
    private final List<ColumnWrapper> wrappedEmptyColumns = Arrays.asList(
            new ColumnWrapper(null),
            new ColumnWrapper(null)
    );

    @NonNull
    private final List<ColumnWrapper> emptyWrappedColumns = Arrays.asList(
            null,
            null
    );

    @NonNull
    private final Collection<Root> rootsList = new ArrayList<>();

    @NonNull
    private final Collection<Root> rootsSet = new LinkedHashSet<>();

    @NonNull
    private final CreateTable createTable = createTableBuilder().createTable();

    @NonNull
    private final AddForeignKeyConstraint constraint = new AddForeignKeyConstraint();

    @Test
    public void testNull() { // need to delete after refactor
        Assert.assertNotNull(ForeignKeyUtil.fks(rootsList));
        Assert.assertNotNull(ForeignKeyUtil.fks(rootsSet));
    }

    @Test
    public void testFksRoot() {
        rootWithDCLEmptyList.setDatabaseChangeLog(Collections.emptyList());
        Assert.assertNotNull(ForeignKeyUtil.fks(rootWithDCLEmptyList));
        Assert.assertEquals(Collections.emptySet(), ForeignKeyUtil.fks(rootWithDCLEmptyList));

        rootWithDCLNull.setDatabaseChangeLog(null);
        Assert.assertNotNull(ForeignKeyUtil.fks(rootWithDCLNull));
        Assert.assertEquals(Collections.emptySet(), ForeignKeyUtil.fks(rootWithDCLNull));

        Assert.assertNotNull(ForeignKeyUtil.fks(rootNull));
        Assert.assertEquals(Collections.emptySet(), ForeignKeyUtil.fks(rootNull));
        //
        createTable.setTableName(TABLE_NAME);
        column.setConstraints(constraints);
        column.setName(COLUMN_NAME);
        final List<ColumnWrapper> columnWrappers = Arrays.asList(
                new ColumnWrapper(column),
                new ColumnWrapper(column)
        );
        createTable.setColumns(columnWrappers);

        constraint.setBaseColumnNames(EMPTY_STRING);
        constraint.setBaseTableName(EMPTY_STRING);
        constraint.setReferencedColumnNames(EMPTY_STRING);
        constraint.setReferencedTableName(EMPTY_STRING);

        changes.get(0).setCreateTable(createTable);
        changes.get(0).setAddForeignKeyConstraint(constraint);
        // 1
        changeSetWithChanges.setChanges(changes);
        listOfDatabaseChangeLogs.get(0).setChangeSet(changeSetWithChanges);
        rootWithDCL.setDatabaseChangeLog(listOfDatabaseChangeLogs);
        Assert.assertNotNull(ForeignKeyUtil.fks(rootWithDCL));
        final Set<FK> result = new LinkedHashSet<>();

        result.addAll(ForeignKeyUtil.fk(createTable));
        result.add(ForeignKeyUtil.fk(changes.get(0).getAddForeignKeyConstraint()));
        Assert.assertEquals(result, ForeignKeyUtil.fks(rootWithDCL));
        // 2 changeLog (changeSet) is null
        result.clear();
        rootWithDCL.setDatabaseChangeLog(Arrays.asList(databaseChangeLogNull));
        Assert.assertEquals(result, ForeignKeyUtil.fks(rootWithDCL));
        // 3 changeSet is not null but changeLog is null
        result.clear();
        changeSetWithChanges.setChanges(Arrays.asList(changeNull));
        listOfOneDatabaseChangeLog.get(0).setChangeSet(changeSetWithChanges);
        rootWithDCL.setDatabaseChangeLog(listOfDatabaseChangeLogs);
        Assert.assertEquals(result, ForeignKeyUtil.fks(rootWithDCL));

    }

    @Test
    public void testFkCreateTable() {
        foreignKey.setReferencedColumnNames(COLUMN_NAME);
        foreignKey.setReferencedTableName(TABLE_NAME);
        constraints.setForeignKey(foreignKey);
        Assert.assertEquals(Collections.emptySet(), ForeignKeyUtil.fk((CreateTable) null));

        Assert.assertNotNull(ForeignKeyUtil.fk(createTable));

        createTable.setColumns(null);
        Assert.assertNotNull(ForeignKeyUtil.fk(createTable));

        createTable.setColumns(wrappedColumns);
        Assert.assertNotNull(ForeignKeyUtil.fk(createTable));

        createTable.setColumns(emptyWrappedColumns);
        Assert.assertNotNull(ForeignKeyUtil.fk(createTable));

        createTable.setColumns(wrappedEmptyColumns);
        Assert.assertNotNull(ForeignKeyUtil.fk(createTable));

        createTable.setTableName(TABLE_NAME);
        column.setConstraints(constraints);
        column.setName(COLUMN_NAME);
        final List<ColumnWrapper> columnWrappers = Arrays.asList(
                new ColumnWrapper(column),
                new ColumnWrapper(column)
        );
        createTable.setColumns(columnWrappers);
        final FK fk = ForeignKeyUtil.fk(createTable.getTableName(), column);
        final Set<FK> result = new LinkedHashSet<>();
        result.add(fk);
        Assert.assertNotNull(fk);
        Assert.assertEquals(result, ForeignKeyUtil.fk(createTable));
    }

    @Test
    public void testFkTableNameColumn() {
        Assert.assertNull(ForeignKeyUtil.fk(null, null));
        Assert.assertNull(ForeignKeyUtil.fk(TABLE_NAME, null));
        Assert.assertNull(ForeignKeyUtil.fk(null, column));
        Assert.assertNull(ForeignKeyUtil.fk(TABLE_NAME, column));

        column.setConstraints(null);
        Assert.assertNull(ForeignKeyUtil.fk(TABLE_NAME, column));

        constraints.setForeignKey(foreignKey);
        column.setConstraints(constraints);
        Assert.assertNull(ForeignKeyUtil.fk(TABLE_NAME, column));

        foreignKey.setReferencedTableName(EMPTY_STRING);
        constraints.setForeignKey(foreignKey);
        column.setConstraints(constraints);
        Assert.assertNull(ForeignKeyUtil.fk(TABLE_NAME, column));

        constraints.setForeignKey(foreignKey);
        column.setConstraints(constraints);
        Assert.assertNull(ForeignKeyUtil.fk(TABLE_NAME, column));

        foreignKey.setReferencedTableName(TABLE_NAME);
        foreignKey.setReferencedColumnNames(EMPTY_STRING);
        constraints.setForeignKey(foreignKey);
        column.setConstraints(constraints);
        Assert.assertNull(ForeignKeyUtil.fk(TABLE_NAME, column));

        foreignKey.setReferencedTableName(TABLE_NAME);
        foreignKey.setReferencedColumnNames(null);
        constraints.setForeignKey(foreignKey);
        column.setConstraints(constraints);
        Assert.assertNull(ForeignKeyUtil.fk(TABLE_NAME, column));

        foreignKey.setReferencedColumnNames(COLUMN_NAME);
        foreignKey.setReferencedTableName(TABLE_NAME);
        constraints.setForeignKey(foreignKey);
        column.setConstraints(constraints);
        Assert.assertNull(ForeignKeyUtil.fk(TABLE_NAME, column));

        column.setName(null);
        Assert.assertNull(ForeignKeyUtil.fk(TABLE_NAME, column));

        column.setName(EMPTY_STRING);
        Assert.assertNull(ForeignKeyUtil.fk(TABLE_NAME, column));

        foreignKey.setReferencedColumnNames(COLUMN_NAME);
        foreignKey.setReferencedTableName(TABLE_NAME);
        constraints.setForeignKey(foreignKey);
        column.setConstraints(constraints);
        column.setName(STRING_VALUE);
        column.getConstraints().setUnique(null);
        final FK result = ForeignKeyUtil.fk(TABLE_NAME, column);
        Assert.assertEquals(false, result.getUnique());
    }

    @Test
    public void testFkConstraint() {
        Assert.assertNull(ForeignKeyUtil.fk((AddForeignKeyConstraint) null));
        Assert.assertNull(ForeignKeyUtil.fk(constraint));
        constraint.setBaseColumnNames(EMPTY_STRING);
        Assert.assertNull(ForeignKeyUtil.fk(constraint));
        constraint.setBaseTableName(EMPTY_STRING);
        Assert.assertNull(ForeignKeyUtil.fk(constraint));
        constraint.setReferencedColumnNames(EMPTY_STRING);
        Assert.assertNull(ForeignKeyUtil.fk(constraint));
        constraint.setReferencedTableName(EMPTY_STRING);
        Assert.assertNotNull(ForeignKeyUtil.fk(constraint));
    }

    @Test
    public void testEnabled() {
        constraints.setForeignKeyName(NAME);
        column.setConstraints(constraints);
        Assert.assertFalse(ForeignKeyUtil.enabled(column));

        foreignKey.setReferencedColumnNames(COLUMN_NAME);
        constraints.setForeignKey(foreignKey);
        column.setConstraints(constraints);
        Assert.assertTrue(ForeignKeyUtil.enabled(column));

        constraints.setForeignKeyName(null);
        foreignKey.setReferencedColumnNames(COLUMN_NAME);
        constraints.setForeignKey(foreignKey);
        column.setConstraints(constraints);
        Assert.assertTrue(ForeignKeyUtil.enabled(column));

        foreignKey.setReferencedTableName(TABLE_NAME);
        constraints.setForeignKey(foreignKey);
        column.setConstraints(constraints);
        Assert.assertTrue(ForeignKeyUtil.enabled(column));

        foreignKey.setReferencedColumnNames(null);
        foreignKey.setReferencedTableName(null);
        constraints.setForeignKeyName(null);
        column.setConstraints(constraints);
        Assert.assertFalse(ForeignKeyUtil.enabled(column));

        column.setConstraints(null);
        Assert.assertFalse(ForeignKeyUtil.enabled(column));

        final Column column = null;
        Assert.assertFalse(ForeignKeyUtil.enabled(column));
    }

}
