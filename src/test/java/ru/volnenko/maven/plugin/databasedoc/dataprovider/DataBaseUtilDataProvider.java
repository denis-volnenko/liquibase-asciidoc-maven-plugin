package ru.volnenko.maven.plugin.databasedoc.dataprovider;

import com.tngtech.java.junit.dataprovider.DataProvider;
import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.util.MapperUtil;


public final class DataBaseUtilDataProvider extends AbstractDataProvider {

    @DataProvider
    public static Object[][] getDataBases() {
        @NonNull final TestData testData = MapperUtil.parseJsonFromResource(
                "testdata/databaseutil/dataGetDataBases.json",
                TestData.class
        );
        return testData.testCases.stream()
                .map(testCase -> new Object[]{testCase.roots, testCase.expectedDatabases})
                .toArray(Object[][]::new);
    }

}
