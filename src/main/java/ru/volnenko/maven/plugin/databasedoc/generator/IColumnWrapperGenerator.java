package ru.volnenko.maven.plugin.databasedoc.generator;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.model.impl.ColumnWrapper;
import ru.volnenko.maven.plugin.databasedoc.model.impl.FK;

import java.util.List;
import java.util.Set;

public interface IColumnWrapperGenerator extends IGenerator {

    @NonNull IColumnWrapperGenerator tableName(@NonNull String tableName);

    @NonNull IColumnWrapperGenerator fks(Set<FK> fks);

    @NonNull
    IColumnWrapperGenerator stringBuilder(@NonNull StringBuilder stringBuilder);

    @NonNull
    IColumnWrapperGenerator index(@NonNull Integer index);

    @NonNull
    IColumnWrapperGenerator columnWrappers(@NonNull List<ColumnWrapper> columnWrappers);

}
