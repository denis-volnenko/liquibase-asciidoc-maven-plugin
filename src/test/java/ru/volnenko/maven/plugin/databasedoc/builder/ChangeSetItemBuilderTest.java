package ru.volnenko.maven.plugin.databasedoc.builder;

import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.ChangeSetItemBuilder;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.RootBuilder;
import ru.volnenko.maven.plugin.databasedoc.model.impl.ChangeSet;

public class ChangeSetItemBuilderTest {

    ChangeSetItemBuilder changeSetItemBuilder = RootBuilder.create()
            .dsl()
            .changeSet()
            .add();

    @Test
    public void testNotNull() {
        Assert.assertNotNull(changeSetItemBuilder.id(""));
        Assert.assertNotNull(changeSetItemBuilder.author(""));
        Assert.assertNotNull(changeSetItemBuilder.change());
        Assert.assertNotNull(changeSetItemBuilder.changeSet());
        Assert.assertNotNull(changeSetItemBuilder.root());
    }

    @Test
    public void testReturn() {
        changeSetItemBuilder.id("id");
        changeSetItemBuilder.author("author");
        ChangeSet changeSet = changeSetItemBuilder.root().getDatabaseChangeLog().getChangeSet().get(0);
        Assert.assertEquals("id", changeSet.getId());
        Assert.assertEquals("author", changeSet.getAuthor());
    }

}
