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

        final CreateTable table = getFirstTable(tableBuilder);

        Assert.assertEquals(expectedTableName, table.getTableName());
        Assert.assertEquals(expectedCatalogName, table.getCatalogName());
        Assert.assertEquals(expectedTablespace, table.getTablespace());
        Assert.assertEquals(expectedRemarks, table.getRemarks());
    }

}
