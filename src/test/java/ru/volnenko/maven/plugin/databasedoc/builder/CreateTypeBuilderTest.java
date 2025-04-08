package ru.volnenko.maven.plugin.databasedoc.builder;

import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.*;
import ru.volnenko.maven.plugin.databasedoc.model.impl.CreateType;

public class CreateTypeBuilderTest {

    CreateTypeBuilder typeBuilder = RootBuilder.create()
                .dsl()
                .changeSet()
                .add()
                .change()
                .createType();

    @Test
    public void testNotNull() {
        Assert.assertNotNull(typeBuilder.root());
        Assert.assertNotNull(typeBuilder.change());
        Assert.assertNotNull(typeBuilder.catalogName(""));
        Assert.assertNotNull(typeBuilder.tablespace(""));
        Assert.assertNotNull(typeBuilder.typeName(""));
        Assert.assertNotNull(typeBuilder.remarks(""));
    }

    @Test
    public void testType() {
        typeBuilder.typeName("Type name");
        typeBuilder.catalogName("Catalog name");
        typeBuilder.tablespace("Type remarks");
        typeBuilder.remarks("Type remarks");
        CreateType type = typeBuilder.root()
                .getDatabaseChangeLog()
                .get(0)
                .getChangeSet()
                .get(0)
                .getChanges()
                .get(0)
                .getCreateType();
        Assert.assertEquals("Type name", type.getTypeName());
        Assert.assertEquals("Catalog name", type.getCatalogName());
        Assert.assertEquals("Type remarks", type.getTablespace());
        Assert.assertEquals("Type remarks", type.getRemarks());
        System.out.println(type);
    }

}
