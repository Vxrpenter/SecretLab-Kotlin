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
enum class ItemType(val id: Int) {
    @SerialName("KeycardJanitor")
    KEYCARD_JANITOR(0),
    @SerialName("KeycardScientist")
    KEYCARD_SCIENTIST(1),
    @SerialName("KeycardResearchCoordinator")
    KEYCARD_RESEARCH_COORDINATOR(2),
    @SerialName("KeycardZoneManager")
    KEYCARD_ZONE_MANAGER(3),
    @SerialName("KeycardGuard")
    KEYCARD_GUARD(4),
    @SerialName("KeycardMTFPrivate")
    KEYCARD_MTF_PRIVATE(5),
    @SerialName("KeycardContainmentEngineer")
    KEYCARD_CONTAINMENT_ENGINEER(6),
    @SerialName("KeycardMTFOperative")
    KEYCARD_MTF_OPERATIVE(7),
    @SerialName("KeycardMTFCaptain")
    KEYCARD_MTF_CAPTAIN(8),
    @SerialName("KeycardFacilityManager")
    KEYCARD_FACILITY_MANAGER(9),
    @SerialName("KeycardChaosInsurgency")
    KEYCARD_CHAOS_INSURGENCY(10),
    @SerialName("KeycardO5")
    KEYCARD_O5(11),
    @SerialName("Radio")
    RADIO(12),
    @SerialName("GunCOM15")
    GUN_COM15(13),
    @SerialName("Medkit")
    MEDKIT(14),
    @SerialName("Flashlight")
    FLASHLIGHT(15),
    @SerialName("MicroHID")
    MICRO_HID(16),
    SCP500(17),
    SCP207(18),
    @SerialName("Ammo12gauge")
    AMMO_12G_AUGE(19),
    @SerialName("GunE11SR")
    GUN_E11_SR(20),
    @SerialName("GunCrossvec")
    GUN_CROSSVEC(21),
    @SerialName("Ammo556x45")
    AMMO_5556X45(22),
    @SerialName("GunFSP9")
    GUN_FSP9(23),
    @SerialName("GunLogicer")
    GUN_LOGICER(24),
    @SerialName("GrenadeHE")
    GRENADE_HE(25),
    @SerialName("GrenadeFlash")
    GRENADE_FLASH(26),
    @SerialName("Ammo44cal")
    AMMO_44CAL(27),
    @SerialName("Ammo762x39")
    AMMO_762X39(28),
    @SerialName("Ammo9x19")
    AMMO_9X19(29),
    @SerialName("GunCOM18")
    GUN_COM18(30),
    SCP018(31),
    SCP268(32),
    @SerialName("Adrenaline")
    ADRENALINE(33),
    @SerialName("Painkillers")
    PAINKILLERS(34),
    @SerialName("Coin")
    COIN(35),
    @SerialName("ArmorLight")
    ARMOR_LIGHT(36),
    @SerialName("ArmorCombat")
    ARMOR_COMBAT(37),
    @SerialName("ArmorHeavy")
    ARMOR_HEAVY(38),
    @SerialName("GunRevolver")
    GUN_REVOLVER(39),
    @SerialName("GunAK")
    GUN_AK(40),
    @SerialName("GunShotgun")
    GUN_SHOTGUN(41),
    SCP330(42),
    SCP2176(43),
    SCP244a(44),
    SCP244b(45),
    SCP1853(46),
    @SerialName("ParticleDisruptor")
    PARTICLE_DISRUPTOR(47),
    @SerialName("GunCom45")
    GUN_COM45(48),
    SCP1576(49),
    @SerialName("Jailbird")
    JAILBIRD(50),
    @SerialName("AntiSCP207")
    ANTI_SCP207(51),
    @SerialName("GunFRMG0")
    GUN_FRMG0(52),
    @SerialName("GunA7")
    GUN_A7(53),
    @SerialName("Lantern")
    LANTERN(54),
    @SerialName("Snowball")
    SNOWBALL(55),
    @SerialName("Coal")
    COAL(56),
    @SerialName("SpecialCoal")
    SPECIAL_COAL(57),
    @SerialName("Tape")
    TAPE(58);

    companion object {
        /**
         * Finds the specified enum name from its ItemType.
         *
         * @param value The itemType e.g. (SpecialCoal, Tape etc.)
         * @see io.github.vxrpenter.ucs.enums.ItemType
         * @return the ItemType (nullable)
         */
        fun findEnum(value: Int): ItemType? = ItemType.entries.find { it.id == value }

        /**
         * Finds the specified ItemType from its enum
         *
         * @param enum The enum e.g. (SPECIAL_COAL, TAPE etc.)
         * @see io.github.vxrpenter.ucs.enums.ItemType
         * @return the ItemType (nullable)
         */
        fun findValue(enum: ItemType): Int? = ItemType.entries.find { it.name == enum.name }?.id
    }
}