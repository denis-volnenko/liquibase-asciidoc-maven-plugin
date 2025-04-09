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

        Assert.assertNotNull(changeSetItemBuilder.id(ID));
        Assert.assertNotNull(changeSetItemBuilder.author(AUTHOR));

        final ChangeSet changeSet = changeSetItemBuilder.changeSet();

        Assert.assertEquals(EXPECTED_ID, changeSet.getId());
        Assert.assertEquals(EXPECTED_AUTHOR, changeSet.getAuthor());
    }

}
