package ru.volnenko.maven.plugin.databasedoc.builder;

import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.*;

public class ColumnBuilderTest {

    ColumnBuilder columnBuilder = RootBuilder.create()
            .dsl()
            .changeSet()
            .add()
            .change()
            .createTable()
            .column();

    @Test
    public void testNotNull() {
        Assert.assertNotNull(columnBuilder.add());
        Assert.assertNotNull(columnBuilder.createTable());
        Assert.assertNotNull(columnBuilder.root());
        Assert.assertNotNull(columnBuilder.change());
    }

}
