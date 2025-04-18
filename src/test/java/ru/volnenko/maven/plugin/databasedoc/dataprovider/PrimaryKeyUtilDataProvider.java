package ru.volnenko.maven.plugin.databasedoc.dataprovider;

import com.tngtech.java.junit.dataprovider.DataProvider;
import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.util.MapperUtil;

public class PrimaryKeyUtilDataProvider extends AbstractDataProvider {

    @DataProvider
    public static Object[][] pksMethodRoot() {
        @NonNull final TestData testData = MapperUtil.parseJsonFromResource(
                "testdata/primarykeyutil/dataPksMethodRoot.json",
                TestData.class
        );
        return testData.testCases.stream()
                .map(testCase -> new Object[]{testCase.root, testCase.expectedPks})
                .toArray(Object[][]::new);
    }

}
