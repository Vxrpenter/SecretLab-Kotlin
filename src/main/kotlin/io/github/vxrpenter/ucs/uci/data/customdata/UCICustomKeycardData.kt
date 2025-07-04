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
    val containment: Int? = null,
    val armory: Int? = null,
    val admin: Int? = null,
    @SerialName("tint_color")
    val tintColor: String? = null,
    @SerialName("permissions_color")
    val permissionsColor: String? = null,
    val name: String? = null,
    val label: String? = null,
    @SerialName("serial_number")
    val serialNumber: String? = null,
    @SerialName("wear_detail")
    val wearDetail: Byte? = null,
    @SerialName("label_color")
    val labelColor: String? = null,
    val rank: Int? = null,
    @SerialName("one_time_use")
    val oneTimeUse: Boolean? = null,
    @SerialName("one_time_use_hint")
    val oneTimeUseHint: String? = null,
)