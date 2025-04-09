package ru.volnenko.maven.plugin.databasedoc.builder;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import lombok.NonNull;
import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.*;
import ru.volnenko.maven.plugin.databasedoc.model.impl.CreateType;

public class CreateTypeBuilderTest extends AbstractBuilderTest {

    @NonNull
    private final CreateTypeBuilder typeBuilder = createTypeBuilder();

    @Test
    @DisplayName("Контракт CreateTypeBuilder")
    @Description("Проверка контракта класса CreateTypeBuilder на null-значения и" +
            "корректности установки значений")
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
