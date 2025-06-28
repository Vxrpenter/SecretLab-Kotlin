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
enum class CustomFlags(val flag: String) {
    @SerialName("CustomPermissions")
    CUSTOM_PERMISSION("CustomPermissions"),
    @SerialName("CustomScpAnnouncer")
    CUSTOM_SCP_ANNOUNCER("CustomScpAnnouncer"),
    @SerialName("DoNotTriggerScp096")
    DO_NOT_TRIGGER_SCP096("DoNotTriggerScp096"),
    @SerialName("DoNotTriggerTeslaGates")
    DO_NOT_TRIGGER_TESLA_GATES("DoNotTriggerTeslaGates"),
    @SerialName("DropItemOnDeath")
    DROP_ITEM_ON_DEATH("DropItemOnDeath"),
    @SerialName("DropNothingOnDeath")
    DROP_NOTHING_ON_DEATH("DropNothingOnDeath"),
    @SerialName("ItemBan")
    ITEM_BAN("ItemBan"),
    @SerialName("LifeStealer")
    LIFE_STEALER("LifeStealer"),
    @SerialName("NotAffectedByAppearance")
    NOT_AFFECTED_BY_APPEARANCE("NotAffectedByAppearance"),
    @SerialName("PacifismUntilDamage")
    PACIFISM_UNTIL_DAMAGE("PacifismUntilDamage"),
    @SerialName("SilentAnnouncer")
    SILENT_ANNOUNCER("SilentAnnouncer"),
    @SerialName("SilentWalker")
    SILENT_WALKER("SilentWalker"),
    @SerialName("TutorialRagdoll")
    TUTORIAL_RAGDOLL("TutorialRagdoll");

    companion object {
        fun find(value: String): CustomFlags? = CustomFlags.entries.find { it.flag == value }
    }
}