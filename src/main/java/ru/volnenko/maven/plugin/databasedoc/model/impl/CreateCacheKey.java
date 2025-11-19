package ru.volnenko.maven.plugin.databasedoc.model.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class CreateCacheKey {

    private Integer ttl;

    @JsonProperty("$ref")
    private String reference;

}
