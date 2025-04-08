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

        final Column column = getColumn(columnItemBuilder);

        Assert.assertEquals(expectedName, column.getName());
        Assert.assertEquals(expectedType, column.getType());
        Assert.assertEquals(expectedRemarks, column.getRemarks());
        Assert.assertEquals(true, column.getAutoIncrement());
    }

}
