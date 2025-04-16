package ru.volnenko.maven.plugin.databasedoc.model.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import ru.volnenko.maven.plugin.databasedoc.model.IDatabaseChangeLog;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;


@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class DatabaseChangeLog implements IDatabaseChangeLog {

    private ChangeSet changeSet = new ChangeSet();

    @NonNull
    public Collection<ChangeSet> changeSets() {
        return Collections.singleton(changeSet);
    }

}
