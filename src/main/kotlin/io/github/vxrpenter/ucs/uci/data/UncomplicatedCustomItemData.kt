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

package io.github.vxrpenter.ucs.uci.data

import io.github.vxrpenter.ucs.enums.secretlab.EffectType
import io.github.vxrpenter.ucs.uci.enums.ItemEvents
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UncomplicatedCustomItemData(
    //
    // AdrenalineData
    //
    val amount: Float? = null,
    val decay: Float? = null,
    val efficacy: Float? = null,
    val sustain: Float? = null,
    val persistant: Boolean? = null,
    //
    // AdrenalineData
    //


    //
    // ArmorData
    //
    @SerialName("head_protection")
    val headProtection: Int? = null,
    @SerialName("body_protection")
    val bodyProtection: Int? = null,
    @SerialName("remove_excess_on_drop")
    val removeExcessOnDrop: Boolean? = null,
    @SerialName("stamina_use_multiplier")
    val staminaUseMultiplier: Float? = null,
    @SerialName("stamina_regen_multiplier")
    val staminaRegenMultiplier: Float? = null,
    //
    // ArmorData
    //


    //
    // ExplosiveGrenadeData
    //
    @SerialName("max_radius")
    val maxRadius: Float? = null,
    @SerialName("scp_damage_multiplier")
    val scpDamageMultiplier: Float? = null,
    @SerialName("burn_duration")
    val burnDuration: Float? = null,
    @SerialName("defeat_duration")
    val deafenDuration: Float? = null,
    @SerialName("concuss_duration")
    val concussDuration: Float? = null,
    @SerialName("fuse_time")
    val fuseTime: Float? = null,
    @SerialName("pin_pull_time")
    val pinPullTIme: Float? = null,
    val repickable: Boolean? = null,
    //
    // ExplosiveGrenadeData
    //


    //
    // FlashGrenadeData
    //
    @SerialName("minimal_duration_effect")
    val minimalDurationEffect: Float? = null,
    @SerialName("additional_blinded_effect")
    val additionalBlindedEffect: Float? = null,
    @SerialName("surface_distance_intensifier")
    val surfaceDistanceIntensifier: Float? = null,
    // Here would be the value fuseTime, but it already exists above. No values can be doubled, leave it as is.
    // Here would be the value pinPullTIme, but it already exists above. No values can be doubled, leave it as is.
    // Here would be the value repickable, but it already exists above. No values can be doubled, leave it as is.
    //
    // FlashGrenadeData
    //


    //
    // ItemData
    //
    val event: ItemEvents? = null,
    val command: String? = null,
    @SerialName("cool_down")
    val coolDown: Float? = null,
    @SerialName("console_message")
    val consoleMessage: String? = null,
    @SerialName("broadcast_message")
    val broadcastMessage: String? = null,
    @SerialName("broadcast_duration")
    val broadcastDuration: Short? = null,
    @SerialName("hint_message")
    val hintMessage: String? = null,
    @SerialName("hint_duration")
    val hintDuration: Float? = null,
    @SerialName("destroy_after_use")
    val destroyAfterUse: Boolean? = null,
    //
    // ItemData
    //


    //
    // JailbirdData
    //
    @SerialName("melee_damage")
    val meleeDamage: Float? = null,
    @SerialName("charge_damage")
    val chargeDamage: Float? = null,
    @SerialName("flash_duration")
    val flashDuration: Float? = null,
    val radius: Float? = null,
    @SerialName("total_charges")
    val totalCharges: Int? = null,
    //
    // JailbirdData
    //


    //
    // KeycardData
    //
    val containment: Int? = null,
    val armory: Int? = null,
    val admin: Int? = null,
    @SerialName("tint_color")
    val tintColor: String? = null,
    @SerialName("permission_color")
    val permissionColor: String? = null,
    val name: String? = null,
    val label: String? = null,
    @SerialName("serial_number")
    val serialNumber: String? = null,
    @SerialName("wear_detail")
    val wearDetail: Byte? = null,
    @SerialName("label_color")
    val labelColor: String? = null,
    val rank: Int? = null,
    @SerialName("one_time_use")
    val oneTimeUse: Boolean? = null,
    @SerialName("one_time_use_hint")
    val oneTimeUseHint: String? = null,
    //
    // KeycardData
    //


    //
    // MedikitData
    //
    val health: Float? = null,
    @SerialName("more_than_max")
    val moreThanMax: Boolean? = null,
    //
    // MedikitData
    //


    //
    // PainkillersData
    //
    @SerialName("tick_heal")
    val tickHeal: Float? = null,
    @SerialName("time_before_start_healing")
    val timeBeforeStartHealing: Float? = null,
    @SerialName("tick_time")
    val tickTime: Float? = null,
    @SerialName("total_healing")
    val totalHealing: Float? = null,
    //
    // PainkillersData
    //


    //
    // SCP500Data
    //
    val effect: EffectType? = null,
    val duration: Float? = null,
    val intensity: Byte? = null,
    //
    // SCP500Data
    //


    //
    // SCP207Data
    //
    // Here would be the value effect, but it already exists above. No values can be doubled, leave it as is.
    // Here would be the value duration, but it already exists above. No values can be doubled, leave it as is.
    // Here would be the value intensity, but it already exists above. No values can be doubled, leave it as is.
    @SerialName("apply_207_effect")
    val apply207Effect: Boolean? = null,
    @SerialName("remove_item_after_use")
    val removeItemAfterUse: Boolean? = null,
    //
    // SCP207Data
    //


    //
    // SCP018Data
    //
    val friendlyFireTime: Float? = null,
    // Here would be the value fuseTime, but it already exists above. No values can be doubled, leave it as is.
    //
    // SCP018Data
    //


    //
    // SCP2176Data
    //
    // Here would be the value fuseTime, but it already exists above. No values can be doubled, leave it as is.
    //
    // SCP2176Data
    //


    //
    // SCP244Data
    //
    @SerialName("activation_dot")
    val activationDot: Float? = null,
    // Here would be the value health, but it already exists above. No values can be doubled, leave it as is.
    @SerialName("max_diameter")
    val maxDiameter: Float? = null,
    val primed: Boolean? = null,
    //
    // SCP244Data
    //


    //
    // SCP1853Data
    //
    // Here would be the value effect, but it already exists above. No values can be doubled, leave it as is.
    // Here would be the value duration, but it already exists above. No values can be doubled, leave it as is.
    // Here would be the value intensity, but it already exists above. No values can be doubled, leave it as is.
    val apply1853Effect: Boolean? = null,
    // Here would be the value removeItemAfterUse, but it already exists above. No values can be doubled, leave it as is.
    //
    // SCP1853Data
    //


    //
    // SCP1576Data
    //
    // Here would be the value effect, but it already exists above. No values can be doubled, leave it as is.
    // Here would be the value duration, but it already exists above. No values can be doubled, leave it as is.
    // Here would be the value intensity, but it already exists above. No values can be doubled, leave it as is.
    //
    // SCP1576Data
    //


    //
    // SCP127Data
    //
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
    //
    // SCP127Data
    //

    //
    // WeaponData
    //
    // Here would be the value damage, but it already exists above. No values can be doubled, leave it as is.
    // Here would be the value maxBarrelAmmo, but it already exists above. No values can be doubled, leave it as is.
    // Here would be the value maxAmmo, but it already exists above. No values can be doubled, leave it as is.
    @SerialName("max_magazine_amount")
    val maxMagazineAmount: Int? = null,
    // Here would be the value ammoDrain, but it already exists above. No values can be doubled, leave it as is.
    // Here would be the value penetration, but it already exists above. No values can be doubled, leave it as is.
    // Here would be the value inaccuracy, but it already exists above. No values can be doubled, leave it as is.
    // Here would be the value aimingInaccuracy, but it already exists above. No values can be doubled, leave it as is.
    // Here would be the value damageFalloffDistance, but it already exists above. No values can be doubled, leave it as is.
    val attachments: String? = null,
    @SerialName("enable_friendly_fire")
    val enableFriendlyFire: Boolean? = null
    //
    // WeaponData
    //
)