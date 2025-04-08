package ru.volnenko.maven.plugin.databasedoc.enumerated;

import org.junit.Assert;
import org.junit.Test;

public class ColumnTypeTest {

    @Test
    public void testInteger() {
        Assert.assertEquals(ColumnType.INTEGER, ColumnType.typeOf("bit"));
        Assert.assertEquals(ColumnType.INTEGER, ColumnType.typeOf("byte"));
        Assert.assertEquals(ColumnType.INTEGER, ColumnType.typeOf("int"));
        Assert.assertEquals(ColumnType.INTEGER, ColumnType.typeOf("Integer"));
        Assert.assertEquals(ColumnType.INTEGER, ColumnType.typeOf("long"));
    }

    @Test
    public void testArray() {
        Assert.assertEquals(ColumnType.ARRAY, ColumnType.typeOf("int[]"));
        Assert.assertEquals(ColumnType.ARRAY, ColumnType.typeOf("integer[]"));
    }

    @Test
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
