package ru.volnenko.maven.plugin.databasedoc.builder;

import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.DatabaseChangeLogBuilder;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.RootBuilder;

public class DatabaseChangeLogBuilderTest {

    DatabaseChangeLogBuilder databaseChangeLogBuilder = RootBuilder.create().dsl();

    @Test
    public void testNotNull() {
        Assert.assertNotNull(databaseChangeLogBuilder.root());
        Assert.assertNotNull(databaseChangeLogBuilder.changeSet());
        Assert.assertNotNull(databaseChangeLogBuilder);
    }

}
