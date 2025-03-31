package ru.volnenko.maven.plugin.databasedoc.generator.impl;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.generator.IValueWrapperGenerator;
import ru.volnenko.maven.plugin.databasedoc.model.ValueWrapper;

import java.util.Collections;
import java.util.List;

public final class ValueWrapperGenerator extends AbstractGenerator implements IValueWrapperGenerator {

    @NonNull
    private List<ValueWrapper> valueWrappers = Collections.emptyList();

    @NonNull
    private final ValueGenerator valueGenerator = new ValueGenerator();

    @NonNull
    public ValueWrapperGenerator valueWrappers(@NonNull final List<ValueWrapper> valueWrappers) {
        this.valueWrappers = valueWrappers;
        return this;
    }

    @NonNull
    @Override
    public StringBuilder append(@NonNull StringBuilder stringBuilder) {
        stringBuilder.append("==== Описание значений \n");
        stringBuilder.append("\n");
        stringBuilder.append("[cols=\"0,30,70\"]\n");
        stringBuilder.append("|===\n");
        stringBuilder.append("\n");
        stringBuilder.append("^|*№*\n");
        stringBuilder.append("|*Физ. название*\n");
        stringBuilder.append("|*Лог. название*\n");
        stringBuilder.append("\n");
        int index = 1;
        for (final ValueWrapper valueWrapper : valueWrappers) {
            valueGenerator.value(valueWrapper.getValue()).index(index).append(stringBuilder);
            index++;
        }
        stringBuilder.append("|===\n");
        stringBuilder.append("\n");
        return stringBuilder;
    }

}
