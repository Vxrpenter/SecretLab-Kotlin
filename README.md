<div align="center">
  <img src="https://avatars.githubusercontent.com/u/64701232?s=200&v=4" width="200" height="200"/>    
  <h1>Cedmod API Kotlin</h1>
</div>
     
A small utility class for accessing the cedmod api in kotlin projects. 

> [!CAUTION]
> Not all api endpoints have been implemented yet. Also many of the already implemented endpoints were not tested due to it being just too many. If you conduct your own test/find out that some are not working correctly then create an issue so it can be fixed

# Compatibilty
This list contains all compatibility information, not all endpoints have been listed yet

## Api
| Type| Api Endpoint | Useronly Endpoint | Implementation | Tested | Implemented on Version |
| --- | --- | --- | --- | --- | --- |
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/ApiTokens/Query` | :white_check_mark: | :x: | :x: | Not Implemented |
| <img src="https://github.com/user-attachments/assets/a8e2183e-d2be-4188-9837-190b8d1dd020"/> | `/Api/ApiTokens/Add` | :white_check_mark: | :x: | :x: | Not Implemented  |
| <img src="https://github.com/user-attachments/assets/639a0a7d-cdb3-43ae-9957-cb92ad322fbc"/> | `/Api/ApiTokens/{id}` | :white_check_mark: | :x: | :x: | Not Implemented |
| <img src="https://github.com/user-attachments/assets/797e682e-896c-45a6-8710-67baf0caf424"/> | `​/Api​/ApiTokens​/{id}` | :white_check_mark: | :x: | :x: | Not Implemented |
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `​/Api​/ApiTokens​/{id}` | :white_check_mark: | :x: | :x: | Not Implemented |
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/ApiTokens/{id}/Token` | :white_check_mark: | :x: | :x: | Not Implemented |

## Appeals
| Type| Api Endpoint | Useronly Endpoint | Implementation | Tested | Implemented on Version |
| --- | --- | --- | --- | --- | --- |
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/Appeal/GetBans` | :white_check_mark: | :x: | :x: | Not Implemented |
| <img src="https://github.com/user-attachments/assets/a8e2183e-d2be-4188-9837-190b8d1dd020"/> | `/Api/Appeal/Submit` | :white_check_mark: | :x: | :x: | Not Implemented |
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/Appeal/Query` | :x: | :white_check_mark: | :x: | 3.4.18 |
| <img src="https://github.com/user-attachments/assets/639a0a7d-cdb3-43ae-9957-cb92ad322fbc"/> | `/Api/Appeal/{appealId}/Handle` | :x: | :white_check_mark: | :white_check_mark: | 3.4.18 |

## AuditLogsController
| Type| Api Endpoint | Useronly Endpoint | Implementation | Tested | Implemented on Version |
| --- | --- | --- | --- | --- | --- |
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/AuditLog/Query` | :white_check_mark: | :x: | :x: | 3.4.18 |

## Ban
| Type| Api Endpoint | Useronly Endpoint | Implementation | Tested | Implemented on Version |
| --- | --- | --- | --- | --- | --- |
| <img src="https://github.com/user-attachments/assets/4067d98b-db32-4b04-b284-7999075bb687"/> | `/Api/Ban/{banId}/AppealState` | :x: | :white_check_mark: | :white_check_mark: | 3.4.18 |
| <img src="https://github.com/user-attachments/assets/4067d98b-db32-4b04-b284-7999075bb687"/> | `/Api/Ban/{banId}/Bypassable` | :x: | :white_check_mark: | :x: | 3.4.18 |
| <img src="https://github.com/user-attachments/assets/4067d98b-db32-4b04-b284-7999075bb687"/> | `/Api/Ban/{banId}/Duration` | :x: | :white_check_mark: | :x: | 3.4.18 |
| <img src="https://github.com/user-attachments/assets/4067d98b-db32-4b04-b284-7999075bb687"/> | `/Api/Ban/{banId}/Reason` | :x: | :white_check_mark: | :x: | 3.4.18 |
| <img src="https://github.com/user-attachments/assets/639a0a7d-cdb3-43ae-9957-cb92ad322fbc"/> | `/Api/Ban/{banId}` | :x: | :white_check_mark: | :x: | 3.4.18 |
| <img src="https://github.com/user-attachments/assets/a8e2183e-d2be-4188-9837-190b8d1dd020"/> | `/Api/Ban/Issue` | :x: | :white_check_mark: | :x: | 3.4.18 |
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/api/Ban/Query` | :x: | :white_check_mark: | :x: | 3.4.18 |

