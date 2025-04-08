package ru.volnenko.maven.plugin.databasedoc.builder;

import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.ChangeSetBuilder;

public class ChangeSetBuilderTest extends AbstractBuilderTest {

    private final ChangeSetBuilder changeSetBuilder = changeSetBuilder();

    @Test
    public void test() {
        Assert.assertNotNull(changeSetBuilder.root());
        Assert.assertNotNull(changeSetBuilder.add());
    }

}
