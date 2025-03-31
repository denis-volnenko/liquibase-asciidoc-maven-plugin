package ru.volnenko.maven.plugin.databasedoc.generator;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.model.Column;

public final class ColumnGenerator extends AbstractGenerator {

    @NonNull
    private StringBuilder stringBuilder = new StringBuilder();

    @NonNull
    private Integer index = 1;

    @NonNull
    private Column column = new Column();

    @NonNull
    public ColumnGenerator stringBuilder(@NonNull final StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
        return this;
    }

    @NonNull
    public ColumnGenerator index(@NonNull final Integer index) {
        this.index = index;
        return this;
    }

    @NonNull
    public ColumnGenerator value(@NonNull final Column column) {
        this.column = column;
        return this;
    }

    @NonNull
    @Override
    public String generate() {
        return null;
    }

}
