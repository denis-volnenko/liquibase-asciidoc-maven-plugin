package ru.volnenko.maven.plugin.databasedoc.builder;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import lombok.NonNull;
import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.ValueItemBuilder;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Value;

@Feature("Builder")
public class ValueItemBuilderTest extends AbstractBuilderTest {

    @NonNull
    private final ValueItemBuilder valueItemBuilder = valueItemBuilder();

    @NonNull
    private final Value value = getValue(valueItemBuilder);

    @Test
    @DisplayName("Контракт ValueItemBuilder")
    @Description("Проверка контракта класса ValueItemBuilder на null-значения и" +
                 "корректности установки значений")
    public void test() {
        Assert.assertNotNull(valueItemBuilder.add());
        Assert.assertNotNull(valueItemBuilder.value());
        Assert.assertNotNull(valueItemBuilder.root());
        Assert.assertNotNull(valueItemBuilder.change());

        Assert.assertNotNull(valueItemBuilder.name(NAME));
        Assert.assertNotNull(valueItemBuilder.remarks(REMARKS));

        Assert.assertEquals(EXPECTED_NAME, value.getName());
        Assert.assertEquals(EXPECTED_REMARKS, value.getRemarks());
    }

    @Test(expected = NullPointerException.class)
    @DisplayName("Конструктор ValueItemBuilder")
    @Description("Проверка конструктора класса ValueItemBuilder на NullPointerException")
    public void testConstructorNPE() {
        new ValueItemBuilder(null);
    }

}
