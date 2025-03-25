package ru.volnenko.maven.plugin.databasedoc.util;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.model.Column;
import ru.volnenko.maven.plugin.databasedoc.model.Constraints;

public final class ForeignKeyUtil {

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
