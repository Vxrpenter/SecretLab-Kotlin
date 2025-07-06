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

import io.github.vxrpenter.ucs.data.Vector3
import io.github.vxrpenter.ucs.enums.secretlab.Color
import io.github.vxrpenter.ucs.ucr.enums.CustomVanillaFlags
import io.github.vxrpenter.ucs.enums.secretlab.EffectType
import io.github.vxrpenter.ucs.enums.secretlab.ItemType
import io.github.vxrpenter.ucs.enums.secretlab.RoleType
import io.github.vxrpenter.ucs.enums.secretlab.RoomType
import io.github.vxrpenter.ucs.enums.secretlab.SpawnType
import io.github.vxrpenter.ucs.enums.secretlab.Team
import io.github.vxrpenter.ucs.enums.secretlab.ZoneType
import io.github.vxrpenter.ucs.uct.enum.Priority
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This data class contains a full Serializer for UncomplicatedCustomRoles by FoxWorn3365, the plugin is licenced
 * under the AGPL-3.0 License and can be found on GitHub.
 *
 * @see <a href="https://github.com/UncomplicatedCustomServer/UncomplicatedCustomRoles">
 * @since 0.5.0
 * @author Vxrpenter
 */
@Serializable
data class UncomplicatedCustomRole(

    @SerialName("max_players")
    //
    // THIS IS PART OF THE UNCOMPLICATEDCUSTOMTEAMS SERIALIZATION, SEE MORE IN ./ucs/uct/data/UncomplicatedCustomTeam.kt
    //
    /**
     * This is part of the UncomplicatedCustomTeams Serializer, look at the Serializer to learn more.
     * The value will be null when querying normal UCR configurations.
     *
     * THe maximum number of members on the team
     *
     * @see io.github.vxrpenter.ucs.uct.data.UncomplicatedCustomTeam
     */
    val maxPlayers: Int? = null,

    /**
     * This is part of the UncomplicatedCustomTeams Serializer, look at the Serializer to learn more.
     * The value will be null when querying normal UCR configurations.
     *
     * The priority is that this team will be spawned at
     *
     * @see Priority
     * @see io.github.vxrpenter.ucs.uct.data.UncomplicatedCustomTeam
     */
    val priority: Priority? = null,
    //
    // THIS IS PART OF THE UNCOMPLICATEDCUSTOMTEAMS SERIALIZATION, SEE MORE IN ./ucs/uct/data/UncomplicatedCustomTeam.kt
    //
    /**
     * The role's unique identification number. Only a single number can correlate to a single custom role!
     */
    val id: Int,

    /**
     * The role's name, only visible to the server owner (unless Override Role Name is activated),
     * and it can be a simpler way to identify a role.
     *
     * If Override Role Name is activated,
     * then this name will appear also to the other players instead of the vanilla role name.
     */
    val name: String,

    /**
     * Defines if the name should appear for user's instead of only being shown to server administrators.
     *
     * @see name
     */
    @SerialName("override_role_name")
    val overrideRoleName: Boolean,

    /**
     * The nickname that will be assigned to all player's having the custom role.
     *
     * Multiple nicknames can be defined by putting in multiple names and then splitting them with a comma,
     * which will randomize the name selection.
     *
     * Example Usage:
     * ```kotlin
     * val nickname: String? = "Custom1, Custom2, Custom3"
     * ```
     */
    val nickname: String? = null,

    /**
     * The custom description that appears underneath the player's name.
     */
    @SerialName("custom_info")
    val customInfo: String? = null,

    /**
     * The badge that will be temporarily added to the player receiving the custom role.
     * Temporary meaning that the badge will only appear in the playerlist for
     * (all members) the 1 round the role is active.
     */
    @SerialName("badge_name")
    val badgeName: String? = null,

    /**
     * The color of the temporary badge that's added to the player for 1 round.
     *
     * **The color will only be applied if `badgeName` is not null**
     *
     * @see io.github.vxrpenter.ucs.enums.secretlab.Color
     */
    @SerialName("badge_color")
    val badgeColor: Color? = null,

    /**
     * The type of the custom role.
     *
     * @see io.github.vxrpenter.ucs.enums.secretlab.RoleType
     */
    val role: RoleType,

    /**
     * The team the custom role will be added to.
     * Teammates cannot attack each other and are able to win/ lose together.
     *
     * @see io.github.vxrpenter.ucs.enums.secretlab.Team
     */
    val team: Team? = null,

    /**
     * The outer appearance of the custom role.
     *
     * @see RoleType
     */
    @SerialName("role_appearance")
    val roleAppearance: RoleType? = null,

    /**
     * A list of team's that are friendly to the custom role (and the other way around).
     * Friendliness means not being able to attack each other
     *
     * @see Team
     */
    @SerialName("is_friend_of")
    val isFriendOf: List<Team>,

    /**
     * The health configuration of the custom role.
     *
     * @see UncomplicatedCustomRoleHealth
     */
    val health: UncomplicatedCustomRoleHealth,

    /**
     * The ahp configuration of the custom role.
     *
     * @see UncomplicatedCustomRoleAhp
     */
    val ahp: UncomplicatedCustomRoleAhp,

    /**
     * The hume-shield configuration of the custom role.
     *
     * @see UncomplicatedCustomRoleHumeShield
     */
    @SerialName("hume_shield")
    val humeShield: UncomplicatedCustomRoleHumeShield,

    /**
     * A list of the custom role's effect configurations.
     *
     * @see UncomplicatedCustomRoleEffect
     */
    val effects: List<UncomplicatedCustomRoleEffect>,

    /**
     * The stamina configuration of the custom role.
     *
     * @see UncomplicatedCustomRoleStamina
     */
    val stamina: UncomplicatedCustomRoleStamina,

    /**
     * The maximum amount of candy that can be taken from SCP330 until
     * the player's hands are severed.
     */
    @SerialName("max_scp330_candies")
    val maxScp330Candies: Int,

    /**
     * Defines if the custom role should be able to escape.
     */
    @SerialName("can_escape")
    val canEscape: Boolean,

    /**
     * The custom role's after escape role configuration.
     *
     * **This logic is quite complicated, further information from the UCR wiki is advised (see down below)**
     *
     * Example Usage:
     * ```kotlin
     * val roleAfterEscapeMap = hashMapOf<String, String>()
     *
     * roleAfterEscapeMap["default"] = "InternalRole Spectator"
     * roleAfterEscapeMap["cuffed by InternalTeam ChaosInsurgency"] = "InternalRole ClassD"
     * ```
     *
     * @see <a href="https://docs.ucr.ucserver.it/custom-roles/configuration/escape-logic">
     */
    @SerialName("role_after_escape")
    val roleAfterEscape: HashMap<String, String>? = null,

    /**
     * The custom role's scale configuration. It consists of a normal vector with `x`,`y` and `z` coordinates.
     *
     * @see Vector3
     */
    val scale: Vector3,

    /**
     * The broadcast message which gets displayed when the custom role is spawned.
     * For any customization, you can use the Unity syntax
     */
    @SerialName("spawn_broadcast")
    val spawnBroadcast: String,

    /**
     * The duration that the broadcast message stays on screen when the custom role is spawned.
     */
    @SerialName("spawn_broadcast_duration")
    val spawnBroadcastDuration: Short,

    /**
     * The hint that gets displayed when the custom role is spawned.
     * For any customization, you can use the Unity syntax.
     */
    @SerialName("spawn_hint")
    val spawnHint: String? = null,

    /**
     * The duration that the spawn hint stays on screen when the custom role is spawned.
     */
    @SerialName("spawn_hint_duration")
    val spawnHintDuration: Float,

    /**
     * The custom role's custom inventory limitation configuration.
     *
     * @see UncomplicatedCustomRoleCustomInventoryLimits
     */
    @SerialName("custom_inventory_limits")
    val customInventoryLimits: UncomplicatedCustomRoleCustomInventoryLimits,

    /**
     * A list of items that are added to the custom role's inventory on spawn.
     *
     * @see io.github.vxrpenter.ucs.enums.secretlab.ItemType
     */
    val inventory: List<ItemType>,

    /**
     * A list of custom items (their id's) that are added to the custom role's inventory on spawn.
     */
    @SerialName("custom_items_inventory")
    val customItemsInventory: List<Int>,

    /**
     * The custom role's ammunition configuration.
     *
     * @see UncomplicatedCustomRoleAmmo
     */
    val ammo: UncomplicatedCustomRoleAmmo,

    /**
     * The multiple that will be applied to all damage taken by the custom role.
     *
     * The Formular:
     * ```kotlin
     * val newDamage = oldDamage * damage_multiplier
     * ```
     */
    @SerialName("damage_multiplier")
    val damageMultiplier: Float,

    /**
     * The custom role's spawn settings configuration.
     *
     * @see UncomplicatedCustomRoleSpawnSettings
     */
    @SerialName("spawn_settings")
    val spawnSettings: UncomplicatedCustomRoleSpawnSettings,

    /**
     * **WARNING:** Currently only vanilla flags are implemented,
     * any other flag will either be ignored or throw an error.
     *
     * A list of custom flags that will be added to the custom role on spawn.
     *
     * @see UncomplicatedCustomRoleCustomFlags
     */
    @SerialName("custom_flags")
    val customFlags: List<UncomplicatedCustomRoleCustomFlags>? = null,

    /**
     * Defines if the role should be evaluated by the UCR internal spawn system.
     */
    @SerialName("ignore_spawn_system")
    val ignoreSpawnSystem: Boolean
)

