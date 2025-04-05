package ru.volnenko.maven.plugin.databasedoc.generator;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Value;

public interface IValueGenerator extends IGenerator {

    @NonNull
    IValueGenerator stringBuilder(@NonNull StringBuilder stringBuilder);

    @NonNull
    IValueGenerator index(@NonNull Integer index);

    @NonNull
    IValueGenerator value(@NonNull Value value);

}
