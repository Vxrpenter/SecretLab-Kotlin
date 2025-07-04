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
import io.github.vxrpenter.ucs.uci.data.customdata.UCICustomAdrenalineData
import io.github.vxrpenter.ucs.uci.data.customdata.UCICustomArmorData
import io.github.vxrpenter.ucs.uci.data.customdata.UCICustomExplosiveGrenadeData
import io.github.vxrpenter.ucs.uci.data.customdata.UCICustomFlashGrenadeData
import io.github.vxrpenter.ucs.uci.data.customdata.UCICustomItemData
import io.github.vxrpenter.ucs.uci.data.customdata.UCICustomJailbirdData
import io.github.vxrpenter.ucs.uci.data.customdata.UCICustomKeycardData
import io.github.vxrpenter.ucs.uci.data.customdata.UCICustomMedkitData
import io.github.vxrpenter.ucs.uci.data.customdata.UCICustomPainkillersData
import io.github.vxrpenter.ucs.uci.data.customdata.UCICustomScp018Data
import io.github.vxrpenter.ucs.uci.data.customdata.UCICustomScp127Data
import io.github.vxrpenter.ucs.uci.data.customdata.UCICustomScp1576Data
import io.github.vxrpenter.ucs.uci.data.customdata.UCICustomScp1853Data
import io.github.vxrpenter.ucs.uci.data.customdata.UCICustomScp207
import io.github.vxrpenter.ucs.uci.data.customdata.UCICustomScp217Data
import io.github.vxrpenter.ucs.uci.data.customdata.UCICustomScp244Data
import io.github.vxrpenter.ucs.uci.data.customdata.UCICustomScp500Data
import io.github.vxrpenter.ucs.uci.data.customdata.UCICustomWeaponData
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
    val weight: Float,
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
    val customItemData: UCICustomItemData? = null,
    @Transient
    val customKeycardData: UCICustomKeycardData? = null,
    @Transient
    val customArmorData: UCICustomArmorData? = null,
    @Transient
    val customWeaponData: UCICustomWeaponData? = null,
    @Transient
    val customMedkitDat: UCICustomMedkitData? = null,
    @Transient
    val customPainkillersData: UCICustomPainkillersData? = null,
    @Transient
    val customJailbirdData: UCICustomJailbirdData? = null,
    @Transient
    val customExplosiveGrenadeData: UCICustomExplosiveGrenadeData? = null,
    @Transient
    val customFlashGrenadeData: UCICustomFlashGrenadeData? = null,
    @Transient
    val customAdrenalineData: UCICustomAdrenalineData? = null,
    // Custom Scp Item Data Classes
    @Transient
    val customScp500Data: UCICustomScp500Data? = null,
    @Transient
    val customScp207Data: UCICustomScp207? = null,
    @Transient
    val custom018Data: UCICustomScp018Data? = null,
    @Transient
    val customScp2176Data: UCICustomScp217Data? = null,
    @Transient
    val customScp244Data: UCICustomScp244Data? = null,
    @Transient
    val customScp1853Data: UCICustomScp1853Data? = null,
    @Transient
    val customScp1576Data: UCICustomScp1576Data? = null,
    @Transient
    val customScp127Data: UCICustomScp127Data? = null,
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
    val pedestalSpawn: Boolean,
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
    val itemGlowSettings: List<UncomplicatedCustomItemGlowSettings>,
    @SerialName("life_steal_settings")
    val lifeStealSettings: List<UncomplicatedCustomItemLifeStealSettings>,
    @SerialName("effect_settings")
    val effectSettings: List<UncomplicatedCustomItemEffectSettings>,
    @SerialName("audio_settings")
    val audioSettings: List<UncomplicatedCustomItemAudioSettings>,
    @SerialName("explosive_bullets_settings")
    val explosiveBulletsSettings: List<UncomplicatedCustomItemExplosiveBulletsSettings>,
    @SerialName("spawn_item_when_detonated_settings")
    val spawnItemWhenDetonatedSettings: List<UncomplicatedCustomItemSpawnItemWhenDetonatedSettings>,
    @SerialName("cluster_settings")
    val clusterSettings: List<UncomplicatedCustomItemClusterSettings>,
    @SerialName("switch_role_on_use_settings")
    val switchRoleOnUseSettings: List<UncomplicatedCustomItemSwitchRoleOnUseSettings>,
    @SerialName("die_on_drop_settings")
    val dieOnDropSettings: List<UncomplicatedCustomItemDieOnDropSettings>,
    @SerialName("cant_drop_settings")
    val cantDropSettings: List<UncomplicatedCustomItemCantDropSettings>,
    @SerialName("disguise_settings")
    val disguiseSettings: List<UncomplicatedCustomItemDisguiseSettings>,
    @SerialName("craftable_settings")
    val craftableSettings: List<UncomplicatedCustomItemCraftableSettings>,
    @SerialName("die_on_use_settings")
    val dieOnUseSettings: List<UncomplicatedCustomItemDieOnUseSettings>,
    @SerialName("heal_on_kill_settings")
    val healOnKillSettings: List<UncomplicatedCustomItemHealOnKillSettings>,
)