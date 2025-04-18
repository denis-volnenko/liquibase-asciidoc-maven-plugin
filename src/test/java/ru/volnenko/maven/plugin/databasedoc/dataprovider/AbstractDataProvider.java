package ru.volnenko.maven.plugin.databasedoc.dataprovider;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ru.volnenko.maven.plugin.databasedoc.model.impl.*;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class AbstractDataProvider {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class TestCase {
        public String description;
        public String tableName;
        public String value;
        public CreateTable createTable;
        public AddForeignKeyConstraint constraint;
        public AddUniqueConstraint constraintUk;
        public Column column;
        public Root root;
        public Collection<Root> roots;
        public Set<FK> expectedFks;
        public Set<UK> expectedUks;
        public FK expectedFk;
        public UK expectedUk;
        public Boolean expectedBoolean;
        public String expectedString;
        public Set<String> expectedDatabases;
        public List<CreateTable> expectedCreateTables;
        public String database;
        public Set<PK> expectedPks;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class TestData {
        public List<TestCase> testCases;
        public List<TestCase> validTestCases;
        public List<TestCase> invalidTestCases;
    }

}
