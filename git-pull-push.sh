#!/bin/bash

git pull
git pull git@github.com:denis-volnenko/liquibase-asciidoc-maven-plugin.git

git add .
git commit -m "Project updated."

git push

git push git@github.com:denis-volnenko/liquibase-asciidoc-maven-plugin.git
