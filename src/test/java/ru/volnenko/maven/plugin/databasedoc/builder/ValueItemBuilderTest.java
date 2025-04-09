package ru.volnenko.maven.plugin.databasedoc.builder;

import lombok.NonNull;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.ValueItemBuilder;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Value;

public class ValueItemBuilderTest extends AbstractBuilderTest {

    @NonNull
    final ValueItemBuilder valueItemBuilder = valueItemBuilder();

    @Test
    @Ignore
    public void test() {
        Assert.assertNotNull(valueItemBuilder.add());
        Assert.assertNotNull(valueItemBuilder.value());
        Assert.assertNotNull(valueItemBuilder.root());
        Assert.assertNotNull(valueItemBuilder.change());

        Assert.assertNotNull(valueItemBuilder.name(NAME));
        Assert.assertNotNull(valueItemBuilder.remarks(REMARKS));

        final Value value = getValue(valueItemBuilder);

        Assert.assertEquals(EXPECTED_NAME, value.getName());
        Assert.assertEquals(EXPECTED_REMARKS, value.getRemarks());
    }

}
