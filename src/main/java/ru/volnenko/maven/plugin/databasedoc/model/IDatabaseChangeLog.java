package ru.volnenko.maven.plugin.databasedoc.model;

import ru.volnenko.maven.plugin.databasedoc.model.impl.ChangeSet;

public interface IDatabaseChangeLog {

    ChangeSet getChangeSet();

    void setChangeSet(ChangeSet changeSet);

}
