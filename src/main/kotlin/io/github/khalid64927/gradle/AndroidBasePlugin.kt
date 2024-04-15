/*
 * Copyright 2024 Mohammed Khalid Hamid. Use of this source code is governed by the Apache 2.0 license.
 */

package io.github.khalid64927.gradle

import com.android.build.gradle.BaseExtension
import io.github.khalid64927.gradle.utils.requiredIntProperty
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidBasePlugin : Plugin<Project> {

    override fun apply(target: Project) {
        val targetSdkValue: Int = target.requiredIntProperty("android.targetSdk")
        val compileSdkValue: Int = target.requiredIntProperty("android.compileSdk")
        val minSdkValue: Int = target.requiredIntProperty("android.minSdk")

        target.configure<BaseExtension> {
            //compileSdkVersions(compileSdkValue)
            defaultConfig {
                minSdk = minSdkValue
                targetSdk = targetSdkValue
            }
        }
    }
}
