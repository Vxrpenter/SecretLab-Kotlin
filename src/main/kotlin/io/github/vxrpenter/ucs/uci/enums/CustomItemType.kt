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

package io.github.vxrpenter.ucs.uci.enums

import io.github.vxrpenter.ucs.enums.secretlab.Color
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class CustomItemType(val type: String) {
    @SerialName("Item")
    ITEM("Item"),
    @SerialName("Keycard")
    KEYCARD("Keycard"),
    @SerialName("Armor")
    ARMOR("Armor"),
    @SerialName("Weapon")
    WEAPON("Weapon"),
    @SerialName("Medikit")
    MEDKIT("Medikit"),
    @SerialName("Painkillers")
    PAINKILLERS("Painkillers"),
    @SerialName("Jailbird")
    JAILBIRD("Jailbird"),
    @SerialName("ExplosiveGrenade")
    EXPLOSIVE_GRENADE("ExplosiveGrenade"),
    @SerialName("FlashGrenade")
    FLASH_GRENADE("FlashGrenade"),
    @SerialName("Adrenaline")
    ADRENALINE("Adrenaline"),
    @SerialName("SCPItem")
    SCP_ITEM("SCPItem");

    companion object {
        /**
         * Finds the specified enum name from its CustomItemType.
         *
         * @param value The CustomItemType e.g. (Adrenaline, SCPItem, etc.)
         * @see io.github.vxrpenter.ucs.uci.enums.CustomItemType
         * @return the CustomItemType (nullable)
         */
        fun findEnum(value: String): CustomItemType? = CustomItemType.entries.find { it.type == value }

        /**
         * Finds the specified CustomItemType from its enum
         *
         * @param enum The enum e.g. (ADRENALINE, SCP_ITEM etc.)
         * @see io.github.vxrpenter.ucs.uci.enums.CustomItemType
         * @return the CustomItemType (nullable)
         */
        fun findValue(enum: CustomItemType): String? = CustomItemType.entries.find { it.name == enum.name }?.type
    }
}