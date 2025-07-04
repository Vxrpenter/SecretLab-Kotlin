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
data class UCICustomExplosiveGrenadeData(
    @SerialName("max_radius")
    val maxRadius: Float? = null,
    @SerialName("scp_damage_multiplier")
    val scpDamageMultiplier: Float? = null,
    @SerialName("burn_duration")
    val burnDuration: Float? = null,
    @SerialName("deafen_duration")
    val deafenDuration: Float? = null,
    @SerialName("concuss_duration")
    val concussDuration: Float? = null,
    @SerialName("fuse_time")
    val fuseTime: Float? = null,
    @SerialName("pin_pull_time")
    val pinPullTIme: Float? = null,
    val repickable: Boolean? = null,
)
