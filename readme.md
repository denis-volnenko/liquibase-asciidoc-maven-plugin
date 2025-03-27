# maven-liquilbase-asciidoc-plugin

## Project Info

### Artifact coordinates

|                 |                                 |
|:----------------|:--------------------------------|
| **groupId**     | ru.volnenko.maven.plugin        |
| **artifactId**  | maven-liquilbase-asciidoc-plugin|
| **version**     | 1.0.0                           |

### System Requirement

## Developer Info

|                 |                     |
|:----------------|:--------------------|
|**Name**         | Denis Volnenko      |
|**E-mail**       | denis@volnenko.ru   |

## Plugin configuration

### Maven config example

```xml
<build>
    <plugins>
        <plugin>
            <groupId>ru.volnenko.maven.plugin</groupId>
            <artifactId>maven-liquilbase-asciidoc-plugin</artifactId>
            <version>1.0.0</version>
            <configuration>
                <serviceName>TaskManager</serviceName>
                <dataBaseInfo>Postgres 15</dataBaseInfo>
                <headerFirstEnabled>true</headerFirstEnabled>
                <headerSecondEnabled>true</headerSecondEnabled>
                <tableOfContentsEnabled>true</tableOfContentsEnabled>
                <outputPath>${project.basedir}/doc/</outputPath>
                <files>
                    <file>${project.basedir}/erd/project.yaml</file>
                    <file>${project.basedir}/erd/task.yaml</file>
                    <file>${project.basedir}/erd/status.yaml</file>
                </files>
            </configuration>
        </plugin>
    </plugins>
</build>
```

### Plugin settings

|Name                       | Description                  |
|:--------------------------|:-----------------------------|
|serviceName                | Service name.                |
|dataBaseInfo               | Data Base extra information. |
|headerFirstEnabled         | Display first level header.  |
|headerSecondEnabled        | Display second level header. |
|tableOfContentsEnabled     | Display table of contents.   |
|outputPath                 | Output folder distination.   |

## Run Plugin

```bash
mvn liquilbase-asciidoc:generate
```