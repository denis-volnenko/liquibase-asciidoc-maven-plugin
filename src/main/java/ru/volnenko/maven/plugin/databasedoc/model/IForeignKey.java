package ru.volnenko.maven.plugin.databasedoc.model;

public interface IForeignKey {
    String getReferencedColumnNames();

    void setReferencedColumnNames(String referencedColumnNames);

    String getReferencedTableName();

    void setReferencedTableName(String referencedTableName);
}
