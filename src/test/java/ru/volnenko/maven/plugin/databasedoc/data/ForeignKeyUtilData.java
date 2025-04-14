package ru.volnenko.maven.plugin.databasedoc.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tngtech.java.junit.dataprovider.DataProvider;
import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.model.impl.AddForeignKeyConstraint;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Column;
import ru.volnenko.maven.plugin.databasedoc.model.impl.FK;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class ForeignKeyUtilData {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class TestCase {
        public String tableName;
        public Column column;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class TestData {
        public List<TestCase> testCases;
    }


    @NonNull
    public static FK correctReturnOfFkConstraintMethod() {
        @NonNull final FK fk = new FK();
        fk.setTableName("baseTable");
        fk.setFieldName("baseColumn");
        fk.getPk().setTableName("refTable");
        fk.getPk().setFieldName("refColumn");
        return fk;
    }

    @NonNull
    public static FK correctReturnOfFkColumnTableNameMethod() {
        @NonNull final FK fk = new FK();
        fk.setTableName("posts");
        fk.setFieldName("author_id");
        fk.getPk().setTableName("users");
        fk.getPk().setFieldName("user_id");
        fk.setUnique(true);
        return fk;
    }

    private static InputStream inputStreamFromJsonFile(String path) {
        try {
            final InputStream inputStream = ForeignKeyUtilData.class
                    .getClassLoader()
                    .getResourceAsStream(path);
            if (inputStream == null) {
                throw new RuntimeException();
            }
            return inputStream;
        } catch (Exception e) {
            throw new RuntimeException("Failed to load test data from " + path, e);
        }
    }

    @DataProvider
    public static Object[][] validColumnWithTableName() throws IOException {
        @NonNull final String path = "testdata/validColumnWithTableName.json";
        @NonNull final InputStream inputStream = ForeignKeyUtilData.inputStreamFromJsonFile(path);
        @NonNull final ObjectMapper objectMapper = new ObjectMapper();
        @NonNull final TestData testData = objectMapper.readValue(inputStream, TestData.class);
        return testData.testCases.stream()
                .map(testCase -> new Object[]{testCase.tableName, testCase.column})
                .toArray(Object[][]::new);
    }

    @DataProvider
    public static Object[][] invalidColumnWithTableName() throws IOException {
        @NonNull final String path = "testdata/invalidColumnWithTableName.json";
        @NonNull final InputStream inputStream = ForeignKeyUtilData.inputStreamFromJsonFile(path);
        @NonNull final ObjectMapper objectMapper = new ObjectMapper();
        @NonNull final TestData testData = objectMapper.readValue(inputStream, TestData.class);
        return testData.testCases.stream()
                .map(testCase -> new Object[]{testCase.tableName, testCase.column})
                .toArray(Object[][]::new);
    }

    @DataProvider
    public static Object[] validForeignKeyConstraints() throws IOException {
        @NonNull final String path = "testdata/validForeignKeyConstraints.json";
        @NonNull final InputStream inputStream = ForeignKeyUtilData.inputStreamFromJsonFile(path);
        @NonNull final ObjectMapper objectMapper = new ObjectMapper();
        @NonNull final AddForeignKeyConstraint constraint = objectMapper.readValue(inputStream, AddForeignKeyConstraint.class);
        return new Object[][]{{constraint}};
    }

    @DataProvider
    public static Object[][] invalidForeignKeyConstraints() throws IOException {
        @NonNull final String path = "testdata/invalidForeignKeyConstraints.json";
        @NonNull final InputStream inputStream = ForeignKeyUtilData.inputStreamFromJsonFile(path);
        @NonNull final ObjectMapper mapper = new ObjectMapper();
        @NonNull final AddForeignKeyConstraint[] constraints = mapper.readValue(inputStream, AddForeignKeyConstraint[].class);
        return Arrays.stream(constraints)
                .map(constraint -> new Object[]{constraint})
                .toArray(Object[][]::new);
    }

    @DataProvider
    public static Object[][] trueColumns() throws IOException {
        @NonNull final String path = "testdata/trueColumns.json";
        @NonNull final InputStream inputStream = ForeignKeyUtilData.inputStreamFromJsonFile(path);
        @NonNull final ObjectMapper objectMapper = new ObjectMapper();
        @NonNull final Column[] columns = objectMapper.readValue(inputStream, Column[].class);
        return Arrays.stream(columns)
                .map(column -> new Object[]{column})
                .toArray(Object[][]::new);
    }

    @DataProvider
    public static Object[][] falseColumns() throws IOException {
        @NonNull final String path = "testdata/falseColumns.json";
        @NonNull final InputStream inputStream = ForeignKeyUtilData.inputStreamFromJsonFile(path);
        @NonNull final ObjectMapper objectMapper = new ObjectMapper();
        @NonNull final Column[] columns = objectMapper.readValue(inputStream, Column[].class);
        return Arrays.stream(columns)
                .map(column -> new Object[]{column})
                .toArray(Object[][]::new);
    }

}
