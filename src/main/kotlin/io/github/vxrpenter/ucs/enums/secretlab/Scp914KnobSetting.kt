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
enum class Scp914KnobSetting(val setting: String) {
    @SerialName("Rough")
    ROUGH("Rough"),
    @SerialName("Coarse")
    COARSE("Coarse"),
    @SerialName("OneToOne")
    ONE_TO_ONE("OneToOne"),
    @SerialName("Fine")
    FINE("Fine"),
    @SerialName("VeryFine")
    VERY_FINE("VeryFine");

    companion object {
        /**
         * Finds the specified enum name from its Scp914KnobSetting.
         *
         * @param value The Scp914KnobSetting e.g. (Fine, VeryFine, etc.)
         * @see io.github.vxrpenter.ucs.enums.secretlab.Scp914KnobSetting
         * @return the Scp914KnobSetting (nullable)
         */
        fun findEnum(value: String): Scp914KnobSetting? = Scp914KnobSetting.entries.find { it.setting == value }

        /**
         * Finds the specified Scp914KnobSetting from its enum
         *
         * @param enum The enum e.g. (FINE, VERY_FINE, etc.)
         * @see io.github.vxrpenter.ucs.enums.secretlab.Scp914KnobSetting
         * @return the Scp914KnobSetting (nullable)
         */
        fun findValue(enum: Scp914KnobSetting): String? = Scp914KnobSetting.entries.find { it.name == enum.name }?.setting
    }
}