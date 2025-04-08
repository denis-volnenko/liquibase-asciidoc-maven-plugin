package ru.volnenko.maven.plugin.databasedoc.model.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.volnenko.maven.plugin.databasedoc.model.IAddPrimaryKey;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class AddPrimaryKey implements IAddPrimaryKey {

    private String columnNames;

    private String constraintName;

    private String schemaName;

    private String tableName;

    private String tablespace;

    public boolean multiple() {
        if (columnNames == null) return false;
        if (columnNames.isEmpty()) return false;
        return columnNames.contains(",");
    }

}
