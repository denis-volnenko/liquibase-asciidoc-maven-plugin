package ru.volnenko.maven.plugin.databasedoc.enumerated;

import lombok.NonNull;

public enum ColumnType {

    NUMBER("Число"),
    DATETIME("Дата"),
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
