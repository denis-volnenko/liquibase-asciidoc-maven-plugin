package ru.volnenko.maven.plugin.databasedoc.generator;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.api.IValueGenerator;
import ru.volnenko.maven.plugin.databasedoc.model.Value;
import ru.volnenko.maven.plugin.databasedoc.util.StringUtil;

public final class ValueGenerator extends AbstractGenerator implements IValueGenerator {

    @NonNull
    private Integer index = 1;

    @NonNull
    private Value value = new Value();

    @NonNull
    public static ValueGenerator create() {
        return new ValueGenerator();
    }

    @NonNull
    @Override
    public IValueGenerator stringBuilder(@NonNull final StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
        return this;
    }

    @NonNull
    @Override
    public IValueGenerator index(@NonNull final Integer index) {
        this.index = index;
        return this;
    }

    @NonNull
    @Override
    public IValueGenerator value(@NonNull final Value value) {
        this.value = value;
        return this;
    }

    @NonNull
    @Override
    public StringBuilder append(@NonNull final StringBuilder stringBuilder) {
        stringBuilder.append("\n");
        stringBuilder.append("^|" + StringUtil.format(index) + ". \n");
        stringBuilder.append("|" + StringUtil.format(value.getName()) + "\n");
        stringBuilder.append("|" + StringUtil.format(value.getRemarks()) + "\n");
        stringBuilder.append("\n");
        return stringBuilder;
    }

}
