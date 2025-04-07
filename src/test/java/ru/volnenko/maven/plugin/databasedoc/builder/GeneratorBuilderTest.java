package ru.volnenko.maven.plugin.databasedoc.builder;

import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.GeneratorBuilder;

public class GeneratorBuilderTest {

    @Test
    public void testNotNull() {
        Assert.assertNotNull(new GeneratorBuilder().serviceName());
        Assert.assertNotNull(new GeneratorBuilder().root());
    }

}
