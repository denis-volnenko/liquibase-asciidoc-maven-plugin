package ru.volnenko.maven.plugin.databasedoc.model;

import ru.volnenko.maven.plugin.databasedoc.model.impl.DatabaseChangeLog;

public interface IRoot {
    DatabaseChangeLog getDatabaseChangeLog();

    void setDatabaseChangeLog(DatabaseChangeLog databaseChangeLog);
}
