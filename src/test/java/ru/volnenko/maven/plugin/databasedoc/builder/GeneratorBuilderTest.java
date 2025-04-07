package ru.volnenko.maven.plugin.databasedoc.builder;

import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.GeneratorBuilder;

public class GeneratorBuilderTest {

    GeneratorBuilder builder = new GeneratorBuilder();

    @Test
    public void testNotNull() {
        Assert.assertNotNull(builder.serviceName());
        Assert.assertNotNull(builder.root());
    }

}
