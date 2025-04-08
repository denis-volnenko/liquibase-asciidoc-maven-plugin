package ru.volnenko.maven.plugin.databasedoc.builder;

import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.*;

public class ColumnBuilderTest extends AbstractBuilderTest {

    ColumnBuilder columnBuilder = columnBuilder();

    @Test
    public void test() {
        Assert.assertNotNull(columnBuilder.add());
        Assert.assertNotNull(columnBuilder.createTable());
        Assert.assertNotNull(columnBuilder.root());
        Assert.assertNotNull(columnBuilder.change());
    }

}
