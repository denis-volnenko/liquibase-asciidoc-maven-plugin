package ru.volnenko.maven.plugin.databasedoc.data;

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
        public CreateTable createTable;
        public AddForeignKeyConstraint constraint;
        public Column column;
        public Root root;
        public Collection<Root> roots;
        public Set<FK> expectedFks;
        public FK expectedFk;
        public Boolean expectedBoolean;
        public String expectedString;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class TestData {
        public List<TestCase> testCases;
        public List<TestCase> validTestCases;
        public List<TestCase> invalidTestCases;
    }

}
