package ru.volnenko.maven.plugin.databasedoc.util;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.model.Column;
import ru.volnenko.maven.plugin.databasedoc.model.Constraints;
import ru.volnenko.maven.plugin.databasedoc.model.FK;
import ru.volnenko.maven.plugin.databasedoc.model.PK;

public final class ForeignKeyUtil {

    public static FK fk(final String tableName, final Column column) {
        if (column == null) return null;
        if (tableName == null || tableName.isEmpty()) return null;
        if (column.getConstraints() == null) return null;
        if (column.getConstraints().getForeignKey() == null) return null;
        if (column.getConstraints().getForeignKey().getReferencedTableName() == null) return null;
        if (column.getConstraints().getForeignKey().getReferencedTableName().isEmpty()) return null;
        if (column.getConstraints().getForeignKey().getReferencedColumnNames() == null) return null;
        if (column.getConstraints().getForeignKey().getReferencedColumnNames().isEmpty()) return null;
        if (column.getName() == null || column.getName().isEmpty()) return null;
        return null;
    }

    public static PK pk(final Column column) {
        PK pk = null;

        return null;
    }

    public static boolean enabled(final Column column) {
        if (column == null) return false;
        if (column.getConstraints() == null) return false;
        if (column.getConstraints().getForeignKey() == null) return false;
        @NonNull final Constraints constraints = column.getConstraints();
        if (StringUtil.exists(constraints.getForeignKeyName())) return true;
        if (StringUtil.exists(column.getConstraints().getForeignKey().getReferencedColumnNames())) return true;
        return StringUtil.exists(column.getConstraints().getForeignKey().getReferencedTableName());
    }

}
