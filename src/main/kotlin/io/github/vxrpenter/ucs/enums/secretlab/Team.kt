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
enum class Team(val team: String) {
    @SerialName("Dead")
    DEAD("Dead"),
    @SerialName("SCPs")
    SCPS("SCPs"),
    @SerialName("ClassD")
    CLASS_D("ClassD"),
    @SerialName("FoundationForces")
    FOUNDATION_FORCES("FoundationForces"),
    @SerialName("Scientists")
    SCIENTISTS("Scientists"),
    @SerialName("ChaosInsurgency")
    CHAOS_INSURGENCY("ChaosInsurgency"),
    @SerialName("Flamingo")
    FLAMINGO("Flamingo"),
    @SerialName("OtherAlive")
    OTHER_ALIVE("OtherAlive");

    companion object {
        /**
         * Finds the specified enum name from its Team.
         *
         * @param value The Team e.g. (Flamingo, OtherAlive etc.)
         * @see io.github.vxrpenter.ucs.enums.Team
         * @return the Team (nullable)
         */
        fun findEnum(value: String): Team? = Team.entries.find { it.team == value }

        /**
         * Finds the specified Team from its enum
         *
         * @param enum The enum e.g. (FLAMINGO, OTHER_ALIVE etc.)
         * @see io.github.vxrpenter.ucs.enums.Team
         * @return the Team (nullable)
         */
        fun findValue(enum: Team): String? = Team.entries.find { it.name == enum.name }?.team
    }
}