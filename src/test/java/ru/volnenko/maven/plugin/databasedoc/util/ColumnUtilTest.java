package ru.volnenko.maven.plugin.databasedoc.util;

import lombok.NonNull;
import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.AbstractBuilderTest;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Column;

public class ColumnUtilTest extends AbstractBuilderTest {

    @NonNull
    private final Column column = columnBuilder().add().column();

    @Test
    public void testNull() {
        Assert.assertNull(ColumnUtil.getName(column));
        column.setName(NAME);
        Assert.assertNotNull(ColumnUtil.getName(column));
        column.setName(null);
        Assert.assertNull(ColumnUtil.getName(column));
        final Column column = null;
        Assert.assertNull(ColumnUtil.getName(column));
    }

    @Test
    public void testGetName() {
        column.setName(NAME);
        Assert.assertEquals(EXPECTED_NAME, ColumnUtil.getName(column));
    }

}
