package ru.volnenko.maven.plugin.databasedoc.util;

import ru.volnenko.maven.plugin.databasedoc.model.impl.Column;

public final class ColumnUtil {

    public static String getName(final Column column) {
        if (column == null) return null;
        if (column.getName() == null || column.getName().isEmpty()) return null;
        return column.getName();
    }

}