/**
 * Defines the health of a custom role.
 */
@Serializable
data class UncomplicatedCustomRoleHealth(
    /**
     * The custom role's health amount.
     */
    val amount: Int,

    /**
     * The maximum health the custom role can reach.
     */
    val maximum: Int
)

/**
 * Defines the ahp of a custom role.
 */
@Serializable
data class UncomplicatedCustomRoleAhp(
    /**
     * The amount of ahp the custom role has.
     *
     * **Note:** The maximum amount of ahp that can be displayed is **75**, but any value above that will
     * still be added as ahp, just not visible for the player.
     */
    val amount: Int,

    /**
     * The maximum ahp the custom role is able to reach.
     */
    val limit: Int,

    /**
     * The amount of ahp that the custom role will lose every second.
     */
    val decay: Float,

    /**
     * The amount of damage absorbed by the ahp instead of the player.
     *
     * This is applied using percentages
     * with 1 standing for 100% and 0 for 0%.
     */
    val efficacy: Float,

    /**
     * The time in seconds until the custom role's ahp starts to decay.
     */
    val sustain: Float,

    /**
     * Defines if the ahp of the custom role is able to decay.
     */
    val persistant: Boolean
)

/**
 * Defines the hume shield of a custom role.
 */
@Serializable
data class UncomplicatedCustomRoleHumeShield(
    /**
     * The amount of hume shield given to the custom role on first spawn.
     */
    val amount: Int,

    /**
     * The maximum hume shield the custom role is able to reach.
     */
    val maximum: Int,

    /**
     * The amount of hume shield to be applied to the custom role every second (set to 0 to disable).
     */
    @SerialName("regeneration_amount")
    val regenerationAmount: Float,

    /**
     * The delay in seconds that the custom role waits until hume shield regeneration.
     */
    @SerialName("regeneration_delay")
    val regenerationDelay: Float
)

