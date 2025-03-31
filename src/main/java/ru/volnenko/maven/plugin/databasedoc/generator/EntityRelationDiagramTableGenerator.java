package ru.volnenko.maven.plugin.databasedoc.generator;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.model.Root;

import java.util.Collections;
import java.util.List;

public final class EntityRelationDiagramTableGenerator extends AbstractGenerator {

    @NonNull
    private List<Root> roots = Collections.emptyList();

    @NonNull
    private final EntityRelationDiagramColumnGenerator generator = new EntityRelationDiagramColumnGenerator();

    @NonNull
    public EntityRelationDiagramTableGenerator createTables(@NonNull List<Root> roots) {
        this.roots = roots;
        return this;
    }

    @NonNull
    @Override
    public StringBuilder append(@NonNull final StringBuilder stringBuilder) {
        stringBuilder.append("@startuml \n");
        stringBuilder.append("!pragma graphviz_dot jdot \n");
        stringBuilder.append("'!pragma layout smetana \n");

//        int index = 1;
//        for (final ColumnWrapper columnWrapper : columnWrappers) {
//            columnGenerator.index(index).column(columnWrapper.getColumn()).append(stringBuilder);
//            index++;
//        }

        stringBuilder.append("\n");
        stringBuilder.append("@enduml");
        stringBuilder.append("\n");
        return stringBuilder;
    }

}
