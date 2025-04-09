package ru.volnenko.maven.plugin.databasedoc.builder;

import lombok.NonNull;
import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.ValueBuilder;

public class ValueBuilderTest extends AbstractBuilderTest {

    @NonNull
    final ValueBuilder valueBuilder = valueBuilder();

    @Test
    public void test() {
//        Assert.assertNotNull(valueBuilder.add());
        Assert.assertNotNull(valueBuilder.createType());
        Assert.assertNotNull(valueBuilder.root());
        Assert.assertNotNull(valueBuilder.change());
    }

}
