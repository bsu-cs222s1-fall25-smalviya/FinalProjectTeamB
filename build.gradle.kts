import org.gradle.kotlin.dsl.internal.sharedruntime.codegen.generateKotlinDslApiExtensionsSourceTo

plugins {
    id("java")
    `java-library`
    id("application")
    id("org.openjfx.javafxplugin") version "0.1.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    // https://mvnrepository.com/artifact/com.google.code.gson/gson
    implementation("com.google.code.gson:gson:2.13.2")
    // https://mvnrepository.com/artifact/com.jayway.jsonpath/json-path
    implementation("com.jayway.jsonpath:json-path:2.9.0")
    // https://mvnrepository.com/artifact/net.minidev/json-smart
    implementation("net.minidev:json-smart:2.6.0")
    // https://mvnrepository.com/artifact/tools.jackson.core/jackson-databind
    implementation("tools.jackson.core:jackson-databind:3.0.1")

    // https://mvnrepository.com/artifact/org.openjfx/javafx-fxml
    implementation("org.openjfx:javafx-fxml:26-ea+16")
    // https://mvnrepository.com/artifact/org.openjfx/javafx-base
    implementation("org.openjfx:javafx-base:26-ea+16")
    // https://mvnrepository.com/artifact/org.openjfx/javafx-controls
    implementation("org.openjfx:javafx-controls:26-ea+16")
    // https://mvnrepository.com/artifact/org.openjfx/javafx-graphics
    implementation("org.openjfx:javafx-graphics:26-ea+16")
    // https://mvnrepository.com/artifact/org.openjfx/javafx-graphics
    implementation("org.openjfx:javafx-graphics:26-ea+16")


}

tasks.test {
    useJUnitPlatform()
}