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
data class UCICustomWeaponData(
    val damage: Float? = null,
    @SerialName("max_barrel_ammo")
    val maxBarrelAmmo: Int? = null,
    @SerialName("max_ammo")
    val maxAmmo: Int? = null,
    @SerialName("max_magazine_amount")
    val maxMagazineAmount: Int? = null,
    @SerialName("ammo_drain")
    val ammoDrain: Int? = null,
    val penetration: Float? = null,
    val inaccuracy: Float? = null,
    @SerialName("aiming_inaccuracy")
    val aimingInaccuracy: Float? = null,
    @SerialName("damage_falloff_distance")
    val damageFalloffDistance: Float? = null,
    val attachments: String? = null,
    @SerialName("enable_friendly_fire")
    val enableFriendlyFire: Boolean? = null
)