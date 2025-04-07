package ru.volnenko.maven.plugin.databasedoc.builder;

import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.*;

public class ConstraintsBuilderTest {

    @Test
    public void testNotNull() {
        ConstraintsBuilder constraintsBuilder = RootBuilder.create()
                .dsl()
                .changeSet()
                .add()
                .change()
                .createTable()
                .column()
                .add()
                .constraints();
        Assert.assertNotNull(constraintsBuilder.foreignKey());
        Assert.assertNotNull(constraintsBuilder.root());
        Assert.assertNotNull(constraintsBuilder.add());
        Assert.assertNotNull(constraintsBuilder.change());
        Assert.assertNotNull(constraintsBuilder.primaryKey(true));
        Assert.assertNotNull(constraintsBuilder.nullable(true));
        Assert.assertNotNull(constraintsBuilder.unique(true));
        Assert.assertNotNull(constraintsBuilder.uniqueConstraintName(""));
        Assert.assertNotNull(constraintsBuilder.foreignKeyName(""));
    }

}
