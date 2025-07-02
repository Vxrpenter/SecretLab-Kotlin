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

package io.github.vxrpenter.ucs.uct.data

import io.github.vxrpenter.ucs.enums.secretlab.ItemType
import io.github.vxrpenter.ucs.enums.secretlab.RoleType
import io.github.vxrpenter.ucs.enums.secretlab.Team
import io.github.vxrpenter.ucs.ucr.data.UncomplicatedCustomRole
import io.github.vxrpenter.ucs.uct.enum.SpawnWave
import io.github.vxrpenter.ucs.uct.enum.TargetScp
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This data class contains a full Serializer for UncomplicatedCustomTeams by FoxWorn3365, the plugin is licenced
 * under the AGPL-3.0 License and can be found on GitHub.
 *
 * @see <a href="https://github.com/UncomplicatedCustomServer/UncomplicatedCustomTeams">
 * @since 0.5.0
 * @author Vxrpenter
 */
@Serializable
data class UncomplicatedCustomTeam(
    val teams: List<UncomplicatedCustomTeamTeam>
)

/**
 * Actual team data class
 */
@Serializable
data class UncomplicatedCustomTeamTeam(
    /**
     * The team's unique identification number. Only a single number can correlate to a single custom team!
     */
    val id: Int,
    /**
     * The name of the custom team.
     */
    val name: String,
    /**
     * The minimum number of players required to spawn the custom team.
     */
    @SerialName("min_players")
    val minPlayers: Int,
    /**
     * The maximum number of times this custom team can be spawned in a single round.
     */
    @SerialName("max_spawns")
    val maxSpawns: Int,
    /**
     * The chance of spawning this custom team.
     * This is applied using percentages with 0 standing for 0% and 100 for 100%.
     */
    @SerialName("spawn_chance")
    val spawnChance: Int,
    /**
     * The spawn configuration of the custom team.
     *
     * @see UncomplicatedCustomTeamSpawnConditions
     */
    @SerialName("spawn_conditions")
    val spawnConditions: UncomplicatedCustomTeamSpawnConditions,
    /**
     * Decide of cassie will announce the custom team being spawned or not.
     */
    @SerialName("is_cassie_announcement_enabled")
    val isCassieAnnouncementEnabled: Boolean,
    /**
     * The message cassie will send when the custom team is spawned.
     * Only works when cassie announcement is enabled.
     */
    @SerialName("cassie_message")
    val cassieMessage: String? = null,
    /**
     * The translation for the message cassie will send when the custom team is spawned.
     * Only works when cassie announcement is enabled and the message is not null.
     */
    @SerialName("cassie_translation")
    val cassieTranslation: String? = null,
    /**
     * Determines whether the cassie message should be noisy.
     * Only works when cassie announcement is enabled and the message is not null.
     */
    @SerialName("is_noisy")
    val isNoisy: Boolean,
    /**
     * The path of a custom sound file that will be played on the custom team's spawn.
     * Required AudioPlayerAPI plugin to function.
     */
    @SerialName("sound_path")
    val soundPath: String? = null,
    /**
     * The volume of the custom sound file that will be played on the custom team's spawn.
     * Only works when the path is set and AudioPlayerAPI is installed.
     */
    @SerialName("sound_volume")
    val soundVolume: Int? = null,
    /**
     *  Defines which team's will win when the custom team is eliminated.
     */
    @SerialName("team_alive_to_win")
    val teamAliveToWin: List<Team>,
    /**
     * A list of UncomplicatedCustomRoles that which can be part of the custom team.
     *
     * Not that you have to add the following options for this parsing to work correctly:
     * ```kotlin
     * val role = UncomplicatedCustomRole(maxPlayers = 1, priority = Priority.NONE, ...)
     * ```
     *
     * @see UncomplicatedCustomRole
     */
    val roles: List<UncomplicatedCustomRole>,
    /**
     * A list of ExiledCustomRoles that will be part of the custom team.
     *
     * @see ExiledCustomRole
     */
    @SerialName("ecr_roles")
    val ecrRoles: List<ExiledCustomRole>
)

/**
 * Defines the custom team's spawn conditions.
 */
@Serializable
data class UncomplicatedCustomTeamSpawnConditions(
    /**
     * The spawn position the custom team will use.
     *
     * @see SpawnWave
     */
    @SerialName("spawn_wave")
    val spawnWave: SpawnWave? = null,
    /**
     * The custom team's spawn position. It consists of a normal vector with `x`,`y` and `z` coordinates.
     *
     * @see UncomplicatedCustomTeamSpawnPosition
     */
    @SerialName("spawn_position")
    val spawnPosition: UncomplicatedCustomTeamSpawnPosition,
    /**
     * The item that has to be used to spawn the custom team.
     */
    val usedItem: ItemType,
    /**
     * The custom item that has to be used to spawn the custom team.
     */
    @SerialName("custom_item_id")
    val customItemId: Int? = null,
    /**
     * Defines the SCP that has to die for this custom team to be spawned.
     * Can be a single SCP or the entire team.
     *
     * Setting is only applied when SpawnWave is set to ScpDeath.
     *
     * @see TargetScp
     */
    val targetScp: TargetScp,
    /**
     * List of roles that have to be alive on round start for the custom team to spawn.
     */
    val roleAliveOnRoundStart: List<RoleType>,
    /**
     * Defines a delay for the custom team's spawn.
     * Setting a SpawnDelay greater than 0 will not work when using NtfWave or ChaosWave!
     */
    val spawnDelay: Float,
)

/**
 * Defines the spawn position of the custom team.
 */
@Serializable
data class UncomplicatedCustomTeamSpawnPosition(
    /**
     * The vectors x coordinate.
     */
    val x: Int,

    /**
     * The vectors y coordinate.
     */
    val y: Int,

    /**
     * The vectors z coordinate.
     */
    val z: Int
)