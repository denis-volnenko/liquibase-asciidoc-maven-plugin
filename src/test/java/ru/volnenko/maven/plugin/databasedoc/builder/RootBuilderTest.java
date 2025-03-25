package ru.volnenko.maven.plugin.databasedoc.builder;

import org.junit.Assert;
import org.junit.Test;

public class RootBuilderTest {

    @Test
    public void test() {
        Assert.assertNotNull(RootBuilder.create());
        Assert.assertNotNull(RootBuilder.create().root());
        Assert.assertNotNull(RootBuilder.create().dsl());
    }

}
