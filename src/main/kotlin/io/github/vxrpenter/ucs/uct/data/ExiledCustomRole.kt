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

package io.github.vxrpenter.ucs.uct.data

import io.github.vxrpenter.ucs.uct.enum.Priority
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This data class contains a small Serializer for the ExiledCustomRole used in UncomplicatedCustomTeam's.
 *
 * @since 0.5.0
 * @author Vxrpenter
 */
@Serializable
data class ExiledCustomRole(
    /**
     * The maximum number of players the custom team can have.
     */
    @SerialName("max_players")
    val maxPlayers: Int,
    /**
     * The priority at that this team spawn's with.
     */
    val priority: Priority,
    /**
     * The id of the custom team.
     */
    val id: String,
)