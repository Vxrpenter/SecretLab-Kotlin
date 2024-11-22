<div align="center">
  <img src="https://avatars.githubusercontent.com/u/64701232?s=200&v=4" width="200" height="200" alt="cedmod" title="cedmod"/>    
  <h1>Cedmod API Kotlin</h1>
</div>

> [!CAUTION]
> Not all api endpoints have been implemented yet.
> Also, many of the already implemented endpoints weren't tested due to it being just too many.
> If you conduct your own test/find out that some aren't working correctly then create an issue so it can be fixed

# Dependencys
| Dependency | Version | Github page                         |
|------------|---------|-------------------------------------|
| Gson       | 2.11.0  | https://github.com/google/gson      |
| Kotlin     | 2.0.20  | https://github.com/JetBrains/kotlin |

# Compatibilty

## Api
| Type                                                                                         | Api Endpoint                | Non Useronly Endpoint | Implementation | Tested | Implemented on Version |
|----------------------------------------------------------------------------------------------|-----------------------------|-----------------------|----------------|--------|------------------------|
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/ApiTokens/Query`      | :x:                   | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/a8e2183e-d2be-4188-9837-190b8d1dd020"/> | `/Api/ApiTokens/Add`        | :x:                   | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/639a0a7d-cdb3-43ae-9957-cb92ad322fbc"/> | `/Api/ApiTokens/{id}`       | :x:                   | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/797e682e-896c-45a6-8710-67baf0caf424"/> | `​/Api​/ApiTokens​/{id}`    | :x:                   | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `​/Api​/ApiTokens​/{id}`    | :x:                   | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/ApiTokens/{id}/Token` | :x:                   | :x:            | :x:    | Not Implemented        |

## Appeals
| Type                                                                                         | Api Endpoint                    | Non Useronly Endpoint | Implementation     | Tested             | Implemented on Version |
|----------------------------------------------------------------------------------------------|---------------------------------|-----------------------|--------------------|--------------------|------------------------|
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/Appeal/GetBans`           | :x:                   | :x:                | :x:                | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/a8e2183e-d2be-4188-9837-190b8d1dd020"/> | `/Api/Appeal/Submit`            | :x:                   | :x:                | :x:                | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/Appeal/Query`             | :white_check_mark:    | :white_check_mark: | :x:                | 3.4.18                 |
| <img src="https://github.com/user-attachments/assets/639a0a7d-cdb3-43ae-9957-cb92ad322fbc"/> | `/Api/Appeal/{appealId}/Handle` | :white_check_mark:    | :white_check_mark: | :white_check_mark: | 3.4.18                 |

## AuditLogsController
| Type                                                                                         | Api Endpoint          | Non Useronly Endpoint | Implementation | Tested | Implemented on Version |
|----------------------------------------------------------------------------------------------|-----------------------|-----------------------|----------------|--------|------------------------|
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/AuditLog/Query` | :grey_question:       | :x:            | :x:    | 3.4.18                 |

## Ban
| Type                                                                                         | Api Endpoint                   | Non Useronly Endpoint | Implementation     | Tested             | Implemented on Version |
|----------------------------------------------------------------------------------------------|--------------------------------|-----------------------|--------------------|--------------------|------------------------|
| <img src="https://github.com/user-attachments/assets/4067d98b-db32-4b04-b284-7999075bb687"/> | `/Api/Ban/{banId}/AppealState` | :white_check_mark:    | :white_check_mark: | :white_check_mark: | 3.4.18                 |
| <img src="https://github.com/user-attachments/assets/4067d98b-db32-4b04-b284-7999075bb687"/> | `/Api/Ban/{banId}/Bypassable`  | :white_check_mark:    | :white_check_mark: | :x:                | 3.4.18                 |
| <img src="https://github.com/user-attachments/assets/4067d98b-db32-4b04-b284-7999075bb687"/> | `/Api/Ban/{banId}/Duration`    | :white_check_mark:    | :white_check_mark: | :x:                | 3.4.18                 |
| <img src="https://github.com/user-attachments/assets/4067d98b-db32-4b04-b284-7999075bb687"/> | `/Api/Ban/{banId}/Reason`      | :white_check_mark:    | :white_check_mark: | :x:                | 3.4.18                 |
| <img src="https://github.com/user-attachments/assets/639a0a7d-cdb3-43ae-9957-cb92ad322fbc"/> | `/Api/Ban/{banId}`             | :white_check_mark:    | :white_check_mark: | :x:                | 3.4.18                 |
| <img src="https://github.com/user-attachments/assets/a8e2183e-d2be-4188-9837-190b8d1dd020"/> | `/Api/Ban/Issue`               | :white_check_mark:    | :white_check_mark: | :x:                | 3.4.18                 |
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/api/Ban/Query`               | :white_check_mark:    | :white_check_mark: | :x:                | 3.4.18                 |

