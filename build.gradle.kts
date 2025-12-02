plugins {
    kotlin("jvm") version "1.9.21"
    application
}

group = "com.aoe25"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}

// Configure the default application (you can change this to run different apps)
application {
    mainClass.set("MainKt")
}
