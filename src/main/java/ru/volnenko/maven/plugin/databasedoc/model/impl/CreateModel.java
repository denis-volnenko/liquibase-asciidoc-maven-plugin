package ru.volnenko.maven.plugin.databasedoc.model.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.volnenko.maven.plugin.databasedoc.model.ICreateModel;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class CreateModel implements ICreateModel {

    private String catalogName = "";

    private String schemaName = "";

    private String modelName = "";

    private String remarks = "";

    private Schema schema;

}
