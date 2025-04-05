package ru.volnenko.maven.plugin.databasedoc.model;

import ru.volnenko.maven.plugin.databasedoc.model.impl.ChangeSet;

import java.util.List;

public interface IDatabaseChangeLog {

    List<ChangeSet> getChangeSet();

    void setChangeSet(List<ChangeSet> changeSet);

}
