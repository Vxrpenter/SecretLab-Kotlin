<div align="center">
  <img src="https://www.giantbomb.com/a/uploads/scale_medium/35/359560/2960939-logo_stylized.png" width="200" height="200" alt="cedmod" title="cedmod"/>    
  <h1>Secret Lab Kotlin</h1>
</div>

> [!CAUTION]
> Not all api endpoints have been implemented yet.
> Also, many of the already implemented endpoints weren't tested due to it being just too many.
> If you conduct your own test/find out that some aren't working correctly then create an issue so it can be fixed

# Implementation

Gradle:
```gradle
dependencies {
  implementation("io.github.vxrpenter:secretlab-kotlin:0.3.0")
}
```

Maven:
```xml
<dependency>
    <groupId>io.github.vxrpenter</groupId>
    <artifactId>secretlab-kotlin</artifactId>
    <version>0.3.0</version>
</dependency
```

# Compatibilty

| Api                   | Implementation Begon | Fully Implemented  | link                         | Documentation Entry                                                                           |
|-----------------------|----------------------|--------------------|------------------------------|-----------------------------------------------------------------------------------------------|
| Secret Laboratory Api | :white_check_mark:   | :white_check_mark: | https://api.scpslgame.com/   | [existing entry](https://github.com/Vxrpenter/Cedmod-Api-Kotlin/wiki/SecretLab-Api-Endpoints) |
| Cedmod Api            | :white_check_mark:   | :x:                | `Only avaidible on instance` | [existing entry](https://github.com/Vxrpenter/Cedmod-Api-Kotlin/wiki/Cedmod-Api-Endpoints)    |
| Scplist Api           | :white_check_mark:   | :white_check_mark: | https://scplist.kr/api       | [existing entry](https://github.com/Vxrpenter/Cedmod-Api-Kotlin/wiki/Scplist-Api-Endpoints)   |

## [`Secret Laboratory Standard Api`](https://github.com/Vxrpenter/Cedmod-Api-Kotlin/wiki/SecretLab-Api-Endpoints)
| Feature                    | Included           | Easy to use        |
|----------------------------|--------------------|--------------------|
| Get Basic Server Info      | :white_check_mark: | :white_check_mark: |
| Get Playercount            | :white_check_mark: | :white_check_mark: |
| Interact with Server       | :x:                | :x:                |
| Complex Systems            | :x:                | :x:                |
| Query Player Specific Info | :x:                | :x:                |

## [`Cedmod Api`](https://github.com/Vxrpenter/Cedmod-Api-Kotlin/wiki/Cedmod-Api-Endpoints)
| Feature                    | Included           | Easy to use        |
|----------------------------|--------------------|--------------------|
| Get Basic Server Info      | :white_check_mark: | :x: |
| Get Playercount            | :white_check_mark: | :white_check_mark: |
| Interact with Server       | :white_check_mark: | :x:                |
| Complex Systems            | :white_check_mark: | :x:                |
| Query Player Specific Info | :white_check_mark: | :white_check_mark: |


## [`Scplist Api`](https://github.com/Vxrpenter/Cedmod-Api-Kotlin/wiki/Scplist-Api-Endpoints)
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
