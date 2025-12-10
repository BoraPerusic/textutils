plugins {
    kotlin("jvm") version "1.9.22"
    application
    kotlin("plugin.serialization") version "1.9.22"
}

group = "textutils"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.github.ajalt.clikt:clikt:4.2.2")
    implementation("com.typesafe:config:1.4.3")
    implementation("org.slf4j:slf4j-api:2.0.12")
    implementation("ch.qos.logback:logback-classic:1.5.3")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
// https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml-full
    implementation("org.apache.poi:poi-ooxml-full:5.5.1")
    // https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml
    implementation("org.apache.poi:poi-ooxml:5.5.1")

    testImplementation("io.kotest:kotest-runner-junit5:5.8.1")
    testImplementation("io.kotest:kotest-assertions-core:5.8.1")
    testImplementation("io.kotest:kotest-property:5.8.1")

}

application {
    mainClass.set("textutils.MainKt")
}

tasks.test {
    useJUnitPlatform()
}
