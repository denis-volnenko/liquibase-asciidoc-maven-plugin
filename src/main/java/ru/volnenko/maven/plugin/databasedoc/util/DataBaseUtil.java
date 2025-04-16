package ru.volnenko.maven.plugin.databasedoc.util;

import edu.emory.mathcs.backport.java.util.Collections;
import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.model.impl.*;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class DataBaseUtil {

    @NonNull
    public static Set<String> getDataBases(final Collection<Root> roots) {
        if (roots == null) return Collections.emptySet();
        @NonNull final Set<String> result = new LinkedHashSet<>();
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
                    result.add(catalogName);
                }
            }
        }
        return result;
    }

}
