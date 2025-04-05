package ru.volnenko.maven.plugin.databasedoc.model;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Change;

import java.util.List;

public interface IChangeSet {

    void add(@NonNull Change change);

    String getId();

    void setId(String id);

    String getAuthor();

    void setAuthor(String author);

    List<Change> getChanges();

    void setChanges(List<Change> changes);

}
