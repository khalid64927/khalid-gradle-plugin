/*
 * Copyright 2024 Mohammed Khalid Hamid. Use of this source code is governed by the Apache 2.0 license.
 */

package io.github.khalid64927.gradle

import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.register
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class JvmPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target.plugins) {
            apply("org.jetbrains.kotlin.jvm")
        }

        target.configure<JavaPluginExtension> {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
            withJavadocJar()
            withSourcesJar()
        }

        target.tasks
            .withType<KotlinCompile>()
            .configureEach {
                kotlinOptions.jvmTarget = "1.8"
            }

        target.plugins.withId("org.gradle.maven-publish") {
            target.configure<PublishingExtension> {
                publications.register("mavenJava", MavenPublication::class) {
                    from(target.components["java"])
                }
            }
        }
    }
}
