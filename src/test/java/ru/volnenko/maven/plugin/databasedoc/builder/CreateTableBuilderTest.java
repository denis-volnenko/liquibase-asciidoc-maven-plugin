package ru.volnenko.maven.plugin.databasedoc.builder;

import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.*;

public class CreateTableBuilderTest {

    @Test
    public void testNotNull() {
        CreateTableBuilder createTableBuilder = RootBuilder.create()
                .dsl()
                .changeSet()
                .add()
                .change()
                .createTable();
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
