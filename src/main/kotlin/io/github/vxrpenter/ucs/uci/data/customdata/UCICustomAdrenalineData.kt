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

package io.github.vxrpenter.ucs.uci.data.customdata

import kotlinx.serialization.Serializable

/**
 * Defines the custom item's adrenaline custom data
 */
@Serializable
data class UCICustomAdrenalineData(
    /**
     * The amount of ahp to be given to the custom item's holder.
     */
    val amount: Float,
    /**
     * The rate/speed of the ahp's decay.
     */
    val decay: Float,
    /**
     * The efficacy of the ahp.
     */
    val efficacy: Float,
    /**
     * The delay before the ahp starts to decay.
     */
    val sustain: Float,
    /**
     * Defines if the ahp is persistant (no decay being applied).
     */
    val persistant: Boolean,
)