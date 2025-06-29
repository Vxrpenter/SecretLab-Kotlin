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
enum class EffectType(val effect: String) {
    @SerialName("AmnesiaItems")
    AMNESIA_ITEMS("AmnesiaItems"),
    @SerialName("AmnesiaVision")
    AMNESIA_VISION("AmnesiaVision"),
    @SerialName("Asphyxiated")
    ASPHYXIATED("Asphyxiated"),
    @SerialName("Bleeding")
    BLEEDING("Bleeding"),
    @SerialName("Blinded")
    BLINDED("Blinded"),
    @SerialName("Burned")
    BURNED("Burned"),
    @SerialName("Concussed")
    CONCUSSED("Concussed"),
    @SerialName("Corroding")
    CORRODING("Corroding"),
    @SerialName("Deafened")
    DEAFENED("Deafened"),
    @SerialName("Decontaminating")
    DECONTAMINATING("Decontaminating"),
    @SerialName("Disabled")
    DISABLED("Disabled"),
    @SerialName("Ensnared")
    ENSNARED("Ensnared"),
    @SerialName("Exhausted")
    EXHAUSTED("Exhausted"),
    @SerialName("Flashed")
    FLASHED("Flashed"),
    @SerialName("Hemorrhage")
    HEMORRHAGE("Hemorrhage"),
    @SerialName("Invigorated")
    INVIGORATED("Invigorated"),
    @SerialName("BodyshotReduction")
    BODY_SHOT_REDUCTION("BodyshotReduction"),
    @SerialName("Poisoned")
    POISONED("Poisoned"),
    @SerialName("Scp207")
    SCP207("Scp207"),
    @SerialName("Invisible")
    INVISIBLE("Invisible"),
    @SerialName("SinkHole")
    SINKHOLE("SinkHole"),
    @SerialName("DamageReduction")
    DAMAGE_REDUCTION("DamageReduction"),
    @SerialName("MovementBoost")
    MOVEMENT_BOOST("MovementBoost"),
    @SerialName("RainbowTaste")
    RAINBOW_TASTE("RainbowTaste"),
    @SerialName("SeveredHands")
    SEVERED_HANDS("SeveredHands"),
    @SerialName("Stained")
    STAINED("Stained"),
    @SerialName("Vitality")
    VITALITY("Vitality"),
    @SerialName("Hypothermia")
    HYPOTHERMIA("Hypothermia"),
    @SerialName("Scp1853")
    SCP1853("Scp1853"),
    @SerialName("CardiacArrest")
    CARDIAC_ARREST("CardiacArrest"),
    @SerialName("InsufficientLighting")
    INSUFFICIENT_LIGHTING("InsufficientLighting"),
    @SerialName("SoundtrackMute")
    SOUNDTRACK_MUTE("SoundtrackMute"),
    @SerialName("SpawnProtected")
    SPAWN_PROTECTED("SpawnProtected"),
    @SerialName("Traumatized")
    TRAUMATIZED("Traumatized"),
    @SerialName("AntiScp207")
    ANTI_SCP207("AntiScp207"),
    @SerialName("Scanned")
    SCANNED("Scanned"),
    @SerialName("PocketCorroding")
    POCKET_CORRODING("PocketCorroding"),
    @SerialName("SilentWalk")
    SILENT_WALK("SilentWalk"),
    @SerialName("Marshmallow")
    MARSHMALLOW("Marshmallow"),
    @SerialName("Strangled")
    STRANGLED("Strangled"),
    @SerialName("Ghostly")
    GHOSTLY("Ghostly");

    companion object {
        /**
         * Finds the specified enum name from its EffectType.
         *
         * @param value The flag e.g. (Strangled, Ghostly etc.)
         * @see io.github.vxrpenter.ucs.enums.EffectType
         * @return the EffectType (nullable)
         */
        fun findEnum(value: String): EffectType? = EffectType.entries.find { it.effect == value }

        /**
         * Finds the specified EffectType from its enum
         *
         * @param enum The enum e.g. (STRANGLED, GHOSTLY etc.)
         * @see io.github.vxrpenter.ucs.enums.EffectType
         * @return the EffectType (nullable)
         */
        fun findValue(enum: EffectType): String? = EffectType.entries.find { it.name == enum.name }?.effect
    }
}