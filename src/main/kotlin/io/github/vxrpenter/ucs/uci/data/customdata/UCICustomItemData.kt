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

import io.github.vxrpenter.ucs.uci.enums.ItemEvents
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Defines the custom item's custom item data
 */
@Serializable
data class UCICustomItemData(
    /**
     * The item's event.
     * @see ItemEvents
     */
    val event: ItemEvents,
    /**
     * The command that will be fired when [event] is fired.
     */
    val command: String? = null,
    /**
     * The delay after [event] is fired.
     */
    @SerialName("cool_down")
    val coolDown: Float,
    /**
     * The message that will be sent into the console when [event] is fired.
     */
    @SerialName("console_message")
    val consoleMessage: String,
    /**
     * The message that will be broadcasted when [event] is fired.
     */
    @SerialName("broadcast_message")
    val broadcastMessage: String,
    /**
     * The duration the broadcast will be displayed.
     */
    @SerialName("broadcast_duration")
    val broadcastDuration: Short,
    /**
     * The hint message that will be displayed when [event] is fired.
     */
    @SerialName("hint_message")
    val hintMessage: String,
    /**
     * The duration the hint will be displayed.
     */
    @SerialName("hint_duration")
    val hintDuration: Float,
    /**
     * Defines if the item should be destroyed after use.
     */
    @SerialName("destroy_after_use")
    val destroyAfterUse: Boolean,
)
