# Generating JARs

## fast-jar

mvn package -DskipTests

## uber-jar

mvn package -DskipTests -Dquarkus.package.jar.type=uber-jar

## native

mvn package -DskipTests -Pnative

### run native executable - without JVM (java -jar)

> target/quarkus-1st-1.0.0-SNAPSHOT-runner

### test native executable

mvn verify -Pnative

# set GRAALVM_HOME

export GRAALVM_HOME=/Library/Java/JavaVirtualMachines/graalvm-jdk-22.0.1+8.1/Contents/Home
