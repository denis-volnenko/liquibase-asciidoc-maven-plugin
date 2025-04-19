package ru.volnenko.maven.plugin.databasedoc.builder;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import lombok.NonNull;
import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.ChangeSetItemBuilder;
import ru.volnenko.maven.plugin.databasedoc.model.impl.ChangeSet;

@Feature("Builder")
public class ChangeSetItemBuilderTest extends AbstractBuilderTest {

    @NonNull
    private final ChangeSetItemBuilder changeSetItemBuilder = changeSetBuilder().add();

    @NonNull
    private final ChangeSet changeSet = changeSetItemBuilder.changeSet();

    @Test
    @DisplayName("Контракт ChangeSetItemBuilder")
    @Description("Проверка контракта класса ChangeSetItemBuilder на null-значения и" +
                 "корректности установки значений")
    public void test() {
        Assert.assertNotNull(changeSetItemBuilder.change());
        Assert.assertNotNull(changeSetItemBuilder.changeSet());
        Assert.assertNotNull(changeSetItemBuilder.root());

        Assert.assertNotNull(changeSetItemBuilder.id(ID));
        Assert.assertNotNull(changeSetItemBuilder.author(AUTHOR));

        Assert.assertEquals(EXPECTED_ID, changeSet.getId());
        Assert.assertEquals(EXPECTED_AUTHOR, changeSet.getAuthor());
    }

    @Test(expected = NullPointerException.class)
    @DisplayName("Контракт ChangeSetItemBuilder")
    @Description("Проверка контракта класса ChangeSetItemBuilder на NullPointerException")
    public void testConstructorNPE() {
        new ChangeSetItemBuilder(null);
    }

}
