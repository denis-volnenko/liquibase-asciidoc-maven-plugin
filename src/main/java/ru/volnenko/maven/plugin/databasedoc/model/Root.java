package ru.volnenko.maven.plugin.databasedoc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Root {

    private DatabaseChangeLog databaseChangeLog = new DatabaseChangeLog();

    public Root(final String value) {
        System.out.println(value);
    }

}
