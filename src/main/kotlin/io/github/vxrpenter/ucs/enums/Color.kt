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

package io.github.vxrpenter.ucs.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Color(val color: String) {
    @SerialName("pink")
    PINK("pink"),
    @SerialName("red")
    RED("red"),
    @SerialName("brown")
    BROWN("brown"),
    @SerialName("silver")
    SILVER("silver"),
    @SerialName("light_green")
    LIGHT_GREEN("light_green"),
    @SerialName("crimson")
    CRIMSON("crimson"),
    @SerialName("cyan")
    CYAN("cyan"),
    @SerialName("aqua")
    AQUA("aqua"),
    @SerialName("deep_pink")
    DEEP_PINK("deep_pink"),
    @SerialName("tomato")
    TOMATO("tomato"),
    @SerialName("yellow")
    YELLOW("yellow"),
    @SerialName("magenta")
    MAGENTA("magenta"),
    @SerialName("blue_green")
    BLUE_GREEN("blue_green"),
    @SerialName("orange")
    ORANGE("orange"),
    @SerialName("lime")
    LIME("lime"),
    @SerialName("green")
    GREEN("green"),
    @SerialName("emerald")
    EMERALD("emerald"),
    @SerialName("carmine")
    CARMINE("carmine"),
    @SerialName("nickel")
    NICKEL("nickel"),
    @SerialName("mint")
    MINT("mint"),
    @SerialName("army_green")
    ARMY_GREEN("army_green"),
    @SerialName("pumpkin")
    PUMPKIN("pumpkin");

    companion object {
        /**
         * Finds the specified enum name from its Color.
         *
         * @param value The Color e.g. (army_green, pumpkin etc.)
         * @see io.github.vxrpenter.ucs.enums.Color
         * @return the Color (nullable)
         */
        fun findEnum(value: String): Color? = Color.entries.find { it.color == value }

        /**
         * Finds the specified Color from its enum
         *
         * @param enum The enum e.g. (ARMY_GREEN, PUMPKIN etc.)
         * @see io.github.vxrpenter.ucs.enums.Color
         * @return the Color (nullable)
         */
        fun findValue(enum: Color): String? = Color.entries.find { it.name == enum.name }?.color
    }
}