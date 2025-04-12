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
import ru.volnenko.maven.plugin.databasedoc.model.impl.AddForeignKeyConstraint;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Column;
import ru.volnenko.maven.plugin.databasedoc.model.impl.FK;

@Feature("ForeignKeyUtil")
@RunWith(DataProviderRunner.class)
public class NewForeignKeyUtilTest {

    @Test
    @DisplayName("ForeignKeyUtil метод fk с параметром AddForeignKeyConstraint")
    @Description("Проверка метода fk с параметром AddForeignKeyConstraint на возврат корректного объекта FK")
    @UseDataProvider(value = "validForeignKeyConstraints", location = ForeignKeyUtilData.class)
    public void testValidConstraintsCorrectReturn(AddForeignKeyConstraint constraint) {
        @NonNull final FK expectedFk = ForeignKeyUtilData.correctReturnOfFkConstraintMethod();
        @NonNull final FK fk = ForeignKeyUtil.fk(constraint);
        Assert.assertEquals(expectedFk, fk);
        Assert.assertEquals(expectedFk.getTableName(), fk.getTableName());
        Assert.assertEquals(expectedFk.getFieldName(), fk.getFieldName());
        Assert.assertEquals(expectedFk.getPk().getTableName(), fk.getPk().getTableName());
        Assert.assertEquals(expectedFk.getPk().getFieldName(), fk.getPk().getFieldName());
    }

    @Test
    @DisplayName("ForeignKeyUtil метод fk с параметром AddForeignKeyConstraint")
    @Description("Проверка метода fk с параметром AddForeignKeyConstraint на NotNull")
    @UseDataProvider(value = "validForeignKeyConstraints", location = ForeignKeyUtilData.class)
    public void testValidConstraints(AddForeignKeyConstraint constraint) {
        Assert.assertNotNull(ForeignKeyUtil.fk(constraint));
    }

    @Test
    @DisplayName("ForeignKeyUtil метод fk с параметром AddForeignKeyConstraint")
    @Description("Проверка метода fk с параметром AddForeignKeyConstraint на Null")
    @UseDataProvider(value = "invalidForeignKeyConstraints", location = ForeignKeyUtilData.class)
    public void testInvalidConstraints(AddForeignKeyConstraint constraint) {
        Assert.assertNull(ForeignKeyUtil.fk(constraint));
    }

    @Test
    @DisplayName("ForeignKeyUtil метод enabled с параметром Column")
    @Description("Проверка метода fk с параметром Column на возврат true")
    @UseDataProvider(value = "trueColumns", location = ForeignKeyUtilData.class)
    public void testTrueColumns(Column column) {
        Assert.assertTrue(ForeignKeyUtil.enabled(column));
    }

    @Test
    @DisplayName("ForeignKeyUtil метод enabled с параметром Column")
    @Description("Проверка метода fk с параметром Column на возврат false")
    @UseDataProvider(value = "falseColumns", location = ForeignKeyUtilData.class)
    public void testFalseColumns(Column column) {
        Assert.assertFalse(ForeignKeyUtil.enabled(column));
    }

//    @Ignore
//    @Test
//    @DisplayName("ForeignKeyUtil метод fks с параметром Roots")
//    @Description("Проверка метода fks с параметром Roots на возврат Set с объектами FK")
//    @UseDataProvider(value = "validSetRoots", location = ForeignKeyUtilData.class)
//    public void testSetRoots(Collection<Root> roots) {
////        Assert.assertEquals(ForeignKeyUtilData.correctReturnOfFksRootsMethod(), ForeignKeyUtil.fks(roots));
//    }
//
//    @Ignore
//    @Test
//    @DisplayName("ForeignKeyUtil метод fks с параметром Roots")
//    @Description("Проверка метода fks с параметром Roots на возврат emptySet")
//    @UseDataProvider(value = "InvalidSetRoots", location = ForeignKeyUtilData.class)
//    public void testEmptySetRoots(Collection<Root> roots) {
////        Assert.assertEquals(Collections.emptySet(), ForeignKeyUtil.fks(roots));
//    }
//
//    @Ignore
//    @Test
//    @DisplayName("ForeignKeyUtil метод fks с параметром Root")
//    @Description("Проверка метода fks с параметром Root на возврат Set с объектами FK")
//    @UseDataProvider(value = "validRoot", location = ForeignKeyUtilData.class)
//    public void testSetRoot(Root root) {
//        Assert.assertEquals(ForeignKeyUtilData.correctReturnOfFksRootMethod(), ForeignKeyUtil.fks(root));
//    }
//
//    @Ignore
//    @Test
//    @DisplayName("ForeignKeyUtil метод fks с параметром Root")
//    @Description("Проверка метода fks с параметром Root на возврат emptySet")
//    @UseDataProvider(value = "invalidRoot", location = ForeignKeyUtilData.class)
//    public void testEmptySetRoot(Root root) {
//        Assert.assertEquals(Collections.emptySet(), ForeignKeyUtil.fks(root));
//    }

}
