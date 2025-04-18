package ru.volnenko.maven.plugin.databasedoc.util;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.volnenko.maven.plugin.databasedoc.dataprovider.DataBaseUtilDataProvider;
import ru.volnenko.maven.plugin.databasedoc.dataprovider.ForeignKeyUtilDataProvider;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Root;

import java.util.Collection;
import java.util.Set;

@Feature("DataBaseUtil")
@RunWith(DataProviderRunner.class)
public class DataBaseUtilTest {

    @Test
    @DisplayName("DataBaseUtil метод getDataBases с параметром roots")
    @Description("Проверка метода getDataBases с roots на возврат корректных Set dataBases")
    @UseDataProvider(value = "getDataBases", location = DataBaseUtilDataProvider.class)
    public void testGetDataBases(final Collection<Root> roots, Set<String> dataBases) {
        Assert.assertEquals(dataBases, DataBaseUtil.getDataBases(roots));
    }

}
