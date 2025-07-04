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

package io.github.vxrpenter.ucs.uci.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class CustomFlags(val flag: Int) {
    @SerialName("None")
    NONE(0),
    @SerialName("DoNotTriggerTeslaGates")
    DO_NOT_TRIGGER_TESLA_GATES(1),
    @SerialName("LifeSteal")
    LIFE_STEAL(2),
    @SerialName("InfiniteAmmo")
    INFINITE_AMMO(3),
    @SerialName("DieOnUse")
    DIE_ON_USE(4),
    @SerialName("WorkstationBan")
    WORKSTATION_BAN(5),
    @SerialName("ItemGlow")
    ITEM_GLOW(6),
    @SerialName("EffectWhenUsed")
    EFFECT_WHEN_USED(7),
    @SerialName("EffectShot")
    EFFECT_SHOT(8),
    @SerialName("EffectWhenEquiped")
    EFFECT_WHEN_EQUIPED(9),
    @SerialName("NoCharge")
    NO_CHARGE(10),
    @SerialName("CustomSound")
    CUSTOM_SOUND(11),
    @SerialName("ExplosiveBullets")
    EXPLOSIVE_BULLETS(12),
    @SerialName("ToolGun")
    TOOL_GUN(13),
    @SerialName("SpawnItemWhenDetonated")
    SPAWN_ITEM_WHEN_DETONATED(14),
    @SerialName("Cluster")
    CLUSTER(15),
    @SerialName("SwitchRoleOnUse")
    SWITCH_ROLE_ON_USE(16),
    @SerialName("DieOnDrop")
    DIE_ON_DROP(17),
    @SerialName("VaporizeKills")
    VAPORIZE_KILLS(18),
    @SerialName("CantDrop")
    CANT_DROP(19),
    @SerialName("ChangeAppearanceOnKill")
    CHANGE_APPEARANCE_ON_KILL(20),
    @SerialName("Disguise")
    DISGUISE(21),
    @SerialName("Craftable")
    CRAFTABLE(22),
    @SerialName("HealOnKill")
    HEAL_ON_KILL(23),
    @SerialName("Capybara")
    CAPYBARA(24),
    @SerialName("Custom")
    CUSTOM(48);

    companion object {
        /**
         * Finds the specified enum name from its CustomFlags.
         *
         * @param value The CustomFlags e.g. (Capybara, Custom, etc.)
         * @see io.github.vxrpenter.ucs.uci.enums.CustomFlags
         * @return the CustomFlags (nullable)
         */
        fun findEnum(value: Int): CustomFlags? = CustomFlags.entries.find { it.flag == value }

        /**
         * Finds the specified CustomFlags from its enum
         *
         * @param enum The enum e.g. (CAPYBARA, CUSTOM etc.)
         * @see io.github.vxrpenter.ucs.uci.enums.CustomFlags
         * @return the CustomFlags (nullable)
         */
        fun findValue(enum: CustomFlags): Int? = CustomFlags.entries.find { it.name == enum.name }?.flag
    }
}