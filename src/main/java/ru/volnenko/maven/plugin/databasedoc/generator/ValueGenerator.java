package ru.volnenko.maven.plugin.databasedoc.generator;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.api.IValueGenerator;
import ru.volnenko.maven.plugin.databasedoc.model.Value;
import ru.volnenko.maven.plugin.databasedoc.util.StringUtil;

public final class ValueGenerator extends AbstractGenerator<Value> implements IValueGenerator {

    @Override
    public String generate(@NonNull Value model, @NonNull Integer index) {
        @NonNull final StringBuilder builder = new StringBuilder();
        builder.append("\n");
        builder.append("^|" + StringUtil.format(index) + ". \n");
        builder.append("|" + StringUtil.format(model.getName()) + "\n");
        builder.append("|" + StringUtil.format(model.getRemarks()) + "\n");
        builder.append("\n");
        return builder.toString();
    }

}
