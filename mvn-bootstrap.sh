#!/usr/bin/env bash
mvn -U io.quarkus:quarkus-maven-plugin:create \
        -DprojectGroupId=com.jovisco \
        -DprojectArtifactId=quarkus-1st \
        -DclassName="com.jovisco.BookResource" \
        -Dpath="/api/books" \
        -Dextensions="resteasy-jsonb"