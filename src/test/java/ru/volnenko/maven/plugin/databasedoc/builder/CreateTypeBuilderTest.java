package ru.volnenko.maven.plugin.databasedoc.builder;

import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.*;
import ru.volnenko.maven.plugin.databasedoc.model.impl.CreateType;

public class CreateTypeBuilderTest {

    CreateTypeBuilder type = RootBuilder.create()
                .dsl()
                .changeSet()
                .add()
                .change()
                .createType();

    @Test
    public void testNotNull() {
        Assert.assertNotNull(type.root());
        Assert.assertNotNull(type.change());
        Assert.assertNotNull(type.catalogName(""));
        Assert.assertNotNull(type.tablespace(""));
        Assert.assertNotNull(type.typeName(""));
        Assert.assertNotNull(type.remarks(""));
    }

    @Test
    public void testType() {
        type.typeName("Type name");
        type.catalogName("Catalog name");
        type.tablespace("Type remarks");
        type.remarks("Type remarks");
        CreateType createType = type.root()
                .getDatabaseChangeLog()
                .getChangeSet()
                .get(0)
                .getChanges()
                .get(0)
                .getCreateType();
        Assert.assertEquals("Type name", createType.getTypeName());
        Assert.assertEquals("Catalog name", createType.getCatalogName());
        Assert.assertEquals("Type remarks", createType.getTablespace());
        Assert.assertEquals("Type remarks", createType.getRemarks());
    }

}
