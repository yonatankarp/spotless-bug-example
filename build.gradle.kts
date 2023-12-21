plugins {
    kotlin("jvm") version "1.9.20"
    id("com.diffplug.spotless") version "6.22.0"
}

repositories {
    mavenCentral()
}
allprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "com.diffplug.spotless")

    spotless {
        kotlin {
            target(
                fileTree("${project.rootDir}/$name") {
                    include("**/*.kt")
                },
            )
            // see https://github.com/shyiko/ktlint#standard-rules
            trimTrailingWhitespace()
            ktlint("1.0.1").editorConfigOverride(
                mapOf(
                    "ktlint_standard_package-name" to "disabled",
                    "ktlint_standard_enum-entry-name-case" to "disabled",
                    "ktlint_standard_trailing-comma" to "disabled",
                    "ktlint_standard_annotation" to "disabled",
                    "ktlint_standard_no-unused-imports" to "disabled",
                    "ktlint_standard_trailing-comma-on-call-site" to "disabled",
                    "ktlint_standard_trailing-comma-on-declaration-site" to "disabled",
                ),
            )
            diktat("1.2.5").configFile("${rootProject.rootDir}/config/diktat/diktat-analysis.yml")
        }
    }
}
