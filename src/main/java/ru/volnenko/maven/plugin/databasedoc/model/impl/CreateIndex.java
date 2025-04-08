package ru.volnenko.maven.plugin.databasedoc.model.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class CreateIndex {

    private String catalogName;

    private String tablespace;

    private String schemaName;

    private Boolean unique;

    private String indexName;

    private String tableName;

    private List<CreateIndexColumn> columns = new ArrayList<>();

}
