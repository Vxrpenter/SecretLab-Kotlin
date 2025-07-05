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

@Serializable
data class UCICustomKeycardData(
    val containment: Int,
    val armory: Int,
    val admin: Int,
    @SerialName("tint_color")
    val tintColor: String,
    @SerialName("permissions_color")
    val permissionsColor: String,
    val name: String,
    val label: String,
    @SerialName("serial_number")
    val serialNumber: String,
    @SerialName("wear_detail")
    val wearDetail: Byte,
    @SerialName("label_color")
    val labelColor: String,
    val rank: Int,
    @SerialName("one_time_use")
    val oneTimeUse: Boolean,
    @SerialName("one_time_use_hint")
    val oneTimeUseHint: String,
)