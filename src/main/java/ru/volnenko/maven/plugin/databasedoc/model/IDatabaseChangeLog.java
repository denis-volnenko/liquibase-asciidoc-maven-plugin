package ru.volnenko.maven.plugin.databasedoc.model;

import ru.volnenko.maven.plugin.databasedoc.model.impl.ChangeSet;

import java.util.List;

public interface IDatabaseChangeLog {

    ChangeSet getChangeSet();

    void setChangeSet(ChangeSet changeSet);

}
