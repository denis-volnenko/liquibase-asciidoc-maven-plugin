package ru.volnenko.maven.plugin.databasedoc.model.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.volnenko.maven.plugin.databasedoc.model.IAddUniqueConstraint;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class AddUniqueConstraint implements IAddUniqueConstraint {

    private String tablespace;

    private String schemaName;

    private String columnNames;

    private String catalogName;

    private String forIndexName;

    private String constraintName;

    private String tableName;

    private Boolean clustered;

    private Boolean deferrable;

    private Boolean disabled;

    private Boolean validate;

    private Boolean initiallyDeferred;

    public boolean multiple() {
        if (columnNames == null) return false;
        if (columnNames.isEmpty()) return false;
        return columnNames.contains(",");
    }

}
