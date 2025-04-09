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

        Assert.assertNotNull(typeBuilder.typeName(TYPE_NAME));
        Assert.assertNotNull(typeBuilder.catalogName(CATALOG_NAME));
        Assert.assertNotNull(typeBuilder.tablespace(TABLESPACE));
        Assert.assertNotNull(typeBuilder.remarks(REMARKS));

        final CreateType type = getFirstType(typeBuilder);

        Assert.assertEquals(EXPECTED_TYPE_NAME, type.getTypeName());
        Assert.assertEquals(EXPECTED_CATALOG_NAME, type.getCatalogName());
        Assert.assertEquals(EXPECTED_TABLESPACE, type.getTablespace());
        Assert.assertEquals(EXPECTED_REMARKS, type.getRemarks());
        System.out.println(type);
    }

}
