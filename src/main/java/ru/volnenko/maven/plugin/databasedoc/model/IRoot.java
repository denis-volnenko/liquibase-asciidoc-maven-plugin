package ru.volnenko.maven.plugin.databasedoc.model;

import ru.volnenko.maven.plugin.databasedoc.model.impl.DatabaseChangeLog;

import java.util.List;

public interface IRoot {

    List<DatabaseChangeLog> getDatabaseChangeLog();

    void setDatabaseChangeLog(List<DatabaseChangeLog> databaseChangeLog);

}
