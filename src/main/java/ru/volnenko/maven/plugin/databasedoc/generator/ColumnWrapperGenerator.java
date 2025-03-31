package ru.volnenko.maven.plugin.databasedoc.generator;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.model.ColumnWrapper;

public final class ColumnWrapperGenerator {

    @NonNull
    private StringBuilder stringBuilder = new StringBuilder();

    @NonNull
    private Integer index = 1;

    @NonNull
    private ColumnWrapper[] columnWrappers = new ColumnWrapper[] {};

    @NonNull
    public ColumnWrapperGenerator stringBuilder(@NonNull final StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
        return this;
    }

    @NonNull
    public ColumnWrapperGenerator index(@NonNull final Integer index) {
        this.index = index;
        return this;
    }



}
