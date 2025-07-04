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
import io.github.vxrpenter.ucs.enums.secretlab.ItemType
import io.github.vxrpenter.ucs.enums.secretlab.RoleSpawnFlags
import io.github.vxrpenter.ucs.enums.secretlab.RoleType
import io.github.vxrpenter.ucs.enums.secretlab.Scp914KnobSetting
import io.github.vxrpenter.ucs.uci.enums.EffectEvent
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UncomplicatedCustomItemGlowSettings(
    @SerialName("glow_color")
    val glowColor: String
)

@Serializable
data class UncomplicatedCustomItemLifeStealSettings(
    @SerialName("life_steal_amount")
    val lifeStealAmount: Float,
    @SerialName("life_steal_percentage")
    val lifeStealPercentage: Float
)

@Serializable
data class UncomplicatedCustomItemEffectSettings(
    @SerialName("effect_event")
    val effectEvent: EffectEvent? = null,
    val effect: EffectType,
    @SerialName("effect_intensity")
    val effectIntensity: Byte,
    @SerialName("effect_duration")
    val effectDuration: Float,
    @SerialName("add_duration_if_active")
    val addDurationIfActive: Boolean? = null
)

@Serializable
data class UncomplicatedCustomItemAudioSettings(
    @SerialName("audio_path")
    val audioPath: String? = null,
    @SerialName("audible_distance")
    val audibleDistance: Float? = null,
    @SerialName("sound_volume")
    val soundVolume: Float? = null,
)

@Serializable
data class UncomplicatedCustomItemExplosiveBulletsSettings(
    @SerialName("damage_radius")
    val damageRadius: Float? = null
)

@Serializable
data class UncomplicatedCustomItemSpawnItemWhenDetonatedSettings(
    @SerialName("item_type")
    val itemType: ItemType? = null,
    @SerialName("item_id")
    val itemId: Int? = null,
    @SerialName("time_till_despawn")
    val timeTillDespawn: Float? = null,
    val chance: Int? = null,
    val pickupable: Boolean? = null
)

@Serializable
data class UncomplicatedCustomItemClusterSettings(
    @SerialName("item_to_spawn")
    val itemToSpawn: ItemType,
    @SerialName("amount_to_spawn")
    val amountToSpawn: Int? = null,
    @SerialName("scp_damage_multiplier")
    val scpDamageMultiplier: Float? = null,
    @SerialName("fuse_time")
    val fuseTime: Float? = null
)

@Serializable
data class UncomplicatedCustomItemSwitchRoleOnUseSettings(
    val delay: Float? = null,
    @SerialName("role_type")
    val roleType: RoleType? = null,
    @SerialName("role_id")
    val roleId: Int? = null,
    @SerialName("spawn_flags")
    val spawnFlags: RoleSpawnFlags? = null,
    @SerialName("keep_location")
    val keepLocation: Boolean? = null
)

@Serializable
data class UncomplicatedCustomItemDieOnDropSettings(
    @SerialName("death_message")
    val deathMessage: String? = null,
    val vaporize: Boolean? = null
)

@Serializable
data class UncomplicatedCustomItemCantDropSettings(
    @SerialName("hint_or_broadcast")
    val hintOrBroadcast: String? = null,
    val message: String? = null,
    val duration: Short? = null
)

@Serializable
data class UncomplicatedCustomItemDisguiseSettings(
    @SerialName("role_id")
    val roleId: RoleType? = null,
    @SerialName("disguise_message")
    val disguiseMessage: String? = null
)

@Serializable
data class UncomplicatedCustomItemCraftableSettings(
    @SerialName("knob_setting")
    val knobSetting: Scp914KnobSetting? = null,
    @SerialName("original_item")
    val originalItem: ItemType? = null,
    val chance: Int? = null
)

@Serializable
data class UncomplicatedCustomItemDieOnUseSettings(
    @SerialName("death_message")
    val deathMessage: String? = null,
    val vaporize: Boolean? = null
)

@Serializable
data class UncomplicatedCustomItemHealOnKillSettings(
    @SerialName("heal_amount")
    val healAmount: Float? = null,
    @SerialName("convert_to_ahp_if_full")
    val convertToAhpIfFull: Boolean? = null
)