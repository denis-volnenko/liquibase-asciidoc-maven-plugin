package ru.volnenko.maven.plugin.databasedoc.builder;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import lombok.NonNull;
import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.ChangeSetBuilder;

public class ChangeSetBuilderTest extends AbstractBuilderTest {

    @NonNull
    private final ChangeSetBuilder changeSetBuilder = changeSetBuilder();

    @Test
    @DisplayName("Контракт ChangeSetBuilder")
    @Description("Проверка контракта класса ChangeSetBuilder на null-значения")
    public void test() {
        Assert.assertNotNull(changeSetBuilder.root());
        Assert.assertNotNull(changeSetBuilder.add());
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorNPE() {
        new ChangeSetBuilder(null);
    }

}
