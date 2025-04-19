package ru.volnenko.maven.plugin.databasedoc.builder;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import lombok.NonNull;
import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.ValueBuilder;

@Feature("Builder")
public class ValueBuilderTest extends AbstractBuilderTest {

    @NonNull
    private final ValueBuilder valueBuilder = valueBuilder();

    @Test
    @DisplayName("Контракт ValueBuilder")
    @Description("Проверка контракта класса ValueBuilder на null-значения")
    public void test() {
        Assert.assertNotNull(valueBuilder.add());
        Assert.assertNotNull(valueBuilder.createType());
        Assert.assertNotNull(valueBuilder.root());
        Assert.assertNotNull(valueBuilder.change());
    }

    @Test(expected = NullPointerException.class)
    @DisplayName("Контракт ValueBuilder")
    @Description("Проверка контракта класса ValueBuilder на NullPointerException")
    public void testConstructorNPE() {
        new ValueBuilder(null);
    }

}
