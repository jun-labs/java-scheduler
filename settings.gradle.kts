pluginManagement {
    val kotlinVersion: String by settings
    val springBootVersion: String by settings
    val springDependencyManagementVersion: String by settings
    val jpaVersion: String by settings

    buildscript {
        repositories {
            gradlePluginPortal()
            mavenCentral()
        }
    }

    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "org.jetbrains.kotlin.jvm",
                "org.jetbrains.kotlin.plugin.allopen",
                "org.jetbrains.kotlin.plugin.spring",
                "org.jetbrains.kotlin.kapt",
                -> useVersion(kotlinVersion)

                "org.jetbrains.kotlin.plugin.jpa" -> useVersion(jpaVersion)
                "org.springframework.boot" -> useVersion(springBootVersion)
                "io.spring.dependency-management" -> useVersion(springDependencyManagementVersion)
            }
        }
    }
}
rootProject.name = "scheduler"
