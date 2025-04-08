package ru.volnenko.maven.plugin.databasedoc.builder;

import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.*;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Constraints;

public class ConstraintsBuilderTest {

    ConstraintsBuilder constraintsBuilder = RootBuilder.create()
            .dsl()
            .changeSet()
            .add()
            .change()
            .createTable()
            .column()
            .add()
            .constraints();

    @Test
    public void testNotNull() {
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

    @Test
    public void testReturn() {
        constraintsBuilder.foreignKeyName("Constraint name");
        constraintsBuilder.uniqueConstraintName("Unique constraint name");
        constraintsBuilder.primaryKey(true);
        constraintsBuilder.nullable(true);
        constraintsBuilder.unique(true);
        Constraints constraints = constraintsBuilder.root()
                .getDatabaseChangeLog()
                .get(0)
                .getChangeSet()
                .get(0)
                .getChanges()
                .get(0)
                .getCreateTable()
                .getColumns()
                .get(0)
                .getColumn()
                .getConstraints();
        Assert.assertEquals("Constraint name", constraints.getForeignKeyName());
        Assert.assertEquals("Unique constraint name", constraints.getUniqueConstraintName());
        Assert.assertEquals(true, constraints.getPrimaryKey());
        Assert.assertEquals(true, constraints.getNullable());
        Assert.assertEquals(true, constraints.getUnique());
    }

}
