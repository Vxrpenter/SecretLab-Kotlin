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
 * Defines the custom item's painkillers custom data
 */
@Serializable
data class UCICustomPainkillersData(
    /**
     * The health that will be granted to the holder every game tick.
     */
    @SerialName("tick_heal")
    val tickHeal: Float,
    /**
     * The buffer time (after usage) that is waited until heal starts.
     */
    @SerialName("time_before_start_healing")
    val timeBeforeStartHealing: Float,
    /**
     * The time between [tickHeal].
     */
    @SerialName("tick_time")
    val tickTime: Float,
    /**
     * The total amount of health that can be granted.
     */
    @SerialName("total_healing")
    val totalHealing: Float,
)
