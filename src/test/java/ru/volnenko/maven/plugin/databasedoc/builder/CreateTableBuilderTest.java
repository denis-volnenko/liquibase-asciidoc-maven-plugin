package ru.volnenko.maven.plugin.databasedoc.builder;

import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.*;
import ru.volnenko.maven.plugin.databasedoc.model.impl.CreateTable;

public class CreateTableBuilderTest extends AbstractBuilderTest {

    private final CreateTableBuilder tableBuilder = createTableBuilder();

    @Test
    public void test() {
        Assert.assertNotNull(tableBuilder.root());
        Assert.assertNotNull(tableBuilder.change());
        Assert.assertNotNull(tableBuilder.column());
        Assert.assertNotNull(tableBuilder.createTable());

        Assert.assertNotNull(tableBuilder.tableName(tableName));
        Assert.assertNotNull(tableBuilder.catalogName(catalogName));
        Assert.assertNotNull(tableBuilder.tablespace(tablespace));
        Assert.assertNotNull(tableBuilder.remarks(remarks));
        CreateTable table = tableBuilder.root()
                .getDatabaseChangeLog()
                .get(0)
                .getChangeSet()
                .getChanges()
                .get(0)
                .getCreateTable();
        Assert.assertEquals("Table name", table.getTableName());
        Assert.assertEquals("Catalog name", table.getCatalogName());
        Assert.assertEquals("Table space", table.getTablespace());
        Assert.assertEquals("Table remarks", table.getRemarks());
    }

}
