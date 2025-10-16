package ru.volnenko.maven.plugin.databasedoc.util;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import lombok.NonNull;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.volnenko.maven.plugin.databasedoc.dataprovider.TableUtilDataProvider;
import ru.volnenko.maven.plugin.databasedoc.model.impl.CreateTable;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Root;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Feature("TableUtil")
@RunWith(DataProviderRunner.class)
public final class TableUtilTest {

    @Test
    @DisplayName("TableUtil метод getCreateTablesWithoutDatabase с параметром roots")
    @Description("Проверка метода getCreateTablesWithoutDatabase с параметром roots на возврат List<CreateTable>")
    @UseDataProvider(value = "getCreateTablesWithoutDatabase", location = TableUtilDataProvider.class)
    public void testGetCreateTablesWithoutDatabase(final Collection<Root> roots, final List<CreateTable> expectedCreateTables) {
        final List<CreateTable> createTables = TableUtil.getCreateTablesWithoutDatabase(roots);
        if (!expectedCreateTables.isEmpty()) {
            @NonNull final CreateTable expectedCreateTable = expectedCreateTables.get(0);
            @NonNull final CreateTable createTable = createTables.get(0);
            Assert.assertEquals(expectedCreateTable.getTableName(), createTable.getTableName());
            Assert.assertEquals(expectedCreateTable.getRemarks(), createTable.getRemarks());
            Assert.assertEquals(expectedCreateTable.getTablespace(), createTable.getTablespace());
            Assert.assertEquals(expectedCreateTable.getSchemaName(), createTable.getSchemaName());
            Assert.assertEquals(expectedCreateTable.getCatalogName(), createTable.getCatalogName());
        } else {
            Assert.assertEquals(expectedCreateTables, createTables);
        }
    }

    @Test(expected = NullPointerException.class)
    @DisplayName("TableUtil метод getCreateTablesWithoutDatabase с параметром roots")
    @Description("Проверка метода getCreateTablesWithoutDatabase с параметром roots на выброс NPE")
    public void testGetCreateTablesWithoutDatabaseNPE() {
        Assert.assertNotNull(TableUtil.getCreateTablesWithoutDatabase(null));
    }

    @Test
    @DisplayName("TableUtil метод getCreateTablesWithDatabase с параметром roots и database")
    @Description("Проверка метода getCreateTablesWithDatabase с параметром roots на возврат List<CreateTable>")
    @UseDataProvider(value = "getCreateTablesWithDatabase", location = TableUtilDataProvider.class)
    public void testGetCreateTablesWithDatabase(final Collection<Root> roots, final String database, final List<CreateTable> expectedCreateTables) {
        final List<CreateTable> createTables = TableUtil.getCreateTablesWithDatabase(roots, database);

        if (!expectedCreateTables.isEmpty() && !createTables.isEmpty()) {
            final CreateTable createTable = createTables.get(0);
            final CreateTable expectedCreateTable = expectedCreateTables.get(0);
            Assert.assertEquals(expectedCreateTable.getTableName(), createTable.getTableName());
            Assert.assertEquals(expectedCreateTable.getRemarks(), createTable.getRemarks());
            Assert.assertEquals(expectedCreateTable.getTablespace(), createTable.getTablespace());
            Assert.assertEquals(expectedCreateTable.getSchemaName(), createTable.getSchemaName());
            Assert.assertEquals(expectedCreateTable.getCatalogName(), createTable.getCatalogName());
        } else {
            Assert.assertEquals(expectedCreateTables, createTables);
        }
    }

    @Test(expected = NullPointerException.class)
    @DisplayName("TableUtil метод getCreateTablesWithDatabase с параметром roots и database")
    @Description("Проверка метода getCreateTablesWithDatabase с параметром roots и database на выброс NPE")
    public void testGetCreateTablesWithDatabaseNPE() {
        Assert.assertNotNull(TableUtil.getCreateTablesWithDatabase(null, null));
    }

    @Test(expected = NullPointerException.class)
    @DisplayName("TableUtil метод getCreateTablesWithDatabase с параметром roots и database")
    @Description("Проверка метода getCreateTablesWithDatabase с параметром roots и database на выброс NPE")
    public void testGetCreateTablesWithDatabaseNPERoots() {
        Assert.assertNotNull(TableUtil.getCreateTablesWithDatabase(null, ""));
    }

    @Test(expected = NullPointerException.class)
    @DisplayName("TableUtil метод getCreateTablesWithDatabase с параметром roots и database")
    @Description("Проверка метода getCreateTablesWithDatabase с параметром roots и database на выброс NPE")
    public void testGetCreateTablesWithDatabaseNPEDatabase() {
        Assert.assertNotNull(TableUtil.getCreateTablesWithDatabase(Arrays.asList(new Root()), null));
    }

}
