package ru.volnenko.maven.plugin.databasedoc.parser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.hemantsonu20.json.JsonMerge;
import lombok.NonNull;
import lombok.SneakyThrows;
import ru.volnenko.maven.plugin.databasedoc.exception.UnsupportedFormatException;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Root;
import ru.volnenko.maven.plugin.databasedoc.util.FileUtil;
import ru.volnenko.maven.plugin.databasedoc.util.MapperUtil;

import java.io.File;
import java.util.*;

public final class RootParser {

    @NonNull
    private List<String> paths = Collections.emptyList();

    @NonNull
    private List<String> files = Collections.emptyList();

    @NonNull
    public RootParser paths(@NonNull final List<String> paths) {
        this.paths = paths;
        return this;
    }

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
    @SneakyThrows
    private JsonNode map(@NonNull final String file) {
        @NonNull final ObjectMapper objectMapper = objectMapper(file);
        return objectMapper.readTree(new File(file));
    }

    @NonNull
    @SneakyThrows
    public List<JsonNode> all() {
        @NonNull final List<JsonNode> result = new ArrayList<>();
        for (final String path: paths) {
            if (path == null || path.isEmpty()) continue;
            for (final String file : FileUtil.files(path)) {
                if (file == null || file.isEmpty()) continue;
                result.add(map(file));
            }
        }
        for (final String file : files) {
            if (file == null || file.isEmpty()) continue;
            result.add(map(file));
        }
        return result;
    }

    @NonNull
    public JsonNode jsonNode() {
        @NonNull final List<JsonNode> jsonNodes = all();
        @NonNull JsonNode mergedNodes = jsonNodes.get(0);
        for (int i = 1; i < jsonNodes.size(); i++) {
            mergedNodes = JsonMerge.merge(mergedNodes, jsonNodes.get(i));
        }
        return mergedNodes;
    }

    @SneakyThrows
    public String json() {
        return MapperUtil.json().writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode());
    }

    @SneakyThrows
    public String yaml() {
        return MapperUtil.yaml().writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode());
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
