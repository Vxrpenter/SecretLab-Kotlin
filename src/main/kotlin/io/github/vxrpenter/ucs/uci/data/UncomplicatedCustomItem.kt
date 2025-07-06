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
import io.github.vxrpenter.ucs.enums.secretlab.RoomType
import io.github.vxrpenter.ucs.enums.secretlab.ZoneType
import io.github.vxrpenter.ucs.uci.data.customdata.*
import io.github.vxrpenter.ucs.uci.enums.CustomItemType
import io.github.vxrpenter.ucs.uci.enums.UCIItemType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This data class contains a full Serializer for UncomplicatedCustomItems, the plugin is licenced
 * under the AGPL-3.0 License and can be found on GitHub.
 *
 * @see <a href="https://github.com/UncomplicatedCustomServer/UncomplicatedCustomItems">
 * @since 0.5.0
 * @author Vxrpenter
 */
@Serializable
data class UncomplicatedCustomItem(
    /**
     * The role's unique identification number. Only a single number can correlate to a single custom item!
     */
    val id: Int,
    /**
     * The custom item's name, appearing when picking it up or in the inventory.
     */
    val name: String,
    /**
     *  The custom item's description.
     */
    val description: String,
    /**
     * The custom item's badge.
     */
    @SerialName("badge_name")
    val badgeName: String,
    /**
     * The custom item's badge color.
     */
    @SerialName("badge_color")
    val badgeColor: String,
    /**
     * Defines the weight of the custom item.
     */
    val weight: Float? = null,
    /**
     * Defines if the custom item is removed from the player inventory after usage.
     * This only applies to items of the consumable type.
     */
    val reusable: Boolean? = null,
    /**
     * The custom item's base item type.
     *
     * @see UCIItemType
     */
    val item: UCIItemType,
    /**
     * The scale of the custom item, e.g. when dropped. Set each value to 0 to disable it.
     *
     * @see Vector3
     */
    val scale: Vector3,
    /**
     * The custom item's spawn data.
     *
     * @see UncomplicatedCustomItemSpawn
     */
    val spawn: UncomplicatedCustomItemSpawn,
    @SerialName("custom_flags")
    /**
     * A scalar of the custom item's custom flags. The scalar types can be found in the following enum.
     *
     * @see io.github.vxrpenter.ucs.uci.enums.CustomFlags
     */
    val customFlags: YamlScalar,
    /**
     * The custom item's flag settings.
     *
     * @see UncomplicatedCustomItemFlagSettings
     */
    @SerialName("flag_settings")
    val flagSettings: UncomplicatedCustomItemFlagSettings,
    /**
     * The custom item's custom item type.
     *
     * @see CustomItemType
     */
    @SerialName("custom_item_type")
    val customItemType: CustomItemType,
    // Custom Item Data Classes
    /**
     * **WARNING:** This value is dependent on the [CustomItemType.ITEM].
     * It will always be null, unless the appropriate [CustomItemType] is given,
     * or the [customData], not being available.
     *
     * The custom item's custom item data.
     *
     * @see UCICustomItemData
     */
    @Transient
    var customItemData: UCICustomItemData? = null,
    /**
     * **WARNING:** This value is dependent on the [CustomItemType.KEYCARD].
     * It will always be null, unless the appropriate [CustomItemType] is given,
     * or the [customData], not being available.
     *
     * The custom item's custom keycard data.
     *
     * @see UCICustomKeycardData
     */
    @Transient
    var customKeycardData: UCICustomKeycardData? = null,
    /**
     * **WARNING:** This value is dependent on the [CustomItemType.ARMOR].
     * It will always be null, unless the appropriate [CustomItemType] is given,
     * or the [customData], not being available.
     *
     * The custom item's custom armor data.
     *
     * @see UCICustomArmorData
     */
    @Transient
    var customArmorData: UCICustomArmorData? = null,
    /**
     * **WARNING:** This value is dependent on the [CustomItemType.WEAPON].
     * It will always be null, unless the appropriate [CustomItemType] is given,
     * or the [customData], not being available.
     *
     * The custom item's custom weapon data.
     *
     * @see UCICustomWeaponData
     */
    @Transient
    var customWeaponData: UCICustomWeaponData? = null,
    /**
     * **WARNING:** This value is dependent on the [CustomItemType.MEDKIT].
     * It will always be null, unless the appropriate [CustomItemType] is given,
     * or the [customData], not being available.
     *
     * The custom item's custom medkit data.
     *
     * @see UCICustomMedkitData
     */
    @Transient
    var customMedkitDat: UCICustomMedkitData? = null,
    /**
     * **WARNING:** This value is dependent on the [CustomItemType.PAINKILLERS].
     * It will always be null, unless the appropriate [CustomItemType] is given,
     * or the [customData], not being available.
     *
     * The custom item's custom painkiller data.
     *
     * @see UCICustomPainkillersData
     */
    @Transient
    var customPainkillersData: UCICustomPainkillersData? = null,
    /**
     * **WARNING:** This value is dependent on the [CustomItemType.JAILBIRD].
     * It will always be null, unless the appropriate [CustomItemType] is given,
     * or the [customData], not being available.
     *
     * The custom item's custom jailbird data.
     *
     * @see UCICustomJailbirdData
     */
    @Transient
    var customJailbirdData: UCICustomJailbirdData? = null,
    /**
     * **WARNING:** This value is dependent on the [CustomItemType.EXPLOSIVE_GRENADE].
     * It will always be null, unless the appropriate [CustomItemType] is given,
     * or the [customData], not being available.
     *
     * The custom item's custom explosive grenade data.
     *
     * @see UCICustomExplosiveGrenadeData
     */
    @Transient
    var customExplosiveGrenadeData: UCICustomExplosiveGrenadeData? = null,
    /**
     * **WARNING:** This value is dependent on the [CustomItemType.FLASH_GRENADE].
     * It will always be null, unless the appropriate [CustomItemType] is given,
     * or the [customData], not being available.
     *
     * The custom item's custom flash grenade data.
     *
     * @see UCICustomFlashGrenadeData
     */
    @Transient
    var customFlashGrenadeData: UCICustomFlashGrenadeData? = null,
    /**
     * **WARNING:** This value is dependent on the [CustomItemType.ADRENALINE].
     * It will always be null, unless the appropriate [CustomItemType] is given,
     * or the [customData], not being available.
     *
     * The custom item's custom adrenaline data.
     *
     * @see UCICustomAdrenalineData
     */
    @Transient
    var customAdrenalineData: UCICustomAdrenalineData? = null,
    // Custom Scp Item Data Classes
    /**
     * **WARNING:** This value is dependent on the [CustomItemType.SCP_ITEM] type, also on the [UCIItemType.SCP500].
     * It will always be null, unless the appropriate [CustomItemType] (or [UCIItemType]) is given,
     * or the [customData], not being available.
     *
     * The custom item's custom Scp500 data.
     *
     * @see UCICustomScp500Data
     */
    @Transient
    var customScp500Data: UCICustomScp500Data? = null,
    /**
     * **WARNING:** This value is dependent on the [CustomItemType.SCP_ITEM] type, also on the [UCIItemType.SCP207].
     * It will always be null, unless the appropriate [CustomItemType] (or [UCIItemType]) is given,
     * or the [customData], not being available.
     *
     * The custom item's custom Scp207 data.
     *
     * @see UCICustomScp207
     */
    @Transient
    var customScp207Data: UCICustomScp207? = null,
    /**
     * **WARNING:** This value is dependent on the [CustomItemType.SCP_ITEM] type, also on the [UCIItemType.SCP018].
     * It will always be null, unless the appropriate [CustomItemType] (or [UCIItemType]) is given,
     * or the [customData], not being available.
     *
     * The custom item's custom Scp018 data.
     *
     * @see UCICustomScp018Data
     */
    @Transient
    var customScp018Data: UCICustomScp018Data? = null,
    /**
     * **WARNING:** This value is dependent on the [CustomItemType.SCP_ITEM] type, also on the [UCIItemType.SCP2176].
     * It will always be null, unless the appropriate [CustomItemType] (or [UCIItemType]) is given,
     * or the [customData], not being available.
     *
     * The custom item's custom Scp2176 data.
     *
     * @see UCICustomScp217Data
     */
    @Transient
    var customScp2176Data: UCICustomScp217Data? = null,
    /**
     * **WARNING:** This value is dependent on the [CustomItemType.SCP_ITEM] type,
     * also on the [UCIItemType.SCP244a] or [UCIItemType.SCP244b].
     * It will always be null, unless the appropriate [CustomItemType] (or [UCIItemType]) is given,
     * or the [customData], not being available.
     *
     * The custom item's custom Scp244 data.
     *
     * @see UCICustomScp244Data
     */
    @Transient
    var customScp244Data: UCICustomScp244Data? = null,
    /**
     * **WARNING:** This value is dependent on the [CustomItemType.SCP_ITEM] type, also on the [UCIItemType.SCP1853].
     * It will always be null, unless the appropriate [CustomItemType] (or [UCIItemType]) is given,
     * or the [customData], not being available.
     *
     * The custom item's custom Scp1853 data.
     *
     * @see UCICustomScp1853Data
     */
    @Transient
    var customScp1853Data: UCICustomScp1853Data? = null,
    /**
     * **WARNING:** This value is dependent on the [CustomItemType.SCP_ITEM] type, also on the [UCIItemType.SCP1576].
     * It will always be null, unless the appropriate [CustomItemType] (or [UCIItemType]) is given,
     * or the [customData], not being available.
     *
     * The custom item's custom Scp1576 data.
     *
     * @see UCICustomScp1576Data
     */
    @Transient
    var customScp1576Data: UCICustomScp1576Data? = null,
    /**
     * **WARNING:** This value is dependent on the [CustomItemType.SCP_ITEM] type, also on the [UCIItemType.GUN_SCP127].
     * It will always be null, unless the appropriate [CustomItemType] (or [UCIItemType]) is given,
     * or the [customData], not being available.
     *
     * The custom item's custom Scp127 data.
     *
     * @see UCICustomScp127Data
     */
    @Transient
    var customScp127Data: UCICustomScp127Data? = null,
    // Custom Item Data
    @SerialName("custom_data")
    /**
     * **WARNING** This value requires an OptIn:
     * ```kotlin
     * import io.github.vxrpenter.ucs.uci.data.CustomItemData
     * @OptIn(CustomItemData::class)
     * ```
     *
     * The custom item's custom data.
     * This value will not be returned by default, by any serializer function.
     * You can set the `returnRawUCICustomData` to true to return this value.
     */
    @OptIn(CustomItemData::class)
    var customData: UncomplicatedCustomItemData? = null,
)

