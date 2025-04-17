package ru.volnenko.maven.plugin.databasedoc.data;

import com.tngtech.java.junit.dataprovider.DataProvider;
import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.util.MapperUtil;

import java.util.stream.Stream;

public class ForeignKeyUtilDataProvider extends AbstractDataProvider {

    @DataProvider
    public static Object[][] fkCreateTable() {
        @NonNull final TestData testData = MapperUtil.parseJsonFromResource(
                "testdata/foreignkey-util/dataFkCreateTable.json", TestData.class
        );
        return testData.testCases.stream()
                .map(testCase -> new Object[]{testCase.createTable, testCase.expectedFks})
                .toArray(Object[][]::new);
    }

    @DataProvider
    public static Object[][] fksRoots() {
        @NonNull final TestData testData = MapperUtil.parseJsonFromResource(
                "testdata/foreignkey-util/dataFksRoots.json", TestData.class
        );
        return testData.testCases.stream()
                .map(testCase -> new Object[]{testCase.roots, testCase.expectedFks})
                .toArray(Object[][]::new);
    }

    @DataProvider
    public static Object[][] fksMethodRoot() {
        @NonNull final TestData testData = MapperUtil.parseJsonFromResource(
                "testdata/foreignkey-util/dataFksMethodRoot.json", TestData.class
        );
        return Stream.concat(
                testData.validTestCases.stream(),
                testData.invalidTestCases.stream()
        )
                .map(testCase -> new Object[]{testCase.root, testCase.expectedFks})
                .toArray(Object[][]::new);
    }

    @DataProvider
    public static Object[][] fkTableNameColumn() {
        @NonNull final TestData testData = MapperUtil.parseJsonFromResource(
                "testdata/foreignkey-util/dataFkTableNameColumn.json", TestData.class
        );
        return Stream.concat(
                testData.validTestCases.stream(),
                testData.invalidTestCases.stream()
                )
                .map(testCase -> new Object[]{testCase.tableName, testCase.column, testCase.expectedFk})
                .toArray(Object[][]::new);
    }

    @DataProvider
    public static Object[][] fkConstraint() {
        @NonNull final TestData testData = MapperUtil.parseJsonFromResource(
                "testdata/foreignkey-util/dataFkConstraint.json", TestData.class
        );
        return Stream.concat(
                testData.validTestCases.stream(),
                testData.invalidTestCases.stream()
        )
                .map(testCase -> new Object[]{testCase.constraint, testCase.expectedFk})
                .toArray(Object[][]::new);
    }

    @DataProvider
    public static Object[][] enabledMethodColumn() {
        @NonNull final TestData testData = MapperUtil.parseJsonFromResource(
                "testdata/foreignkey-util/dataEnabledMethodColumn.json", TestData.class
        );
        return Stream.concat(
                testData.validTestCases.stream(),
                testData.invalidTestCases.stream()
        )
                .map(testCase -> new Object[]{testCase.column, testCase.expectedBoolean})
                .toArray(Object[][]::new);
    }

}