## Banlist
| Type| Api Endpoint | Useronly Endpoint | Implementation | Tested | Implemented on Version |
| --- | --- | --- | --- | --- | --- |
| <img src="https://github.com/user-attachments/assets/a6e32603-d14e-4349-8858-ec892db67c39"/> | `/Api/Banlist/Query` | :x: | :white_check_mark: | :x: | 3.4.18 |
| <img src="https://github.com/user-attachments/assets/639a0a7d-cdb3-43ae-9957-cb92ad322fbc"/> | `/Api/Banlist/{id}` | :x: | :white_check_mark: | :x: | 3.4.18 |
| <img src="https://github.com/user-attachments/assets/797e682e-896c-45a6-8710-67baf0caf424"/> | `/Api/Banlist/{id}/{id}` | :x: | :white_check_mark: | :x: | 3.4.18 |

## BanLog
| Type| Api Endpoint | Useronly Endpoint | Implementation | Tested | Implemented on Version |
| --- | --- | --- | --- | --- | --- |
|  |  |  |  |  |  |
|  |  |  |  |  |  |
|  |  |  |  |  |  |

## Changelog
| Type| Api Endpoint | Useronly Endpoint | Implementation | Tested | Implemented on Version |
| --- | --- | --- | --- | --- | --- |
|  |  |  |  |  |  |

## Config
| Type| Api Endpoint | Useronly Endpoint | Implementation | Tested | Implemented on Version |
| --- | --- | --- | --- | --- | --- |
|  |  |  |  |  |  |
|  |  |  |  |  |  |
|  |  |  |  |  |  |

## ExternalLookup
| Type| Api Endpoint | Useronly Endpoint | Implementation | Tested | Implemented on Version |
| --- | --- | --- | --- | --- | --- |
|  |  |  |  |  |  |
|  |  |  |  |  |  |

## Feedback
| Type| Api Endpoint | Useronly Endpoint | Implementation | Tested | Implemented on Version |
| --- | --- | --- | --- | --- | --- |
|  |  |  |  |  |  |

## Instance
| Type| Api Endpoint | Useronly Endpoint | Implementation | Tested | Implemented on Version |
| --- | --- | --- | --- | --- | --- |
|  |  |  |  |  |  |
|  |  |  |  |  |  |
|  |  |  |  |  |  |

## Login
| Type| Api Endpoint | Useronly Endpoint | Implementation | Tested | Implemented on Version |
| --- | --- | --- | --- | --- | --- |
|  |  |  |  |  |  |
|  |  |  |  |  |  |
|  |  |  |  |  |  |
|  |  |  |  |  |  |
|  |  |  |  |  |  |
|  |  |  |  |  |  |


## Mute
| Type| Api Endpoint | Useronly Endpoint | Implementation | Tested | Implemented on Version |
| --- | --- | --- | --- | --- | --- |
|  |  |  |  |  |  |
|  |  |  |  |  |  |
|  |  |  |  |  |  |
|  |  |  |  |  |  |
|  |  |  |  |  |  |
|  |  |  |  |  |  |

## MuteLog
| Type| Api Endpoint | Useronly Endpoint | Implementation | Tested | Implemented on Version |
| --- | --- | --- | --- | --- | --- |
|  |  |  |  |  |  |

