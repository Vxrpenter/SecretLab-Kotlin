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

package io.github.vxrpenter.ucs.uci.data.customdata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Defines the custom item's jailbird custom data
 */
@Serializable
data class UCICustomJailbirdData(
    /**
     * The damage the jailbird will apply on a melee attack.
     */
    @SerialName("melee_damage")
    val meleeDamage: Float,
    /**
     * The damage the jailbird will apply on a charge attack.
     */
    @SerialName("charge_damage")
    val chargeDamage: Float,
    /**
     * The duration the victim of the jailbird will be flashed.
     */
    @SerialName("flash_duration")
    val flashDuration: Float,
    /**
     * The radius the jailbird's hit will register in.
     */
    val radius: Float,
    /**
     * The total amount of jailbird charges.
     */
    @SerialName("total_charges")
    val totalCharges: Int,
)
