[![GitHub license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0) [![Download](https://img.shields.io/maven-central/v/io/github/khalid64927/khalid-gradle-plugin) ](https://repo1.maven.org/maven2/io/github/khalid64927/khalid-gradle-plugin/)

# khalid gradle plugin
This plugin is based on [moko-gradle-plugin] (https://github.com/icerockdev/moko-gradle-plugin)

## Setup
Add below ENV 

```shell

# Publishing
export OSSRH_USER="<username>"
export OSSRH_KEY="<alphanumeric pwd>"
export SIGNING_KEY_ID1=F312210C487AA8669E069A13B66B61C5A32EEAA4
export SIGNING_KEY_ID="<B669848B>"
export SIGNING_PASSWORD="<passphrase>"
export SIGNING_KEY="<base64 encoded PGP private key block>"

# vannitech plugin variables
export ORG_GRADLE_PROJECT_SONATYPE_NEXUS_USERNAME=$OSSRH_USER
export ORG_GRADLE_PROJECT_mavenCentralUsername=$OSSRH_USER
export ORG_GRADLE_PROJECT_SONATYPE_NEXUS_PASSWORD=$OSSRH_KEY
export ORG_GRADLE_PROJECT_mavenCentralPassword=$OSSRH_KEY

#PGP PRIVATE KEY BLOCK
export ORG_GRADLE_PROJECT_SIGNING_KEY=$SIGNING_KEY
export ORG_GRADLE_PROJECT_signingInMemoryKey=$SIGNING_KEY

```


## Usage
TODO

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
