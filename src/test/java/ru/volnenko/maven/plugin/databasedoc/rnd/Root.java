package ru.volnenko.maven.plugin.databasedoc.rnd;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Root {

    private List<DatabaseChangeLog> databaseChangeLogs = new ArrayList<>();

    {
        databaseChangeLogs.add(new DatabaseChangeLog());
        databaseChangeLogs.add(new DatabaseChangeLog());
    }
}
