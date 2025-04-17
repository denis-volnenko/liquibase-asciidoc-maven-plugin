package ru.volnenko.maven.plugin.databasedoc.util;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.volnenko.maven.plugin.databasedoc.builder.AbstractBuilderTest;
import ru.volnenko.maven.plugin.databasedoc.data.StringUtilDataProvider;

@Feature("StringUtil")
@RunWith(DataProviderRunner.class)
public class StringUtilTest extends AbstractBuilderTest {

    @Test
    @DisplayName("StringUtil метод exists с параметром String value")
    @Description("Проверка метода exists с параметром String value на возврат корректного column.getName()")
    @UseDataProvider(value = "existsValue", location = StringUtilDataProvider.class)
    public void testExistsValue(final String value, final Boolean expectedBoolean) {
        Assert.assertEquals(expectedBoolean, StringUtil.exists(value));
    }

    @Test
    @DisplayName("StringUtil метод format")
    @Description("Проверка метода format на возврат корректных значений")
    public void testFormat() {
        Assert.assertEquals(EXPECTED_INTEGER_TO_STRING_VALUE, StringUtil.format(INTEGER_VALUE));
        Assert.assertEquals(EMPTY_STRING, StringUtil.format((Integer) null));
        Assert.assertEquals(EMPTY_STRING, StringUtil.format((String) null));
        Assert.assertEquals(EMPTY_STRING, StringUtil.format(EMPTY_STRING));
        Assert.assertEquals(CHECK_MARK, StringUtil.format(true));
        Assert.assertEquals(CHECK_MARK, StringUtil.format((Boolean) true));
        Assert.assertEquals(StringUtil.EMPTY, StringUtil.format(false));
        Assert.assertEquals(StringUtil.EMPTY, StringUtil.format((Boolean) false));
        Assert.assertEquals(StringUtil.EMPTY, StringUtil.format((Boolean) null));
        Assert.assertEquals(STRING_VALUE, StringUtil.format(STRING_VALUE));
    }

}
