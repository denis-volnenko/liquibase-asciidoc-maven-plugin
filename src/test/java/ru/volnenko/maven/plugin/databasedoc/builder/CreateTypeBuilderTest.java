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

        final CreateType type = getFirstType(typeBuilder);

        Assert.assertEquals(expectedTypeName, type.getTypeName());
        Assert.assertEquals(expectedCatalogName, type.getCatalogName());
        Assert.assertEquals(expectedTablespace, type.getTablespace());
        Assert.assertEquals(expectedRemarks, type.getRemarks());
        System.out.println(type);
    }

}
