package ru.volnenko.maven.plugin.databasedoc.api;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.generator.ColumnGenerator;
import ru.volnenko.maven.plugin.databasedoc.model.Column;

public interface IColumnGenerator extends IGenerator {

    @NonNull
    IColumnGenerator stringBuilder(@NonNull StringBuilder stringBuilder);

    @NonNull
    ColumnGenerator index(@NonNull Integer index);

    @NonNull
    ColumnGenerator column(@NonNull Column column);

}
