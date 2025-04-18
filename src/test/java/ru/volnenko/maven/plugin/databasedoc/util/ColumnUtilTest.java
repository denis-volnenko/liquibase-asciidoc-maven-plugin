package ru.volnenko.maven.plugin.databasedoc.util;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.volnenko.maven.plugin.databasedoc.dataprovider.ColumnUtilDataProvider;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Column;

@Feature("ColumnUtil")
@RunWith(DataProviderRunner.class)
public class ColumnUtilTest {

    @Test
    @DisplayName("ColumnUtil метод getName с параметром Column")
    @Description("Проверка метода getName с параметром Column на возврат true/false")
    @UseDataProvider(value = "getNameColumn", location = ColumnUtilDataProvider.class)
    public void testGetNameColumn(final Column column, final String expectedString) {
        Assert.assertEquals(expectedString, ColumnUtil.getName(column));
    }

}
