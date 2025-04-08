package ru.volnenko.maven.plugin.databasedoc.rnd;

import lombok.SneakyThrows;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.util.MapperUtil;

public class RootTest {

    @Test
    @SneakyThrows
    public void test() {
        System.out.println(MapperUtil.yaml().writerWithDefaultPrettyPrinter().writeValueAsString(new Root()));
    }

}
