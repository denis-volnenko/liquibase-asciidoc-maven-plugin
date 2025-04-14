package ru.volnenko.maven.plugin.databasedoc.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import lombok.NonNull;
import lombok.SneakyThrows;

public final class MapperUtil {

    @NonNull
    private static final ObjectMapper JSON = new ObjectMapper();

    @NonNull
    private static final ObjectMapper YAML = new YAMLMapper();

    static {
//        JSON.registerModule(new JSONPModule());
//        YAML.registerModule(new JSONPModule());
//        JSON.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
//        YAML.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
    }

    @NonNull
    public static ObjectMapper json() {
        return JSON;
    }

    @NonNull
    public static ObjectMapper yaml() {
        return YAML;
    }

    @NonNull
    @SneakyThrows
    public static <T> T parseJsonFromResource(@NonNull final String fileName, @NonNull final Class<T> clazz) {
        return json().readValue(ClassLoader.getSystemResourceAsStream(fileName), clazz);
    }

}
