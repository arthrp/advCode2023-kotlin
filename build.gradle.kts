import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    kotlin("jvm") version "1.9.0"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
}

val testLogEvents: Set<TestLogEvent> = setOf(
    TestLogEvent.PASSED,
    TestLogEvent.SKIPPED,
    TestLogEvent.FAILED,
    TestLogEvent.STANDARD_OUT,
    TestLogEvent.STANDARD_ERROR
)


tasks.test {
    useJUnitPlatform()
    testLogging {
        events(*testLogEvents.toTypedArray())
    }
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}