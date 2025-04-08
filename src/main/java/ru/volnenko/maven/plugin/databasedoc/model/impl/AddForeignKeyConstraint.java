package ru.volnenko.maven.plugin.databasedoc.model.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class AddForeignKeyConstraint {

    private String baseColumnNames;

    private String baseTableName;

    private String constraintName;

    private Boolean deferrable;

    private Boolean initiallyDeferred;

    private String onDelete;

    private String onUpdate;

    private String referencedColumnNames;

    private String referencedTableName;

    private Boolean validate;

}