/**
 * Defines the spawn of the custom item.
 */
@Serializable
data class UncomplicatedCustomItemSpawn(
    /**
     * Determines if the custom item is able to spawn.
     */
    @SerialName("do_spawn")
    val doSpawn: Boolean,
    /**
     * The amount of custom item's to be spawned.
     */
    val count: Int,
    /**
     * Defines if the custom item should spawn in an SCP Pedestal.
     * If this value is false, [coords] will be used instead.
     */
    @SerialName("pedestal_spawn")
    val pedestalSpawn: Boolean? = null,
    /**
     * The custom item's spawn coordinates.
     *
     * @see Vector3
     */
    val coords: List<Vector3>,
    /**
     * The custom item's possible spawn rooms.
     * (automatically fins the correct spawn location).
     * If this is empty, [zones] will be used instead.
     *
     * @see UncomplicatedCustomItemDynamicSpawn
     */
    @SerialName("dynamic_spawn")
    val dynamicSpawn: List<UncomplicatedCustomItemDynamicSpawn>,
    /**
     * A list of zones the custom item can be spawned in.
     *
     * @see ZoneType
     */
    val zones: List<ZoneType>,
    /**
     * Defines if the custom item should replace an already existing pickup (ingame item).
     */
    @SerialName("replace_existing_pickup")
    val replaceExistingPickup: Boolean,
    /**
     * Defines if the custom item should only replace an already existing pickup of the same [UCIItemType].
     */
    @SerialName("force_item")
    val forceItem: Boolean,
    /**
     * Defines if the custom item should replace item's already spawned in pedestals.
     */
    @SerialName("replace_items_in_pedestals")
    val replaceItemsInPedestals: Boolean? = null
)

