package ru.volnenko.maven.plugin.databasedoc.util;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.volnenko.maven.plugin.databasedoc.dataprovider.PrimaryKeyUtilDataProvider;
import ru.volnenko.maven.plugin.databasedoc.model.impl.PK;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Root;

import java.util.Set;

@Feature("PrimaryKeyUtil")
@RunWith(DataProviderRunner.class)
public class PrimaryKeyUtilTest {

    @Test
    @DisplayName("PrimaryKeyUtil метод pks с параметром Root")
    @Description("Проверка метода pks с Root на возврат корректных Set<PK>")
    @UseDataProvider(value = "pksMethodRoot", location = PrimaryKeyUtilDataProvider.class)
    public void testPksMethodRoot(final Root root, Set<PK> expectedPks) {
        Assert.assertEquals(expectedPks, PrimaryKeyUtil.pks(root));
    }

}
