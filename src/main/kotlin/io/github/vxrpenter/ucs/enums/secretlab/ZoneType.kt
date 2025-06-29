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

package io.github.vxrpenter.ucs.enums.secretlab

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ZoneType(val zone: String) {
    @SerialName("LightContainment")
    LIGHT_CONTAINMENT("LightContainment"),
    @SerialName("HeavyContainment")
    HEAVY_CONTAINMENT("HeavyContainment"),
    @SerialName("Entrance")
    ENTRANCE("Entrance"),
    @SerialName("Surface")
    SURFACE("Surface");

    companion object {
        /**
         * Finds the specified enum name from its ZoneType.
         *
         * @param value The ZoneType e.g. (Entrance, Surface etc.)
         * @see io.github.vxrpenter.ucs.enums.ZoneType
         * @return the ZoneType (nullable)
         */
        fun findEnum(value: String): ZoneType? = ZoneType.entries.find { it.zone == value }

        /**
         * Finds the specified ZoneType from its enum
         *
         * @param enum The enum e.g. (ENTRANCE, SURFACE etc.)
         * @see io.github.vxrpenter.ucs.enums.ZoneType
         * @return the ZoneType (nullable)
         */
        fun findValue(enum: ZoneType): String? = ZoneType.entries.find { it.name == enum.name }?.zone
    }
}