## Banlist
| Type                                                                                         | Api Endpoint             | Non Useronly Endpoint | Implementation     | Tested | Implemented on Version |
|----------------------------------------------------------------------------------------------|--------------------------|-----------------------|--------------------|--------|------------------------|
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/Banlist/Query`     | :white_check_mark:    | :white_check_mark: | :x:    | 3.4.18                 |
| <img src="https://github.com/user-attachments/assets/639a0a7d-cdb3-43ae-9957-cb92ad322fbc"/> | `/Api/Banlist/{id}`      | :white_check_mark:    | :white_check_mark: | :x:    | 3.4.18                 |
| <img src="https://github.com/user-attachments/assets/797e682e-896c-45a6-8710-67baf0caf424"/> | `/Api/Banlist/{id}/{id}` | :white_check_mark:    | :white_check_mark: | :x:    | 3.4.18                 |

## BanLog
| Type                                                                                         | Api Endpoint          | Non Useronly Endpoint | Implementation     | Tested | Implemented on Version |
|----------------------------------------------------------------------------------------------|-----------------------|-----------------------|--------------------|--------|------------------------|
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/BanLog/User`    | :x:                   | :x:                | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/639a0a7d-cdb3-43ae-9957-cb92ad322fbc"/> | `/Api/BanLog/{banId}` | :white_check_mark:    | :white_check_mark: | :x:    | 3.4.18                 |
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/Changelog/Get`  | :white_check_mark:    | :white_check_mark: | :x:    | 3.4.18                 |

## Changelog
| Type                                                                                         | Api Endpoint         | Non Useronly Endpoint | Implementation     | Tested | Implemented on Version |
|----------------------------------------------------------------------------------------------|----------------------|-----------------------|--------------------|--------|------------------------|
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/Changelog/Get` | :white_check_mark:    | :white_check_mark: | :x:    | 3.4.18                 |

## Config
| Type                                                                                         | Api Endpoint      | Non Useronly Endpoint | Implementation | Tested | Implemented on Version |
|----------------------------------------------------------------------------------------------|-------------------|-----------------------|----------------|--------|------------------------|
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/Config/Get` | :x:                   | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/639a0a7d-cdb3-43ae-9957-cb92ad322fbc"/> | `/Api/Config/Set` | :x:                   | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/Config/Set` | :x:                   | :x:            | :x:    | Not Implemented        |

## ExternalLookup
| Type                                                                                         | Api Endpoint                 | Non Useronly Endpoint | Implementation | Tested | Implemented on Version |
|----------------------------------------------------------------------------------------------|------------------------------|-----------------------|----------------|--------|------------------------|
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/v3/Lookup`             | :grey_question:       | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/v3/LookupAuthCallback` | :grey_question:       | :x:            | :x:    | Not Implemented        |

## Feedback
| Type                                                                                         | Api Endpoint           | Non Useronly Endpoint | Implementation     | Tested | Implemented on Version |
|----------------------------------------------------------------------------------------------|------------------------|-----------------------|--------------------|--------|------------------------|
| <img src="https://github.com/user-attachments/assets/a8e2183e-d2be-4188-9837-190b8d1dd020"/> | `/Api/Feedback/Submit` | :white_check_mark:    | :white_check_mark: | :x:    | 3.4.14                 |

