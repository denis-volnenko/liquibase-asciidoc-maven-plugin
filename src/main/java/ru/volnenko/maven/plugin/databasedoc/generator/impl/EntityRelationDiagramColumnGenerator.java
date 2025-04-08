package ru.volnenko.maven.plugin.databasedoc.generator.impl;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.enumerated.ColumnType;
import ru.volnenko.maven.plugin.databasedoc.enumerated.ErdType;
import ru.volnenko.maven.plugin.databasedoc.generator.IEntityRelationDiagramColumnGenerator;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Column;
import ru.volnenko.maven.plugin.databasedoc.util.StringUtil;

public final class EntityRelationDiagramColumnGenerator extends AbstractGenerator implements IEntityRelationDiagramColumnGenerator {

    @NonNull
    private Column column = new Column();

    @NonNull
    private ErdType erdType = ErdType.PHYSIC;

    @NonNull
    public ErdType erdType() {
        return erdType;
    }

    @NonNull
    public EntityRelationDiagramColumnGenerator erdType(@NonNull final ErdType erdType) {
        this.erdType = erdType;
        return this;
    }

    @NonNull
    @Override
    public IEntityRelationDiagramColumnGenerator stringBuilder(@NonNull final StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
        return this;
    }

    @NonNull
    @Override
    public IEntityRelationDiagramColumnGenerator column(@NonNull final Column column) {
        this.column = column;
        return this;
    }

    @NonNull
    @Override
    public StringBuilder append(@NonNull final StringBuilder stringBuilder) {
        stringBuilder.append("    ");
        if (column.getConstraints().getPrimaryKey()) stringBuilder.append("*");
        stringBuilder.append("\"" + getName() + "\"");
        stringBuilder.append(" : ");
        stringBuilder.append("\"" + getType() + "\"");
        stringBuilder.append("\n");
        return stringBuilder;
    }

    @NonNull
    private String getType() {
        final String type = StringUtil.format(column.getType());
        if (erdType.isPhysic()) {
            return type;
        }
        if (erdType.isLogic()) {
            final ColumnType columnType = ColumnType.typeOf(type);
            if (columnType == null) return type;
            return columnType.displayName();
        }
        return type;
    }

    @NonNull
    private String getName() {
        if (erdType.isPhysic()) {
            return StringUtil.format(column.getName());
        }
        if (erdType.isLogic()) {
            if (column.getRemarks() != null && !column.getRemarks().isEmpty())
                return StringUtil.format(column.getRemarks());
        }
        return StringUtil.format(column.getName());
    }

}
