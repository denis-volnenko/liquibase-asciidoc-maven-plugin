package ru.volnenko.maven.plugin.databasedoc.data;
import com.tngtech.java.junit.dataprovider.DataProvider;
import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.model.impl.*;
import ru.volnenko.maven.plugin.databasedoc.util.ForeignKeyUtil;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ForeignKeyUtilData {

    @NonNull
    public static FK correctReturnOfFkConstraintMethod() {
        final FK fk = new FK();
        fk.setTableName("baseTable");
        fk.setFieldName("baseColumn");
        fk.getPk().setTableName("refTable");
        fk.getPk().setFieldName("refColumn");
        return fk;
    }

    @DataProvider
    public static Object[] validForeignKeyConstraints() {
        return new Object[]{
                createForeignKeyConstraint("baseTable", "baseColumn", "refTable", "refColumn")
        };
    }

    @DataProvider
    public static Object[] invalidForeignKeyConstraints() {
        return new Object[][]{
                {null},
                {createForeignKeyConstraint(null, null, null, null)},
                {createForeignKeyConstraint(null, null, null, "refColumn")},
                {createForeignKeyConstraint(null, null, "refTable", null)},
                {createForeignKeyConstraint(null, "baseColumn", null, null)},
                {createForeignKeyConstraint("baseTable", null, null, null)},
                {createForeignKeyConstraint(null, null, "refTable", "refColumn")},
                {createForeignKeyConstraint(null, "baseColumn", null, "refColumn")},
                {createForeignKeyConstraint(null, "baseColumn", "refTable", null)},
                {createForeignKeyConstraint("baseTable", null, null, "refColumn")},
                {createForeignKeyConstraint("baseTable", null, "refTable", null)},
                {createForeignKeyConstraint("baseTable", "baseColumn", null, null)},
                {createForeignKeyConstraint(null, "baseColumn", "refTable", "refColumn")},
                {createForeignKeyConstraint("baseTable", null, "refTable", "refColumn")},
                {createForeignKeyConstraint("baseTable", "baseColumn", null, "refColumn")},
                {createForeignKeyConstraint("baseTable", "baseColumn", "refTable", null)}
        };
    }

    @NonNull
    private static AddForeignKeyConstraint createForeignKeyConstraint(
            String baseTable, String baseColumn, String refTable, String refColumn
    ) {
        final AddForeignKeyConstraint foreignKeyConstraint = new AddForeignKeyConstraint();
        foreignKeyConstraint.setBaseTableName(baseTable);
        foreignKeyConstraint.setBaseColumnNames(baseColumn);
        foreignKeyConstraint.setReferencedTableName(refTable);
        foreignKeyConstraint.setReferencedColumnNames(refColumn);
        return foreignKeyConstraint;
    }

    @NonNull
    private static ForeignKey createForeignKey(
            String baseTable,
            String baseColumn) {
        ForeignKey foreignKey = new ForeignKey();
        foreignKey.setReferencedColumnNames(baseTable);
        foreignKey.setReferencedTableName(baseColumn);
        return foreignKey;
    }

    @DataProvider
    public static Object[] trueColumns() {
        return new Object[][]{
                {createColumn("", createConstraints(false,"ForeignKeyName", createForeignKey("ReferencedTableName", "ReferencedColumnNames")))},
                {createColumn("", createConstraints(false,"ForeignKeyName", createForeignKey(null, "ReferencedColumnNames")))},
                {createColumn("", createConstraints(false,null, createForeignKey(null, "ReferencedColumnNames")))},
                {createColumn("", createConstraints(false,null, createForeignKey("ReferencedTableName", null)))},
                {createColumn("", createConstraints(false,null, createForeignKey("ReferencedTableName", "ReferencedColumnNames")))}
        };
    }

    @DataProvider
    public static Object[] falseColumns() {
        return new Object[][]{
                {null},
                {createColumn("", null)},
                {createColumn("", createConstraints(false,null, null))},
                {createColumn("", createConstraints(false,"ForeignKeyName", null))},
                {createColumn("", createConstraints(false,null, createForeignKey(null, null)))}
        };
    }

    @NonNull
    private static Constraints createConstraints(
            Boolean unique,
            String foreignKeyName,
            ForeignKey foreignKey
    ) {
        final Constraints constraints = new Constraints();
        constraints.setUnique(unique);
        constraints.setForeignKeyName(foreignKeyName);
        constraints.setForeignKey(foreignKey);
        return constraints;
    }

    @NonNull
    private static Column createColumn(
            String name,
            Constraints constraints
    ) {
        final Column column = new Column();
        column.setName(name);
        column.setConstraints(constraints);
        return column;
    }

    @NonNull
    public static Set<FK> correctReturnOfFksSetRootsMethod() {
        final Root root = new Root();
        final Set<FK> fks = new LinkedHashSet<>();
        return fks;
    }

    @NonNull
    public static Set<FK> correctReturnOfFksRootMethod() {
        final Root root = new Root();
        final DatabaseChangeLog databaseChangeLog = new DatabaseChangeLog();
        final ChangeSet changeSet = new ChangeSet();
        final Change change = new Change();
        final CreateTable createTable = new CreateTable();
        final AddForeignKeyConstraint foreignKeyConstraint = new AddForeignKeyConstraint();
        final Column column = new Column();
        final Constraints constraints = new Constraints();
        final AddForeignKeyConstraint constraint = new AddForeignKeyConstraint();
        final List<Change> changes = Arrays.asList(new Change(), new Change());
        constraint.setBaseColumnNames("");
        constraint.setBaseTableName("");
        constraint.setReferencedColumnNames("");
        constraint.setReferencedTableName("");
        column.setConstraints(constraints);
        column.setName("Column name");
        final List<ColumnWrapper> columnWrappers = Arrays.asList(
                new ColumnWrapper(column),
                new ColumnWrapper(column)
        );
        createTable.setColumns(columnWrappers);
        createTable.setTableName("Table name");
        change.setCreateTable(change.getCreateTable());
        change.setAddForeignKeyConstraint(foreignKeyConstraint);
        changes.get(0).setCreateTable(createTable);
        changes.get(0).setAddForeignKeyConstraint(constraint);
        final Set<FK> fks = new LinkedHashSet<>();
        fks.addAll(ForeignKeyUtil.fk(createTable));
        fks.add(ForeignKeyUtil.fk(change.getAddForeignKeyConstraint()));
        return fks;
    }

    @NonNull
    private static Root createRoot(
            List<DatabaseChangeLog> listOfDatabaseChangeLog
    ) {
        final Root root = new Root();
        root.setDatabaseChangeLog(listOfDatabaseChangeLog);
        return root;
    }

    private static DatabaseChangeLog createDatabaseChangeLog(
            ChangeSet changeSet
    ) {
        final DatabaseChangeLog databaseChangeLog = new DatabaseChangeLog();
        databaseChangeLog.setChangeSet(changeSet);
        return databaseChangeLog;
    }

    private static ChangeSet createChangeSet(
            List<Change> changes
    ) {
        final ChangeSet changeSet = new ChangeSet();
        changeSet.setChanges(changes);
        return changeSet;
    }

    private static Change createChange(
            CreateTable createTable,
            AddForeignKeyConstraint addForeignKeyConstraint
    ) {
        final Change change = new Change();
        change.setCreateTable(createTable);
        change.setAddForeignKeyConstraint(addForeignKeyConstraint);
        return change;
    }

    private static CreateTable createTable(
            String tableName,
            List<ColumnWrapper> columns
    ) {
        final CreateTable table = new CreateTable();
        table.setTableName(tableName);
        table.setColumns(columns);
        return table;
    }

    private static ColumnWrapper createColumnWrapper(
            Column column
    ) {
        final ColumnWrapper columnWrapper = new ColumnWrapper();
        columnWrapper.setColumn(column);
        return columnWrapper;
    }

    @DataProvider
    public static Object[] validRoot() {
        return new Object[]{
                createRoot(Arrays.asList(createDatabaseChangeLog(null))) // поправить
        };
    }

}
