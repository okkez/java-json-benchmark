plugins {
    java
    id("me.champeau.jmh") version "0.6.1"
}

group = "net.okkez"
version = "1.0-SNAPSHOT"
java {
    sourceCompatibility = org.gradle.api.JavaVersion.VERSION_1_8
    targetCompatibility = org.gradle.api.JavaVersion.VERSION_1_8
}

repositories {
    mavenCentral()
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
    maven("http://conjars.org/repo")
}

dependencies {
    implementation("org.json:json:20201115")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.12.2")
    implementation("javax.json:javax.json-api:1.1.4")
    implementation("org.glassfish:javax.json:1.1.4")
    implementation("com.google.code.gson:gson:2.8.6")
    implementation("com.squareup.moshi:moshi:1.11.0")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.7.0")
    testImplementation("org.hamcrest:hamcrest-core:2.1")
    testImplementation("org.hamcrest:hamcrest-library:2.2")
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

jmh {
    iterations.set(5)
    fork.set(12)
    timeOnIteration.set("1s")
    jmhTimeout.set("5m")
    warmupIterations.set(5)
}