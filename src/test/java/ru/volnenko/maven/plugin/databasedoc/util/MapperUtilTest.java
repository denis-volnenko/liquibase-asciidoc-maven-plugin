package ru.volnenko.maven.plugin.databasedoc.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import lombok.NonNull;
import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Column;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Root;

@Feature("MapperUtil")
public class MapperUtilTest {

    @NonNull
    private static final ObjectMapper JSON = MapperUtil.json();

    @NonNull
    private static final ObjectMapper YAML = MapperUtil.yaml();

    @Test
    @DisplayName("MapperUtil метод json")
    @Description("Проверка метода json на возврат корректного объекта ObjectMapper JSON")
    public void testJson() {
        Assert.assertEquals(JSON, MapperUtil.json());
    }

    @Test
    @DisplayName("MapperUtil метод yaml")
    @Description("Проверка метода yaml на возврат корректного объекта ObjectMapper YAML")
    public void testYaml() {
        Assert.assertEquals(YAML, MapperUtil.yaml());
    }

    @Test
    @DisplayName("MapperUtil метод parseJsonFromResource")
    @Description("Проверка метода parseJsonFromResource на возврат корректного объекта")
    public void testParseJsonFromResource() {
        @NonNull final Column expectedColumn = new Column();
        expectedColumn.setName("name");
        expectedColumn.setRemarks("remarks");
        expectedColumn.setType("type");
        expectedColumn.setDefaultValue("defaultValue");
        @NonNull final Column column = MapperUtil.parseJsonFromResource(
                "testdata/mapperutil/dataParseJsonFromResource.json",
                Column.class
        );
        Assert.assertEquals(expectedColumn.getName(), column.getName());
        Assert.assertEquals(expectedColumn.getRemarks(), column.getRemarks());
        Assert.assertEquals(expectedColumn.getType(), column.getType());
        Assert.assertEquals(expectedColumn.getDefaultValue(), column.getDefaultValue());
    }

    @Test(expected = RuntimeException.class)
    @DisplayName("MapperUtil метод parseJsonFromResource")
    @Description("Проверка метода parseJsonFromResource на возврат RuntimeException при отсутствии файла")
    public void testParseJsonFromResourceFileNotFound() {
        MapperUtil.parseJsonFromResource("testdata/mapperutil/missing.json", Column.class);
    }

    @Test(expected = RuntimeException.class)
    @DisplayName("MapperUtil метод parseJsonFromResource")
    @Description("Проверка метода parseJsonFromResource на возврат RuntimeException при неккоректном json")
    public void testParseJsonFromResourceInvalidJson() {
        MapperUtil.parseJsonFromResource("testdata/mapperutil/invalidJson.json", Column.class);
    }

    @Test(expected = RuntimeException.class)
    @DisplayName("MapperUtil метод parseJsonFromResource")
    @Description("Проверка метода parseJsonFromResource на возврат RuntimeException при неккоректном Class")
    public void testParseJsonFromResourceInvalidClass() {
        MapperUtil.parseJsonFromResource("testdata/mapperutil/invalidJson.json", Root.class);
    }

    @Test(expected = NullPointerException.class)
    @DisplayName("MapperUtil метод parseJsonFromResource")
    @Description("Проверка метода parseJsonFromResource на возврат NullPointerException при null имени файла")
    public void testParseJsonFromResourceNullFileName() {
        MapperUtil.parseJsonFromResource(null, Column.class);
    }

    @Test(expected = NullPointerException.class)
    @DisplayName("MapperUtil метод parseJsonFromResource")
    @Description("Проверка метода parseJsonFromResource на возврат NullPointerException при null классе")
    public void testParseJsonFromResourceNullClass() {
        MapperUtil.parseJsonFromResource("testdata/mapperutil/dataParseJsonFromResource.json", null);
    }

}
