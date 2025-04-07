package ru.volnenko.maven.plugin.databasedoc.generator;

import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.generator.impl.ColumnGenerator;

public class ColumnGeneratorTest {

    @Test
    public void testNotNull() {
        Assert.assertNotNull(ColumnGenerator.create());
        Assert.assertNotNull(ColumnGenerator.create().generate());
        Assert.assertNotNull(ColumnGenerator.create().stringBuilder());
    }

}
