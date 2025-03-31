package ru.volnenko.maven.plugin.databasedoc;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.SneakyThrows;
import net.sourceforge.plantuml.FileFormat;
import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.SourceStringReader;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.FileUtils;
import ru.volnenko.maven.plugin.databasedoc.exception.UnsupportedFormatException;
import ru.volnenko.maven.plugin.databasedoc.generator.*;
import ru.volnenko.maven.plugin.databasedoc.model.*;
import ru.volnenko.maven.plugin.databasedoc.util.MapperUtil;
import ru.volnenko.maven.plugin.databasedoc.util.StringUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Mojo(name = "generate", defaultPhase = LifecyclePhase.COMPILE)
public final class Generator extends AbstractMojo {

    @Getter
    @Setter
    @Parameter(property = "serviceName")
    public String serviceName = "Сервис";

    @Getter
    @Setter
    @Parameter(property = "dataBaseInfo")
    public String dataBaseInfo = "";

    @Getter
    @Setter
    @Parameter(property = "headerFirstEnabled")
    public boolean headerFirstEnabled = true;

    @Getter
    @Setter
    @Parameter(property = "headerSecondEnabled")
    public boolean headerSecondEnabled = true;

    @Getter
    @Setter
    @Parameter(property = "tableOfContentsEnabled")
    public boolean tableOfContentsEnabled = true;

    @Getter
    @Setter
    @Parameter(property = "tableOfContentsEnabled")
    public boolean entityRelationDiagramEnabled = true;

    @Getter
    @Setter
    @Parameter(property = "entityRelationDiagramInclude")
    public boolean entityRelationDiagramInclude = true;

    @Getter
    @Setter
    @Parameter(property = "outputPath")
    public String outputPath = "./doc";

    @Getter
    @Setter
    @Parameter(property = "outputFile")
    public String outputFile = "index.adoc";

    @Parameter(defaultValue = "${project}", required = true, readonly = true)
    private MavenProject project;

    @Getter
    @Setter
    @Parameter(property = "files")
    private List<String> files = new ArrayList<>();

    @NonNull
    private final StringBuilder stringBuilder = new StringBuilder();

    @NonNull
    private final StringBuilder erd = new StringBuilder();

    @NonNull
    private final CreateTypeGenerator createTypeGenerator = new CreateTypeGenerator();

    @NonNull
    private final ValueWrapperGenerator valueWrapperGenerator = new ValueWrapperGenerator();

    @NonNull
    private final CreateTableGenerator createTableGenerator = new CreateTableGenerator();

    @NonNull
    private final ColumnWrapperGenerator columnWrapperGenerator = new ColumnWrapperGenerator();

    @NonNull
    private final EntityRelationDiagramColumnWrapperGenerator entityRelationDiagramColumnWrapperGenerator = new EntityRelationDiagramColumnWrapperGenerator();

    @NonNull
    private ObjectMapper objectMapper(@NonNull final String file) {
        @NonNull final String name = file.toLowerCase(Locale.ROOT);
        if (name.endsWith(".json")) return MapperUtil.json();
        if (name.endsWith(".yaml")) return MapperUtil.yaml();
        if (name.endsWith(".yml")) return MapperUtil.yaml();
        throw new UnsupportedFormatException();
    }

    @SneakyThrows
    public void execute() throws MojoExecutionException, MojoFailureException {
        header();
        erd.append("@startuml \n");
        erd.append("!pragma graphviz_dot jdot \n");
        erd.append("'!pragma layout smetana \n");
        for (final String file : files) {
            if (file == null || file.isEmpty()) {
                continue;
            }
            parse(file);
        }
        erd.append("\n");
        erd.append("@enduml");
        erd.append("\n");
        save();
    }

    @SneakyThrows
    public void save() {
        if (outputPath == null || outputPath.isEmpty()) return;
        File path = new File(outputPath);
        path.mkdirs();

        if (outputFile == null || outputFile.isEmpty()) return;
        {
            File file = new File(path.getAbsolutePath() + "/" + outputFile);
            FileUtils.fileWrite(file, stringBuilder.toString());
        }
        {
            File file = new File(path.getAbsolutePath() + "/" + "erd.puml");
            FileUtils.fileWrite(file, erd.toString());
        }
        if (entityRelationDiagramEnabled) {
            final SourceStringReader reader = new SourceStringReader(erd.toString());
            final FileOutputStream output = new FileOutputStream(new File(path.getAbsolutePath() + "/" + "erd.svg"));
            reader.generateImage(output, new FileFormatOption(FileFormat.SVG, false));
        }
    }

    @SneakyThrows
    public void parse(@NonNull final String file) {
        @NonNull final ObjectMapper objectMapper = objectMapper(file);
        @NonNull final Root root = objectMapper.readValue(new File(file), Root.class);
        generate(root);
    }

    @NonNull
    private final DocumentGenerator documentGenerator = new DocumentGenerator();

    private void header() {
        documentGenerator
                .serviceName(serviceName)
                .entityRelationDiagramEnabled(entityRelationDiagramEnabled)
                .entityRelationDiagramInclude(entityRelationDiagramInclude)
                .headerSecondEnabled(headerSecondEnabled)
                .headerFirstEnabled(headerFirstEnabled)
                .tableOfContentsEnabled(tableOfContentsEnabled);
    }

    public void generate(@NonNull final Root root) {
        @NonNull final DatabaseChangeLog databaseChangeLog = root.getDatabaseChangeLog();
        @NonNull final List<ChangeSet> changeSet = databaseChangeLog.getChangeSet();
        for (@NonNull final ChangeSet item : changeSet) generate(item);
    }

    private void generate(@NonNull final ChangeSet changeSet) {
        for (Change change : changeSet.getChanges()) generate(change);
    }

    private void generate(@NonNull final Change change) {
        final CreateTable createTable = change.getCreateTable();
        if (createTable != null) {
            generate(createTable);
            {
                erd.append("entity \"" + StringUtil.format(createTable.getTableName()) + "\" {");
                erd.append("\n");
            }
            generate(createTable.getColumns().toArray(new ColumnWrapper[0]));
            {
                erd.append("}");
                erd.append("\n");
                erd.append("\n");
            }
        }
        final CreateType createType = change.getCreateType();
        if (createType != null) {
            generate(createType);
            generate(createType.getValues().toArray(new ValueWrapper[0]));
        }
    }

    private void generate(@NonNull final CreateType createType) {
        createTypeGenerator
                .dataBaseInfo(dataBaseInfo)
                .serviceName(serviceName)
                .createType(createType)
                .append(stringBuilder);
    }

    private void generate(@NonNull final CreateTable createTable) {
        createTableGenerator
                .dataBaseInfo(dataBaseInfo)
                .serviceName(serviceName)
                .createTable(createTable)
                .append(stringBuilder);
    }

    private void generate(@NonNull final ValueWrapper[] valueWrappers) {
        valueWrapperGenerator
                .valueWrappers(valueWrappers)
                .append(stringBuilder);
    }

    private void generate(@NonNull final ColumnWrapper[] columnWrappers) {
        columnWrapperGenerator
                .columnWrappers(columnWrappers)
                .append(stringBuilder);

        entityRelationDiagramColumnWrapperGenerator
                .columnWrappers(columnWrappers)
                .append(erd);
    }

}
