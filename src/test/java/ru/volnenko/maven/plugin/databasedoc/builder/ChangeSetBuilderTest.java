package ru.volnenko.maven.plugin.databasedoc.builder;

import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.ChangeSetBuilder;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.RootBuilder;

public class ChangeSetBuilderTest {

    @Test
    public void testNotNull() {
        ChangeSetBuilder changeSetBuilder = RootBuilder.create()
                .dsl()
                .changeSet();
        Assert.assertNotNull(changeSetBuilder.root());
        Assert.assertNotNull(changeSetBuilder.add());
    }

}
