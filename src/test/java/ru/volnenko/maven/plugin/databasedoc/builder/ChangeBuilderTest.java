package ru.volnenko.maven.plugin.databasedoc.builder;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.*;

public class ChangeBuilderTest {

    ChangeBuilder changeBuilder = RootBuilder.create()
            .dsl()
            .changeSet()
            .add()
            .change();

    @Test
    @DisplayName("Контракт ChangeBuilder")
    @Description("Проверка контракта класса ChangeBuilder на null-значения")
    public void testNotNull() {
        Assert.assertNotNull(changeBuilder.createTable());
        Assert.assertNotNull(changeBuilder.change());
        Assert.assertNotNull(changeBuilder.root());
        Assert.assertNotNull(changeBuilder.and());
    }

}
