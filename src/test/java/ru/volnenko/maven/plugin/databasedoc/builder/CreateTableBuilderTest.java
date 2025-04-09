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

        Assert.assertNotNull(tableBuilder.tableName(TABLE_NAME));
        Assert.assertNotNull(tableBuilder.catalogName(CATALOG_NAME));
        Assert.assertNotNull(tableBuilder.tablespace(TABLESPACE));
        Assert.assertNotNull(tableBuilder.remarks(REMARKS));

        final CreateTable table = getFirstTable(tableBuilder);

        Assert.assertEquals(EXPECTED_TABLE_NAME, table.getTableName());
        Assert.assertEquals(EXPECTED_CATALOG_NAME, table.getCatalogName());
        Assert.assertEquals(EXPECTED_TABLESPACE, table.getTablespace());
        Assert.assertEquals(EXPECTED_REMARKS, table.getRemarks());
    }

}
