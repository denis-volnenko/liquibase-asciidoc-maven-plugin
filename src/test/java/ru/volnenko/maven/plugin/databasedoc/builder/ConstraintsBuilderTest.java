package ru.volnenko.maven.plugin.databasedoc.builder;

import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.*;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Constraints;

public class ConstraintsBuilderTest extends AbstractBuilderTest {

    ConstraintsBuilder constraintsBuilder = constraintsBuilder();

    @Test
    public void test() {
        Assert.assertNotNull(constraintsBuilder.foreignKey());
        Assert.assertNotNull(constraintsBuilder.root());
        Assert.assertNotNull(constraintsBuilder.add());
        Assert.assertNotNull(constraintsBuilder.change());

        Assert.assertNotNull(constraintsBuilder.foreignKeyName(foreignKeyName));
        Assert.assertNotNull(constraintsBuilder.uniqueConstraintName(uniqueConstraintName));
        Assert.assertNotNull(constraintsBuilder.primaryKey(true));
        Assert.assertNotNull(constraintsBuilder.nullable(true));
        Assert.assertNotNull(constraintsBuilder.unique(true));

        final Constraints constraints = getConstraints(constraintsBuilder);

        Assert.assertEquals(expectedForeignKeyName, constraints.getForeignKeyName());
        Assert.assertEquals(expectedUniqueConstraintName, constraints.getUniqueConstraintName());
        Assert.assertEquals(true, constraints.getPrimaryKey());
        Assert.assertEquals(true, constraints.getNullable());
        Assert.assertEquals(true, constraints.getUnique());
    }

}
