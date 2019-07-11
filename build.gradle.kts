import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.31"
    `maven-publish`
    `java-gradle-plugin`
    id("com.gradle.plugin-publish") version "0.10.1"
}

group = "pub.cellebi"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testCompile("junit", "junit", "4.12")
}


tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

gradlePlugin {
    plugins {
        create("makeExecutable") {
            id = "pub.cellebi.make-executable"
            implementationClass = "pub.cellebi.plugin.ExecutorPlugin"
            displayName = "Make Jar Executable"
            description = "This is a gradle plugin for you to make your jar executable. It can produce a executable binary file from jar files"
        }
    }
}

pluginBundle {
    website = "https://github.com/cellebi/make-executable"
    vcsUrl = "https://github.com/cellebi/make-executable.git"
    tags = listOf("executable", "jar")
}






