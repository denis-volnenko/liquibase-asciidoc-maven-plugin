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
        Assert.assertEquals(true, ConstraintUtil.nullable(column));
        column.getConstraints().setNullable(null);
        Assert.assertEquals(true, ConstraintUtil.nullable(column));
        column.setConstraints(null);
        Assert.assertEquals(true, ConstraintUtil.nullable(column));
        final Column column = null;
        Assert.assertEquals(true, ConstraintUtil.nullable(column));
    }

    @Test
    public void testNotnull() {
        Assert.assertEquals(false, ConstraintUtil.notnull(column));
        column.getConstraints().setNullable(null);
        Assert.assertEquals(false, ConstraintUtil.notnull(column));
        column.getConstraints().setNullable(false);
        Assert.assertEquals(true, ConstraintUtil.notnull(column));
        column.setConstraints(null);
        Assert.assertEquals(false, ConstraintUtil.notnull(column));
        final Column column = null;
        Assert.assertEquals(false, ConstraintUtil.notnull(column));
    }

}
