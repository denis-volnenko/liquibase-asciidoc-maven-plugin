package ru.volnenko.maven.plugin.databasedoc;

import io.qameta.allure.Feature;
import lombok.SneakyThrows;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.RootBuilder;
import ru.volnenko.maven.plugin.databasedoc.model.impl.Root;
import ru.volnenko.maven.plugin.databasedoc.util.MapperUtil;

@Feature("Generator")
public class GeneratorTest {

    @SneakyThrows
    public static void main(String[] args) {
        Root root = RootBuilder.create().dsl()
                .changeSet()
                .add().id("tables").author("volnenko")

                .change().createTable()
                .catalogName("tm")
                .tableName("app_project")
                .remarks("Проекты")
                .tablespace("public")

                .column()
                .add()
                .name("id").type("varchar(64)").remarks("Код")
                .constraints().primaryKey(true).foreignKey()

                .add()
                .name("name").type("text")

                .change().createTable()
                .tableName("app_task")
                .catalogName("tm")
                .remarks("Задачи")
                .tablespace("public")

                .column()
                .add()
                .name("id").type("varchar(64)").remarks("Код")
                .constraints().primaryKey(true)

                .root();

        System.out.println(MapperUtil.yaml().writeValueAsString(root));

//        new Generator().generate(root);
    }

}
