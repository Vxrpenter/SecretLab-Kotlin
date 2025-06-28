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
enum class RoleType(val id: Int) {
    @SerialName("None")
    NONE(-1),
    @SerialName("Scp173")
    SCP173(0),
    @SerialName("ClassD")
    CLASS_D(1),
    @SerialName("Spectator")
    SPECTATOR(2),
    @SerialName("Scp106")
    SCP106(3),
    @SerialName("NtfSpecialist")
    NTF_SPECIALIST(4),
    @SerialName("Scp049")
    SCP049(5),
    @SerialName("Scientist")
    SCIENTIST(6),
    @SerialName("Scp079")
    SCP079(7),
    @SerialName("ChaosConscript")
    CHAOS_CONSCRIPT(8),
    @SerialName("Scp096")
    SCP096(9),
    @SerialName("Scp0492")
    SCP0492(10),
    @SerialName("NtfSergeant")
    NTF_SERGEANT(11),
    @SerialName("NtfCaptain")
    NTF_CAPTAIN(12),
    @SerialName("NtfPrivate")
    NTF_PRIVATE(13),
    @SerialName("Tutorial")
    TUTORIAL(14),
    @SerialName("FacilityGuard")
    FACILITY_GUARD(15),
    @SerialName("Scp939")
    SCP939(16),
    @SerialName("CustomRole")
    CUSTOM_ROLE(17),
    @SerialName("ChaosRifleman")
    CHAOS_RIFLEMAN(18),
    @SerialName("ChaosMarauder")
    CHAOS_MARAUDER(19),
    @SerialName("ChaosRepressor")
    CHAOS_REPRESSOR(20),
    @SerialName("Overwatch")
    OVERWATCH(21),
    @SerialName("Filmmaker")
    FILMMAKER(22),
    @SerialName("Scp3114")
    SCP3114(23),
    @SerialName("Flamingo")
    FLAMINGO(24),
    @SerialName("AlphaFlamingo")
    ALPHA_FLAMINGO(25),
    @SerialName("ZombieFlamingo")
    ZOMBIE_FLAMINGO(26);

    companion object {
        fun find(value: Int): RoleType? = RoleType.entries.find { it.id == value }
    }
}