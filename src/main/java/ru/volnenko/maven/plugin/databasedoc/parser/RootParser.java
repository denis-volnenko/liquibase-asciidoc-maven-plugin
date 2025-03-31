package ru.volnenko.maven.plugin.databasedoc.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import lombok.SneakyThrows;
import ru.volnenko.maven.plugin.databasedoc.exception.UnsupportedFormatException;
import ru.volnenko.maven.plugin.databasedoc.model.Root;
import ru.volnenko.maven.plugin.databasedoc.util.MapperUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public final class RootParser {

    @NonNull
    private List<String> files = Collections.emptyList();

    @NonNull
    public RootParser files(@NonNull final List<String> files) {
        this.files = files;
        return this;
    }

    @NonNull
    private ObjectMapper objectMapper(@NonNull final String file) {
        @NonNull final String name = file.toLowerCase(Locale.ROOT);
        if (name.endsWith(".json")) return MapperUtil.json();
        if (name.endsWith(".yaml")) return MapperUtil.yaml();
        if (name.endsWith(".yml")) return MapperUtil.yaml();
        throw new UnsupportedFormatException();
    }

    @NonNull
    @SneakyThrows
    public Root parse(@NonNull final String file) {
        @NonNull final ObjectMapper objectMapper = objectMapper(file);
        return objectMapper.readValue(new File(file), Root.class);
    }

    @NonNull
    public List<Root> parse() {
        @NonNull final List<Root> result = new ArrayList<>();
        for (final String file : files) {
            if (file == null || file.isEmpty()) continue;
            result.add(parse(file));
        }
        return result;
    }
}
