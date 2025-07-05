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

enum class HintOrBroadcast(val type: String) {
    @SerialName("Hint")
    HINT("Hint"),
    @SerialName("Broadcast")
    BROADCAST("Broadcast");

    companion object {
        /**
         * Finds the specified enum name from its HintOrBroadcast.
         *
         * @param value The HintOrBroadcast e.g. (Hint, Broadcast, etc.)
         * @see io.github.vxrpenter.ucs.uci.enums.HintOrBroadcast
         * @return the HintOrBroadcast (nullable)
         */
        fun findEnum(value: String): HintOrBroadcast? = HintOrBroadcast.entries.find { it.type == value }

        /**
         * Finds the specified HintOrBroadcast from its enum
         *
         * @param enum The enum e.g. (HINT, BROADCAST etc.)
         * @see io.github.vxrpenter.ucs.uci.enums.HintOrBroadcast
         * @return the HintOrBroadcast (nullable)
         */
        fun findValue(enum: HintOrBroadcast): String? = HintOrBroadcast.entries.find { it.name == enum.name }?.type
    }
}