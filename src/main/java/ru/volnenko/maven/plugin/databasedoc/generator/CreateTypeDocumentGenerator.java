package ru.volnenko.maven.plugin.databasedoc.generator;

import lombok.NonNull;
import ru.volnenko.maven.plugin.databasedoc.api.ICreateTypeDocumentGenerator;
import ru.volnenko.maven.plugin.databasedoc.model.*;

import java.util.Collections;
import java.util.List;

public final class CreateTypeDocumentGenerator extends AbstractGenerator implements ICreateTypeDocumentGenerator {

    @NonNull
    private final CreateTypeGenerator createTypeGenerator = new CreateTypeGenerator();

    @NonNull
    private List<Root> roots = Collections.emptyList();

    @NonNull
    private String serviceName = "";

    @NonNull
    private String dataBaseInfo = "";

    private void generate(@NonNull StringBuilder stringBuilder, @NonNull final Root root) {
        final DatabaseChangeLog databaseChangeLog = root.getDatabaseChangeLog();
        if (databaseChangeLog == null) return;
        final List<ChangeSet> changeSet = databaseChangeLog.getChangeSet();
        if (changeSet == null) return;
        for (final ChangeSet item : changeSet) generate(stringBuilder, item);
    }

    private void generate(@NonNull StringBuilder stringBuilder, final ChangeSet changeSet) {
        if (changeSet == null) return;
        for (Change change : changeSet.getChanges()) generate(stringBuilder, change);
    }

    private void generate(@NonNull StringBuilder stringBuilder, final Change change) {
        if (change == null) return;
        final CreateType createType = change.getCreateType();
        if (createType == null) return;
        createTypeGenerator
                .dataBaseInfo(dataBaseInfo)
                .serviceName(serviceName)
                .createType(createType)
                .append(stringBuilder);
    }

    @NonNull
    @Override
    public ICreateTypeDocumentGenerator serviceName(@NonNull final String serviceName) {
        this.serviceName = serviceName;
        return this;
    }

    @NonNull
    @Override
    public ICreateTypeDocumentGenerator dataBaseInfo(@NonNull final String dataBaseInfo) {
        this.dataBaseInfo = dataBaseInfo;
        return this;
    }

    @NonNull
    @Override
    public ICreateTypeDocumentGenerator roots(@NonNull final List<Root> roots) {
        this.roots = roots;
        return this;
    }

    @NonNull
    @Override
    public StringBuilder append(@NonNull final StringBuilder stringBuilder) {
        for (@NonNull final Root root : roots) generate(stringBuilder, root);
        return stringBuilder;
    }

}
