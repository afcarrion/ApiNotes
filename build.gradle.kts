import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.2.1"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "1.7.0"
    kotlin("plugin.spring") version "1.7.0"
}

group = "com.application"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_18
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework:spring-context")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework:spring-web")
    implementation("org.springframework:spring-webmvc")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("com.mysql:mysql-connector-j")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.hibernate.validator:hibernate-validator")
    testImplementation("org.springframework.boot:spring-boot-starter-test")


}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "18"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
