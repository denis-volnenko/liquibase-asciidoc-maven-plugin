package ru.volnenko.maven.plugin.databasedoc.builder;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import lombok.NonNull;
import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.ConstraintsBuilder;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Constraints;

@Feature("Builder")
public class ConstraintsBuilderTest extends AbstractBuilderTest {

    @NonNull
    private final ConstraintsBuilder constraintsBuilder = constraintsBuilder();

    @NonNull
    private final Constraints constraints = getConstraints(constraintsBuilder);

    @Test
    @DisplayName("Контракт ConstraintsBuilder")
    @Description("Проверка контракта класса ConstraintsBuilder на null-значения и" +
                 "корректности установки значений")
    public void test() {
        Assert.assertNotNull(constraintsBuilder.foreignKey());
        Assert.assertNotNull(constraintsBuilder.root());
        Assert.assertNotNull(constraintsBuilder.add());
        Assert.assertNotNull(constraintsBuilder.change());

        Assert.assertNotNull(constraintsBuilder.foreignKeyName(FOREIGN_KEY_NAME));
        Assert.assertNotNull(constraintsBuilder.uniqueConstraintName(UNIQUE_CONSTRAINT_NAME));
        Assert.assertNotNull(constraintsBuilder.primaryKey(true));
        Assert.assertNotNull(constraintsBuilder.nullable(true));
        Assert.assertNotNull(constraintsBuilder.unique(true));

        Assert.assertEquals(EXPECTED_FOREIGN_KEY_NAME, constraints.getForeignKeyName());
        Assert.assertEquals(EXPECTED_UNIQUE_CONSTRAINT_NAME, constraints.getUniqueConstraintName());
        Assert.assertEquals(true, constraints.getPrimaryKey());
        Assert.assertEquals(true, constraints.getNullable());
        Assert.assertEquals(true, constraints.getUnique());
    }

    @Test(expected = NullPointerException.class)
    @DisplayName("Конструктор ConstraintsBuilder")
    @Description("Проверка конструктора класса ConstraintsBuilder на NullPointerException")
    public void testConstructorNPE() {
        new ConstraintsBuilder(null);
    }

}
