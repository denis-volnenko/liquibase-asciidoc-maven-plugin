package ru.volnenko.maven.plugin.databasedoc.builder;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.RootBuilder;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.ValueBuilder;

public class RootBuilderTest {

    @Test
    @DisplayName("Контракт RootBuilder")
    @Description("Проверка контракта класса RootBuilder на null-значения")
    public void test() {
        Assert.assertNotNull(RootBuilder.create());
        Assert.assertNotNull(RootBuilder.create().root());
        Assert.assertNotNull(RootBuilder.create().dsl());
        Assert.assertNotNull(new RootBuilder());
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorNPE() {
        new RootBuilder(null);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateNPE() {
        RootBuilder.create(null);
    }

}
