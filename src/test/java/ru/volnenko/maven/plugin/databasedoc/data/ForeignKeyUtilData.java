package ru.volnenko.maven.plugin.databasedoc.data;
import com.tngtech.java.junit.dataprovider.DataProvider;
import ru.volnenko.maven.plugin.databasedoc.model.impl.AddForeignKeyConstraint;

public class ForeignKeyUtilData {

    @DataProvider
    public static Object[] validConstraints() {
        return new Object[]{
                createConstraint("baseTable", "baseColumn", "refTable", "refColumn")
        };
    }

    @DataProvider
    public static Object[] invalidConstraints() {
        return new Object[][]{
                {null},
                {createConstraint(null, null, null, null)},
                {createConstraint(null, null, null, "refColumn")},
                {createConstraint(null, null, "refTable", null)},
                {createConstraint(null, "baseColumn", null, null)},
                {createConstraint("baseTable", null, null, null)},
                {createConstraint(null, null, "refTable", "refColumn")},
                {createConstraint(null, "baseColumn", null, "refColumn")},
                {createConstraint(null, "baseColumn", "refTable", null)},
                {createConstraint("baseTable", null, null, "refColumn")},
                {createConstraint("baseTable", null, "refTable", null)},
                {createConstraint("baseTable", "baseColumn", null, null)},
                {createConstraint(null, "baseColumn", "refTable", "refColumn")},
                {createConstraint("baseTable", null, "refTable", "refColumn")},
                {createConstraint("baseTable", "baseColumn", null, "refColumn")},
                {createConstraint("baseTable", "baseColumn", "refTable", null)}
        };
    }

    private static AddForeignKeyConstraint createConstraint(
            String baseTable, String baseColumn, String refTable, String refColumn
    ) {
        AddForeignKeyConstraint constraint = new AddForeignKeyConstraint();
        constraint.setBaseTableName(baseTable);
        constraint.setBaseColumnNames(baseColumn);
        constraint.setReferencedTableName(refTable);
        constraint.setReferencedColumnNames(refColumn);
        return constraint;
    }

}
