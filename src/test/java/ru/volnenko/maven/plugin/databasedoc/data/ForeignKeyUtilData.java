package ru.volnenko.maven.plugin.databasedoc.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tngtech.java.junit.dataprovider.DataProvider;
import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.model.impl.*;
import ru.volnenko.maven.plugin.databasedoc.util.MapperUtil;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class ForeignKeyUtilData {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class TestCase {
        public String description;
        public CreateTable createTable;
        public String tableName;
        public Column column;
        public Root root;
        public Collection<Root> roots;
        public Set<FK> expectedFks;
        public FK expectedFk;
        public AddForeignKeyConstraint constraint;
        public Constraints constraints;
        public Boolean expectedBoolean;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class TestData {
        public List<TestCase> testCases;
        public List<TestCase> validTestCases;
        public List<TestCase> invalidTestCases;
    }

    @DataProvider
    public static Object[][] fkCreateTable() {
        @NonNull final TestData testData = MapperUtil.parseJsonFromResource(
                "testdata/createTables.json", TestData.class
        );
        return testData.testCases.stream()
                .map(testCase -> new Object[]{testCase.createTable, testCase.expectedFks})
                .toArray(Object[][]::new);
    }

    @DataProvider
    public static Object[][] fksRoots() {
        @NonNull final TestData testData = MapperUtil.parseJsonFromResource(
                "testdata/fksRoots.json", TestData.class
        );
        return testData.testCases.stream()
                .map(testCase -> new Object[]{testCase.roots, testCase.expectedFks})
                .toArray(Object[][]::new);
    }

    @DataProvider
    public static Object[][] fksMethodRoot() {
        @NonNull final TestData testData = MapperUtil.parseJsonFromResource(
                "testdata/dataFksMethodRoot.json", TestData.class
        );
        return Stream.concat(
                testData.validTestCases.stream(),
                testData.invalidTestCases.stream()
        )
                .map(testCase -> new Object[]{testCase.root, testCase.expectedFks})
                .toArray(Object[][]::new);
    }

    @DataProvider
    public static Object[][] validColumnWithTableName() {
        @NonNull final TestData testData = MapperUtil.parseJsonFromResource(
                "testdata/validColumnWithTableName.json", TestData.class
        );
        return testData.testCases.stream()
                .map(testCase -> new Object[]{testCase.tableName, testCase.column, testCase.expectedFk})
                .toArray(Object[][]::new);
    }

    @DataProvider
    public static Object[][] invalidColumnWithTableName() {
        @NonNull final TestData testData = MapperUtil.parseJsonFromResource(
                "testdata/invalidColumnWithTableName.json", TestData.class
        );
        return testData.testCases.stream()
                .map(testCase -> new Object[]{testCase.tableName, testCase.column})
                .toArray(Object[][]::new);
    }

    @DataProvider
    public static Object[] validForeignKeyConstraints() {
        @NonNull final TestData testData = MapperUtil.parseJsonFromResource(
                "testdata/validForeignKeyConstraints.json", TestData.class
        );
        return testData.testCases.stream()
                .map(testCase -> new Object[]{testCase.constraint, testCase.expectedFk})
                .toArray(Object[][]::new);
    }

    @DataProvider
    public static Object[][] invalidForeignKeyConstraints() {
        @NonNull final AddForeignKeyConstraint[] constraints = MapperUtil.parseJsonFromResource(
                "testdata/invalidForeignKeyConstraints.json", AddForeignKeyConstraint[].class
        );
        return Arrays.stream(constraints)
                .map(constraint -> new Object[]{constraint})
                .toArray(Object[][]::new);
    }

    @DataProvider
    public static Object[][] enabledMethodColumn() {
        @NonNull final TestData testData = MapperUtil.parseJsonFromResource(
                "testdata/dataEnabledMethodColumn.json", TestData.class
        );
        return Stream.concat(
                testData.validTestCases.stream(),
                testData.invalidTestCases.stream()
        )
                .map(testCase -> new Object[]{testCase.column, testCase.expectedBoolean})
                .toArray(Object[][]::new);
    }

}
