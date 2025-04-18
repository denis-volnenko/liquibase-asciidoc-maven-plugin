package ru.volnenko.maven.plugin.databasedoc.dataprovider;

import com.tngtech.java.junit.dataprovider.DataProvider;
import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.util.MapperUtil;

public class ColumnUtilDataProvider extends AbstractDataProvider {

    @DataProvider
    public static Object[][] getNameColumn() {
        @NonNull final TestData testData = MapperUtil.parseJsonFromResource(
                "testdata/columnutil/dataGetNameColumn.json",
                TestData.class
        );
        return testData.testCases.stream()
                .map(testCase -> new Object[]{testCase.column, testCase.expectedString})
                .toArray(Object[][]::new);
    }

}
