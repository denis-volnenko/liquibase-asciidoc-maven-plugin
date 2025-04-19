package ru.volnenko.maven.plugin.databasedoc.builder;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.RootBuilder;

@Feature("Builder")
public class RootBuilderTest {

    @Test
    @DisplayName("Контракт RootBuilder")
    @Description("Проверка контракта класса RootBuilder на null-значения")
    public void test() {
        Assert.assertNotNull(RootBuilder.create());
        Assert.assertNotNull(RootBuilder.create().root());
        Assert.assertNotNull(RootBuilder.create().dsl());
    }

    @Test(expected = NullPointerException.class)
    @DisplayName("Конструктор RootBuilder")
    @Description("Проверка конструктора класса RootBuilder на NullPointerException")
    public void testConstructorNPE() {
        new RootBuilder(null);
    }

    @Test(expected = NullPointerException.class)
    @DisplayName("Контракт RootBuilder")
    @Description("Проверка контракта класса RootBuilder на NullPointerException")
    public void testCreateNPE() {
        RootBuilder.create(null);
    }

}
