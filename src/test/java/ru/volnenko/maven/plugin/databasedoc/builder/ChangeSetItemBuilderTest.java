package ru.volnenko.maven.plugin.databasedoc.builder;

import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.ChangeSetItemBuilder;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.RootBuilder;

public class ChangeSetItemBuilderTest {

    @Test
    public void testNotNull() {
        ChangeSetItemBuilder changeSetItemBuilder = RootBuilder.create()
                .dsl()
                .changeSet()
                .add();
        Assert.assertNotNull(changeSetItemBuilder.id(""));
        Assert.assertNotNull(changeSetItemBuilder.author(""));
        Assert.assertNotNull(changeSetItemBuilder.change());
        Assert.assertNotNull(changeSetItemBuilder.changeSet());
        Assert.assertNotNull(changeSetItemBuilder.root());
    }

}
