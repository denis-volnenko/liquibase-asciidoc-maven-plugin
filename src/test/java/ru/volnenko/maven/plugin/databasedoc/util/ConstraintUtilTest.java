package ru.volnenko.maven.plugin.databasedoc.util;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.volnenko.maven.plugin.databasedoc.dataprovider.ConstraintUtilDataProvider;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Column;

@Feature("ConstraintUtil")
@RunWith(DataProviderRunner.class)
public final class ConstraintUtilTest  {

    @Test
    @DisplayName("ConstraintUtil метод nullable с параметром Column")
    @Description("Проверка метода nullable с параметром Column на возврат true/false")
    @UseDataProvider(value = "nullableColumn", location = ConstraintUtilDataProvider.class)
    public void testNullableColumn(final Column column, final Boolean expectedBoolean) {
        Assert.assertEquals(expectedBoolean, ConstraintUtil.nullable(column));
    }

    @Test
    @DisplayName("ConstraintUtil метод notNull с параметром Column")
    @Description("Проверка метода notNull с параметром Column на возврат true/false")
    @UseDataProvider(value = "notNullColumn", location = ConstraintUtilDataProvider.class)
    public void testNotNullColumn(final Column column, final Boolean expectedBoolean) {
        Assert.assertEquals(expectedBoolean, ConstraintUtil.notnull(column));
    }

}
