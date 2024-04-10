import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.23"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("io.appium:java-client:9.2.2")
    testImplementation("io.cucumber:cucumber-java:7.1.0")
    testImplementation("io.cucumber:cucumber-junit:7.1.0")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:7.16.1")
    testImplementation("org.junit.platform:junit-platform-suite:1.10.2")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "21"
}
