package ru.volnenko.maven.plugin.databasedoc.generator;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.model.Column;
import ru.volnenko.maven.plugin.databasedoc.util.StringUtil;

public final class EntityRelationDiagramColumnGenerator extends AbstractGenerator {

    @NonNull
    private Column column = new Column();

    @NonNull
    public EntityRelationDiagramColumnGenerator stringBuilder(@NonNull final StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
        return this;
    }

    @NonNull
    public EntityRelationDiagramColumnGenerator column(@NonNull final Column column) {
        this.column = column;
        return this;
    }

    @NonNull
    @Override
    public StringBuilder append(@NonNull final StringBuilder stringBuilder) {
        stringBuilder.append("    ");
        if (column.getConstraints().getPrimaryKey()) stringBuilder.append("*");
        stringBuilder.append("\"" + StringUtil.format(column.getName()) + "\"");
        stringBuilder.append(" : ");
        stringBuilder.append("\"" + StringUtil.format(column.getType()) + "\"");
        stringBuilder.append("\n");
        return stringBuilder;
    }

}
