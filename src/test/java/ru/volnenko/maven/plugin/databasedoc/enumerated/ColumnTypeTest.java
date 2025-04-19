package ru.volnenko.maven.plugin.databasedoc.enumerated;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import lombok.NonNull;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@Feature("ColumnType")
@RunWith(DataProviderRunner.class)
public class ColumnTypeTest {

    @Test
    @UseDataProvider("integers")
    @DisplayName("Целочисленные типы")
    public void testInteger(@NonNull final String type) {
        Assert.assertEquals(ColumnType.INTEGER, ColumnType.typeOf(type));
    }

    @Test
    @DisplayName("Массивы")
    @UseDataProvider("arrays")
    public void testArray(@NonNull final String type) {
        Assert.assertEquals(ColumnType.ARRAY, ColumnType.typeOf(type));
    }

    @Test
    @DisplayName("Строки")
    @UseDataProvider("strings")
    public void testString(@NonNull final String type) {
        Assert.assertEquals(ColumnType.STRING, ColumnType.typeOf(type));
    }

    @NonNull
    @DataProvider
    public static Object[][] arrays() {
        return new String[][]{
                {"int[]"},
                {"integer[]"}
        };
    }

    @NonNull
    @DataProvider
    public static Object[][] strings() {
        return new String[][]{
                {"varchar"},
                {"varchar(256)"},
                {"varchar2"},
                {"text"},
                {"json"},
                {"smalltext"},
                {"bigtext"},
        };
    }

    @NonNull
    @DataProvider
    public static Object[][] integers() {
        return new String[][]{
                {"bit"},
                {"byte"},
                {"int"},
                {"Integer"},
                {"long"},
        };
    }

    @Test
    @DisplayName("null")
    public void testNull() {
        Assert.assertEquals(null, ColumnType.typeOf(null));
    }

    @Test
    @DisplayName("empty string")
    public void testEmpty() {
        Assert.assertEquals(null, ColumnType.typeOf(""));
    }

    @Test
    @DisplayName("miss type")
    public void testMissType() {
        Assert.assertEquals(null, ColumnType.typeOf("color"));
    }

}
