package ru.volnenko.maven.plugin.databasedoc.enumerated;

public enum ErdType {

    LOGIC,
    PHYSIC;

    public boolean isLogic() {
        return this == LOGIC;
    }

    public boolean isPhysic() {
        return this == PHYSIC;
    }

}
