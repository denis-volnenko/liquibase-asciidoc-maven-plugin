package ru.volnenko.maven.plugin.databasedoc.util;

import lombok.NonNull;
import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.AbstractBuilderTest;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Column;

public class ConstraintUtilTest extends AbstractBuilderTest {

    @NonNull
    private final Column column = constraintsBuilder().add().column();

    @Test
    public void testNullable() {
        Assert.assertTrue(ConstraintUtil.nullable(column));
        column.getConstraints().setNullable(null);
        Assert.assertTrue(ConstraintUtil.nullable(column));
        column.setConstraints(null);
        Assert.assertTrue(ConstraintUtil.nullable(column));
        final Column column = null;
        Assert.assertTrue(ConstraintUtil.nullable(column));
    }

    @Test
    public void testNotnull() {
        Assert.assertFalse(ConstraintUtil.notnull(column));
        column.getConstraints().setNullable(null);
        Assert.assertFalse(ConstraintUtil.notnull(column));
        column.getConstraints().setNullable(false);
        Assert.assertTrue(ConstraintUtil.notnull(column));
        column.setConstraints(null);
        Assert.assertFalse(ConstraintUtil.notnull(column));
        final Column column = null;
        Assert.assertFalse(ConstraintUtil.notnull(column));
    }

    @Test
    public void testNotNull() {
        Assert.assertNotNull(new ConstraintUtil());
    }

}
