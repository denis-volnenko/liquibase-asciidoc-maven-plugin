package ru.volnenko.maven.plugin.databasedoc.builder;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import lombok.NonNull;
import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.GeneratorBuilder;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Root;

public class GeneratorBuilderTest {

    @NonNull
    private final GeneratorBuilder builder = new GeneratorBuilder();

    @Test
    @DisplayName("Контракт GeneratorBuilder")
    @Description("Проверка контракта класса GeneratorBuilder на null-значения")
    public void test() {
        Root root = new Root();
        Assert.assertNotNull(builder.serviceName());
        Assert.assertNotNull(builder.root());
        Assert.assertNotNull(new GeneratorBuilder(root));
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorNPE() {
        new GeneratorBuilder(null);
    }

}
