package ru.volnenko.maven.plugin.databasedoc.util;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.model.impl.*;

import java.util.*;

public final class UniqueKeyUtil {

    @NonNull
    public static Set<UK> uks(final Collection<Root> roots) {
        if (roots == null || roots.isEmpty()) return Collections.emptySet();
        @NonNull final Set<UK> result = new LinkedHashSet<>();
        for (Root root: roots) result.addAll(uks(root));
        return result;
    }

    @NonNull
    public static Set<UK> uks(Root root) {
        if (root == null) return Collections.emptySet();
        if (root.getDatabaseChangeLog() == null) return Collections.emptySet();
        if (root.getDatabaseChangeLog().isEmpty()) return Collections.emptySet();
        @NonNull final Set<UK> result = new LinkedHashSet<>();
        for (DatabaseChangeLog changeLog: root.getDatabaseChangeLog()) {
            if (changeLog == null) continue;
            final ChangeSet changeSet = changeLog.getChangeSet();
            if (changeLog == null) continue;
            final List<Change> changes = changeSet.getChanges();
            if (changes == null || changes.isEmpty()) continue;
            for (Change change: changes) {
                if (change == null) continue;
                result.addAll(uk(change.getCreateTable()));
                final UK uk = uk(change.getAddUniqueConstraint());
                if (uk == null) continue;
                result.add(uk);
            }
        }
        return result;
    }

    @NonNull
    public static Set<UK> uk(final CreateTable createTable) {
        if (createTable == null) return Collections.emptySet();
        if (createTable.getColumns() == null) return Collections.emptySet();
        if (createTable.getColumns().isEmpty()) return Collections.emptySet();
        @NonNull final Set<UK> result = new LinkedHashSet<>();
        for (final ColumnWrapper columnWrapper: createTable.getColumns()) {
            if (columnWrapper == null) continue;
            final Column column = columnWrapper.getColumn();
            if (column == null) continue;
            final UK uk = uk(createTable.getTableName(), column);
            if (uk == null) continue;
            result.add(uk);
        }
        return result;
    }

    public static UK uk(final AddUniqueConstraint constraint) {
        if (constraint == null) return null;
        if (constraint.getTableName() == null) return null;
        if (constraint.getTableName().isEmpty()) return null;
        if (constraint.getColumnNames() == null) return null;
        if (constraint.getColumnNames().isEmpty()) return null;
        final UK uk = new UK();
        uk.setTableName(constraint.getTableName());
        uk.setFieldName(constraint.getColumnNames());
        return uk;
    }
    public static UK uk(final String tableName, final Column column) {
        if (column == null) return null;
        if (tableName == null || tableName.isEmpty()) return null;
        if (column.getConstraints() == null) return null;
        if (column.getConstraints().getUnique() == null) return null;
        if (!column.getConstraints().getUnique()) return null;
        @NonNull final UK uk = new UK();
        uk.setTableName(tableName);
        uk.setFieldName(column.getName());
        return uk;
    }

}