/**
 * Defines a specific effect of a custom role.
 */
@Serializable
data class UncomplicatedCustomRoleEffect(
    /**
     * The type of the effect.
     *
     * @see io.github.vxrpenter.ucs.enums.secretlab.EffectType
     */
    @SerialName("effect_type")
    val effectType: EffectType,

    /**
     * The duration the effect will last. (set to -1 for infinite).
     */
    val duration: Float,

    /**
     * Defines the effects intensity when being from values 1 - 255 (byte).
     */
    val intensity: Byte,

    /**
     * Whether the effect can be removed by SCP500 or if it is permanent.
     */
    val removable: Boolean
)

/**
 * Defines the stamina of a custom role
 */
@Serializable
data class UncomplicatedCustomRoleStamina(
    /**
     * The multiplier that is applied to the default stamina of the custom role.
     *
     * The Formular:
     * ```kotlin
     * val newStaminaRegen = staminaRegen * regen_multiplier
     * ```
     */
    @SerialName("regen_multiplier")
    val regenMultiplier: Float,

    /**
     * The multiplier being applied to the usage amount while sprinting.
     *
     * The Formular:
     * ```kotlin
     * val newStaminaUsage = staminaUsage * usage_multiplier
     * ```
     */
    @SerialName("usage_multiplier")
    val usageMultiplier: Float,

    /**
     * Whether the stamina does not run out or if it does.
     */
    val infinite: Boolean
)

