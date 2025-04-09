package ru.volnenko.maven.plugin.databasedoc.builder;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import lombok.NonNull;
import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.ForeignKeyBuilder;

public class ForeignKeyBuilderTest extends AbstractBuilderTest {

    @NonNull
    private final ForeignKeyBuilder fkBuilder = foreignKeyBuilder();

    @Test
    @DisplayName("Контракт ForeignKeyBuilder")
    @Description("Проверка контракта класса ForeignKeyBuilder на null-значения")
    public void test() {
        Assert.assertNotNull(fkBuilder.add());
        Assert.assertNotNull(fkBuilder.root());
        Assert.assertNotNull(fkBuilder.change());
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorNPE() {
        new ForeignKeyBuilder(null);
    }

}
