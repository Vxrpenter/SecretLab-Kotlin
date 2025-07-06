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

package io.github.vxrpenter.secretlab.data

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Transient

@Serializable
data class ServerInfo(
    @Transient
    var response: Long = 0L,
    @SerialName("Success")
    val success: Boolean = false,
    @SerialName("Error")
    val error: String? = null,
    @SerialName("Cooldown")
    val cooldown: Int? = null,
    @SerialName("Servers")
    val servers: List<Server>? = null,
)

@Serializable
data class Server(
    @SerialName("ID")
    val id: Int,
    @SerialName("Port")
    val port: Int,
    @SerialName("Online")
    val online: Boolean,
    @SerialName("LastOnline")
    val lastOnline: String,
    @SerialName("Players")
    val players: String? = null,
    @SerialName("PlayersList")
    val playerList: List<PlayerList>? = null,
    @SerialName("Info")
    val info: String? = null,
    @SerialName("Version")
    val version: String? = null,
    @SerialName("Pastebin")
    val pasteBin: String? = null,
    @SerialName("FF")
    val ff: Boolean? = null,
    @SerialName("WL")
    val wl: Boolean? = null,
    @SerialName("Modded")
    val modded: Boolean? = null,
    @SerialName("Mods")
    val mods: Int? = null,
    @SerialName("Suppress")
    val support: Int? = null,
    @SerialName("AutoSuppress")
    val autoSuppress: Boolean? = null
)

@Serializable
data class PlayerList(
    @SerialName("ID")
    val id: String? = null,
    @SerialName("Nickname")
    val nickname: String? = null
)