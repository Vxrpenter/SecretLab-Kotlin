<div align="center">
  <img src="https://www.giantbomb.com/a/uploads/scale_medium/35/359560/2960939-logo_stylized.png" width="200" height="200" alt="cedmod" title="cedmod"/>    
  <h1>Secret Lab Kotlin</h1>
  
  <a href="https://github.com/Vxrpenter/SecretLab-Kotlin/releases"><img src="https://img.shields.io/github/v/release/Vxrpenter/SecretLab-Kotlin?include_prereleases&logo=github&logoColor=black&logoSize=amg&labelColor=333834&sort=date&display_name=tag&style=for-the-badge&label=LATEST%20RELEASE&color=green"/></a>&nbsp;<a href="https://central.sonatype.com/artifact/io.github.vxrpenter/secretlab-kotlin"><img src="https://img.shields.io/maven-central/v/io.github.vxrpenter/secretlab-kotlin?style=for-the-badge&logo=apache&logoColor=red&logoSize=amg&labelColor=333834&color=red"/><a/>&nbsp;
  
  <h3><a href="https://override.gitbook.io/secretlab-kotlin">Wiki</a> - <a href="https://vxrpenter.github.io/SecretLab-Kotlin/">Dokka Docs</a></h3>
</div>

> [!CAUTION]
> Not all api endpoints have been implemented yet.
> Also, many of the already implemented endpoints weren't tested due to it being just too many.
> If you conduct your own test/find out that some aren't working correctly then create an issue so it can be fixed

# Implementation [![Publish](https://github.com/Vxrpenter/SecretLab-Kotlin/actions/workflows/publish.yml/badge.svg)](https://github.com/Vxrpenter/SecretLab-Kotlin/actions/workflows/publish.yml)

Gradle:
```gradle
dependencies {
  implementation("io.github.vxrpenter:secretlab-kotlin:0.4.0")
}
```

Maven:
```xml
<dependency>
    <groupId>io.github.vxrpenter</groupId>
    <artifactId>secretlab-kotlin</artifactId>
    <version>0.4.0</version>
</dependency>
```

_Note that new version releases could take around an hour until they are successfully published to maven central_

# Compatibilty

| Api                   | Implementation Begon | Fully Implemented  | link                         | Documentation Entry                                                                           |
|-----------------------|----------------------|--------------------|------------------------------|-----------------------------------------------------------------------------------------------|
| Secret Laboratory Api | :white_check_mark:   | :white_check_mark: | https://api.scpslgame.com/   | [existing entry](https://github.com/Vxrpenter/Cedmod-Api-Kotlin/wiki/SecretLab-Api-Endpoints) |
| Cedmod Api            | :white_check_mark:   | :x:                | `Only avaidible on instance` | [existing entry](https://github.com/Vxrpenter/Cedmod-Api-Kotlin/wiki/Cedmod-Api-Endpoints)    |
| Scplist Api           | :white_check_mark:   | :white_check_mark: | https://scplist.kr/api       | [existing entry](https://github.com/Vxrpenter/Cedmod-Api-Kotlin/wiki/Scplist-Api-Endpoints)   |

## [`Secret Laboratory Standard Api`](https://override.gitbook.io/secretlab-kotlin/endpoints/secretlab-api)
| Feature                    | Included           | Easy to use        |
|----------------------------|--------------------|--------------------|
| Get Basic Server Info      | :white_check_mark: | :white_check_mark: |
| Get Playercount            | :white_check_mark: | :white_check_mark: |
| Interact with Server       | :x:                | :x:                |
| Complex Systems            | :x:                | :x:                |
| Query Player Specific Info | :x:                | :x:                |

## [`Cedmod Api`](https://override.gitbook.io/secretlab-kotlin/endpoints/cedmod-api)
| Feature                    | Included           | Easy to use        |
|----------------------------|--------------------|--------------------|
| Get Basic Server Info      | :white_check_mark: | :x: |
| Get Playercount            | :white_check_mark: | :white_check_mark: |
| Interact with Server       | :white_check_mark: | :x:                |
| Complex Systems            | :white_check_mark: | :x:                |
| Query Player Specific Info | :white_check_mark: | :white_check_mark: |


## [`Scplist Api`](https://override.gitbook.io/secretlab-kotlin/endpoints/scplist-api)
| Feature                    | Included           | Easy to use        |
|----------------------------|--------------------|--------------------|
| Get Basic Server Info      | :white_check_mark: | :white_check_mark: |
| Get Playercount            | :white_check_mark: | :white_check_mark: |
| Interact with Server       | :x:                | :x:                |
| Complex Systems            | :x:                | :x:                |
| Query Player Specific Info | :x:                | :x:                |

## Examples

Get current playercount with the SecretLabApi
```kotlin
import io.github.vxrpenter.secretlab.SecretLab

fun main() {
    // The server-specific api key can be obtained by typing !api show into the server console
    val api = "API_KEY"
    // The account id can be optained by the same way
    val accountId = "ACCOUNT_ID"
    
    // Get current online players using the SecretLab Api
    val players = SecretLab(api, accountId).serverInfo(false, players = true)?.servers?.get(0)?.players
}
```

Get the current playercount with the ScpListApi
```kotlin
import io.github.vxrpenter.scplist.ScpList

fun main() {
    // Get players using the ScpListApi
    val players = ScpList().serverGet("ID")?.players
}
```

Ban a player using the cedmod api
```kotlin
import io.github.vxrpenter.cedmod.Cedmod

fun main() {
    // The api key of the server. This can only be obtained after asking cedmod staff to active it for the specific instance
    val api = "API_KEY"
    // Url of the instance being normally https://myservername.cmod.app
    val instanceUrl = "INSTANCE_URL"

    // Issues a ban to the cedmod api. The userId is typically steam/discord id with @steam or @discord attached.
    Cedmod(api, instanceUrl).banPostIssue(userId = "USER_ID@steam", reason = "REASON", duration = 1, appealable = true, banlists = listOf(1111))
}
```
