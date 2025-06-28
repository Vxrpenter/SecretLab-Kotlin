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
enum class RoomType(val room: String) {
    @SerialName("LczArmory")
    LCZ_ARMORY("LczArmory"),
    @SerialName("LczCurve")
    LCZ_CURVE("LczCurve"),
    @SerialName("LczStraight")
    LCZ_STRAIGHT("LczStraight"),
    @SerialName("Lcz330")
    LCZ_330("Lcz330"),
    @SerialName("Lcz914")
    LCZ_914("Lcz914"),
    @SerialName("LczCrossing")
    LCZ_CROSSING("LczCrossing"),
    @SerialName("LczTCross")
    LCZ_TCROSS("LczTCross"),
    @SerialName("LczCafe")
    LCZ_CAFE("LczCafe"),
    @SerialName("LczPlants")
    LCZ_PLANTS("LczPlants"),
    @SerialName("LczToilets")
    LCZ_TOILETS("LczToilets"),
    @SerialName("LczAirlock")
    LCZ_AIRLOCK("LczAirlock"),
    @SerialName("Lcz173")
    LCZ_173("Lcz173"),
    @SerialName("LczClassDSpawn")
    LCZ_CLASSD_SPAWN("LczClassDSpawn"),
    @SerialName("LczCheckpointB")
    LCZ_CHECKPOINT_B("LczCheckpointB"),
    @SerialName("LczGlassBox")
    LCZ_GLASS_BOX("LczGlassBox"),
    @SerialName("LczCheckpointA")
    LCZ_CHECKPOINT_A("LczCheckpointA"),
    @SerialName("Hcz079")
    HCZ_079("Hcz079"),
    @SerialName("HczEzCheckpointA")
    HCZ_EZ_CHECKPOINT_A("HczEzCheckpointA"),
    @SerialName("HczEzCheckpointB")
    HCZ_EZ_CHECKPOINT_B("HczEzCheckpointB"),
    @SerialName("HczArmory")
    HCZ_ARMORY("HczArmory"),
    @SerialName("Hcz939")
    HCZ_939("Hcz939"),
    @SerialName("HczHid")
    HCZ_HID("HczHid"),
    @SerialName("Hcz049")
    HCZ_049("Hcz049"),
    @SerialName("HczChkpA")
    HCZ_CHKP_A("HczChkpA"),
    @SerialName("HczCrossing")
    HCZ_CROSSING("HczCrossing"),
    @SerialName("Hcz106")
    HCZ_106("Hcz106"),
    @SerialName("HczNuke")
    HCZ_NUKE("HczNuke"),
    @SerialName("HczTesla")
    HCZ_TESLA("HczTesla"),
    @SerialName("HczTestRoom")
    HCZ_TEST_ROOM("HczTestRoom"),
    @SerialName("HczElevatorA")
    HCZ_ELEVATOR_A("HczElevatorA"),
    @SerialName("HczElevatorB")
    HCZ_ELEVATOR_B("HczElevatorB"),
    @SerialName("HczServers")
    HCZ_SERVERS("HczServers"),
    @SerialName("HczChkpB")
    HCZ_CHKP_B("HczChkpB"),
    @SerialName("HczTCross")
    HCZ_TCROSS("HczTCross"),
    @SerialName("HczCurve")
    HCZ_CURVE("HczCurve"),
    @SerialName("Hcz096")
    HCZ_096("Hcz096"),
    @SerialName("EzVent")
    EZ_VENT("EzVent"),
    @SerialName("EzIntercom")
    EZ_INTERCOM("EzIntercom"),
    @SerialName("EzGateA")
    EZ_GATE_A("EzGateA"),
    @SerialName("EzDownstairsPcs")
    EZ_DOWNSTAIRS_PCS("EzDownstairsPcs"),
    @SerialName("EzCurve")
    EZ_CURVE("EzCurve"),
    @SerialName("EzPcs")
    EZ_PCS("EzPcs"),
    @SerialName("EzCrossing")
    EZ_CROSSINGS("EzCrossing"),
    @SerialName("EzCollapsedTunnel")
    EZ_COLLAPSED_TUNNEL("EzCollapsedTunnel"),
    @SerialName("EzConference")
    EZ_CONFERENCE("EzConference"),
    @SerialName("EzStraight")
    EZ_STRAIGHT("EzStraight"),
    @SerialName("EzCafeteria")
    EZ_CAFETERIA("EzCafeteria"),
    @SerialName("EzUpstairsPcs")
    EZ_UPSTAIRS_PCS("EzUpstairsPcs"),
    @SerialName("EzGateB")
    EZ_GATE_B("EzGateB"),
    @SerialName("EzShelter")
    EZ_SHELTER("EzShelter"),
    @SerialName("Pocket")
    POCKET("Pocket"),
    @SerialName("Surface")
    SURFACE("Surface"),
    @SerialName("EzCheckpointHallway")
    EZ_CHECKPOINT_HALLWAY("EzCheckpointHallway");

    companion object {
        /**
         * Finds the specified enum name from its RoomType.
         *
         * @param value The RoomType e.g. (Surface, EzCheckpointHallway etc.)
         * @see io.github.vxrpenter.ucs.enums.RoomType
         * @return the RoomType (nullable)
         */
        fun findEnum(value: String): RoomType? = RoomType.entries.find { it.room == value }

        /**
         * Finds the specified RoomType from its enum
         *
         * @param enum The enum e.g. (SURFACE, EZ_CHECKPOINT_HALLWAY etc.)
         * @see io.github.vxrpenter.ucs.enums.RoomType
         * @return the RoomType (nullable)
         */
        fun findValue(enum: RoomType): String? = RoomType.entries.find { it.name == enum.name }?.room
    }
}