/**
 * Defines the custom item's dynamic spawn.
 */
@Serializable
data class UncomplicatedCustomItemDynamicSpawn(
    /**
     * The custom item's spawn room
     */
    val room: RoomType,
    /**
     * The chance to spawn the custom item in the spawn room.
     */
    val chance: Int,
    /**
     * The coordinates to spawn the custom item (inside the room) at.
     */
    val coords: Vector3? = null
)

/**
 * Defines the custom item's flag settings.
 */
@Serializable
data class UncomplicatedCustomItemFlagSettings(
    /**
     * The custom item's glow settings.
     *
     * @see UncomplicatedCustomItemGlowSettings
     */
    @SerialName("item_glow_settings")
    val itemGlowSettings: List<UncomplicatedCustomItemGlowSettings>? = null,
    /**
     * The custom item's life steal settings.
     *
     * @see UncomplicatedCustomItemLifeStealSettings
     */
    @SerialName("life_steal_settings")
    val lifeStealSettings: List<UncomplicatedCustomItemLifeStealSettings>? = null,
    /**
     * The custom item's effect settings.
     *
     * @see UncomplicatedCustomItemEffectSettings
     */
    @SerialName("effect_settings")
    val effectSettings: List<UncomplicatedCustomItemEffectSettings>? = null,
    /**
     * The custom item's audio settings.
     *
     * @see UncomplicatedCustomItemAudioSettings
     */
    @SerialName("audio_settings")
    val audioSettings: List<UncomplicatedCustomItemAudioSettings>? = null,
    /**
     * The custom item's explosive bullets settings.
     *
     * @see UncomplicatedCustomItemExplosiveBulletsSettings
     */
    @SerialName("explosive_bullets_settings")
    val explosiveBulletsSettings: List<UncomplicatedCustomItemExplosiveBulletsSettings>? = null,
    /**
     * The custom item's spawn item when detonated settings.
     *
     * @see UncomplicatedCustomItemSpawnItemWhenDetonatedSettings
     */
    @SerialName("spawn_item_when_detonated_settings")
    val spawnItemWhenDetonatedSettings: List<UncomplicatedCustomItemSpawnItemWhenDetonatedSettings>? = null,
    /**
     * The custom item's cluster settings.
     *
     * @see UncomplicatedCustomItemClusterSettings
     */
    @SerialName("cluster_settings")
    val clusterSettings: List<UncomplicatedCustomItemClusterSettings>? = null,
    /**
     * The custom item's switch role on use settings.
     *
     * @see UncomplicatedCustomItemSwitchRoleOnUseSettings
     */
    @SerialName("switch_role_on_use_settings")
    val switchRoleOnUseSettings: List<UncomplicatedCustomItemSwitchRoleOnUseSettings>? = null,
    /**
     * The custom item's die on drop settings.
     *
     * @see UncomplicatedCustomItemDieOnDropSettings
     */
    @SerialName("die_on_drop_settings")
    val dieOnDropSettings: List<UncomplicatedCustomItemDieOnDropSettings>? = null,
    /**
     * The custom item's cant drop settings.
     *
     * @see UncomplicatedCustomItemCantDropSettings
     */
    @SerialName("cant_drop_settings")
    val cantDropSettings: List<UncomplicatedCustomItemCantDropSettings>? = null,
    /**
     * The custom item's disguise settings.
     *
     * @see UncomplicatedCustomItemDisguiseSettings
     */
    @SerialName("disguise_settings")
    val disguiseSettings: List<UncomplicatedCustomItemDisguiseSettings>? = null,
    /**
     * The custom item's craftable settings.
     *
     * @see UncomplicatedCustomItemCraftableSettings
     */
    @SerialName("craftable_settings")
    val craftableSettings: List<UncomplicatedCustomItemCraftableSettings>? = null,
    /**
     * The custom item's die on use settings.
     *
     * @see UncomplicatedCustomItemDieOnUseSettings
     */
    @SerialName("die_on_use_settings")
    val dieOnUseSettings: List<UncomplicatedCustomItemDieOnUseSettings>? = null,
    /**
     * The custom item's heal on kill settings.
     *
     * @see UncomplicatedCustomItemHealOnKillSettings
     */
    @SerialName("heal_on_kill_settings")
    val healOnKillSettings: List<UncomplicatedCustomItemHealOnKillSettings>? = null,
)