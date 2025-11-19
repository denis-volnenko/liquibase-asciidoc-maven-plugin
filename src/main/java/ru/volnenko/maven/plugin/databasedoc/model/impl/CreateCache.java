package ru.volnenko.maven.plugin.databasedoc.model.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.volnenko.maven.plugin.databasedoc.model.ICreateCache;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class CreateCache implements ICreateCache {

    private String catalogName = "";

    private String schemaName = "";

    private String cacheName = "";

    private String remarks = "";

    private CreateCacheKey key;

    private CreateCacheValue value;

}
