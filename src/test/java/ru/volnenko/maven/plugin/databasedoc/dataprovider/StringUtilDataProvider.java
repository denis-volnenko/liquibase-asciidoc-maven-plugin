package ru.volnenko.maven.plugin.databasedoc.dataprovider;

import com.tngtech.java.junit.dataprovider.DataProvider;
import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.util.MapperUtil;

public class StringUtilDataProvider extends AbstractDataProvider {

    @DataProvider
    public static Object[][] existsValue() {
        @NonNull final TestData testData = MapperUtil.parseJsonFromResource(
                "testdata/stringutil/dataExistsValue.json",
                TestData.class
        );
        return testData.testCases.stream()
                .map(testCase -> new Object[]{testCase.value, testCase.expectedBoolean})
                .toArray(Object[][]::new);
    }

}
