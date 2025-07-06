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
 * Defines the custom item's weapon custom data
 */
@Serializable
data class UCICustomWeaponData(
    /**
     * The damage of the ammunition.
     */
    val damage: Float,
    /**
     * The max amount of ammunition in the barrel.
     */
    @SerialName("max_barrel_ammo")
    val maxBarrelAmmo: Int? = null,
    /**
     * The max amount of ammunition.
     */
    @SerialName("max_ammo")
    val maxAmmo: Int,
    /**
     * The max amount of ammunition in the magazine.
     */
    @SerialName("max_magazine_amount")
    val maxMagazineAmount: Int? = null,
    /**
     * The ammunition drained per shot.
     */
    @SerialName("ammo_drain")
    val ammoDrain: Int? = null,
    /**
     * The penetration of the firearm.
     */
    val penetration: Float,
    /**
     * The inaccuracy of the firearm.
     */
    val inaccuracy: Float,
    /**
     * The inaccuracy of the firearm, while aiming.
     */
    @SerialName("aiming_inaccuracy")
    val aimingInaccuracy: Float,
    /**
     * The distance at that the damage falls off.
     */
    @SerialName("damage_falloff_distance")
    val damageFalloffDistance: Float,
    /**
     * The weapon attachments.
     */
    val attachments: String? = null,
    /**
     * Defines if the weapon can damage friendly teams.
     */
    @SerialName("enable_friendly_fire")
    val enableFriendlyFire: Boolean,
)