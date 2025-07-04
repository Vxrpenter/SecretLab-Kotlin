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

import io.github.vxrpenter.ucs.enums.secretlab.EffectType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UCICustomScp500Data(
    val effect: EffectType? = null,
    val duration: Float? = null,
    val intensity: Byte? = null,
)

@Serializable
data class UCICustomScp207(
    val effect: EffectType? = null,
    val duration: Float? = null,
    val intensity: Byte? = null,
    @SerialName("apply_207_effect")
    val apply207Effect: Boolean? = null,
    @SerialName("remove_item_after_use")
    val removeItemAfterUse: Boolean? = null,
)

@Serializable
data class UCICustomScp018Data(
    val friendlyFireTime: Float? = null,
    @SerialName("fuse_time")
    val fuseTime: Float? = null,
)

@Serializable
data class UCICustomScp217Data(
    @SerialName("fuse_time")
    val fuseTime: Float? = null,
)

@Serializable
data class UCICustomScp244Data(
    @SerialName("activation_dot")
    val activationDot: Float? = null,
    val health: Float? = null,
    @SerialName("max_diameter")
    val maxDiameter: Float? = null,
    val primed: Boolean? = null,
)

@Serializable
data class UCICustomScp1853Data(
    val effect: EffectType? = null,
    val duration: Float? = null,
    val intensity: Byte? = null,
    val apply1853Effect: Boolean? = null,
    @SerialName("remove_item_after_use")
    val removeItemAfterUse: Boolean? = null,
)

@Serializable
data class UCICustomScp1576Data(
    val effect: EffectType? = null,
    val duration: Float? = null,
    val intensity: Byte? = null,
)

@Serializable
data class UCICustomScp127Data(
    @SerialName("give_hume_shield")
    val giveHumeShield: Boolean? = null,
    @SerialName("tier1_bullet_fire_rate")
    val tier1BulletFireRate: Float? = null,
    @SerialName("tier2_bullet_fire_rate")
    val tier2BulletFireRate: Float? = null,
    @SerialName("tier3_bullet_fire_rate")
    val tier3BulletFireRate: Float? = null,
    @SerialName("tier1_bullet_regen_rate")
    val tier1BulletRegenRate: Float? = null,
    @SerialName("tier2_bullet_regen_rate")
    val tier2BulletRegenRate: Float? = null,
    @SerialName("tier3_bullet_regen_rate")
    val tier3BulletRegenRate: Float? = null,
    @SerialName("tier1_bullet_regen_post_fire_delay")
    val tier1BulletRegenPostFireDelay: Float? = null,
    @SerialName("tier2_bullet_regen_post_fire_delay")
    val tier2BulletRegenPostFireDelay: Float? = null,
    @SerialName("tier3_bullet_regen_post_fire_delay")
    val tier3BulletRegenPostFireDelay: Float? = null,
    @SerialName("tier1_hume_shield_amount")
    val tier1HumeShieldAmount: Float? = null,
    @SerialName("tier2_hume_shield_amount")
    val tier2HumeShieldAmount: Float? = null,
    @SerialName("tier3_hume_shield_amount")
    val tier3HumeShieldAmount: Float? = null,
    @SerialName("tier1_shield_regen_rate")
    val tier1ShieldRegenRate: Float? = null,
    @SerialName("tier2_shield_regen_rate")
    val tier2ShieldRegenRate: Float? = null,
    @SerialName("tier3_shield_regen_rate")
    val tier3ShieldRegenRate: Float? = null,
    @SerialName("tier1_shield_decay_rate")
    val tier1ShieldDecayRate: Float? = null,
    @SerialName("tier2_shield_decay_rate")
    val tier2ShieldDecayRate: Float? = null,
    @SerialName("tier3_shield_decay_rate")
    val tier3ShieldDecayRate: Float? = null,
    @SerialName("tier1_shield_on_damage_pause")
    val tier1ShieldOnDamagePause: Float? = null,
    @SerialName("tier2_shield_on_damage_pause")
    val tier2ShieldOnDamagePause: Float? = null,
    @SerialName("tier3_shield_on_damage_pause")
    val tier3ShieldOnDamagePause: Float? = null,
    val damage: Float? = null,
    @SerialName("max_barrel_ammo")
    val maxBarrelAmmo: Int? = null,
    @SerialName("max_ammo")
    val maxAmmo: Int? = null,
    @SerialName("ammo_drain")
    val ammoDrain: Int? = null,
    val penetration: Float? = null,
    val inaccuracy: Float? = null,
    @SerialName("aiming_inaccuracy")
    val aimingInaccuracy: Float? = null,
    @SerialName("damage_falloff_distance")
    val damageFalloffDistance: Float? = null,
    @SerialName("mute_voice_lines")
    val muteVoiceLines: Boolean? = null,
)