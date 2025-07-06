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

/**
 * Defines the custom item's Scp500 custom data
 */
@Serializable
data class UCICustomScp500Data(
    /**
     * The effect applied by the custom item.
     *
     * @see EffectType
     */
    val effect: EffectType,
    /**
     * The duration of the effect applied by the custom item.
     */
    val duration: Float,
    /**
     * The intensity of the effect applied by the custom item.
     */
    val intensity: Byte,
)

/**
 * Defines the custom item's Scp207 custom data
 */
@Serializable
data class UCICustomScp207(
    /**
     * The effect applied by the custom item.
     *
     * @see EffectType
     */
    val effect: EffectType,
    /**
     * The duration of the effect applied by the custom item.
     */
    val duration: Float,
    /**
     * The intensity of the effect applied by the custom item.
     */
    val intensity: Byte,
    /**
     * Defines if the [EffectType.SCP207] will be applied.
     */
    @SerialName("apply207_effect")
    val apply207Effect: Boolean,
    /**
     * Defines if the item should be removed from the holder inventory after usage.
     */
    @SerialName("remove_item_after_use")
    val removeItemAfterUse: Boolean? = null,
)

/**
 * Defines the custom item's Scp018 custom data
 */
@Serializable
data class UCICustomScp018Data(
    /**
     * The time of friendly fire.
     */
    @SerialName("friendly_fire_time")
    val friendlyFireTime: Float,
    /**
     * Time until Scp018 starts bouncing.
     */
    @SerialName("fuse_time")
    val fuseTime: Float,
)

/**
 * Defines the custom item's Scp217 custom data
 */
@Serializable
data class UCICustomScp217Data(
    /**
     * The fuse time.
     */
    @SerialName("fuse_time")
    val fuseTime: Float,
)

/**
 * Defines the custom item's Scp244 custom data
 */
@Serializable
data class UCICustomScp244Data(
    /**
     * The time it takes to pull the dot out of Scp244.
     */
    @SerialName("activation_dot")
    val activationDot: Float,
    /**
     * The health that Scp244 will remove.
     */
    val health: Float,
    /**
     * The range of Scp244.
     */
    @SerialName("max_diameter")
    val maxDiameter: Float,
    /**
     * Defines if Scp244 is primed.
     */
    val primed: Boolean,
)

/**
 * Defines the custom item's Scp1853 custom data
 */
@Serializable
data class UCICustomScp1853Data(
    /**
     * The effect applied by the custom item.
     *
     * @see EffectType
     */
    val effect: EffectType,
    /**
     * The duration of the effect applied by the custom item.
     */
    val duration: Float,
    /**
     * The intensity of the effect applied by the custom item.
     */
    val intensity: Byte,
    /**
     * Defines if the [EffectType.SCP1853] will be applied.
     */
    @SerialName("apply1853_effect")
    val apply1853Effect: Boolean,
    /**
     * Defines if the item should be removed from the holder inventory after usage.
     */
    @SerialName("remove_item_after_use")
    val removeItemAfterUse: Boolean,
)

/**
 * Defines the custom item's Scp1576 custom data
 */
@Serializable
data class UCICustomScp1576Data(
    /**
     * The effect applied by the custom item.
     *
     * @see EffectType
     */
    val effect: EffectType,
    /**
     * The duration of the effect applied by the custom item.
     */
    val duration: Float,
    /**
     * The intensity of the effect applied by the custom item.
     */
    val intensity: Byte,
)

/**
 * Defines the custom item's Scp127 custom data
 */
