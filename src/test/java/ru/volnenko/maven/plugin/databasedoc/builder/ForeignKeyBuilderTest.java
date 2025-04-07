package ru.volnenko.maven.plugin.databasedoc.builder;

import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.*;

public class ForeignKeyBuilderTest {

    ForeignKeyBuilder fkBuilder = RootBuilder.create()
            .dsl()
            .changeSet()
            .add()
            .change()
            .createTable()
            .column()
            .add()
            .constraints()
            .foreignKey();

    @Test
    public void testNotNull() {
        Assert.assertNotNull(fkBuilder.add());
        Assert.assertNotNull(fkBuilder.root());
        Assert.assertNotNull(fkBuilder.change());
    }

}
