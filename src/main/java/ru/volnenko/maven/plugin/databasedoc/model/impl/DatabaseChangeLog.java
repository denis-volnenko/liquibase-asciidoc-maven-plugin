package ru.volnenko.maven.plugin.databasedoc.model.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.volnenko.maven.plugin.databasedoc.model.IDatabaseChangeLog;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class DatabaseChangeLog implements IDatabaseChangeLog {

    private ChangeSet changeSet = new ChangeSet();

}
