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

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Defines the custom item's keycard custom data
 */
@Serializable
data class UCICustomKeycardData(
    /**
     * The keycards containment access level (Allowed values are 0-3).
     */
    val containment: Int,
    /**
     * The keycards armory access level (Allowed values are 0-3).
     */
    val armory: Int,
    /**
     * The keycards admin access level (Allowed values are 0-3).
     */
    val admin: Int,
    /**
     * The keycards main background color (hex value).
     */
    @SerialName("tint_color")
    val tintColor: String,
    /**
     * The keycard's permission indicator color (hex value).
     */
    @SerialName("permissions_color")
    val permissionsColor: String,
    /**
     * The name of the keycard's holder.
     */
    val name: String,
    /**
     * The label of the keycard, e.g. department.
     */
    val label: String,
    /**
     * The serial number displayed on the keycard.
     */
    @SerialName("serial_number")
    val serialNumber: String,
    /**
     * **WARNING:** Does currently not work
     * The amount of wear.
     */
    @SerialName("wear_detail")
    val wearDetail: Byte,
    /**
     * The color of the [label] (hex value).
     */
    @SerialName("label_color")
    val labelColor: String,
    /**
     * **WARNING:** Does currently not work
     */
    val rank: Int,
    /**
     * Defines if the keycard can be used only once.
     */
    @SerialName("one_time_use")
    val oneTimeUse: Boolean,
    /**
     * The hint message displayed when keycard is used once (Set [oneTimeUse] to true for this to apply).
     */
    @SerialName("one_time_use_hint")
    val oneTimeUseHint: String,
)