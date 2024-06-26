/*
 * Copyright 2024 Mohammed Khalid Hamid. Use of this source code is governed by the Apache 2.0 license.
 */

package io.github.khalid64927.gradle

import com.android.build.gradle.AppExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidAppPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target.plugins) {
            apply("com.android.application")
            apply("kotlin-android")
            apply(AndroidBasePlugin::class.java)
        }

        target.configure<AppExtension> {
            buildTypes {
                getByName("release") {
                    isMinifyEnabled = true
                    proguardFiles(
                        getDefaultProguardFile("proguard-android.txt"),
                        "proguard-rules.pro"
                    )
                }
                getByName("debug") {
                    isDebuggable = true
                    applicationIdSuffix = ".debug"
                }
            }

            packagingOptions {
                with(resources.excludes) {
                    add("META-INF/*.kotlin_module")
                    add("META-INF/AL2.0")
                    add("META-INF/LGPL2.1")
                }
            }
        }
    }
}
