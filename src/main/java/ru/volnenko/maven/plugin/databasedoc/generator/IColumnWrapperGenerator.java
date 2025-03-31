package ru.volnenko.maven.plugin.databasedoc.generator;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.model.ColumnWrapper;

import java.util.List;

public interface IColumnWrapperGenerator extends IGenerator {

    @NonNull
    IColumnWrapperGenerator stringBuilder(@NonNull StringBuilder stringBuilder);

    @NonNull
    IColumnWrapperGenerator index(@NonNull Integer index);

    @NonNull
    IColumnWrapperGenerator columnWrappers(@NonNull List<ColumnWrapper> columnWrappers);

}
