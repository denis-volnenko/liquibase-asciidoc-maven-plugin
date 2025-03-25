package ru.volnenko.maven.plugin.databasedoc.util;

import ru.volnenko.maven.plugin.databasedoc.model.Column;

public final class ConstraintUtil {

    public static boolean nullable(final Column column) {
        if (column == null) return true;
        if (column.getConstraints() == null) return true;
        if (column.getConstraints().getNullable() == null) return true;
        return column.getConstraints().getNullable();
    }

    public static boolean notnull(final Column column) {
        if (column == null) return false;
        if (column.getConstraints() == null) return false;
        if (column.getConstraints().getNullable() == null) return false;
        return !column.getConstraints().getNullable();
    }
}
