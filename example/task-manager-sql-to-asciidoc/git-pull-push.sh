#!/bin/bash

git pull

git add .
git commit -m "tm-sql-to-asciidoc updated."

git push

git push git@github.com:denis-volnenko/maven-liquilbase-asciidoc-plugin.git