## Instance
| Type                                                                                         | Api Endpoint            | Non Useronly Endpoint | Implementation | Tested | Implemented on Version |
|----------------------------------------------------------------------------------------------|-------------------------|-----------------------|----------------|--------|------------------------|
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/Instance/Icon`    | :grey_question:       | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/Instance/Initial` | :grey_question:       | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/Instance/Stats`   | :grey_question:       | :x:            | :x:    | Not Implemented        |

## Login
| Type                                                                                         | Api Endpoint                | Non Useronly Endpoint | Implementation | Tested | Implemented on Version |
|----------------------------------------------------------------------------------------------|-----------------------------|-----------------------|----------------|--------|------------------------|
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/Login/InitiateLogin`  | :x:                   | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/a8e2183e-d2be-4188-9837-190b8d1dd020"/> | `/Api/Login/ServerCallback` | :x:                   | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/Login/ClientCallback` | :x:                   | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/Login/LoginConfirm`   | :x:                   | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/Login/LogoutConfirm`  | :x:                   | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/Login/Check`          | :x:                   | :x:            | :x:    | Not Implemented        |


## Mute
| Type                                                                                         | Api Endpoint                 | Non Useronly Endpoint | Implementation     | Tested | Implemented on Version |
|----------------------------------------------------------------------------------------------|------------------------------|-----------------------|--------------------|--------|------------------------|
| <img src="https://github.com/user-attachments/assets/4067d98b-db32-4b04-b284-7999075bb687"/> | `/Api/Mute/{banId}/Type`     | :white_check_mark:    | :white_check_mark: | :x:    | 3.4.14                 |
| <img src="https://github.com/user-attachments/assets/4067d98b-db32-4b04-b284-7999075bb687"/> | `/Api/Mute/{banId}/Duration` | :white_check_mark:    | :white_check_mark: | :x:    | 3.4.14                 |
| <img src="https://github.com/user-attachments/assets/4067d98b-db32-4b04-b284-7999075bb687"/> | `/Api/Mute/{banId}/Reason`   | :white_check_mark:    | :white_check_mark: | :x:    | 3.4.14                 |
| <img src="https://github.com/user-attachments/assets/639a0a7d-cdb3-43ae-9957-cb92ad322fbc"/> | `/Api/Mute/{banId}`          | :white_check_mark:    | :white_check_mark: | :x:    | 3.4.14                 |
| <img src="https://github.com/user-attachments/assets/a8e2183e-d2be-4188-9837-190b8d1dd020"/> | `/Api/Mute/Issue`            | :white_check_mark:    | :white_check_mark: | :x:    | 3.4.14                 |
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/Mute/Query`            | :white_check_mark:    | :white_check_mark: | :x:    | 3.4.14                 |

## MuteLog
| Type                                                                                         | Api Endpoint           | Non Useronly Endpoint | Implementation     | Tested | Implemented on Version |
|----------------------------------------------------------------------------------------------|------------------------|-----------------------|--------------------|--------|------------------------|
| <img src="https://github.com/user-attachments/assets/639a0a7d-cdb3-43ae-9957-cb92ad322fbc"/> | `/Api/MuteLog/{banId}` | :white_check_mark:    | :white_check_mark: | :x:    | 3.4.14                 |
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/MuteLog/User`    | :x:                   | :x:                | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/MuteLog/Query`   | :white_check_mark:    | :white_check_mark: | :x:    | 3.4.14                 |

## Permissions
| Type                                                                                         | Api Endpoint           | Non Useronly Endpoint | Implementation | Tested | Implemented on Version |
|----------------------------------------------------------------------------------------------|------------------------|-----------------------|----------------|--------|------------------------|
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/Permissions/Get` | :grey_question:       | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/639a0a7d-cdb3-43ae-9957-cb92ad322fbc"/> | `/Api/Permissions/Set` | :grey_question:       | :x:            | :x:    | Not Implemented        |

