/*
 * Copyright 2024 Mohammed Khalid Hamid. Use of this source code is governed by the Apache 2.0 license.
 */

package io.github.khalid64927.gradle

import io.github.khalid64927.gradle.utils.connectTargetsToSourceSet
import io.github.khalid64927.gradle.utils.createMainTest
import io.github.khalid64927.gradle.utils.setupDependency
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KmmLibraryPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target.plugins) {
            apply("com.android.library")
            apply(AndroidBasePlugin::class.java)
            apply("org.jetbrains.kotlin.multiplatform")
            apply("dev.icerock.mobile.multiplatform.android-manifest")
        }

        target.configure<KotlinMultiplatformExtension> {
            android {
                publishAllLibraryVariants()
                publishLibraryVariantsGroupedByFlavor = true
            }
            iosArm64()
            iosX64()
            iosSimulatorArm64()

            with(this.sourceSets) {
                // creation
                createMainTest("ios")

                // ios dependencies
                setupDependency("ios", "common")
                connectTargetsToSourceSet(
                    targetNames = listOf("iosX64", "iosArm64", "iosSimulatorArm64"),
                    sourceSetPrefix = "ios"
                )

                // kotlin stdlib in common
                getByName("commonMain").dependencies {
                    implementation(kotlin("stdlib"))
                }
            }
        }
    }
}
