package ru.volnenko.maven.plugin.databasedoc.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tngtech.java.junit.dataprovider.DataProvider;
import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Column;
import ru.volnenko.maven.plugin.databasedoc.util.MapperUtil;

import java.util.List;

public class ConstraintUtilDataProvider {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class TestCase {
        public Column column;
        public Boolean expectedBoolean;
    }

    public static final class TestData {
        public List<TestCase> testCases;
    }

    @DataProvider
    public static Object[][] nullableColumn() {
        @NonNull final TestData testData = MapperUtil.parseJsonFromResource(
                "testdata/constraint-util/dataNullableColumn.json",
                TestData.class
        );
        return testData.testCases.stream()
                .map(testCase -> new Object[]{testCase.column, testCase.expectedBoolean})
                .toArray(Object[][]::new);
    }

    @DataProvider
    public static Object[][] notNullColumn() {
        @NonNull final TestData testData = MapperUtil.parseJsonFromResource(
                "testdata/constraint-util/dataNotNullColumn.json",
                TestData.class
        );
        return testData.testCases.stream()
                .map(testCase -> new Object[]{testCase.column, testCase.expectedBoolean})
                .toArray(Object[][]::new);
    }



}
