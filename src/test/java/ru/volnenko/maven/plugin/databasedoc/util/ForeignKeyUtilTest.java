package ru.volnenko.maven.plugin.databasedoc.util;


import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import lombok.NonNull;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.volnenko.maven.plugin.databasedoc.data.ForeignKeyUtilData;
import ru.volnenko.maven.plugin.databasedoc.model.impl.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Feature("ForeignKeyUtil")
@RunWith(DataProviderRunner.class)
public class ForeignKeyUtilTest {

    @Test
    @DisplayName("ForeignKeyUtil метод fk с параметром AddForeignKeyConstraint")
    @Description("Проверка метода fk с параметром AddForeignKeyConstraint на возврат корректного объекта FK и not null")
    @UseDataProvider(value = "validForeignKeyConstraints", location = ForeignKeyUtilData.class)
    public void testValidConstraintsCorrectReturn(final AddForeignKeyConstraint constraint, final FK expectedFk) {
        @NonNull final FK fk = ForeignKeyUtil.fk(constraint);
        Assert.assertNotNull(ForeignKeyUtil.fk(constraint));
        Assert.assertEquals(expectedFk, fk);
        Assert.assertEquals(expectedFk.getTableName(), fk.getTableName());
        Assert.assertEquals(expectedFk.getFieldName(), fk.getFieldName());
        Assert.assertEquals(expectedFk.getPk().getTableName(), fk.getPk().getTableName());
        Assert.assertEquals(expectedFk.getPk().getFieldName(), fk.getPk().getFieldName());
    }

    @Test
    @DisplayName("ForeignKeyUtil метод fk с параметром AddForeignKeyConstraint")
    @Description("Проверка метода fk с параметром AddForeignKeyConstraint на возврат null")
    @UseDataProvider(value = "invalidForeignKeyConstraints", location = ForeignKeyUtilData.class)
    public void testInvalidConstraints(final AddForeignKeyConstraint constraint) {
        Assert.assertNull(ForeignKeyUtil.fk(constraint));
    }

    @Test
    @DisplayName("ForeignKeyUtil метод enabled с параметром Column")
    @Description("Проверка метода fk с параметром Column на возврат true/false")
    @UseDataProvider(value = "enabledMethodColumn", location = ForeignKeyUtilData.class)
    public void testEnabledMethodColumn(final Column column, final Boolean expectedBoolean) {
        Assert.assertEquals(expectedBoolean, ForeignKeyUtil.enabled(column));
    }

    @Test
    @DisplayName("ForeignKeyUtil метод fk с параметром CreateTable")
    @Description("Проверка метода fk с параметром CreateTable на возврат Set с объектами FK")
    @UseDataProvider(value = "fkCreateTable", location = ForeignKeyUtilData.class)
    public void testFkCreateTable(final CreateTable createTable, final Set<FK> expectedFks) {
        final Set<FK> fks = ForeignKeyUtil.fk(createTable);
        Assert.assertEquals(expectedFks, fks);
    }

    @Test
    @DisplayName("ForeignKeyUtil метод fks с параметром Roots")
    @Description("Проверка метода fks с параметром Roots на возврат Set с объектами FK и emptySet()")
    @UseDataProvider(value = "fksRoots", location = ForeignKeyUtilData.class)
    public void testSetRoots(final Collection<Root> roots, final Set<FK> expectedFks) {
        Assert.assertEquals(expectedFks, ForeignKeyUtil.fks(roots));
    }

    @Test
    @DisplayName("ForeignKeyUtil метод fks с параметром Root")
    @Description("Проверка метода fks с параметром Root на возврат Set с объектами FK и emptySet()")
    @UseDataProvider(value = "fksMethodRoot", location = ForeignKeyUtilData.class)
    public void testFksMethodRoot(final Root root, final Set<FK> expectedFks) {
        Assert.assertEquals(expectedFks, ForeignKeyUtil.fks(root));
    }

    @Test
    @DisplayName("ForeignKeyUtil медод fk с параметрами tableName и Column")
    @Description("Проверка метода fk с параметрами tableName и Column на возврат корректного объекта FK и not null")
    @UseDataProvider(value = "validColumnWithTableName", location = ForeignKeyUtilData.class)
    public void testValidColumnWithTableName(final String tableName, final Column column, final FK expectedFk) {
        @NonNull final FK fk = ForeignKeyUtil.fk(tableName, column);
        Assert.assertNotNull(ForeignKeyUtil.fk(tableName, column));
        Assert.assertEquals(expectedFk, fk);
        Assert.assertEquals(expectedFk.getUnique(), fk.getUnique());
        Assert.assertEquals(expectedFk.getTableName(), fk.getTableName());
        Assert.assertEquals(expectedFk.getFieldName(), fk.getFieldName());
        Assert.assertEquals(expectedFk.getPk().getTableName(), fk.getPk().getTableName());
        Assert.assertEquals(expectedFk.getPk().getFieldName(), fk.getPk().getFieldName());
    }

    @Test
    @DisplayName("ForeignKeyUtil медод fk с параметрами tableName и Column")
    @Description("Проверка метода fk с параметрами tableName и Column на возврат null")
    @UseDataProvider(value = "invalidColumnWithTableName", location = ForeignKeyUtilData.class)
    public void testInvalidColumnWithTableNameNull(final String tableName, final Column column) {
        Assert.assertNull(ForeignKeyUtil.fk(tableName, column));
    }

}
