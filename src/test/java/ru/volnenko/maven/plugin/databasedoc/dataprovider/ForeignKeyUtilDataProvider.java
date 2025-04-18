package ru.volnenko.maven.plugin.databasedoc.dataprovider;

import com.tngtech.java.junit.dataprovider.DataProvider;
import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.util.MapperUtil;

import java.util.stream.Stream;

public class ForeignKeyUtilDataProvider extends AbstractDataProvider {

    @DataProvider
    public static Object[][] fkMethodCreateTable() {
        @NonNull final TestData testData = MapperUtil.parseJsonFromResource(
                "testdata/foreignkeyutil/dataFkMethodCreateTable.json", TestData.class
        );
        return testData.testCases.stream()
                .map(testCase -> new Object[]{testCase.createTable, testCase.expectedFks})
                .toArray(Object[][]::new);
    }

    @DataProvider
    public static Object[][] fksMethodRoots() {
        @NonNull final TestData testData = MapperUtil.parseJsonFromResource(
                "testdata/foreignkeyutil/dataFksMethodRoots.json", TestData.class
        );
        return testData.testCases.stream()
                .map(testCase -> new Object[]{testCase.roots, testCase.expectedFks})
                .toArray(Object[][]::new);
    }

    @DataProvider
    public static Object[][] fksMethodRoot() {
        @NonNull final TestData testData = MapperUtil.parseJsonFromResource(
                "testdata/foreignkeyutil/dataFksMethodRoot.json", TestData.class
        );
        return Stream.concat(
                testData.validTestCases.stream(),
                testData.invalidTestCases.stream()
        )
                .map(testCase -> new Object[]{testCase.root, testCase.expectedFks})
                .toArray(Object[][]::new);
    }

    @DataProvider
    public static Object[][] fkMethodTableNameColumn() {
        @NonNull final TestData testData = MapperUtil.parseJsonFromResource(
                "testdata/foreignkeyutil/dataFkMethodTableNameColumn.json", TestData.class
        );
        return Stream.concat(
                testData.validTestCases.stream(),
                testData.invalidTestCases.stream()
                )
                .map(testCase -> new Object[]{testCase.tableName, testCase.column, testCase.expectedFk})
                .toArray(Object[][]::new);
    }

    @DataProvider
    public static Object[][] fkMethodConstraint() {
        @NonNull final TestData testData = MapperUtil.parseJsonFromResource(
                "testdata/foreignkeyutil/dataFkMethodConstraint.json", TestData.class
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
                "testdata/foreignkeyutil/dataEnabledMethodColumn.json", TestData.class
        );
        return Stream.concat(
                testData.validTestCases.stream(),
                testData.invalidTestCases.stream()
        )
                .map(testCase -> new Object[]{testCase.column, testCase.expectedBoolean})
                .toArray(Object[][]::new);
    }

}
