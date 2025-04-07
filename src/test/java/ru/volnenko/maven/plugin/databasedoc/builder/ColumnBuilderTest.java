package ru.volnenko.maven.plugin.databasedoc.builder;

import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.*;

public class ColumnBuilderTest {

    @Test
    public void testNotNull() {
        ColumnBuilder columnBuilder = RootBuilder.create()
                .dsl()
                .changeSet()
                .add()
                .change()
                .createTable()
                .column();
        Assert.assertNotNull(columnBuilder.add());
        Assert.assertNotNull(columnBuilder.createTable());
        Assert.assertNotNull(columnBuilder.root());
        Assert.assertNotNull(columnBuilder.change());
    }

}
