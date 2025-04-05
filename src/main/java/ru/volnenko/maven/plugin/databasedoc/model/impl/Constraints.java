package ru.volnenko.maven.plugin.databasedoc.model.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.volnenko.maven.plugin.databasedoc.model.IConstraints;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Constraints implements IConstraints {

    private Boolean primaryKey = false;

    private Boolean nullable = true;

    private Boolean unique = false;

    private String uniqueConstraintName;

    private String foreignKeyName;

    private ForeignKey foreignKey;

    //    private String references;

}
