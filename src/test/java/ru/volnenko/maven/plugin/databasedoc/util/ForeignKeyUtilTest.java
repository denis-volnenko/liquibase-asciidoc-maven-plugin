package ru.volnenko.maven.plugin.databasedoc.util;

import lombok.NonNull;
import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.AbstractBuilderTest;
import ru.volnenko.maven.plugin.databasedoc.model.impl.*;

import java.util.*;

public class ForeignKeyUtilTest extends AbstractBuilderTest {

    @NonNull
    private final Root root = new Root();

    @NonNull
    private final Column column = new Column();

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
