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

import kotlinx.serialization.SerialName

enum class ItemEvents(val event: String) {
    @SerialName("Command")
    COMMAND("Command"),
    @SerialName("Pickup")
    PICKUP("Pickup"),
    @SerialName("Drop")
    DROP("Drop"),
    @SerialName("Use")
    USE("Use"),
    @SerialName("Noclip")
    NOCLIP("Noclip"),
    @SerialName("Detonation")
    DETONATION("Detonation"),
    @SerialName("SSSS")
    SSSS("SSSS");

    companion object {
        /**
         * Finds the specified enum name from its ItemEvents.
         *
         * @param value The ItemEvents e.g. (Detonation, SSSS, etc.)
         * @see io.github.vxrpenter.ucs.uci.enums.ItemEvents
         * @return the ItemEvents (nullable)
         */
        fun findEnum(value: String): ItemEvents? = ItemEvents.entries.find { it.event == value }

        /**
         * Finds the specified Event from its enum
         *
         * @param enum The enum e.g. (DETONATION, SSSS etc.)
         * @see io.github.vxrpenter.ucs.uci.enums.ItemEvents
         * @return the Event (nullable)
         */
        fun findValue(enum: ItemEvents): String? = ItemEvents.entries.find { it.name == enum.name }?.event
    }
}