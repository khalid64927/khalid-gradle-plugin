/*
 * Copyright 2024 Mohammed Khalid Hamid. Use of this source code is governed by the Apache 2.0 license.
 */

import com.vanniktech.maven.publish.SonatypeHost
import java.util.Base64

plugins {
    `kotlin-dsl`
    id("com.vanniktech.maven.publish") version ("0.28.0")
}

group = "io.github.khalid64927"
version = libs.versions.khalidGradlePluginVersion.get()

repositories {
    mavenCentral()
    google()
    gradlePluginPortal()
}

dependencies {
    implementation(kotlin("stdlib"))
    api(libs.androidGradlePlugin)
    api(libs.kotlinGradlePlugin)
    api(libs.mobileMultiplatformGradlePlugin)
    api(libs.detektGradlePlugin)
    api(libs.vanniktechPublishGradlePlugin)
}

//java {
//    sourceCompatibility = JavaVersion.VERSION_11
//    targetCompatibility = JavaVersion.VERSION_11
//    withJavadocJar()
//    withSourcesJar()
//}

gradlePlugin {
    plugins {
        create("android-app") {
            id = "io.github.khalid64927.gradle.android.application"
            implementationClass = "io.github.khalid64927.gradle.AndroidAppPlugin"
        }
        create("android-library") {
            id = "io.github.khalid64927.gradle.android.library"
            implementationClass = "io.github.khalid64927.gradle.AndroidLibraryPlugin"
        }
        create("android-base") {
            id = "io.github.khalid64927.gradle.android.base"
            implementationClass = "io.github.khalid64927.gradle.AndroidBasePlugin"
        }
        create("android-publication") {
            id = "io.github.khalid64927.gradle.android.publication"
            implementationClass = "io.github.khalid64927.gradle.AndroidPublicationPlugin"
        }

        create("detekt") {
            id = "io.github.khalid64927.gradle.detekt"
            implementationClass = "io.github.khalid64927.gradle.DetektPlugin"
        }

        create("multiplatform-mobile") {
            id = "io.github.khalid64927.gradle.multiplatform.mobile"
            implementationClass = "io.github.khalid64927.gradle.KmmLibraryPlugin"
        }
        create("multiplatform-all") {
            id = "io.github.khalid64927.gradle.multiplatform.all"
            implementationClass = "io.github.khalid64927.gradle.KmpLibraryPlugin"
        }

        create("publication") {
            id = "io.github.khalid64927.gradle.publication"
            implementationClass = "io.github.khalid64927.gradle.PublicationPlugin"
        }

        create("tests") {
            id = "io.github.khalid64927.gradle.tests"
            implementationClass = "io.github.khalid64927.gradle.TestsReportPlugin"
        }

    }
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.S01, automaticRelease = true)
    //publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL, automaticRelease = true)
    pom {
        name.set("khalid gradle plugin")
        description.set("This is a Gradle plugin with common build logic for all KMP libraries in my open source repo.")
        url.set("https://github.com/khalid64927/khalid-gradle-plugin")
        licenses {
            license {
                name.set("Apache-2.0")
                distribution.set("repo")
                url.set("https://github.com/khalid64927/khalid-gradle-plugin/blob/master/LICENSE.md")
            }
        }

        developers {
            developer {
                id.set("khalid64927")
                name.set("Mohammed Khalid Hamid")
                email.set("khalid64927@gmail.com")
            }
        }

        scm {
            connection.set("scm:git:ssh://github.com/khalid64927/khalid-gradle-plugin.git")
            developerConnection.set("scm:git:ssh://github.com/khalid64927/khalid-gradle-plugin.git")
            url.set("https://github.com/khalid64927/khalid-gradle-plugin")
        }
    }
}
