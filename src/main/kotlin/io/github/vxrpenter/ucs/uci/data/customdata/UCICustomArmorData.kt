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
 * Defines the custom item's armor custom data
 */
@Serializable
data class UCICustomArmorData(
    /**
     * The armor's head protection.
     */
    @SerialName("head_protection")
    val headProtection: Int,
    /**
     * The armor's body protection.
     */
    @SerialName("body_protection")
    val bodyProtection: Int,
    @Deprecated(message = "Marked by UCI Developers as 'Obsolete'", level = DeprecationLevel.WARNING)
    @SerialName("remove_excess_on_drop")
    val removeExcessOnDrop: Boolean,
    /**
     * The stamina being drained by the armor.
     */
    @SerialName("stamina_use_multiplier")
    val staminaUseMultiplier: Float,
    /**
     * The stamina regen multiplier.
     */
    @SerialName("stamina_regen_multiplier")
    val staminaRegenMultiplier: Float,
)
