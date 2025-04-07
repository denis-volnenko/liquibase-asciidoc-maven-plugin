package ru.volnenko.maven.plugin.databasedoc.builder;

import org.junit.Assert;
import org.junit.Test;
import ru.volnenko.maven.plugin.databasedoc.builder.impl.*;

public class ForeignKeyBuilderTest {

    @Test
    public void testNotNull() {
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
        Assert.assertNotNull(fkBuilder.add());
        Assert.assertNotNull(fkBuilder.root());
        Assert.assertNotNull(fkBuilder.change());
    }

}
