package ru.volnenko.maven.plugin.databasedoc.builder;

import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.GeneratorBuilder;

public class GeneratorBuilderTest {

    private final GeneratorBuilder builder = new GeneratorBuilder();

    @Test
    public void test() {
        Assert.assertNotNull(builder.serviceName());
        Assert.assertNotNull(builder.root());
    }

}
