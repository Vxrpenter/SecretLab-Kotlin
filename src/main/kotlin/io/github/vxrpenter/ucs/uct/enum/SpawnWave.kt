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

package io.github.vxrpenter.ucs.uct.enum

import kotlinx.serialization.SerialName

enum class SpawnWave(val wave: String) {
    @SerialName("AfterWarhead")
    AFTER_WARHEAD("AfterWarhead"),
    @SerialName("AfterDecontamination")
    AFTER_DECONTAMINATION("AfterDecontamination"),
    @SerialName("UsedItem")
    USED_ITEM("UsedItem"),
    @SerialName("RoundStarted")
    ROUND_STARTED("RoundStarted"),
    @SerialName("NtfWave")
    NTF_WAVE("NtfWave"),
    @SerialName("ChaosWave")
    CHAOS_WAVE("ChaosWave"),
    @SerialName("ScpDeath")
    SCP_DEATH("ScpDeath");

    companion object {
        /**
         * Finds the specified enum name from its spawn wave.
         *
         * @param value The flag e.g. (NtfWave, ChaosWave etc.)
         * @see io.github.vxrpenter.ucs.uct.enum.SpawnWave
         * @return the SpawnWave (nullable)
         */
        fun findEnum(value: String): SpawnWave? = SpawnWave.entries.find { it.wave == value }

        /**
         * Finds the specified spawn wave from its enum
         *
         * @param enum The enum e.g. (NTF_WAVE, CHAOS_WAVE etc.)
         * @see io.github.vxrpenter.ucs.uct.enum.SpawnWave
         * @return the SpawnWave (nullable)
         */
        fun findValue(enum: SpawnWave): String? = SpawnWave.entries.find { it.name == enum.name }?.wave
    }
}