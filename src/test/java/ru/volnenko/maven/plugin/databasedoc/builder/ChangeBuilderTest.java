package ru.volnenko.maven.plugin.databasedoc.builder;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.*;

public class ChangeBuilderTest extends AbstractBuilderTest {

    ChangeBuilder changeBuilder = changeBuilder();

    @Test
    @DisplayName("Контракт ChangeBuilder")
    @Description("Проверка контракта класса ChangeBuilder на null-значения")
    public void test() {
        Assert.assertNotNull(changeBuilder.createTable());
        Assert.assertNotNull(changeBuilder.change());
        Assert.assertNotNull(changeBuilder.root());
        Assert.assertNotNull(changeBuilder.and());
    }

}
