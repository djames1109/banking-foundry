# CoverBill Gradle Notes

## Plugins

Plugins add capabilities to the Gradle build.

```groovy
id 'java'
```

Adds Java compilation, the standard `test` task, and Java project conventions.

```groovy
id 'org.springframework.boot' version "${springBootVersion}"
```

Adds Spring Boot tasks, including executable-application packaging. The version
is read from `gradle.properties`.

```groovy
id 'io.spring.dependency-management' version "${dependencyManagementVersion}"
```

Imports the Spring Boot BOM and applies its tested versions to managed
dependencies. The property is the version of this Gradle plugin, not the BOM.

## Repository

```groovy
repositories {
    mavenCentral()
}
```

Tells Gradle to resolve dependencies from Maven Central.

## Dependencies

```groovy
implementation 'org.springframework.boot:spring-boot-starter-web'
```

Adds the libraries needed for an HTTP application, including Spring MVC,
embedded server support, and JSON handling.

```groovy
testImplementation 'org.springframework.boot:spring-boot-starter-test'
```

Adds test libraries and Spring's testing utilities. `testImplementation` keeps
these dependencies out of the production runtime classpath.

## Test Task

```groovy
tasks.named('test') {
    useJUnitPlatform()
}
```

Configures Gradle's existing `test` task to discover and run tests through the
JUnit Platform, which is used by JUnit 5. This does not add JUnit; the test
starter provides those dependencies.
