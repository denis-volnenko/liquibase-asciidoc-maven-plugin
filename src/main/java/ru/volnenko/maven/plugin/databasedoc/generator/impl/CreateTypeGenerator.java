package ru.volnenko.maven.plugin.databasedoc.generator.impl;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.generator.ICreateTypeGenerator;
import ru.volnenko.maven.plugin.databasedoc.model.impl.CreateType;

public final class CreateTypeGenerator extends AbstractGenerator implements ICreateTypeGenerator {

    @NonNull
    private final CreateTypeBasicGenerator createTypeBasicGenerator = new CreateTypeBasicGenerator();

    @NonNull
    private final ValueWrapperGenerator valueWrapperGenerator = new ValueWrapperGenerator();

    @NonNull
    private CreateType createType = new CreateType();

    @NonNull
    private String serviceName = "";

    @NonNull
    private String dataBaseInfo = "";

    @NonNull
    @Override
    public ICreateTypeGenerator createType(@NonNull final CreateType createType) {
        this.createType = createType;
        return this;
    }

    @NonNull
    @Override
    public ICreateTypeGenerator serviceName(@NonNull final String serviceName) {
        this.serviceName = serviceName;
        return this;
    }

    @NonNull
    @Override
    public ICreateTypeGenerator dataBaseInfo(@NonNull final String dataBaseInfo) {
        this.dataBaseInfo = dataBaseInfo;
        return this;
    }

    @NonNull
    @Override
    public StringBuilder append(@NonNull StringBuilder stringBuilder) {
        createTypeBasicGenerator
                .dataBaseInfo(dataBaseInfo)
                .serviceName(serviceName)
                .createType(createType)
                .append(stringBuilder);
        valueWrapperGenerator
                .valueWrappers(createType.getValues())
                .append(stringBuilder);
        return stringBuilder;
    }

}
