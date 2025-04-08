package ru.volnenko.maven.plugin.databasedoc.enumerated;

public enum ErdRender {

    INTERNAL,
    EXTERNAL;

    public boolean isInternal() {
        return this == INTERNAL;
    }

    public boolean isExternal() {
        return this == EXTERNAL;
    }

}
