package ru.volnenko.maven.plugin.databasedoc.api;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.model.CreateType;

public interface ICreateTypeBasicGenerator extends IGenerator {

    @NonNull
    ICreateTypeBasicGenerator createType(@NonNull CreateType createType);

    @NonNull
    ICreateTypeBasicGenerator serviceName(@NonNull String serviceName);

    @NonNull
    ICreateTypeBasicGenerator dataBaseInfo(@NonNull String dataBaseInfo);

}
