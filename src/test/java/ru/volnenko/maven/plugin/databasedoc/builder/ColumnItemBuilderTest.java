package ru.volnenko.maven.plugin.databasedoc.builder;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import lombok.NonNull;
import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.*;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Column;

public class ColumnItemBuilderTest extends AbstractBuilderTest {

    @NonNull
    private final ColumnItemBuilder columnItemBuilder = columnItemBuilder();

    @Test
    @DisplayName("Контракт ColumnItemBuilder")
    @Description("Проверка контракта класса ColumnItemBuilder на null-значения и" +
            "корректности установки значений")
    public void test() {
        Assert.assertNotNull(columnItemBuilder.add());
        Assert.assertNotNull(columnItemBuilder.constraints());
        Assert.assertNotNull(columnItemBuilder.column());
        Assert.assertNotNull(columnItemBuilder.root());
        Assert.assertNotNull(columnItemBuilder.change());

        Assert.assertNotNull(columnItemBuilder.name(NAME));
        Assert.assertNotNull(columnItemBuilder.type(TYPE));
        Assert.assertNotNull(columnItemBuilder.remarks(REMARKS));
        Assert.assertNotNull(columnItemBuilder.autoIncrement(true));

        final Column column = getColumn(columnItemBuilder);

        Assert.assertEquals(EXPECTED_NAME, column.getName());
        Assert.assertEquals(EXPECTED_TYPE, column.getType());
        Assert.assertEquals(EXPECTED_REMARKS, column.getRemarks());
        Assert.assertEquals(true, column.getAutoIncrement());
    }

}
