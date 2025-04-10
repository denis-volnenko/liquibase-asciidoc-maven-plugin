package ru.volnenko.maven.plugin.databasedoc.enumerated;

import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

@Feature("ColumnType")
public class ColumnTypeTest {

    @Test
    @DisplayName("Целочисленные типы")
    public void testInteger() {
        Assert.assertEquals(ColumnType.INTEGER, ColumnType.typeOf("bit"));
        Assert.assertEquals(ColumnType.INTEGER, ColumnType.typeOf("byte"));
        Assert.assertEquals(ColumnType.INTEGER, ColumnType.typeOf("int"));
        Assert.assertEquals(ColumnType.INTEGER, ColumnType.typeOf("Integer"));
        Assert.assertEquals(ColumnType.INTEGER, ColumnType.typeOf("long"));
    }

    @Test
    @DisplayName("Массивы")
    public void testArray() {
        Assert.assertEquals(ColumnType.ARRAY, ColumnType.typeOf("int[]"));
        Assert.assertEquals(ColumnType.ARRAY, ColumnType.typeOf("integer[]"));
    }

    @Test
    @DisplayName("Строки")
    public void testString() {
        Assert.assertEquals(ColumnType.STRING, ColumnType.typeOf("varchar"));
        Assert.assertEquals(ColumnType.STRING, ColumnType.typeOf("varchar(256)"));
        Assert.assertEquals(ColumnType.STRING, ColumnType.typeOf("varchar2"));
        Assert.assertEquals(ColumnType.STRING, ColumnType.typeOf("text"));
        Assert.assertEquals(ColumnType.STRING, ColumnType.typeOf("json"));
        Assert.assertEquals(ColumnType.STRING, ColumnType.typeOf("smalltext"));
        Assert.assertEquals(ColumnType.STRING, ColumnType.typeOf("bigtext"));
    }

}
