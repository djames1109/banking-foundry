# CoverBill Gradle Notes

## Build Properties

`gradle.properties` stores values that Gradle and the build can reuse. Keeping
versions and project metadata there avoids scattering them across build files.

The project properties identify the application (`group` and `version`), define
the Java source and bytecode level (`sourceCompatibility` and
`targetCompatibility`), and hold the Spring Boot and dependency-management
plugin versions. The build file reads the plugin-version properties when it
applies those plugins.

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

## Lombok

Lombok generates Java code during compilation, so it needs an annotation
processor rather than a normal runtime dependency:

```groovy
annotationProcessor 'org.projectlombok:lombok'
```

This tells the Java compiler to run Lombok. The configuration below makes that
same dependency visible to source code as `compileOnly`, so Lombok annotations
can be imported without packaging Lombok in the application:

```groovy
configurations {
    compileOnly {
        extendsFrom annotationProcessor
    }
}
```

`compileOnly` inherits dependencies from `annotationProcessor`; the reverse is
not true.

## Test Task

```groovy
tasks.named('test') {
    useJUnitPlatform()
}
```

Configures Gradle's existing `test` task to discover and run tests through the
JUnit Platform, which is used by JUnit 5. This does not add JUnit; the test
starter provides those dependencies.

## Spring Boot 4 Web Tests

Spring Boot 4 separates web-layer test support from the general test starter.
Use both dependencies when testing MVC controllers:

```groovy
testImplementation 'org.springframework.boot:spring-boot-starter-test'
testImplementation 'org.springframework.boot:spring-boot-starter-webmvc-test'
```

The first provides general testing support; the second provides MVC-specific
test slices such as `@WebMvcTest`. In Boot 4, import that annotation from:

```java
org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest
```
