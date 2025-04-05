package ru.volnenko.maven.plugin.databasedoc.model.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.volnenko.maven.plugin.databasedoc.model.ICreateType;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class CreateType implements ICreateType {

    private String catalogName = "";

    private String schemaName = "";

    private String tablespace = "";

    private String typeName = "";

    private String remarks = "";

    private List<ValueWrapper> values;

}