## Permissions
| Type| Api Endpoint | Useronly Endpoint | Implementation | Tested | Implemented on Version |
| --- | --- | --- | --- | --- | --- |
|  |  |  |  |  |  |
|  |  |  |  |  |  |

## Player
| Type| Api Endpoint | Useronly Endpoint | Implementation | Tested | Implemented on Version |
| --- | --- | --- | --- | --- | --- |
|  |  |  |  |  |  |
|  |  |  |  |  |  |
|  |  |  |  |  |  |
|  |  |  |  |  |  |
|  |  |  |  |  |  |

## QueryServer
| Type| Api Endpoint | Useronly Endpoint | Implementation | Tested | Implemented on Version |
| --- | --- | --- | --- | --- | --- |
|  |  |  |  |  |  |
|  |  |  |  |  |  |
|  |  |  |  |  |  |
|  |  |  |  |  |  |
|  |  |  |  |  |  |
|  |  |  |  |  |  |

## ReportController
| Type| Api Endpoint | Useronly Endpoint | Implementation | Tested | Implemented on Version |
| --- | --- | --- | --- | --- | --- |
|  |  |  |  |  |  |
|  |  |  |  |  |  |

## RoleSync
| Type| Api Endpoint | Useronly Endpoint | Implementation | Tested | Implemented on Version |
| --- | --- | --- | --- | --- | --- |
|  |  |  |  |  |  |


## Stafflist
| Type| Api Endpoint | Useronly Endpoint | Implementation | Tested | Implemented on Version |
| --- | --- | --- | --- | --- | --- |
|  |  |  |  |  |  |


## TeamkillLogs
| Type| Api Endpoint | Useronly Endpoint | Implementation | Tested | Implemented on Version |
| --- | --- | --- | --- | --- | --- |
|  |  |  |  |  |  |
|  |  |  |  |  |  |
|  |  |  |  |  |  |
|  |  |  |  |  |  |

## Translation
| Type| Api Endpoint | Useronly Endpoint | Implementation | Tested | Implemented on Version |
| --- | --- | --- | --- | --- | --- |
|  |  |  |  |  |  |
|  |  |  |  |  |  |
|  |  |  |  |  |  |
|  |  |  |  |  |  |
|  |  |  |  |  |  |
|  |  |  |  |  |  |
|  |  |  |  |  |  |


## User
| Type| Api Endpoint | Useronly Endpoint | Implementation | Tested | Implemented on Version |
| --- | --- | --- | --- | --- | --- |
|  |  |  |  |  |  |
|  |  |  |  |  |  |

## UserPreferences
| Type| Api Endpoint | Useronly Endpoint | Implementation | Tested | Implemented on Version |
| --- | --- | --- | --- | --- | --- |
|  |  |  |  |  |  |
|  |  |  |  |  |  |


## Warn
| Type| Api Endpoint | Useronly Endpoint | Implementation | Tested | Implemented on Version |
| --- | --- | --- | --- | --- | --- |
|  |  |  |  |  |  |
|  |  |  |  |  |  |
|  |  |  |  |  |  |
|  |  |  |  |  |  |
|  |  |  |  |  |  |

## Watchlist
| Type| Api Endpoint | Useronly Endpoint | Implementation | Tested | Implemented on Version |
| --- | --- | --- | --- | --- | --- |
|  |  |  |  |  |  |
|  |  |  |  |  |  |
|  |  |  |  |  |  |
|  |  |  |  |  |  |
|  |  |  |  |  |  |
|  |  |  |  |  |  |
|  |  |  |  |  |  |
|  |  |  |  |  |  |
|  |  |  |  |  |  |

## Whitelists
| Type| Api Endpoint | Useronly Endpoint | Implementation | Tested | Implemented on Version |
| --- | --- | --- | --- | --- | --- |
|  |  |  |  |  |  |
|  |  |  |  |  |  |
|  |  |  |  |  |  |
|  |  |  |  |  |  |
