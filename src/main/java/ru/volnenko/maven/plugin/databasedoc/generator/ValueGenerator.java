package ru.volnenko.maven.plugin.databasedoc.generator;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.model.Value;

public final class ValueGenerator extends AbstractGenerator<Value> {

    @Override
    public String generate(@NonNull Value model) {
        return null;
    }

    @Override
    public void append(@NonNull Value model, @NonNull StringBuilder builder) {

    }

}
