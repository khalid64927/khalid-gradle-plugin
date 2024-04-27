[![GitHub license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0) [![Download](https://img.shields.io/maven-central/v/io/github/khalid64927/khalid-gradle-plugin) ](https://repo1.maven.org/maven2/io/github/khalid64927/khalid-gradle-plugin/)

# khalid-gradle-plugin
This plugin is based on [moko-gradle-plugin](https://github.com/icerockdev/moko-gradle-plugin)

## Setup


## Usage

In your KMP/Java/Android module's gradle file add the plugin as below

```kotlin
plugins {
    id("io.github.khalid64927.gradle.multiplatform.mobile")
    id("o.github.khalid64927.gradle.publication")
    id("io.github.khalid64927.gradle.stub.javadoc")
    id("io.github.khalid64927.gradle.detekt")
    id("com.diffplug.spotless")
}
```
# Publication plugin

Usage

```kotlin
plugins {
    id("o.github.khalid64927.gradle.publication")
}
```
This plugin requires you to provide below values in your Env variables for signing the artifact
and uploading it to

```shell
export OSSRH_USER=<nexusUsername>
export OSSRH_KEY=<nexusPassword>
export SIGNING_KEY="<base64-encoded-GPG-Key>"
export SIGNING_PASSWORD="<GPG-passphrase>"
```
And below Gradle properties values

```gradle.properties
khalid.android.targetSdk=34
khalid.android.compileSdk=34
khalid.android.minSdk=21
khalid.publish.name=<name>
khalid.publish.description=<description>
khalid.publish.repo.org=<org-name>
khalid.publish.repo.name=<repo-name>
khalid.publish.license=<license-type>
khalid.publish.developers=<developers>
```

Then run below command to publish artifacts to Nexus Central

```shell
./gradlew publishMavenJavaPublicationToOSSRHRepository
```

## License

    Copyright 2024 Mohammed Khalid Hamid.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