/**
 * Defines the maximum of a specific Itemtype a custom role can hold in their
 * inventory.
 */
@Serializable
data class UncomplicatedCustomRoleCustomInventoryLimits(
    /**
     * Defines how many keycards the custom role can have in their inventory.
     */
    @SerialName("Keycard")
    val keycard: Int? = null,

    /**
     * Defines how many medical items the custom role can have in their inventory.
     */
    @SerialName("Medical")
    val medical: Int? = null,

    /**
     * Defines how many radios the custom role can have in their inventory.
     */
    @SerialName("Radio")
    val radio: Int? = null,

    /**
     * Defines how many firearms the custom role can have in their inventory.
     */
    @SerialName("Firearm")
    val firearm: Int? = null,

    /**
     * Defines how many grenades the custom role can have in their inventory.
     */
    @SerialName("Grenade")
    val grenade: Int? = null,

    /**
     * Defines how many scp-items the custom role can have in their inventory.
     */
    @SerialName("SCPItem")
    val scpItem: Int? = null,

    /**
     * Defines how many special weapons the custom role can have in their inventory.
     */
    @SerialName("SpecialWeapon")
    val specialWeapon: Int? = null,

    /**
     * Defines how much ammo the custom role can have in their inventory.
     */
    @SerialName("Ammo")
    val ammo: Int? = null,

    /**
     * Defines how many armors the custom role can have in their inventory.
     */
    @SerialName("Armor")
    val armor: Int? = null,
)

/**
 * Defines the maximum amount of certain ammunition types that the custom role is able
 * to hold in their inventory.
 */
@Serializable
data class UncomplicatedCustomRoleAmmo(
    /**
     * Defines how much Nato9 ammunition the custom role can have in their inventory.
     */
    @SerialName("Nato9")
    val nato9: Int? = null,

    /**
     * Defines how much Nato556 ammunition the custom role can have in their inventory.
     */
    @SerialName("Nato556")
    val nato556: Int? = null,

    /**
     * Defines how much Nato762 ammunition the custom role can have in their inventory.
     */
    @SerialName("Nato762")
    val bato762: Int? = null,

    /**
     * Defines how much Ammo12Gauge ammunition the custom role can have in their inventory.
     */
    @SerialName("Ammo12Gauge")
    val ammo12gauge: Int? = null,

    /**
     * Defines how much Ammo44Cal ammunition the custom role can have in their inventory.
     */
    @SerialName("Ammo44Cal")
    val ammo44cal: Int? = null
)

/**
 * Defines the specific spawn of a custom role
 */
@Serializable
data class UncomplicatedCustomRoleSpawnSettings(
    /**
     * The vanilla roles that can become a custom role on round start
     */
    @SerialName("can_replace_roles")
    val canReplaceRoles: List<RoleType>,

    /**
     * The maximum amount of players a custom role can have
     */
    @SerialName("max_players")
    val maxPlayers: Int,

    /**
     * The minimum amount of players a custom role must have
     */
    @SerialName("min_players")
    val minPlayers: Int,

    /**
     * The chance at which the custom role is able to replace a vanilla role.
     *
     * This is applied using percentages
     * with 0 standing for 0% and 100 for 100%.
     */
    @SerialName("spawn_chance")
    val spawnChance: Int,

    /**
     * The spawn mechanism by which the custom role will be spawned with.
     *
     * @see io.github.vxrpenter.ucs.enums.secretlab.SpawnType
     */
    val spawn: SpawnType,

    /**
     * A list of zones the custom role can be spawned in.
     *
     * @see io.github.vxrpenter.ucs.enums.secretlab.ZoneType
     */
    @SerialName("spawn_zones")
    val spawnZone: List<ZoneType>,

    /**
     * A list of rooms the custom role can be spawned in.
     *
     * @see io.github.vxrpenter.ucs.enums.secretlab.RoomType
     */
    @SerialName("spawn_rooms")
    val spawnRooms: List<RoomType>,

    /**
     * A list of vanilla roles which spawnpoints the custom role can be spawned at.
     *
     * @see RoleType
     */
    @SerialName("spawn_roles")
    val spawnRoles: List<RoleType>,

    /**
     * A list of spawnpoints, created by the /spawnpoints command, that the custom role be spawned at.
     */
    @SerialName("spawn_points")
    val spawnPoints: List<String>,

    /**
     * The required permission for a player to be spawned as a custom role.
     */
    @SerialName("required_permission")
    val requiredPermissions: String
)

