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

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
enum class RoleSpawnFlags(val flag: Int) {
    @SerialName("All")
    ALL(-1),
    @SerialName("None")
    NONE(0),
    @SerialName("AssignInventory")
    ASSIGN_INVENTORY(1),
    @SerialName("UseSpawnpoint")
    USE_SPAWNPOINT(2);

    companion object {
        /**
         * Finds the specified enum name from its RoleSpawnFlags.
         *
         * @param value The flag e.g. (AssignInventory, UseSpawnpoint, etc.)
         * @see io.github.vxrpenter.ucs.enums.secretlab.RoleSpawnFlags
         * @return the RoleSpawnFlags (nullable)
         */
        fun findEnum(value: Int): RoleSpawnFlags? = RoleSpawnFlags.entries.find { it.flag == value }

        /**
         * Finds the specified RoleSpawnFlags from its enum
         *
         * @param enum The enum e.g. (ASSIGN_INVENTORY, USE_SPAWNPOINT, etc.)
         * @see io.github.vxrpenter.ucs.enums.secretlab.RoleSpawnFlags
         * @return the RoleSpawnFlags (nullable)
         */
        fun findValue(enum: RoleSpawnFlags): Int? = RoleSpawnFlags.entries.find { it.name == enum.name }?.flag
    }
}