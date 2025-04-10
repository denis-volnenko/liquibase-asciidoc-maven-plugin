package ru.volnenko.maven.plugin.databasedoc.builder;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import lombok.NonNull;
import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.ColumnBuilder;

@Feature("Builder")
public class ColumnBuilderTest extends AbstractBuilderTest {

    @NonNull
    private final ColumnBuilder columnBuilder = columnBuilder();

    @Test
    @DisplayName("Контракт ColumnBuilder")
    @Description("Проверка контракта класса ColumnBuilder на null-значения")
    public void test() {
        Assert.assertNotNull(columnBuilder.add());
        Assert.assertNotNull(columnBuilder.createTable());
        Assert.assertNotNull(columnBuilder.root());
        Assert.assertNotNull(columnBuilder.change());
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorNPE() {
        new ColumnBuilder(null);
    }

}
