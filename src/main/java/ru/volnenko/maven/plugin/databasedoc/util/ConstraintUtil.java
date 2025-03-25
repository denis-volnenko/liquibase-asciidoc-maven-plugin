package ru.volnenko.maven.plugin.databasedoc.util;

import ru.volnenko.maven.plugin.databasedoc.model.Column;

public final class ConstraintUtil {

    public static boolean nullable(final Column column) {
        if (column == null) return true;
        if (column.getConstraints() == null) return true;
        if (column.getConstraints().getNullable() == null) return true;
        if (column.getConstraints().getNullable()) return true;
        return false;
    }
}
