package ru.volnenko.maven.plugin.databasedoc.generator;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.generator.impl.ColumnGenerator;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Column;
import ru.volnenko.maven.plugin.databasedoc.model.impl.FK;
import ru.volnenko.maven.plugin.databasedoc.model.impl.UK;

import java.util.Set;

public interface IColumnGenerator extends IGenerator {

    @NonNull
    IColumnGenerator tableName(@NonNull String tableName);

    @NonNull
    IColumnGenerator fks(@NonNull Set<FK> fks);

    @NonNull
    IColumnGenerator uks(@NonNull Set<UK> uks);

    @NonNull
    IColumnGenerator stringBuilder(@NonNull StringBuilder stringBuilder);

    @NonNull
    ColumnGenerator index(@NonNull Integer index);

    @NonNull
    ColumnGenerator column(@NonNull Column column);

}
