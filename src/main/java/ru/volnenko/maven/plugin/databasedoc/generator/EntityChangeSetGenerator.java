package ru.volnenko.maven.plugin.databasedoc.generator;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.model.ChangeSet;

public final class EntityChangeSetGenerator extends AbstractGenerator {

    @NonNull
    private final ChangeSet changeSet = new ChangeSet();

    @NonNull
    private final EntityChangeGenerator entityChangeGenerator = new EntityChangeGenerator();

    @NonNull
    public ChangeSet changeSet() {
        return changeSet;
    }

    @NonNull
    public EntityChangeGenerator entityChangeGenerator() {
        return entityChangeGenerator;
    }

    @NonNull
    @Override
    public StringBuilder append(@NonNull StringBuilder stringBuilder) {
        return null;
    }

}
