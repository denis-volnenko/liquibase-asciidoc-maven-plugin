package ru.volnenko.maven.plugin.databasedoc.model.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.volnenko.maven.plugin.databasedoc.model.IChange;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Change implements IChange {

    private CreateTable createTable;

    private CreateType createType;

    private AddPrimaryKey addPrimaryKey;

    private AddUniqueConstraint addUniqueConstraint;

    private AddForeignKeyConstraint addForeignKeyConstraint;

}
