package ru.volnenko.maven.plugin.databasedoc.builder;

import lombok.NonNull;
import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.ChangeSetItemBuilder;
import ru.volnenko.maven.plugin.databasedoc.model.impl.ChangeSet;

public class ChangeSetItemBuilderTest extends AbstractBuilderTest {

    @NonNull
    private final ChangeSetItemBuilder changeSetItemBuilder = changeSetBuilder().add();

    @Test
    public void test() {
        Assert.assertNotNull(changeSetItemBuilder.change());
        Assert.assertNotNull(changeSetItemBuilder.changeSet());
        Assert.assertNotNull(changeSetItemBuilder.root());

        Assert.assertNotNull(changeSetItemBuilder.id(id));
        Assert.assertNotNull(changeSetItemBuilder.author(author));

        final ChangeSet changeSet = changeSetItemBuilder.changeSet();

        Assert.assertEquals(expectedId, changeSet.getId());
        Assert.assertEquals(expectedAuthor, changeSet.getAuthor());
    }

}
