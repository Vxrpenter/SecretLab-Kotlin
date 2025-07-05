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

@Serializable
data class UCICustomJailbirdData(
    @SerialName("melee_damage")
    val meleeDamage: Float,
    @SerialName("charge_damage")
    val chargeDamage: Float,
    @SerialName("flash_duration")
    val flashDuration: Float,
    val radius: Float,
    @SerialName("total_charges")
    val totalCharges: Int,
)
