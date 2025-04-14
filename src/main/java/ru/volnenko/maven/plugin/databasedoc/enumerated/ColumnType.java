package ru.volnenko.maven.plugin.databasedoc.enumerated;

import lombok.NonNull;

import java.util.Locale;

public enum ColumnType {

    ARRAY("Массив", "[]", "array"),
    INTEGER("Целочисленный",
            "int", "serial", "byte", "bit", "uuid", "long", "number",
            "year", "month", "day", "hour", "minute", "second"
    ),
    BINARY("Бинарный", "raw", "binary", "blob"),
    FLOAT("Дробный", "float", "double", "real", "precision", "numeric"),
    DATETIME("Дата/Время", "date", "time", "interval"),
    BOOLEAN("Логический", "bool", "boolean"),
    STRING("Строка", "varchar", "text", "json", "clob", "char", "string", "jsonb");

    @NonNull
    private final String displayName;

    @NonNull
    private final String[] parts;

    ColumnType(@NonNull String displayName, @NonNull String... parts) {
        this.displayName = displayName;
        this.parts = parts;
    }

    private static boolean check(final ColumnType columnType, final String type) {
        for (final String part: columnType.parts) {
            final String partLower = part.toLowerCase(Locale.ROOT);
            final String typeLower = type.toLowerCase(Locale.ROOT);
            if (typeLower.contains(partLower)) return true;
        }
        return false;
    }

    public static ColumnType typeOf(final String type) {
        if (type == null || type.isEmpty()) return null;
        for (ColumnType columnType: values()) {
            if (check(columnType, type)) return columnType;
        }
        return null;
    }

    @NonNull
    public String displayName() {
        return displayName;
    }

}
