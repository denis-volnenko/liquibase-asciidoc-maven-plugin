package ru.volnenko.maven.plugin.databasedoc.util;


import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.volnenko.maven.plugin.databasedoc.data.ForeignKeyUtilData;
import ru.volnenko.maven.plugin.databasedoc.model.impl.AddForeignKeyConstraint;

@RunWith(DataProviderRunner.class)
public class NewForeignKeyUtilTest {

    @Ignore
    @Test
    @UseDataProvider(value = "validConstraints", location = ForeignKeyUtilData.class)
    public void testValidConstraintsCorrectReturn(AddForeignKeyConstraint constraint) {

        //Assert.assertEquals(correctReturn, ForeignKeyUtil.fk(constraint));
    }

    @Test
    @UseDataProvider(value = "validConstraints", location = ForeignKeyUtilData.class)
    public void testValidConstraints(AddForeignKeyConstraint constraint) {
        Assert.assertNotNull(ForeignKeyUtil.fk(constraint));
    }

    @Test
    @UseDataProvider(value = "invalidConstraints", location = ForeignKeyUtilData.class)
    public void testInvalidConstraints(AddForeignKeyConstraint constraint) {
        Assert.assertNull(ForeignKeyUtil.fk(constraint));
    }

}
