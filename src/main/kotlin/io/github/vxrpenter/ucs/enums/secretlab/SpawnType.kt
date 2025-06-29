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

package io.github.vxrpenter.ucs.enums.secretlab

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class SpawnType(val spawnType: String) {
    /**
     * A random room inside the whole facility will be chosen.
     */
    @SerialName("CompleteRandomSpawn")
    COMPLETE_RANDOM_SPAWN("CompleteRandomSpawn"),

    /**
     * The Custom role will spawn in a room in one of the given Zones
     */
    @SerialName("ZoneSpawn")
    ZONE_SPAWN("ZoneSpawn"),

    /**
     * The custom role will spawn in one of the given Rooms.
     */
    @SerialName("RoomsSpawn")
    ROOM_SPAWN("RoomsSpawn"),

    /**
     * The custom role will spawn in one of the given Spawn Points.
     */
    @SerialName("SpawnPointSpawn")
    SPAWN_POINT_SPAWN("SpawnPointSpawn"),

    /**
     * The custom role will keep the default vanilla Role position, chosen by the game.
     */
    @SerialName("KeepRoleSpawn")
    KEEP_ROLE_SPAWN("KeepRoleSpawn"),

    /**
     * The custom role won't modify the player position (where they spawned as the vanilla Role)
     */
    @SerialName("KeepCurrentPositionSpawn")
    KEEP_CURRENT_POSITION_SPAWN("KeepCurrentPositionSpawn"),

    /**
     * The custom role will spawn in one of the Class-D's cells.
     */
    @SerialName("ClassDCell")
    CLASS_D_CELL("ClassDCell"),

    /**
     * The custom role will be spawned in a random spawn position of one of the given Spawn Roles.
     */
    @SerialName("RoleSpawn")
    ROLE_SPAWN("RoleSpawn");

    companion object {
        /**
         * Finds the specified enum name from its SpawnType.
         *
         * @param value The SpawnType e.g. (ClassDCell, RoleSpawn, etc.)
         * @see io.github.vxrpenter.ucs.enums.secretlab.SpawnType
         * @return the SpawnType (nullable)
         */
        fun findEnum(value: String): SpawnType? = SpawnType.entries.find { it.spawnType == value }

        /**
         * Finds the specified SpawnType from its enum
         *
         * @param enum The enum e.g. (CLASS_D_CELL, ROLE_SPAWN etc.)
         * @see io.github.vxrpenter.ucs.enums.secretlab.SpawnType
         * @return the SpawnType (nullable)
         */
        fun findValue(enum: SpawnType): String? = SpawnType.entries.find { it.name == enum.name }?.spawnType
    }
}