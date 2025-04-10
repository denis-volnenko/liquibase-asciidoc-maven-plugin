package ru.volnenko.maven.plugin.databasedoc.util;

import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.AbstractBuilderTest;

public class StringUtilTest extends AbstractBuilderTest {

    @Test
    public void testNotNull() {
        Assert.assertNotNull(StringUtil.format(INTEGER_VALUE));
        Assert.assertNotNull(StringUtil.format(true));
        Assert.assertNotNull(StringUtil.format((Integer) null));
        Assert.assertNotNull(StringUtil.format((String) null));
        Assert.assertNotNull(StringUtil.format((Boolean) null));
        Assert.assertNotNull(StringUtil.format((Boolean) true));
        Assert.assertNotNull(new StringUtil());
    }

    @Test
    public void testMethodReturn() {
        Assert.assertTrue(StringUtil.exists(STRING_VALUE));
        Assert.assertFalse(StringUtil.exists(null));
        Assert.assertFalse(StringUtil.exists(EMPTY_STRING));
        Assert.assertEquals(EXPECTED_INTEGER_TO_STRING_VALUE, StringUtil.format(INTEGER_VALUE));
        Assert.assertEquals(EMPTY_STRING, StringUtil.format((Integer) null));
        Assert.assertEquals(StringUtil.EMPTY, StringUtil.format(false));
    }

}