/**
 * **WARNING:** Currently only vanilla flags are implemented,
 * any other flag will either be ignored or throw an error.
 *
 * Defines the custom flags of a custom role.
 */
@Serializable
data class UncomplicatedCustomRoleCustomFlags(
    /**
     * Allows the player that has a custom role to have additional EXILED permissions.
     *
     * @see CustomPermission
     */
    @SerialName("CustomPermissions")
    val customPermissions: CustomPermission? = null,

    /**
     * Forces the game to make an announcement on the role's termination.
     *
     * @see CustomScpAnnouncer
     */
    @SerialName("CustomScpAnnouncer")
    val customScpAnnouncer: CustomScpAnnouncer,

    /**
     * Makes the role unable to trigger SCP096.
     *
     * @see doNotTriggerScp096
     */
    @SerialName("DoNotTriggerScp096")
    val doNotTriggerScp096: CustomVanillaFlags,

    /**
     * Makes the role not trigger tesla gates.
     *
     * @see doNotTriggerTeslaGates
     */
    @SerialName("DoNotTriggerTeslaGates")
    val doNotTriggerTeslaGates: CustomVanillaFlags,

    /**
     * Defines which specific item's the custom role should drop on death.
     *
     * @see DropItemsOnDeath
     */
    @SerialName("DropItemOnDeath")
    val dropItemOnDeath: DropItemsOnDeath,

    /**
     * Makes the custom role drop nothing on death.
     *
     * @see CustomVanillaFlags
     */
    @SerialName("DropNothingOnDeath")
    val dropNothingOnDeath: CustomVanillaFlags,

    /**
     * Prevents the custom role from picking up and therefore using specific items.
     *
     * @see ItemBan
     */
    @SerialName("ItemBan")
    val itemBan: ItemBan,

    /**
     * Allows the custom role to gain a certain amount of health upon damaging a player.
     *
     * @see LifeStealer
     */
    @SerialName("LifeStealer")
    val lifeStealer: LifeStealer,

    /**
     * Makes the custom role see other custom role's 'real' appearances and not their 'fake' ones.
     *
     * @see CustomVanillaFlags
     */
    @SerialName("NotAffectedByAppearance")
    val notAffectedByAppearance: CustomVanillaFlags,

    /**
     * Prevents the custom role from being damaged until they damaged someone else.
     *
     * @see CustomVanillaFlags
     */
    @SerialName("PacifismUntilDamage")
    val pacifismUntilDeath: CustomVanillaFlags,

    /**
     * Prevents the game on making a termination announcement of the custom role's death.
     *
     * @see CustomVanillaFlags
     */
    @SerialName("SilentAnnouncer")
    val silentAnnouncer: CustomVanillaFlags,

    /**
     * Prevents the custom role from making sounds while walking.
     *
     * @see CustomVanillaFlags
     */
    @SerialName("SilentWalker")
    val silentWalker: CustomVanillaFlags,

    /**
     * Spawns a tutorial ragdoll on the custom role's death instead of the intended one.
     *
     * @see CustomVanillaFlags
     */
    @SerialName("TutorialRagdoll")
    val tutorialRagdoll: CustomVanillaFlags
)