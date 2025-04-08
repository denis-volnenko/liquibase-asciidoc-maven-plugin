package ru.volnenko.maven.plugin.databasedoc.builder;

import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.*;

public class ForeignKeyBuilderTest extends AbstractBuilderTest {

    private final ForeignKeyBuilder fkBuilder = foreignKeyBuilder();

    @Test
    public void test() {
        Assert.assertNotNull(fkBuilder.add());
        Assert.assertNotNull(fkBuilder.root());
        Assert.assertNotNull(fkBuilder.change());
    }

}
