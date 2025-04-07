package ru.volnenko.maven.plugin.databasedoc.builder;

import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.*;

public class ColumnItemBuilderTest {

    @Test
    public void testNotNull() {
        ColumnItemBuilder columnItemBuilder = RootBuilder.create()
                .dsl()
                .changeSet()
                .add()
                .change()
                .createTable()
                .column()
                .add();
        Assert.assertNotNull(columnItemBuilder.add());
        Assert.assertNotNull(columnItemBuilder.constraints());
        Assert.assertNotNull(columnItemBuilder.column());
        Assert.assertNotNull(columnItemBuilder.root());
        Assert.assertNotNull(columnItemBuilder.change());
        Assert.assertNotNull(columnItemBuilder.name(""));
        Assert.assertNotNull(columnItemBuilder.type(""));
        Assert.assertNotNull(columnItemBuilder.remarks(""));
        Assert.assertNotNull(columnItemBuilder.autoIncrement(true));
    }

}