## Player
| Type                                                                                         | Api Endpoint                       | Non Useronly Endpoint | Implementation | Tested | Implemented on Version |
|----------------------------------------------------------------------------------------------|------------------------------------|-----------------------|----------------|--------|------------------------|
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/Player/{playerId}/StatsUser` | :x:                   | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/Player/{UserId}/User`        | :x:                   | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/Player/{playerId}/Stats`     | :white_check_mark:    | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/Player/Query`                | :white_check_mark:    | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/Player/ResetStaff/{userId}`  | :white_check_mark:    | :x:            | :x:    | Not Implemented        |

## QueryServer
| Type                                                                                         | Api Endpoint                     | Non Useronly Endpoint | Implementation | Tested | Implemented on Version |
|----------------------------------------------------------------------------------------------|----------------------------------|-----------------------|----------------|--------|------------------------|
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/QueryServer/Query`         | :grey_question:       | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/a8e2183e-d2be-4188-9837-190b8d1dd020"/> | `/Api/QueryServer/Create`        | :grey_question:       | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/QueryServer/{id}`          | :grey_question:       | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/797e682e-896c-45a6-8710-67baf0caf424"/> | `/Api/QueryServer/{id}`          | :grey_question:       | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/QueryServer/{id}/Settings` | :grey_question:       | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/639a0a7d-cdb3-43ae-9957-cb92ad322fbc"/> | `/Api/QueryServer/{id}/Settings` | :grey_question:       | :x:            | :x:    | Not Implemented        |

## ReportController
| Type                                                                                         | Api Endpoint        | Non Useronly Endpoint | Implementation | Tested | Implemented on Version |
|----------------------------------------------------------------------------------------------|---------------------|-----------------------|----------------|--------|------------------------|
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/Report/User`  | :x:                   | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/Report/Query` | :white_check_mark:    | :x:            | :x:    | Not Implemented        |

## RoleSync
| Type                                                                                         | Api Endpoint              | Non Useronly Endpoint | Implementation | Tested | Implemented on Version |
|----------------------------------------------------------------------------------------------|---------------------------|-----------------------|----------------|--------|------------------------|
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/RoleSync/GetStatus` | :x:                   | :x:            | :x:    | Not Implemented        |


## Stafflist
| Type                                                                                         | Api Endpoint           | Useronly Endpoint  | Implementation | Tested | Implemented on Version |
|----------------------------------------------------------------------------------------------|------------------------|--------------------|----------------|--------|------------------------|
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/Stafflist/Query` | :white_check_mark: | :x:            | :x:    | Not Implemented        |


## TeamkillLogs
| Type                                                                                         | Api Endpoint                    | Useronly Endpoint  | Implementation | Tested | Implemented on Version |
|----------------------------------------------------------------------------------------------|---------------------------------|--------------------|----------------|--------|------------------------|
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/TeamkillLogs/Query`       | :white_check_mark: | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/TeamkillLogs/{id}`        | :white_check_mark: | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/TeamkillLogs/Viewer/{id}` | :grey_question:    | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/TeamkillLogs/Rooms/{id}`  | :grey_question:    | :x:            | :x:    | Not Implemented        |

## Translation
| Type                                                                                         | Api Endpoint                          | Useronly Endpoint  | Implementation | Tested | Implemented on Version |
|----------------------------------------------------------------------------------------------|---------------------------------------|--------------------|----------------|--------|------------------------|
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/Translation/GetTranslation`     | :white_check_mark: | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/Translation/GetTranslationDate` | :white_check_mark: | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/Translation/Get/{languageCode}` | :white_check_mark: | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/Translation/List`               | :white_check_mark: | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/639a0a7d-cdb3-43ae-9957-cb92ad322fbc"/> | `/Api/Translation/Set/{languageCode}` | :white_check_mark: | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/Translation/ListPublic`         | :white_check_mark: | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/Translation/SetUser/{langCode}` | :white_check_mark: | :x:            | :x:    | Not Implemented        |


## User
| Type                                                                                         | Api Endpoint                    | Useronly Endpoint | Implementation | Tested | Implemented on Version |
|----------------------------------------------------------------------------------------------|---------------------------------|-------------------|----------------|--------|------------------------|
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/User/CheckSteam`          | :x:               | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/a8e2183e-d2be-4188-9837-190b8d1dd020"/> | `/Api/User/SetSteam/{steamid }` | :x:               | :x:            | :x:    | Not Implemented        |