@Serializable
data class UCICustomScp127Data(
    /**
     * Defines if hume shield should be applied.
     */
    @SerialName("give_hume_shield")
    val giveHumeShield: Boolean,
    /**
     * The fire rate on tier 1.
     */
    @SerialName("tier1_bullet_fire_rate")
    val tier1BulletFireRate: Float,
    /**
     * The fire rate on tier 2.
     */
    @SerialName("tier2_bullet_fire_rate")
    val tier2BulletFireRate: Float,
    /**
     * The fire rate on tier 3.
     */
    @SerialName("tier3_bullet_fire_rate")
    val tier3BulletFireRate: Float,
    /**
     * The bullet regen rate on tier 1.
     */
    @SerialName("tier1_bullet_regen_rate")
    val tier1BulletRegenRate: Float,
    /**
     * The bullet regen rate on tier 2.
     */
    @SerialName("tier2_bullet_regen_rate")
    val tier2BulletRegenRate: Float,
    /**
     * The bullet regen rate on tier 3.
     */
    @SerialName("tier3_bullet_regen_rate")
    val tier3BulletRegenRate: Float,
    /**
     * The bullet regen post fire delay on tier 1.
     */
    @SerialName("tier1_bullet_regen_post_fire_delay")
    val tier1BulletRegenPostFireDelay: Float,
    /**
     * The bullet regen post fire delay on tier 2.
     */
    @SerialName("tier2_bullet_regen_post_fire_delay")
    val tier2BulletRegenPostFireDelay: Float,
    /**
     * The bullet regen post fire delay on tier 3.
     */
    @SerialName("tier3_bullet_regen_post_fire_delay")
    val tier3BulletRegenPostFireDelay: Float,
    /**
     * The hume shield amount on tier 1.
     */
    @SerialName("tier1_hume_shield_amount")
    val tier1HumeShieldAmount: Float,
    /**
     * The hume shield amount on tier 2.
     */
    @SerialName("tier2_hume_shield_amount")
    val tier2HumeShieldAmount: Float,
    /**
     * The hume shield amount on tier 3.
     */
    @SerialName("tier3_hume_shield_amount")
    val tier3HumeShieldAmount: Float,
    /**
     * The shield regen rate on tier 1.
     */
    @SerialName("tier1_shield_regen_rate")
    val tier1ShieldRegenRate: Float,
    /**
     * The shield regen rate on tier 2.
     */
    @SerialName("tier2_shield_regen_rate")
    val tier2ShieldRegenRate: Float,
    /**
     * The shield regen rate on tier 3.
     */
    @SerialName("tier3_shield_regen_rate")
    val tier3ShieldRegenRate: Float,
    /**
     * The shield decay rate on tier 1.
     */
    @SerialName("tier1_shield_decay_rate")
    val tier1ShieldDecayRate: Float,
    /**
     * The shield decay rate on tier 2.
     */
    @SerialName("tier2_shield_decay_rate")
    val tier2ShieldDecayRate: Float,
    /**
     * The shield decay rate on tier 3.
     */
    @SerialName("tier3_shield_decay_rate")
    val tier3ShieldDecayRate: Float,
    /**
     * The shield on damage pause on tier 1.
     */
    @SerialName("tier1_shield_on_damage_pause")
    val tier1ShieldOnDamagePause: Float,
    /**
     * The shield on damage pause on tier 2.
     */
    @SerialName("tier2_shield_on_damage_pause")
    val tier2ShieldOnDamagePause: Float,
    /**
     * The shield on damage pause on tier 3.
     */
    @SerialName("tier3_shield_on_damage_pause")
    val tier3ShieldOnDamagePause: Float,
    /**
     * The damage applied by Scp127.
     */
    val damage: Float,
    /**
     * The maximum barrel ammo of Scp127.
     */
    @SerialName("max_barrel_ammo")
    val maxBarrelAmmo: Int,
    /**
     * The max ammo of Scp127.
     */
    @SerialName("max_ammo")
    val maxAmmo: Int,
    /**
     * The max magazine ammo of Scp127.
     */
    @SerialName("max_magazine_ammo")
    val maxMagazineAmmo: Int,
    /**
     * The ammo drained by Scp127.
     */
    @SerialName("ammo_drain")
    val ammoDrain: Int,
    /**
     * The penetration of Scp127.
     */
    val penetration: Float,
    /**
     * The inaccuracy of Scp127.
     */
    val inaccuracy: Float,
    /**
     * The aiming inaccuracy of Scp127.
     */
    @SerialName("aiming_inaccuracy")
    val aimingInaccuracy: Float,
    /**
     * The damage falloff of Scp127.
     */
    @SerialName("damage_falloff_distance")
    val damageFalloffDistance: Float,
    /**
     * Defines if the Scp127 voicelines should be muted.
     */
    @SerialName("mute_voice_lines")
    val muteVoiceLines: Boolean,
)