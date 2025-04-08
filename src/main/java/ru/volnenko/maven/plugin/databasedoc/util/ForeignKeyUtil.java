package ru.volnenko.maven.plugin.databasedoc.util;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.model.impl.*;

public final class ForeignKeyUtil {

    public static FK fk(final AddForeignKeyConstraint constraint) {
        if (constraint == null) return null;
        if (constraint.getBaseColumnNames() == null) return null;
        if (constraint.getBaseTableName() == null) return null;
        if (constraint.getReferencedColumnNames() == null) return null;
        if (constraint.getReferencedTableName() == null) return null;

        @NonNull final FK fk = new FK();
        fk.setTableName(constraint.getBaseTableName());
        fk.setFieldName(constraint.getBaseColumnNames());
        fk.getPk().setTableName(constraint.getReferencedTableName());
        fk.getPk().setFieldName(constraint.getReferencedColumnNames());

        return fk;
    }

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

        @NonNull final PK pk = new PK();
        pk.setTableName(column.getConstraints().getForeignKey().getReferencedTableName());
        pk.setFieldName(column.getConstraints().getForeignKey().getReferencedColumnNames());

        @NonNull final FK fk = new FK();
        fk.setTableName(tableName);
        fk.setFieldName(column.getName());

        if (column.getConstraints().getUnique() != null) {
            fk.setUnique(column.getConstraints().getUnique());
        }

        fk.setPk(pk);

        return fk;
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
