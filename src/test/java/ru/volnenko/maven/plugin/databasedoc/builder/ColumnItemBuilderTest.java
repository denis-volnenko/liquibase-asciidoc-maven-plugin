package ru.volnenko.maven.plugin.databasedoc.builder;

import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.*;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Column;

public class ColumnItemBuilderTest extends AbstractBuilderTest {

    ColumnItemBuilder columnItemBuilder = columnItemBuilder();

    @Test
    public void test() {
        Assert.assertNotNull(columnItemBuilder.add());
        Assert.assertNotNull(columnItemBuilder.constraints());
        Assert.assertNotNull(columnItemBuilder.column());
        Assert.assertNotNull(columnItemBuilder.root());
        Assert.assertNotNull(columnItemBuilder.change());

        Assert.assertNotNull(columnItemBuilder.name(name));
        Assert.assertNotNull(columnItemBuilder.type(type));
        Assert.assertNotNull(columnItemBuilder.remarks(remarks));
        Assert.assertNotNull(columnItemBuilder.autoIncrement(true));
        Column column = columnItemBuilder.root()
                .getDatabaseChangeLog()
                .get(0)
                .getChangeSet()
                .getChanges()
                .get(0)
                .getCreateTable()
                .getColumns()
                .get(0)
                .getColumn();
        Assert.assertEquals("Name", column.getName());
        Assert.assertEquals("Type", column.getType());
        Assert.assertEquals("Remarks", column.getRemarks());
        Assert.assertEquals(true, column.getAutoIncrement());
    }

}
