package ru.volnenko.maven.plugin.databasedoc.rnd;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DatabaseChangeLog {

    private List<ChangeSet> changeSets = new ArrayList<>();

    {
        changeSets.add(new ChangeSet());
        changeSets.add(new ChangeSet());
    }
}
