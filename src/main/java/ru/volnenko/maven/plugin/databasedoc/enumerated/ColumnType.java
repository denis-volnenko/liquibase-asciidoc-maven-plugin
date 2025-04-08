package ru.volnenko.maven.plugin.databasedoc.enumerated;

import lombok.NonNull;

public enum ColumnType {

    INTEGER("Целочисленный"),
    FLOAT("Дробный"),
    DATETIME("Дата и время"),
    BOOLEAN("Логический"),
    STRING("Строка");

    @NonNull
    private final String name;

    @NonNull
    private final String[] parts;

    ColumnType(@NonNull String name, @NonNull String... parts) {
        this.name = name;
        this.parts = parts;
    }

}
