package ru.volnenko.maven.plugin.databasedoc.data;
import com.tngtech.java.junit.dataprovider.DataProvider;
import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.model.impl.*;

public class ForeignKeyUtilData {

    @NonNull
    public static FK correctReturnOfFkConstraintMethod() {
        final FK fk = new FK();
        fk.setTableName("baseTable");
        fk.setFieldName("baseColumn");
        fk.getPk().setTableName("refTable");
        fk.getPk().setFieldName("refColumn");
        return fk;
    }

    @DataProvider
    public static Object[] validForeignKeyConstraints() {
        return new Object[]{
                createForeignKeyConstraint("baseTable", "baseColumn", "refTable", "refColumn")
        };
    }

    @DataProvider
    public static Object[] invalidForeignKeyConstraints() {
        return new Object[][]{
                {null},
                {createForeignKeyConstraint(null, null, null, null)},
                {createForeignKeyConstraint(null, null, null, "refColumn")},
                {createForeignKeyConstraint(null, null, "refTable", null)},
                {createForeignKeyConstraint(null, "baseColumn", null, null)},
                {createForeignKeyConstraint("baseTable", null, null, null)},
                {createForeignKeyConstraint(null, null, "refTable", "refColumn")},
                {createForeignKeyConstraint(null, "baseColumn", null, "refColumn")},
                {createForeignKeyConstraint(null, "baseColumn", "refTable", null)},
                {createForeignKeyConstraint("baseTable", null, null, "refColumn")},
                {createForeignKeyConstraint("baseTable", null, "refTable", null)},
                {createForeignKeyConstraint("baseTable", "baseColumn", null, null)},
                {createForeignKeyConstraint(null, "baseColumn", "refTable", "refColumn")},
                {createForeignKeyConstraint("baseTable", null, "refTable", "refColumn")},
                {createForeignKeyConstraint("baseTable", "baseColumn", null, "refColumn")},
                {createForeignKeyConstraint("baseTable", "baseColumn", "refTable", null)}
        };
    }

    @NonNull
    private static AddForeignKeyConstraint createForeignKeyConstraint(
            String baseTable, String baseColumn, String refTable, String refColumn
    ) {
        AddForeignKeyConstraint foreignKeyConstraint = new AddForeignKeyConstraint();
        foreignKeyConstraint.setBaseTableName(baseTable);
        foreignKeyConstraint.setBaseColumnNames(baseColumn);
        foreignKeyConstraint.setReferencedTableName(refTable);
        foreignKeyConstraint.setReferencedColumnNames(refColumn);
        return foreignKeyConstraint;
    }

    @NonNull
    private FK createFk(
            String tableNameFK,
            String fieldNameFK,
            String tableNamePK,
            String fieldNamePK
    ) {
        final FK fk = new FK();
        final PK pk = new PK();
        fk.setTableName(tableNameFK);
        fk.setFieldName(fieldNameFK);
        pk.setTableName(tableNamePK);
        pk.setFieldName(fieldNamePK);
        fk.setPk(pk);
        return fk;
    }

    @NonNull
    private static ForeignKey createForeignKey(String baseTable, String baseColumn) {
        ForeignKey foreignKey = new ForeignKey();
        foreignKey.setReferencedColumnNames(baseTable);
        foreignKey.setReferencedTableName(baseColumn);
        return foreignKey;
    }

    @DataProvider
    public static Object[] trueColumns() {
        return new Object[][]{
                {createColumn(createConstraints("ForeignKeyName", createForeignKey("ReferencedTableName", "ReferencedColumnNames")))},
                {createColumn(createConstraints("ForeignKeyName", createForeignKey(null, "ReferencedColumnNames")))},
                {createColumn(createConstraints(null, createForeignKey(null, "ReferencedColumnNames")))},
                {createColumn(createConstraints(null, createForeignKey("ReferencedTableName", null)))},
                {createColumn(createConstraints(null, createForeignKey("ReferencedTableName", "ReferencedColumnNames")))}
        };
    }

    @DataProvider
    public static Object[] falseColumns() {
        return new Object[][]{
                {null},
                {createColumn(null)},
                {createColumn(createConstraints(null, null))},
                {createColumn(createConstraints("ForeignKeyName", null))},
                {createColumn(createConstraints(null, createForeignKey(null, null)))}
        };
    }

    @NonNull
    private static Constraints createConstraints(
            String foreignKeyName,
            ForeignKey foreignKey
    ) {
        final Constraints constraints = new Constraints();
        constraints.setForeignKeyName(foreignKeyName);
        constraints.setForeignKey(foreignKey);
        return constraints;
    }

    @NonNull
    private static Column createColumn(
            Constraints constraints
    ) {
        final Column column = new Column();
        column.setConstraints(constraints);
        return column;
    }

}
