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

import io.github.vxrpenter.ucs.enums.CustomFlags
import io.github.vxrpenter.ucs.enums.ItemType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CustomPermission(
    @Transient
    val type: CustomFlags = CustomFlags.CUSTOM_PERMISSION,
    val permission: String
)

@Serializable
data class CustomScpAnnouncer(
    @Transient
    val type: CustomFlags = CustomFlags.CUSTOM_SCP_ANNOUNCER,
    val name: String
)

@Serializable
data class DropItemsOnDeath(
    @Transient
    val type: CustomFlags = CustomFlags.DROP_ITEM_ON_DEATH,
    val item: ItemType
)

@Serializable
data class ItemBan(
    @Transient
    val type: CustomFlags = CustomFlags.ITEM_BAN,
    @SerialName("item_type")
    val itemType: String
)

@Serializable
data class LifeStealer(
    @Transient
    val type: CustomFlags = CustomFlags.LIFE_STEALER,
    val percentage: Int
)

