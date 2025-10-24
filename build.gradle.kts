plugins {
    id("java")
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
    implementation("com.jayway.jsonpath:json-path:2.9.0")
}

tasks.test {
    useJUnitPlatform()
}