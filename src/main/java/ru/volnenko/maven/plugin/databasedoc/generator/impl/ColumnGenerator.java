package ru.volnenko.maven.plugin.databasedoc.generator.impl;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.generator.IColumnGenerator;
import ru.volnenko.maven.plugin.databasedoc.model.Column;
import ru.volnenko.maven.plugin.databasedoc.util.ConstraintUtil;
import ru.volnenko.maven.plugin.databasedoc.util.ForeignKeyUtil;
import ru.volnenko.maven.plugin.databasedoc.util.StringUtil;

public final class ColumnGenerator extends AbstractGenerator implements IColumnGenerator {

    @NonNull
    private Integer index = 1;

    @NonNull
    private Column column = new Column();

    @NonNull
    public static IColumnGenerator create() {
        return new ColumnGenerator();
    }

    @NonNull
    @Override
    public IColumnGenerator stringBuilder(@NonNull final StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
        return this;
    }

    @NonNull
    @Override
    public ColumnGenerator index(@NonNull final Integer index) {
        this.index = index;
        return this;
    }

    @NonNull
    @Override
    public ColumnGenerator column(@NonNull final Column column) {
        this.column = column;
        return this;
    }

    @NonNull
    @Override
    public StringBuilder append(@NonNull final StringBuilder stringBuilder) {
        stringBuilder.append("\n");
        stringBuilder.append("^|" + StringUtil.format(index) + ". \n");
        stringBuilder.append("|" + StringUtil.format(column.getName()) + "\n");
        stringBuilder.append("|" + StringUtil.format(column.getType()) + "\n");
        stringBuilder.append("|" + StringUtil.format(column.getRemarks()) + "\n");
        stringBuilder.append("^|" + StringUtil.format(column.getConstraints().getPrimaryKey()) + "\n");
        stringBuilder.append("^|" + StringUtil.format(column.getConstraints().getUnique()) + "\n");
        stringBuilder.append("^|" + StringUtil.format(ForeignKeyUtil.enabled(column)) + "\n");
        stringBuilder.append("^|" + StringUtil.format(column.getAutoIncrement()) + "\n");
        stringBuilder.append("^|" + StringUtil.format(ConstraintUtil.notnull(column)) + "\n");
        stringBuilder.append("|" + StringUtil.format(column.getDefaultValue()) + "\n");
        stringBuilder.append("\n");
        return stringBuilder;
    }

}
