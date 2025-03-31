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
import ru.volnenko.maven.plugin.databasedoc.api.IValueGenerator;
import ru.volnenko.maven.plugin.databasedoc.exception.UnsupportedFormatException;
import ru.volnenko.maven.plugin.databasedoc.generator.ValueGenerator;
import ru.volnenko.maven.plugin.databasedoc.model.*;
import ru.volnenko.maven.plugin.databasedoc.util.ConstraintUtil;
import ru.volnenko.maven.plugin.databasedoc.util.ForeignKeyUtil;
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
    private final IValueGenerator valueGenerator = new ValueGenerator();

    @NonNull
    private ObjectMapper objectMapper(@NonNull final String file) {
        @NonNull final String name = file.toLowerCase(Locale.ROOT);
        if (name.endsWith(".json")) return MapperUtil.json();
        if (name.endsWith(".yaml")) return MapperUtil.yaml();
        if (name.endsWith(".yml")) return MapperUtil.yaml();
        throw new UnsupportedFormatException();
    }

    @SneakyThrows
    private void createERD() {

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

    private void header() {
        if (headerFirstEnabled) {
            stringBuilder.append("= " + StringUtil.format(serviceName) + "\n");
            if (tableOfContentsEnabled) {
                stringBuilder.append(":toc-title: Оглавление\n");
                stringBuilder.append(":toc:\n");
            }
            stringBuilder.append("\n");
        }
        if (headerSecondEnabled) {
            stringBuilder.append("== Представление данных\n");
        }
        if (entityRelationDiagramEnabled) {
            if (entityRelationDiagramInclude) {
                stringBuilder.append("\n");
                stringBuilder.append("=== ER-диаграмма базы данных \n");
                stringBuilder.append("\n");
                stringBuilder.append("image::erd.svg[] \n");
                stringBuilder.append("\n");
            }
        }
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
        stringBuilder.append("=== Перечисление \"" + StringUtil.format(createType.getTypeName()) + "\"\n");
        stringBuilder.append("==== Общие сведения\n");
        stringBuilder.append("\n");
        stringBuilder.append("[cols=\"20,80\"]\n");
        stringBuilder.append("|===\n");
        stringBuilder.append("\n");
        stringBuilder.append("|*Физ. название*:\n");
        stringBuilder.append("|" + StringUtil.format(createType.getTypeName()) + "\n");
        stringBuilder.append("\n");
        stringBuilder.append("|*Лог. название*:\n");
        stringBuilder.append("|" + StringUtil.format(createType.getRemarks()) + "\n");
        stringBuilder.append("\n");
        stringBuilder.append("|*Сервис*:\n");
        stringBuilder.append("|" + StringUtil.format(serviceName) + "\n");
        stringBuilder.append("\n");
        stringBuilder.append("|*База данных*:\n");
        stringBuilder.append("|" + StringUtil.format(createType.getCatalogName()) + "\n");
        stringBuilder.append("\n");
        stringBuilder.append("|*Доп. сведения*:\n");
        stringBuilder.append("|" + StringUtil.format(dataBaseInfo) + "\n");
        stringBuilder.append("\n");
        stringBuilder.append("|*Схема*:\n");
        stringBuilder.append("|" + StringUtil.format(createType.getSchemaName()) + "\n");
        stringBuilder.append("\n");
        stringBuilder.append("|===\n");
        stringBuilder.append("\n");
    }

    private void generate(@NonNull final CreateTable createTable) {
        stringBuilder.append("=== Сущность \"" + StringUtil.format(createTable.getTableName()) + "\"\n");
        stringBuilder.append("\n");
        stringBuilder.append("==== Общие сведения\n");
        stringBuilder.append("\n");
        stringBuilder.append("[cols=\"20,80\"]\n");
        stringBuilder.append("|===\n");
        stringBuilder.append("\n");
        stringBuilder.append("|*Физ. название*:\n");
        stringBuilder.append("|" + StringUtil.format(createTable.getTableName()) + "\n");
        stringBuilder.append("\n");
        stringBuilder.append("|*Лог. название*:\n");
        stringBuilder.append("|" + StringUtil.format(createTable.getRemarks()) + "\n");
        stringBuilder.append("\n");
        stringBuilder.append("|*Сервис*:\n");
        stringBuilder.append("|" + StringUtil.format(serviceName) + "\n");
        stringBuilder.append("\n");
        stringBuilder.append("|*База данных*:\n");
        stringBuilder.append("|" + StringUtil.format(createTable.getCatalogName()) + "\n");
        stringBuilder.append("\n");
        stringBuilder.append("|*Доп. сведения*:\n");
        stringBuilder.append("|" + StringUtil.format(dataBaseInfo) + "\n");
        stringBuilder.append("\n");
        stringBuilder.append("|*Схема*:\n");
        stringBuilder.append("|" + StringUtil.format(createTable.getSchemaName()) + "\n");
        stringBuilder.append("\n");
        stringBuilder.append("|===\n");
        stringBuilder.append("\n");
    }

    private void generate(@NonNull final ValueWrapper[] valueWrappers) {
        stringBuilder.append("==== Описание значений\n");
        stringBuilder.append("\n");
        stringBuilder.append("[cols=\"0,30,70\"]\n");
        stringBuilder.append("|===\n");
        stringBuilder.append("\n");
        stringBuilder.append("^|*№*\n");
        stringBuilder.append("|*Физ. название*\n");
        stringBuilder.append("|*Лог. название*\n");
        stringBuilder.append("\n");
        int index = 1;
        for (final ValueWrapper valueWrapper : valueWrappers) {
            generate(valueWrapper.getValue(), index);
            index++;
        }
        stringBuilder.append("|===\n");
        stringBuilder.append("\n");
    }

    private void generate(@NonNull final ColumnWrapper[] columnWrappers) {
        stringBuilder.append("==== Описание полей\n");
        stringBuilder.append("\n");
        stringBuilder.append("[cols=\"0,20,20,20,5,5,5,5,5,10\"]\n");
        stringBuilder.append("|===\n");
        stringBuilder.append("\n");
        stringBuilder.append("^|*№*\n");
        stringBuilder.append("|*Физ. название*\n");
        stringBuilder.append("|*Тип*\n");
        stringBuilder.append("|*Лог. название*\n");
        stringBuilder.append("^|*PK*\n");
        stringBuilder.append("^|*UK*\n");
        stringBuilder.append("^|*FK*\n");
        stringBuilder.append("^|*AI*\n");
        stringBuilder.append("^|*NN*\n");
        stringBuilder.append("|*DEFAULT*\n");
        stringBuilder.append("\n");
        int index = 1;
        for (final ColumnWrapper columnWrapper : columnWrappers) {
            generate(columnWrapper.getColumn(), index);
            index++;
        }
        stringBuilder.append("|===\n");
        stringBuilder.append("\n");
    }

    private void generate(@NonNull final Value value, final int index) {
        valueGenerator.append(value, index, stringBuilder);
    }

    private void generate(@NonNull final Column column, int index) {
        {
            erd.append("    ");
            if (column.getConstraints().getPrimaryKey()) erd.append("*");
            erd.append("\"" + StringUtil.format(column.getName()) + "\"");
            erd.append(" : ");
            erd.append("\"" + StringUtil.format(column.getType()) + "\"");
            erd.append("\n");
        }
        {
            stringBuilder.append("\n");
            stringBuilder.append("^|" + StringUtil.format(index) + ". \n");
            stringBuilder.append("|" + StringUtil.format(column.getName()) + "\n");
            stringBuilder.append("|" + StringUtil.format(column.getType()) + "\n");
            stringBuilder.append("|" + StringUtil.format(column.getRemarks()) + "\n");
            stringBuilder.append("^|" + StringUtil.format(column.getConstraints().getPrimaryKey()) + "\n");
            stringBuilder.append("^|" + StringUtil.format(column.getConstraints().getUnique()) + "\n");
            stringBuilder.append("^|" + StringUtil.format(ForeignKeyUtil.enabled(column)) + "\n");
            stringBuilder.append("^|" + StringUtil.format(column.getAutoIncrement()) + "\n");
            stringBuilder.append("^|" + StringUtil.format(ConstraintUtil.notnull(column)) + "\n");
            stringBuilder.append("|" + StringUtil.format(column.getDefaultValue()) + "\n");
            stringBuilder.append("\n");
        }
    }

}
