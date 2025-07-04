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
enum class EffectEvent(val event: String) {
    @SerialName("EffectWhenUsed")
    EFFECT_WHEN_USED("EffectWhenUsed"),
    @SerialName("PickedUpEffect")
    PICKED_UP_EFFECT("PickedUpEffect"),
    @SerialName("EffectWhenEquiped")
    EFFECT_WHEN_EQUIPED("EffectWhenEquiped"),
    @SerialName("EffectShot")
    EFFECT_SHOT("EffectShot");

    companion object {
        /**
         * Finds the specified enum name from its EffectEvent.
         *
         * @param value The EffectEvent e.g. (EffectWhenEquiped, EffectShot, etc.)
         * @see io.github.vxrpenter.ucs.uci.enums.EffectEvent
         * @return the EffectEvent (nullable)
         */
        fun findEnum(value: String): EffectEvent? = EffectEvent.entries.find { it.event == value }

        /**
         * Finds the specified EffectEvent from its enum
         *
         * @param enum The enum e.g. (EFFECT_WHEN_EQUIPED, EFFECT_SHOT etc.)
         * @see io.github.vxrpenter.ucs.uci.enums.EffectEvent
         * @return the EffectEvent (nullable)
         */
        fun findValue(enum: EffectEvent): String? = EffectEvent.entries.find { it.name == enum.name }?.event
    }
}