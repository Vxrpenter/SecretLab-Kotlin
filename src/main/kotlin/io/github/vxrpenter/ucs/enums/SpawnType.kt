/*
 * Copyright (c) 2024 Vxrpenter and the SecretLab Kotlin contributors
 *
 * Licenced under the MIT License, any non-license compliant usage of this file(s) content
 * is prohibited. If you did not receive a copy of the license with this file, you
 * may obtain the license at
 *
 *  https://mit-license.org/
 *
 * This software may be used commercially if the usage is license compliant. The software
 * is provided without any sort of WARRANTY, and the authors cannot be held liable for
 * any form of claim, damages or other liabilities.
 *
 * Note: This is no legal advice, please read the license conditions
 */

package io.github.vxrpenter.ucs.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class SpawnType(val spawnType: String) {
    @SerialName("CompleteRandomSpawn")
    COMPLETE_RANDOM_SPAWN("CompleteRandomSpawn"),
    @SerialName("ZoneSpawn")
    ZONE_SPAWN("ZoneSpawn"),
    @SerialName("RoomsSpawn")
    ROOM_SPAWN("RoomsSpawn"),
    @SerialName("SpawnPointSpawn")
    SPAWN_POINT_SPAWN("SpawnPointSpawn"),
    @SerialName("KeepRoleSpawn")
    KEEP_ROLE_SPAWN("KeepRoleSpawn"),
    @SerialName("KeepCurrentPositionSpawn")
    KEEP_CURRENT_POSITION_SPAWN("KeepCurrentPositionSpawn"),
    @SerialName("ClassDCell")
    CLASS_D_CELL("ClassDCell"),
    @SerialName("RoleSpawn")
    ROLE_SPAWN("RoleSpawn");

    companion object {
        fun find(value: String): SpawnType? = SpawnType.entries.find { it.spawnType == value }
    }
}