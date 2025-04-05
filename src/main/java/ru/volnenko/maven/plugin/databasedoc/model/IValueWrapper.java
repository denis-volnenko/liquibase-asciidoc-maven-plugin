package ru.volnenko.maven.plugin.databasedoc.model;

import ru.volnenko.maven.plugin.databasedoc.model.impl.Value;

public interface IValueWrapper {
    Value getValue();

    void setValue(Value value);
}
