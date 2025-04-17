package ru.volnenko.maven.plugin.databasedoc.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import lombok.NonNull;
import org.junit.Assert;
import org.junit.Test;

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

}
