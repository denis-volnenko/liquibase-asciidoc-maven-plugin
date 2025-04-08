package ru.volnenko.maven.plugin.databasedoc.builder;

import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.DatabaseChangeLogBuilder;

public class DatabaseChangeLogBuilderTest extends AbstractBuilderTest {

    private final DatabaseChangeLogBuilder databaseChangeLogBuilder = changeLogBuilder();

    @Test
    public void test() {
        Assert.assertNotNull(databaseChangeLogBuilder.root());
        Assert.assertNotNull(databaseChangeLogBuilder.changeSet());
        Assert.assertNotNull(databaseChangeLogBuilder);
    }

}
