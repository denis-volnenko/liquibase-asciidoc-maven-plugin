package ru.volnenko.maven.plugin.databasedoc.api;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.generator.ValueWrapperGenerator;
import ru.volnenko.maven.plugin.databasedoc.model.ValueWrapper;

import java.util.List;

public interface IValueWrapperGenerator extends IGenerator {

    @NonNull
    ValueWrapperGenerator valueWrappers(@NonNull List<ValueWrapper> valueWrappers);

}
