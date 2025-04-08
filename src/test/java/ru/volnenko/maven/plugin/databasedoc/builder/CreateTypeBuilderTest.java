package ru.volnenko.maven.plugin.databasedoc.builder;

import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.*;
import ru.volnenko.maven.plugin.databasedoc.model.impl.CreateType;

public class CreateTypeBuilderTest extends AbstractBuilderTest {

    private final CreateTypeBuilder typeBuilder = createTypeBuilder();

    @Test
    public void test() {
        Assert.assertNotNull(typeBuilder.root());
        Assert.assertNotNull(typeBuilder.change());

        Assert.assertNotNull(typeBuilder.typeName(typeName));
        Assert.assertNotNull(typeBuilder.catalogName(catalogName));
        Assert.assertNotNull(typeBuilder.tablespace(tablespace));
        Assert.assertNotNull(typeBuilder.remarks(remarks));
        CreateType type = typeBuilder.root()
                .getDatabaseChangeLog()
                .get(0)
                .getChangeSet()
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
