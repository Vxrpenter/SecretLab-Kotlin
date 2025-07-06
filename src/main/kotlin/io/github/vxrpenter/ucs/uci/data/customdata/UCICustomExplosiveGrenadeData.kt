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
import io.github.vxrpenter.ucs.enums.secretlab.EffectType

/**
 * Defines the custom item's explosive grenade custom data
 */
@Serializable
data class UCICustomExplosiveGrenadeData(
    /**
     * The maximum explosion radius.
     */
    @SerialName("max_radius")
    val maxRadius: Float,
    /**
     * The damage multiplier against Scp's.
     */
    @SerialName("scp_damage_multiplier")
    val scpDamageMultiplier: Float,
    /**
     * The time that the [EffectType.BURNED] will last.
     */
    @SerialName("burn_duration")
    val burnDuration: Float,
    /**
     * The time that the [EffectType.DEAFENED] will last.
     */
    @SerialName("deafen_duration")
    val deafenDuration: Float,
    /**
     * The time that the [EffectType.CONCUSSED] will last.
     */
    @SerialName("concuss_duration")
    val concussDuration: Float,
    /**
     * The fuse time until the grenade explodes.
     */
    @SerialName("fuse_time")
    val fuseTime: Float,
    /**
     * The time it takes to pull the pin.
     */
    @SerialName("pin_pull_time")
    val pinPullTIme: Float,
    /**
     * Defines if the grenade can be picked up after being thrown.
     */
    val repickable: Boolean,
)
