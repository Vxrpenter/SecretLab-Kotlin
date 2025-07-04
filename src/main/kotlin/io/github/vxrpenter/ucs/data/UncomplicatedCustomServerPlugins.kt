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

package io.github.vxrpenter.ucs.data

import kotlinx.serialization.Serializable

/**
 * A data class to serialize the Vector3 from the C# language
 */
@Serializable
data class Vector3(
    /**
     * The vectors x coordinate.
     */
    val x: Double,

    /**
     * The vectors y coordinate.
     */
    val y: Double,

    /**
     * The vectors z coordinate.
     */
    val z: Double
)