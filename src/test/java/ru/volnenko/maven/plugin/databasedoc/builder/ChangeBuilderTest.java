package ru.volnenko.maven.plugin.databasedoc.builder;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import lombok.NonNull;
import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.ChangeBuilder;

@Feature("Builder")
public class ChangeBuilderTest extends AbstractBuilderTest {

    @NonNull
    private final ChangeBuilder changeBuilder = changeBuilder();

    @Test
    @DisplayName("Контракт ChangeBuilder")
    @Description("Проверка контракта класса ChangeBuilder на null-значения")
    public void test() {
        Assert.assertNotNull(changeBuilder.createTable());
        Assert.assertNotNull(changeBuilder.change());
        Assert.assertNotNull(changeBuilder.root());
        Assert.assertNotNull(changeBuilder.and());
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorNPE() {
        new ChangeBuilder(null);
    }

}
