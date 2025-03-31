package ru.volnenko.maven.plugin.databasedoc.generator;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.api.IModelGenerator;

public abstract class AbstractModelGenerator<M> implements IModelGenerator<M> {

    @NonNull
    public abstract String generate(@NonNull M model, @NonNull Integer index);

    public final void append(
            @NonNull final M model,
            @NonNull final Integer index,
            @NonNull final StringBuilder builder
    ) {
        builder.append(generate(model, index));
    }

}
