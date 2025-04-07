package ru.volnenko.maven.plugin.databasedoc.builder;

import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.*;

public class CreateTableBuilderTest {

    CreateTableBuilder createTableBuilder = RootBuilder.create()
            .dsl()
            .changeSet()
            .add()
            .change()
            .createTable();

    @Test
    public void testNotNull() {
        Assert.assertNotNull(createTableBuilder.root());
        Assert.assertNotNull(createTableBuilder.change());
        Assert.assertNotNull(createTableBuilder.column());
        Assert.assertNotNull(createTableBuilder.createTable());
        Assert.assertNotNull(createTableBuilder.tablespace(""));
        Assert.assertNotNull(createTableBuilder.catalogName(""));
        Assert.assertNotNull(createTableBuilder.tableName(""));
        Assert.assertNotNull(createTableBuilder.remarks(""));
    }

}
