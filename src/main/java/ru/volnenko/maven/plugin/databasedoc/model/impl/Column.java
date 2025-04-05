package ru.volnenko.maven.plugin.databasedoc.model.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.volnenko.maven.plugin.databasedoc.model.IColumn;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Column implements IColumn {

    private String name = "";

    private String type = "";

    private String remarks = "";

    private Boolean autoIncrement = false;

    private String defaultValue = "";

    private String defaultValueComputed = "";

    private Constraints constraints = new Constraints();

}
