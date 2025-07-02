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
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class UncomplicatedCustomTeam(
    val id: Int,
    val name: String,
    @SerialName("min_players")
    val minPlayers: Int,
    @SerialName("max_players")
    val maxPlayers: Int,
    @SerialName("spawn_chance")
    val spawnChance: Int,
    @SerialName("spawn_conditions")
    val spawnConditions: UncomplicatedCustomTeamSpawnConditions,
    @SerialName("is_cassie_announcement_enabled")
    val isCassieAnnouncementEnabled: Boolean,
    @SerialName("cassie_message")
    val cassieMessage: String,
    @SerialName("cassie_translation")
    val cassieTranslation: String,
    @SerialName("is_noisy")
    val isNoisy: Boolean,
    @SerialName("sound_path")
    val soundPath: String? = null,
    @SerialName("sound_volume")
    val soundVolume: Int? = null,
    @SerialName("team_alive_to_win")
    val teamAliveToWin: List<Team>,
    val roles: List<UncomplicatedCustomRole>,
    @SerialName("ecr_roles")
    val ecrRoles: List<ExiledCustomRole>
)

@Serializable
data class UncomplicatedCustomTeamSpawnConditions(
    @SerialName("spawn_wave")
    val spawnWave: SpawnWave? = null,
    @SerialName("spawn_position")
    val spawnPosition: UncomplicatedCustomTeamSpawnPosition,
    val usedItem: ItemType,
    @SerialName("custom_item_id")
    val customItemId: Int? = null,
    val targetScp: RoleType,
    val roleAliveOnRoundStart: List<RoleType>,
    val spawnDelay: Float,
)

@Serializable
data class UncomplicatedCustomTeamSpawnPosition(
    val x: Int,
    val y: Int,
    val z: Int
)