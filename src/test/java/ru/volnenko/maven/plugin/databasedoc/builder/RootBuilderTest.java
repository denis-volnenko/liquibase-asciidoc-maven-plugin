package ru.volnenko.maven.plugin.databasedoc.builder;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.RootBuilder;

public class RootBuilderTest {

    @Test
    @DisplayName("Контракт RootBuilder")
    @Description("Проверка контракта класса RootBuilder на null-значения")
    public void test() {
        Assert.assertNotNull(RootBuilder.create());
        Assert.assertNotNull(RootBuilder.create().root());
        Assert.assertNotNull(RootBuilder.create().dsl());
    }

}
