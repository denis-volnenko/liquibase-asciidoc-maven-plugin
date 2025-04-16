package ru.volnenko.maven.plugin.databasedoc.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tngtech.java.junit.dataprovider.DataProvider;
import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.model.impl.AddForeignKeyConstraint;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Column;
import ru.volnenko.maven.plugin.databasedoc.model.impl.FK;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Root;
import ru.volnenko.maven.plugin.databasedoc.util.MapperUtil;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class ForeignKeyUtilData {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class TestCase {
        public String tableName;
        public Column column;
        public Root root;
        public Collection<Root> roots;
        public Set<FK> expectedFks;
        public FK expectedFk;
        public AddForeignKeyConstraint constraint;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class TestData {
        public List<TestCase> testCases;
    }

    @DataProvider
    public static Object[][] validRootWithFK() {
        @NonNull final TestData testData = MapperUtil.parseJsonFromResource(
                "testdata/validRootWithFK.json", TestData.class
        );
        return testData.testCases.stream()
                .map(testCase -> new Object[]{testCase.root, testCase.expectedFks})
                .toArray(Object[][]::new);
    }

    @DataProvider
    public static Object[][] setRoots() {
        @NonNull final TestData testData = MapperUtil.parseJsonFromResource(
                "testdata/setRoots.json", TestData.class
        );
        return testData.testCases.stream()
                .map(testCase -> new Object[]{testCase.roots, testCase.expectedFks})
                .toArray(Object[][]::new);
    }

    @DataProvider
    public static Object[][] validRootReturnEmptySet() {
        @NonNull final TestData testData = MapperUtil.parseJsonFromResource(
                "testdata/validRootReturnEmptySet.json", TestData.class
        );
        return testData.testCases.stream()
                .map(testCase -> new Object[]{testCase.root})
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
    public static Object[][] trueColumns() {
        @NonNull final Column[] columns = MapperUtil.parseJsonFromResource(
                "testdata/trueColumns.json", Column[].class
        );
        return Arrays.stream(columns)
                .map(column -> new Object[]{column})
                .toArray(Object[][]::new);
    }

    @DataProvider
    public static Object[][] falseColumns() {
        @NonNull final Column[] columns = MapperUtil.parseJsonFromResource(
                "testdata/falseColumns.json", Column[].class
        );
        return Arrays.stream(columns)
                .map(column -> new Object[]{column})
                .toArray(Object[][]::new);
    }

}
