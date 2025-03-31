package ru.volnenko.maven.plugin.databasedoc.generator;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.model.Column;

public final class ColumnGenerator extends AbstractModelGenerator<Column> {

    @NonNull
    @Override
    public String generate(@NonNull Column model, @NonNull Integer index) {
        return null;
    }

}
