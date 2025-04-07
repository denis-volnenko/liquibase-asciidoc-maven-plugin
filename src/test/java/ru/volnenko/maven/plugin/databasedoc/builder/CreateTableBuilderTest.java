package ru.volnenko.maven.plugin.databasedoc.builder;

import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.*;
import ru.volnenko.maven.plugin.databasedoc.model.impl.CreateTable;

public class CreateTableBuilderTest {

    CreateTableBuilder table = RootBuilder.create()
            .dsl()
            .changeSet()
            .add()
            .change()
            .createTable();

    @Test
    public void testNotNull() {
        Assert.assertNotNull(table.root());
        Assert.assertNotNull(table.change());
        Assert.assertNotNull(table.column());
        Assert.assertNotNull(table.createTable());
        Assert.assertNotNull(table.tablespace(""));
        Assert.assertNotNull(table.catalogName(""));
        Assert.assertNotNull(table.tableName(""));
        Assert.assertNotNull(table.remarks(""));
    }

    @Test
    public void testTable() {
        table.tableName("Table name");
        table.catalogName("Catalog name");
        table.tablespace("Table space");
        table.remarks("Table remarks");
        CreateTable createTable = table.root()
                .getDatabaseChangeLog()
                .getChangeSet()
                .get(0)
                .getChanges()
                .get(0)
                .getCreateTable();
        Assert.assertEquals("Table name", createTable.getTableName());
        Assert.assertEquals("Catalog name", createTable.getCatalogName());
        Assert.assertEquals("Table space", createTable.getTablespace());
        Assert.assertEquals("Table remarks", createTable.getRemarks());
    }

}
