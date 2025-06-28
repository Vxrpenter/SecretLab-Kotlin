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

package io.github.vxrpenter.ucs.ucr.data

import io.github.vxrpenter.ucs.enums.Color
import io.github.vxrpenter.ucs.enums.CustomFlags
import io.github.vxrpenter.ucs.enums.EffectType
import io.github.vxrpenter.ucs.enums.ItemType
import io.github.vxrpenter.ucs.enums.RoleType
import io.github.vxrpenter.ucs.enums.RoomType
import io.github.vxrpenter.ucs.enums.SpawnType
import io.github.vxrpenter.ucs.enums.Team
import io.github.vxrpenter.ucs.enums.ZoneType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UncomplicatedCustomRole(
    val id: Int,
    val name: String,
    @SerialName("override_role_name")
    val overrideRoleName: Boolean,
    val nickname: String? = null,
    @SerialName("custom_info")
    val customInfo: String? = null,
    @SerialName("badge_name")
    val badgeName: String? = null,
    @SerialName("badge_color")
    val badgeColor: Color? = null,
    val role: RoleType,
    val team: Team? = null,
    @SerialName("role_appearance")
    val roleAppearance: RoleType? = null,
    @SerialName("is_friend_of")
    val isFriendOf: List<Team>,
    val health: UncomplicatedCustomRoleHealth,
    val ahp: UncomplicatedCustomRoleAhp,
    @SerialName("hume_shield")
    val humeShield: UncomplicatedCustomRoleHumeShield,
    val effects: List<UncomplicatedCustomRoleEffect>,
    val stamina: UncomplicatedCustomRoleStamina,
    @SerialName("max_scp330_candies")
    val maxScp330Candies: Int,
    @SerialName("can_escape")
    val canEscape: Boolean,
    @SerialName("role_after_escape")
    val roleAfterEscape: HashMap<String, String>,
    val scale: UncomplicatedCustomRoleScale,
    @SerialName("spawn_broadcast")
    val spawnBroadcast: String,
    @SerialName("spawn_broadcast_duration")
    val spawnBroadcastDuration: Short,
    @SerialName("spawn_hint")
    val spawnHint: String,
    @SerialName("spawn_hint_duration")
    val spawnHintDuration: Float,
    @SerialName("custom_inventory_limits")
    val customInventoryLimits: UncomplicatedCustomRoleCustomInventoryLimits,
    val inventory: List<ItemType>,
    @SerialName("custom_items_inventory")
    val customItemsInventory: List<Int>,
    val ammo: UncomplicatedCustomRoleAmmo,
    @SerialName("damage_multiplier")
    val damageMultiplier: Float,
    @SerialName("spawn_settings")
    val spawnSettings: UncomplicatedCustomRoleSpawnSettings,
    @SerialName("custom_flags")
    val customFlags: List<UncomplicatedCustomRoleCustomFlags>? = null,
    @SerialName("ignore_spawn_system")
    val ignoreSpawnSystem: Boolean
    )

@Serializable
data class UncomplicatedCustomRoleHealth(
    val amount: Int,
    val maximum: Int
)

@Serializable
data class UncomplicatedCustomRoleAhp(
    val amount: Int,
    val limit: Int,
    val decay: Float,
    val efficacy: Float,
    val sustain: Float,
    val persistant: Boolean
)

@Serializable
data class UncomplicatedCustomRoleHumeShield(
    val amount: Int,
    val maximum: Int,
    @SerialName("regeneration_amount")
    val regenerationAmount: Float,
    @SerialName("regeneration_delay")
    val regenerationDelay: Float
)

@Serializable
data class UncomplicatedCustomRoleEffect(
    @SerialName("effect_type")
    val effectType: EffectType,
    val duration: Float,
    val intensity: Byte,
    val removable: Boolean
)

@Serializable
data class UncomplicatedCustomRoleStamina(
    @SerialName("regen_multiplier")
    val regenMultiplier: Float,
    @SerialName("usage_multiplier")
    val usageMultiplier: Float,
    val infinite: Boolean
)

@Serializable
data class UncomplicatedCustomRoleScale(
    val x: Int,
    val y: Int,
    val z: Int
)

@Serializable
data class UncomplicatedCustomRoleCustomInventoryLimits(
    @SerialName("Keycard")
    val keycard: Int? = null,
    @SerialName("Medical")
    val medical: Int? = null,
    @SerialName("Radio")
    val radio: Int? = null,
    @SerialName("Firearm")
    val firearm: Int? = null,
    @SerialName("Grenade")
    val grenade: Int? = null,
    @SerialName("SCPItem")
    val scpItem: Int? = null,
    @SerialName("SpecialWeapon")
    val specialWeapon: Int? = null,
    @SerialName("Ammo")
    val ammo: Int? = null,
    @SerialName("Armor")
    val armor: Int? = null,
)

@Serializable
data class UncomplicatedCustomRoleAmmo(
    @SerialName("Nato9")
    val nato9: Int? = null,
    @SerialName("Nato556")
    val nato556: Int? = null,
    @SerialName("Nato762")
    val bato762: Int? = null,
    @SerialName("Ammo12Gauge")
    val ammo12gauge: Int? = null,
    @SerialName("Ammo44Cal")
    val ammo44cal: Int? = null
)

@Serializable
data class UncomplicatedCustomRoleSpawnSettings(
    @SerialName("can_replace_roles")
    val canReplaceRoles: List<RoleType>,
    @SerialName("max_players")
    val maxPlayers: Int,
    @SerialName("min_players")
    val minPlayers: Int,
    @SerialName("spawn_chance")
    val spawnChance: Int,
    val spawn: SpawnType,
    @SerialName("spawn_zones")
    val spawnZone: List<ZoneType>,
    @SerialName("spawn_rooms")
    val spawnRooms: List<RoomType>,
    @SerialName("spawn_roles")
    val spawnRoles: List<RoleType>,
    @SerialName("spawn_points")
    val spawnPoints: List<String>,
    @SerialName("required_permission")
    val requiredPermissions: String
)

@Serializable
data class UncomplicatedCustomRoleCustomFlags(
    @SerialName("CustomPermissions")
    val customPermissions: CustomPermission? = null,
    @SerialName("CustomScpAnnouncer")
    val customScpAnnouncer: CustomScpAnnouncer,
    @SerialName("DoNotTriggerScp096")
    val doNotTriggerScp096: CustomFlags,
    @SerialName("DoNotTriggerTeslaGates")
    val doNotTriggerTeslaGates: CustomFlags,
    @SerialName("DropItemOnDeath")
    val dropItemOnDeath: DropItemsOnDeath,
    @SerialName("DropNothingOnDeath")
    val dropNothingOnDeath: CustomFlags,
    @SerialName("ItemBan")
    val itemBan: ItemBan,
    @SerialName("LifeStealer")
    val lifeStealer: LifeStealer,
    @SerialName("NotAffectedByAppearance")
    val notAffectedByAppearance: CustomFlags,
    @SerialName("PacifismUntilDamage")
    val pacifismUntilDeath: CustomFlags,
    @SerialName("SilentAnnouncer")
    val silentAnnouncer: CustomFlags,
    @SerialName("SilentWalker")
    val silentWalker: CustomFlags,
    @SerialName("TutorialRagdoll")
    val tutorialRagdoll: CustomFlags
)