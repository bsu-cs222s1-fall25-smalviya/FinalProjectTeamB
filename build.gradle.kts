import org.gradle.kotlin.dsl.internal.sharedruntime.codegen.generateKotlinDslApiExtensionsSourceTo

plugins {
    id("java")
    `java-library`
    id("application")
    id ("org.openjfx.javafxplugin") version("0.1.0")
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
    testImplementation(platform("org.junit:junit-bom:5.10.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.slf4j:slf4j-nop:2.0.11")
    implementation("com.jayway.jsonpath:json-path:2.9.0")
    implementation("net.minidev:json-smart:2.5.0")

    // https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind
    implementation("com.fasterxml.jackson.core:jackson-databind:2.20.0")
    implementation("com.jayway.jsonpath:json-path:2.9.0")
    implementation("net.minidev:json-smart:2.6.0")

   val javafxVersion = "23.0.1"

    implementation("org.openjfx:javafx-base:$javafxVersion")
    implementation("org.openjfx:javafx-controls:$javafxVersion")
    implementation("org.openjfx:javafx-fxml:$javafxVersion")
    implementation("org.openjfx:javafx-graphics:$javafxVersion")



}
// Add this!
javafx {
    version = "23.0.1"
    modules("javafx.controls", "javafx.fxml")
}

application {
    mainClass.set("edu.bsu.cs222.MainApplication")
}
tasks.test {
    useJUnitPlatform()
}