package ru.volnenko.maven.plugin.databasedoc.model.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import ru.volnenko.maven.plugin.databasedoc.model.ICreateTable;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class CreateTable implements ICreateTable {

    private String catalogName = "";

    private String tablespace = "";

    private String schemaName = "";

    private String tableName = "";

    private String remarks = "";

    private List<ColumnWrapper> columns = new ArrayList<>();

    public void add(@NonNull final Column column) {
        columns.add(new ColumnWrapper(column));
    }

}
