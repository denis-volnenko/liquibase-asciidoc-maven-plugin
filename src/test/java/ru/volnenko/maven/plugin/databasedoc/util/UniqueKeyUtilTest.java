package ru.volnenko.maven.plugin.databasedoc.util;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import lombok.NonNull;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.volnenko.maven.plugin.databasedoc.data.UniqueKeyUtilDataProvider;
import ru.volnenko.maven.plugin.databasedoc.model.impl.*;

import java.util.Collection;
import java.util.Set;

@RunWith(DataProviderRunner.class)
public class UniqueKeyUtilTest {

    @Test
    @DisplayName("UniqueKeyUtil метод uk с параметром AddUniqueConstraint")
    @Description("Проверка метода uk с параметром AddUniqueConstraint на возврат корректного объекта UK")
    @UseDataProvider(value = "ukMethodConstraint", location = UniqueKeyUtilDataProvider.class)
    public void testUkMethodConstraint(final AddUniqueConstraint constraint, final UK expectedUk) {
        final UK uk = UniqueKeyUtil.uk(constraint);
        Assert.assertEquals(expectedUk, uk);
        if (expectedUk != null) {
            Assert.assertEquals(expectedUk.getTableName(), uk.getTableName());
            Assert.assertEquals(expectedUk.getFieldName(), uk.getFieldName());
        }
    }

    @Test
    @DisplayName("UniqueKeyUtil метод enabled с параметром Column")
    @Description("Проверка метода enabled с параметром Column на возврат true/false")
    @UseDataProvider(value = "enabledMethodColumn", location = UniqueKeyUtilDataProvider.class)
    public void testEnabledMethodColumn(final Column column, final Boolean expectedBoolean) {
        Assert.assertEquals(expectedBoolean, UniqueKeyUtil.enabled(column));
    }

    @Test
    @DisplayName("UniqueKeyUtil метод uk с параметром CreateTable")
    @Description("Проверка метода uk с параметром CreateTable на возврат Set с объектами UK и emptySet()")
    @UseDataProvider(value = "ukMethodCreateTable", location = UniqueKeyUtilDataProvider.class)
    public void testUkMethodCreateTable(final CreateTable createTable, final Set<UK> expectedUks) {
        Assert.assertEquals(expectedUks, UniqueKeyUtil.uk(createTable));
    }

    @Test
    @DisplayName("UniqueKeyUtil метод uks с параметром Roots")
    @Description("Проверка метода uks с параметром Roots на возврат Set с объектами UK и emptySet()")
    @UseDataProvider(value = "uksMethodRoots", location = UniqueKeyUtilDataProvider.class)
    public void testUksMethodRoots(final Collection<Root> roots, final Set<UK> expectedUks) {
        Assert.assertEquals(expectedUks, UniqueKeyUtil.uks(roots));
    }

    @Test
    @DisplayName("UniqueKeyUtil метод uks с параметром Root")
    @Description("Проверка метода uks с параметром Root на возврат Set с объектами UK и emptySet()")
    @UseDataProvider(value = "uksMethodRoot", location = UniqueKeyUtilDataProvider.class)
    public void testUksMethodRoot(final Root root, final Set<UK> expectedUks) {
        Assert.assertEquals(expectedUks, UniqueKeyUtil.uks(root));
    }

    @Test
    @DisplayName("UniqueKeyUtil медод uk с параметрами tableName и Column")
    @Description("Проверка метода uk с параметрами tableName и Column на возврат корректного объекта UK")
    @UseDataProvider(value = "ukMethodTableNameColumn", location = UniqueKeyUtilDataProvider.class)
    public void testUkMethodTableNameColumn(final String tableName, final Column column, final UK expectedUk) {
        @NonNull final UK uk = UniqueKeyUtil.uk(tableName, column);
        Assert.assertEquals(expectedUk, uk);
        if (expectedUk != null) {
            Assert.assertEquals(expectedUk.getTableName(), uk.getTableName());
            Assert.assertEquals(expectedUk.getFieldName(), uk.getFieldName());
        }
    }

}
