package ru.volnenko.maven.plugin.databasedoc.model.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import ru.volnenko.maven.plugin.databasedoc.model.IChangeSet;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class ChangeSet implements IChangeSet {

    private String id = "";

    private String author = "";

    private List<Change> changes = new ArrayList<>();

    @Override
    public void add(@NonNull final Change change) {
        changes.add(change);
    }

}
