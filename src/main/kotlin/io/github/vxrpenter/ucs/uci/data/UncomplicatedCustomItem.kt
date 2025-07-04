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

import com.charleskorn.kaml.YamlScalar
import io.github.vxrpenter.ucs.data.Vector3
import io.github.vxrpenter.ucs.enums.secretlab.ItemType
import io.github.vxrpenter.ucs.enums.secretlab.RoomType
import io.github.vxrpenter.ucs.enums.secretlab.ZoneType
import io.github.vxrpenter.ucs.uci.data.customdata.*
import io.github.vxrpenter.ucs.uci.enums.CustomItemType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UncomplicatedCustomItem(
    val id: Int,
    val name: String,
    val description: String,
    @SerialName("badge_name")
    val badgeName: String,
    @SerialName("badge_color")
    val badgeColor: String,
    val weight: Float? = null,
    val reusable: Boolean? = null,
    val item: ItemType,
    val scale: Vector3,
    val spawn: UncomplicatedCustomItemSpawn,
    @SerialName("custom_flags")
    val customFlags: YamlScalar,
    @SerialName("flag_settings")
    val flagSettings: UncomplicatedCustomItemFlagSettings,
    @SerialName("custom_item_type")
    val customItemType: CustomItemType,
    // Custom Item Data Classes
    @Transient
    var customItemData: UCICustomItemData? = null,
    @Transient
    var customKeycardData: UCICustomKeycardData? = null,
    @Transient
    var customArmorData: UCICustomArmorData? = null,
    @Transient
    var customWeaponData: UCICustomWeaponData? = null,
    @Transient
    var customMedkitDat: UCICustomMedkitData? = null,
    @Transient
    var customPainkillersData: UCICustomPainkillersData? = null,
    @Transient
    var customJailbirdData: UCICustomJailbirdData? = null,
    @Transient
    var customExplosiveGrenadeData: UCICustomExplosiveGrenadeData? = null,
    @Transient
    var customFlashGrenadeData: UCICustomFlashGrenadeData? = null,
    @Transient
    var customAdrenalineData: UCICustomAdrenalineData? = null,
    // Custom Scp Item Data Classes
    @Transient
    var customScp500Data: UCICustomScp500Data? = null,
    @Transient
    var customScp207Data: UCICustomScp207? = null,
    @Transient
    var customScp018Data: UCICustomScp018Data? = null,
    @Transient
    var customScp2176Data: UCICustomScp217Data? = null,
    @Transient
    var customScp244Data: UCICustomScp244Data? = null,
    @Transient
    var customScp1853Data: UCICustomScp1853Data? = null,
    @Transient
    var customScp1576Data: UCICustomScp1576Data? = null,
    @Transient
    var customScp127Data: UCICustomScp127Data? = null,
    // Custom Item Data
    @SerialName("custom_data")
    val customData: UncomplicatedCustomItemData,
)

@Serializable
data class UncomplicatedCustomItemSpawn(
    @SerialName("do_spawn")
    val doSpawn: Boolean,
    val count: Int,
    @SerialName("pedestal_spawn")
    val pedestalSpawn: Boolean? = null,
    val coords: List<Vector3>,
    @SerialName("dynamic_spawn")
    val dynamicSpawn: List<UncomplicatedCustomItemDynamicSpawn>,
    val zones: List<ZoneType>,
    @SerialName("replace_existing_pickup")
    val replaceExistingPickup: Boolean,
    @SerialName("force_item")
    val forceItem: Boolean,
    @SerialName("replace_items_in_pedestals")
    val replaceItemsInPedestals: Boolean? = null
)

@Serializable
data class UncomplicatedCustomItemDynamicSpawn(
    val room: RoomType,
    val chance: Int,
    val coords: Vector3? = null
)

@Serializable
data class UncomplicatedCustomItemFlagSettings(
    @SerialName("item_glow_settings")
    val itemGlowSettings: List<UncomplicatedCustomItemGlowSettings>? = null,
    @SerialName("life_steal_settings")
    val lifeStealSettings: List<UncomplicatedCustomItemLifeStealSettings>? = null,
    @SerialName("effect_settings")
    val effectSettings: List<UncomplicatedCustomItemEffectSettings>? = null,
    @SerialName("audio_settings")
    val audioSettings: List<UncomplicatedCustomItemAudioSettings>? = null,
    @SerialName("explosive_bullets_settings")
    val explosiveBulletsSettings: List<UncomplicatedCustomItemExplosiveBulletsSettings>? = null,
    @SerialName("spawn_item_when_detonated_settings")
    val spawnItemWhenDetonatedSettings: List<UncomplicatedCustomItemSpawnItemWhenDetonatedSettings>? = null,
    @SerialName("cluster_settings")
    val clusterSettings: List<UncomplicatedCustomItemClusterSettings>? = null,
    @SerialName("switch_role_on_use_settings")
    val switchRoleOnUseSettings: List<UncomplicatedCustomItemSwitchRoleOnUseSettings>? = null,
    @SerialName("die_on_drop_settings")
    val dieOnDropSettings: List<UncomplicatedCustomItemDieOnDropSettings>? = null,
    @SerialName("cant_drop_settings")
    val cantDropSettings: List<UncomplicatedCustomItemCantDropSettings>? = null,
    @SerialName("disguise_settings")
    val disguiseSettings: List<UncomplicatedCustomItemDisguiseSettings>? = null,
    @SerialName("craftable_settings")
    val craftableSettings: List<UncomplicatedCustomItemCraftableSettings>? = null,
    @SerialName("die_on_use_settings")
    val dieOnUseSettings: List<UncomplicatedCustomItemDieOnUseSettings>? = null,
    @SerialName("heal_on_kill_settings")
    val healOnKillSettings: List<UncomplicatedCustomItemHealOnKillSettings>? = null,
)