## UserPreferences
| Type                                                                                         | Api Endpoint               | Useronly Endpoint  | Implementation | Tested | Implemented on Version |
|----------------------------------------------------------------------------------------------|----------------------------|--------------------|----------------|--------|------------------------|
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/UserPreferences/Get` | :white_check_mark: | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/639a0a7d-cdb3-43ae-9957-cb92ad322fbc"/> | `/Api/UserPreferences/Set` | :white_check_mark: | :x:            | :x:    | Not Implemented        |


## Warn
| Type                                                                                         | Api Endpoint               | Useronly Endpoint  | Implementation | Tested | Implemented on Version |
|----------------------------------------------------------------------------------------------|----------------------------|--------------------|----------------|--------|------------------------|
| <img src="https://github.com/user-attachments/assets/4067d98b-db32-4b04-b284-7999075bb687"/> | `/Api/Warn/{banId}/Reason` | :white_check_mark: | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/639a0a7d-cdb3-43ae-9957-cb92ad322fbc"/> | `/Api/Warn/{banId}`        | :white_check_mark: | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/Warn/User`           | :x:                | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/Warn/Query`          | :white_check_mark: | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/a8e2183e-d2be-4188-9837-190b8d1dd020"/> | `/Api/Warn/Issue`          | :white_check_mark: | :x:            | :x:    | Not Implemented        |

## Watchlist
| Type                                                                                         | Api Endpoint                  | Useronly Endpoint  | Implementation | Tested | Implemented on Version |
|----------------------------------------------------------------------------------------------|-------------------------------|--------------------|----------------|--------|------------------------|
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/Watchlist/Query`        | :white_check_mark: | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/watchlist/{id}`         | :white_check_mark: | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/Watchlist/Group/{id}`   | :white_check_mark: | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/a8e2183e-d2be-4188-9837-190b8d1dd020"/> | `/Api/Watchlist/Issue`        | :white_check_mark: | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/4067d98b-db32-4b04-b284-7999075bb687"/> | `/Api/Watchlist/Edit`         | :white_check_mark: | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/639a0a7d-cdb3-43ae-9957-cb92ad322fbc"/> | `/Api/Watchlist/Delete`       | :white_check_mark: | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/a8e2183e-d2be-4188-9837-190b8d1dd020"/> | `/Api/Watchlist/Group/Issue`  | :white_check_mark: | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/4067d98b-db32-4b04-b284-7999075bb687"/> | `/Api/Watchlist/Group/Edit`   | :white_check_mark: | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/639a0a7d-cdb3-43ae-9957-cb92ad322fbc"/> | `/Api/Watchlist/Group/Delete` | :white_check_mark: | :x:            | :x:    | Not Implemented        |

## Whitelists
| Type                                                                                         | Api Endpoint            | Useronly Endpoint  | Implementation | Tested | Implemented on Version |
|----------------------------------------------------------------------------------------------|-------------------------|--------------------|----------------|--------|------------------------|
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/Whitelists/Query` | :white_check_mark: | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/a8e2183e-d2be-4188-9837-190b8d1dd020"/> | `/Api/Whitelists/New`   | :white_check_mark: | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/639a0a7d-cdb3-43ae-9957-cb92ad322fbc"/> | `/Api/Whitelists/{id}`  | :white_check_mark: | :x:            | :x:    | Not Implemented        |
| <img src="https://github.com/user-attachments/assets/797e682e-896c-45a6-8710-67baf0caf424"/> | `/Api/Whitelists/{id}`  | :white_check_mark: | :x:            | :x:    | Not Implemented        |
