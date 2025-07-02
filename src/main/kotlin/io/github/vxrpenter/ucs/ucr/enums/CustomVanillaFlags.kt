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

package io.github.vxrpenter.ucs.ucr.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class CustomVanillaFlags(val flag: String) {
    /**
     * Allows the player that has a custom role to have additional EXILED permissions.
     */
    @SerialName("CustomPermissions")
    CUSTOM_PERMISSION("CustomPermissions"),

    /**
     * Forces the game to make an announcement on the role's termination.
     */
    @SerialName("CustomScpAnnouncer")
    CUSTOM_SCP_ANNOUNCER("CustomScpAnnouncer"),

    /**
     * Makes the role unable to trigger SCP096.
     */
    @SerialName("DoNotTriggerScp096")
    DO_NOT_TRIGGER_SCP096("DoNotTriggerScp096"),

    /**
     * Makes the role not trigger tesla gates.
     */
    @SerialName("DoNotTriggerTeslaGates")
    DO_NOT_TRIGGER_TESLA_GATES("DoNotTriggerTeslaGates"),

    /**
     * Defines which specific item's the custom role should drop on death.
     */
    @SerialName("DropItemOnDeath")
    DROP_ITEM_ON_DEATH("DropItemOnDeath"),

    /**
     * Makes the custom role drop nothing on death.
     */
    @SerialName("DropNothingOnDeath")
    DROP_NOTHING_ON_DEATH("DropNothingOnDeath"),

    /**
     * Prevents the custom role from picking up and therefore using specific items.
     */
    @SerialName("ItemBan")
    ITEM_BAN("ItemBan"),

    /**
     * Allows the custom role to gain a certain amount of health upon damaging a player.
     */
    @SerialName("LifeStealer")
    LIFE_STEALER("LifeStealer"),

    /**
     * Makes the custom role see another custom role's 'real' appearances and not their 'fake' ones.
     */
    @SerialName("NotAffectedByAppearance")
    NOT_AFFECTED_BY_APPEARANCE("NotAffectedByAppearance"),

    /**
     * Prevents the custom role from being damaged until they damaged someone else.
     */
    @SerialName("PacifismUntilDamage")
    PACIFISM_UNTIL_DAMAGE("PacifismUntilDamage"),


    /**
     * Prevents the game from making a termination announcement of the custom role's death.
     */
    @SerialName("SilentAnnouncer")
    SILENT_ANNOUNCER("SilentAnnouncer"),

    /**
     * Prevents the custom role from making sounds while walking.
     */
    @SerialName("SilentWalker")
    SILENT_WALKER("SilentWalker"),

    /**
     * Spawns a tutorial ragdoll on the custom role's death instead of the intended one.
     */
    @SerialName("TutorialRagdoll")
    TUTORIAL_RAGDOLL("TutorialRagdoll");

    companion object {
        /**
         * Finds the specified enum name from its flag.
         *
         * @param value The flag e.g. (SilentWalker, TutorialRagdoll etc.)
         * @see io.github.vxrpenter.ucs.enums.secretlab.CustomVanillaFlags
         * @return the CustomVanillaFlag (nullable)
         */
        fun findEnum(value: String): CustomVanillaFlags? = CustomVanillaFlags.entries.find { it.flag == value }

        /**
         * Finds the specified flag from its enum
         *
         * @param enum The enum e.g. (SILENT_ANNOUNCER, TUTORIAL_RAGDOLL etc.)
         * @see io.github.vxrpenter.ucs.enums.secretlab.CustomVanillaFlags
         * @return the CustomVanillaFlag (nullable)
         */
        fun findValue(enum: CustomVanillaFlags): String? = CustomVanillaFlags.entries.find { it.name == enum.name }?.flag
    }
}