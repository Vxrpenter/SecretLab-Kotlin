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

import io.github.vxrpenter.ucs.enums.secretlab.CustomVanillaFlags
import io.github.vxrpenter.ucs.enums.secretlab.ItemType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CustomPermission(
    /**
     * The type of the custom flag, this is not included in the config (transient).
     */
    @Transient
    val type: CustomVanillaFlags = CustomVanillaFlags.CUSTOM_PERMISSION,

    /**
     * The permissions that the player's with the custom role get applied.
     *
     * Multiple permissions can be defined by putting in multiple permissions and then splitting them with a comma.
     *
     * Example Usage:
     * ```kotlin
     * val type: CustomVanillaFlags? = "ucr.spawn, ucr.list"
     * ```
     */
    val permission: String
)

@Serializable
data class CustomScpAnnouncer(
    /**
     * The type of the custom flag, this is not included in the config (transient).
     */
    @Transient
    val type: CustomVanillaFlags = CustomVanillaFlags.CUSTOM_SCP_ANNOUNCER,

    /**
     * The number of the scp which announcement will be sent.
     */
    val name: String
)

@Serializable
data class DropItemsOnDeath(
    /**
     * The type of the custom flag, this is not included in the config (transient).
     */
    @Transient
    val type: CustomVanillaFlags = CustomVanillaFlags.DROP_ITEM_ON_DEATH,

    /**
     * The item which the custom role will drop on termination.
     *
     * @see ItemType
     */
    val item: ItemType
)

@Serializable
data class ItemBan(
    /**
     * The type of the custom flag, this is not included in the config (transient)
     */
    @Transient
    val type: CustomVanillaFlags = CustomVanillaFlags.ITEM_BAN,

    /**
     * The item which the custom role cannot pick up anymore.
     *
     * @see ItemType
     */
    @SerialName("item_type")
    val itemType: ItemType
)

@Serializable
data class LifeStealer(
    /**
     * The type of the custom flag, this is not included in the config (transient)
     */
    @Transient
    val type: CustomVanillaFlags = CustomVanillaFlags.LIFE_STEALER,

    /**
     * The percentage of the damage that will be transferred to the custom role.
     *
     * This is applied using percentages
     * with 0 standing for 0% and 100 for 100%.
     */
    val percentage: Int
)