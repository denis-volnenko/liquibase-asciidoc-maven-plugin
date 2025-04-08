package ru.volnenko.maven.plugin.databasedoc.generator.impl;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.generator.IColumnGenerator;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Column;
import ru.volnenko.maven.plugin.databasedoc.model.impl.FK;
import ru.volnenko.maven.plugin.databasedoc.model.impl.UK;
import ru.volnenko.maven.plugin.databasedoc.util.ConstraintUtil;
import ru.volnenko.maven.plugin.databasedoc.util.ForeignKeyUtil;
import ru.volnenko.maven.plugin.databasedoc.util.StringUtil;

import java.util.Collections;
import java.util.Set;

public final class ColumnGenerator extends AbstractGenerator implements IColumnGenerator {

    @NonNull
    private Integer index = 1;

    @NonNull
    private Column column = new Column();

    @NonNull
    private String tableName = "";

    @NonNull
    private Set<FK> fks = Collections.emptySet();

    @NonNull
    private Set<UK> uks = Collections.emptySet();

    @NonNull
    public static IColumnGenerator create() {
        return new ColumnGenerator();
    }

    @Override
    @NonNull
    public IColumnGenerator tableName(@NonNull final String tableName) {
        this.tableName = tableName;
        return this;
    }

    @Override
    @NonNull
    public IColumnGenerator fks(@NonNull final Set<FK> fks) {
        this.fks = fks;
        return this;
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
        boolean fke = ForeignKeyUtil.enabled(column);
        if (!fke) {
            final FK fk = new FK(tableName, column.getName());
            fke = fks.contains(fk);
        }
        stringBuilder.append("^|" + StringUtil.format(fke) + "\n");
        stringBuilder.append("^|" + StringUtil.format(column.getAutoIncrement()) + "\n");
        stringBuilder.append("^|" + StringUtil.format(ConstraintUtil.notnull(column)) + "\n");
        stringBuilder.append("|" + StringUtil.format(column.getDefaultValue()) + "\n");
        stringBuilder.append("\n");

        return stringBuilder;
    }

}
