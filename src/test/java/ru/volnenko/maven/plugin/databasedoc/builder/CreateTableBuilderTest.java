package ru.volnenko.maven.plugin.databasedoc.builder;

import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.*;
import ru.volnenko.maven.plugin.databasedoc.model.impl.CreateTable;

public class CreateTableBuilderTest {

    CreateTableBuilder tableBuilder = RootBuilder.create()
            .dsl()
            .changeSet()
            .add()
            .change()
            .createTable();

    @Test
    public void testNotNull() {
        Assert.assertNotNull(tableBuilder.root());
        Assert.assertNotNull(tableBuilder.change());
        Assert.assertNotNull(tableBuilder.column());
        Assert.assertNotNull(tableBuilder.createTable());
        Assert.assertNotNull(tableBuilder.tablespace(""));
        Assert.assertNotNull(tableBuilder.catalogName(""));
        Assert.assertNotNull(tableBuilder.tableName(""));
        Assert.assertNotNull(tableBuilder.remarks(""));
    }

    @Test
    public void testTable() {
        tableBuilder.tableName("Table name");
        tableBuilder.catalogName("Catalog name");
        tableBuilder.tablespace("Table space");
        tableBuilder.remarks("Table remarks");
        CreateTable table = tableBuilder.root()
                .getDatabaseChangeLog()
                .getChangeSet()
                .get(0)
                .getChanges()
                .get(0)
                .getCreateTable();
        Assert.assertEquals("Table name", table.getTableName());
        Assert.assertEquals("Catalog name", table.getCatalogName());
        Assert.assertEquals("Table space", table.getTablespace());
        Assert.assertEquals("Table remarks", table.getRemarks());
    }

}
