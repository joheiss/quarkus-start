# Bootstrapping with Maven Quarkus Plugin

mvn -U io.quarkus:quarkus-maven-plugin:create \
 -DprojectGroupId=com.jovisco.quarkus-start \
 -DprojectArtifactId=rest-book \
 -DclassName="com.jovisco.quarkus.start.BookResource" \
 -Dpath="/api/books" \
 -Dextensions="resteasy-jsonb"

## Run Quarkus in Development Mode

mvn quarkus:dev

## Run Quarkus Tests

mvn test

## Override Configuration

mvn quarkus:dev -Dbooks.genre=Poetry
mv test -Dbooks.genre=IT

# Generating JARs

## fast-jar (default)

mvn package -DskipTests

## uber-jar (Fat Jar)

mvn package -DskipTests -Dquarkus.package.jar.type=uber-jar

## native

mvn package -DskipTests -Pnative

### run native executable - without JVM (java -jar)

> target/quarkus-1st-1.0.0-SNAPSHOT-runner

### test native executable

mvn verify -Pnative

# set GRAALVM_HOME

export GRAALVM_HOME=/Library/Java/JavaVirtualMachines/graalvm-jdk-22.0.1+8.1/Contents/Home

# Build Docker image for a Executable Jar (JVM)

## Add quarkus container image docker to pom.xml

mvn quarkus:add-extension -Dextensions="container-image-docker"

## Build docker container image

mvn package -Dquarkus.container-image.build=true -Dquarkus.container-image.tag=jvm

## Run docker container

docker run -i --rm -p 8080:8080 joheiss/quarkus-1st:jvm

# Build Docker image for a Linux Native Executable

## Build docker container image

mvn package -Dquarkus.container-image.build=true -Dquarkus.package.type=native -Dquarkus.native.container-build=true -Dquarkus.container-image.tag=native

## Run docker container

docker run -i --rm -p 8080:8080 joheiss/quarkus-1st:native
