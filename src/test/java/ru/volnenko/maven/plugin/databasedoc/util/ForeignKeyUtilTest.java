package ru.volnenko.maven.plugin.databasedoc.util;

import lombok.NonNull;
import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.AbstractBuilderTest;
import ru.volnenko.maven.plugin.databasedoc.model.impl.*;

import java.util.*;

public class ForeignKeyUtilTest extends AbstractBuilderTest {

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
    public void testNull() {
        Assert.assertNotNull(ForeignKeyUtil.fks(new Root()));
        Assert.assertNotNull(ForeignKeyUtil.fks(rootsList));
        Assert.assertNotNull(ForeignKeyUtil.fks(rootsSet));

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
        System.out.println(ForeignKeyUtil.fk(createTable.getTableName(), column));

        createTable.setTableName(TABLE_NAME);
        column.setConstraints(constraints);
        column.setName(COLUMN_NAME);
        final List<ColumnWrapper> columnWrapper = Arrays.asList(
                new ColumnWrapper(column),
                new ColumnWrapper(column)
        );
        createTable.setColumns(columnWrapper);
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
        constraint.setBaseColumnNames("");
        Assert.assertNull(ForeignKeyUtil.fk(constraint));
        constraint.setBaseTableName("");
        Assert.assertNull(ForeignKeyUtil.fk(constraint));
        constraint.setReferencedColumnNames("");
        Assert.assertNull(ForeignKeyUtil.fk(constraint));
        constraint.setReferencedTableName("");
        Assert.assertNotNull(ForeignKeyUtil.fk(constraint));
    }

}
