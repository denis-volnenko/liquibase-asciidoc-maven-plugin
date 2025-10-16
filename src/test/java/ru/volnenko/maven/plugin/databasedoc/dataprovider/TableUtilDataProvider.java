package ru.volnenko.maven.plugin.databasedoc.dataprovider;

import com.tngtech.java.junit.dataprovider.DataProvider;
import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.util.MapperUtil;

public final class TableUtilDataProvider extends AbstractDataProvider {

    @DataProvider
    public static Object[][] getCreateTablesWithoutDatabase() {
        @NonNull final TestData testData = MapperUtil.parseJsonFromResource(
                "testdata/tableutil/dataGetCreateTablesWithoutDatabase.json",
                TestData.class
        );
        return testData.testCases.stream()
                .map(testCase -> new Object[]{testCase.roots, testCase.expectedCreateTables})
                .toArray(Object[][]::new);
    }

    @DataProvider
    public static Object[][] getCreateTablesWithDatabase() {
        @NonNull final TestData testData = MapperUtil.parseJsonFromResource(
                "testdata/tableutil/dataGetCreateTablesWithDatabase.json",
                TestData.class
        );
        return testData.testCases.stream()
                .map(testCase -> new Object[]{testCase.roots, testCase.database, testCase.expectedCreateTables})
                .toArray(Object[][]::new);
    }

}
