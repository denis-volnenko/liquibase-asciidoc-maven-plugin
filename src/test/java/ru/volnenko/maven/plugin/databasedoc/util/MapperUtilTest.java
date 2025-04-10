package ru.volnenko.maven.plugin.databasedoc.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import lombok.NonNull;
import org.junit.Assert;
import org.junit.Test;

public class MapperUtilTest {

    @NonNull
    private final MapperUtil mapperUtil = new MapperUtil();

    @NonNull
    private static final ObjectMapper JSON = MapperUtil.json();

    @NonNull
    private static final ObjectMapper YAML = MapperUtil.yaml();

    @Test
    public void testJson() {
        Assert.assertEquals(JSON, MapperUtil.json());
    }

    @Test
    public void testYaml() {
        Assert.assertEquals(YAML, MapperUtil.yaml());
    }

}
