package ru.volnenko.maven.plugin.databasedoc.util;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.model.impl.*;

import java.util.*;

public final class TableUtil {

    @NonNull
    public static List<CreateTable> getCreateTablesWithoutDatabase(@NonNull final Collection<Root> roots) {
        @NonNull final List<CreateTable> result = new ArrayList<>();
        for (final Root root: roots) {
            if (root == null) continue;
            final List<DatabaseChangeLog> databaseChangeLogs = root.getDatabaseChangeLog();
            if (databaseChangeLogs == null || databaseChangeLogs.isEmpty()) continue;
            for (final DatabaseChangeLog databaseChangeLog: databaseChangeLogs) {
                if (databaseChangeLog == null) continue;
                final ChangeSet changeSet = databaseChangeLog.getChangeSet();
                if (changeSet == null) continue;
                final List<Change> changes = changeSet.getChanges();
                if (changes == null || changes.isEmpty()) continue;
                for (final Change change: changes) {
                    if (change == null) continue;
                    final CreateTable createTable = change.getCreateTable();
                    if (createTable == null) continue;
                    final String catalogName = createTable.getCatalogName();
                    if (catalogName == null || catalogName.isEmpty()) result.add(createTable);
                }
            }
        }
        return result;
    }

    @NonNull
    public static List<CreateTable> getCreateTablesWithDatabase(@NonNull Collection<Root> roots, @NonNull final String database) {
        @NonNull final List<CreateTable> result = new ArrayList<>();
        for (final Root root: roots) {
            if (root == null) continue;
            final List<DatabaseChangeLog> databaseChangeLogs = root.getDatabaseChangeLog();
            if (databaseChangeLogs == null || databaseChangeLogs.isEmpty()) continue;
            for (final DatabaseChangeLog databaseChangeLog: databaseChangeLogs) {
                if (databaseChangeLog == null) continue;
                final ChangeSet changeSet = databaseChangeLog.getChangeSet();
                if (changeSet == null) continue;
                final List<Change> changes = changeSet.getChanges();
                if (changes == null || changes.isEmpty()) continue;
                for (final Change change: changes) {
                    if (change == null) continue;
                    final CreateTable createTable = change.getCreateTable();
                    if (createTable == null) continue;;
                    final String catalogName = createTable.getCatalogName();
                    if (catalogName == null || catalogName.isEmpty()) continue;
                    if (database.equals(catalogName)) result.add(createTable);
                }
            }
        }
        return result;
    }

}
