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

package io.github.vxrpenter.ucs.uci

import com.charleskorn.kaml.Yaml
import io.github.vxrpenter.ucs.enums.PluginLoader
import io.github.vxrpenter.ucs.enums.secretlab.ItemType
import io.github.vxrpenter.ucs.uci.data.UncomplicatedCustomItem
import io.github.vxrpenter.ucs.uci.data.UncomplicatedCustomItemData
import io.github.vxrpenter.ucs.uci.data.customdata.UCICustomAdrenalineData
import io.github.vxrpenter.ucs.uci.data.customdata.UCICustomArmorData
import io.github.vxrpenter.ucs.uci.data.customdata.UCICustomExplosiveGrenadeData
import io.github.vxrpenter.ucs.uci.data.customdata.UCICustomFlashGrenadeData
import io.github.vxrpenter.ucs.uci.data.customdata.UCICustomItemData
import io.github.vxrpenter.ucs.uci.data.customdata.UCICustomJailbirdData
import io.github.vxrpenter.ucs.uci.data.customdata.UCICustomKeycardData
import io.github.vxrpenter.ucs.uci.data.customdata.UCICustomMedkitData
import io.github.vxrpenter.ucs.uci.data.customdata.UCICustomPainkillersData
import io.github.vxrpenter.ucs.uci.data.customdata.UCICustomScp018Data
import io.github.vxrpenter.ucs.uci.data.customdata.UCICustomScp1576Data
import io.github.vxrpenter.ucs.uci.data.customdata.UCICustomScp1853Data
import io.github.vxrpenter.ucs.uci.data.customdata.UCICustomScp207
import io.github.vxrpenter.ucs.uci.data.customdata.UCICustomScp217Data
import io.github.vxrpenter.ucs.uci.data.customdata.UCICustomScp244Data
import io.github.vxrpenter.ucs.uci.data.customdata.UCICustomScp500Data
import io.github.vxrpenter.ucs.uci.data.customdata.UCICustomWeaponData
import io.github.vxrpenter.ucs.uci.enums.CustomItemType
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString

class UncomplicatedCustomItems {
    inline fun <reified T> customUCIDecoder(yaml: String): T = Yaml.default.decodeFromString<T>(yaml)

    fun toSplittetData(defaultItemType: ItemType, itemType: CustomItemType, customData: UncomplicatedCustomItemData): Any? {
        val yaml = Yaml.default.encodeToString<UncomplicatedCustomItemData>(customData)

        return when(itemType) {
            CustomItemType.ITEM -> customUCIDecoder<UCICustomItemData>(yaml)
            CustomItemType.KEYCARD -> customUCIDecoder<UCICustomKeycardData>(yaml)
            CustomItemType.ARMOR -> customUCIDecoder<UCICustomArmorData>(yaml)
            CustomItemType.WEAPON -> customUCIDecoder<UCICustomWeaponData>(yaml)
            CustomItemType.MEDKIT -> customUCIDecoder<UCICustomMedkitData>(yaml)
            CustomItemType.PAINKILLERS -> customUCIDecoder<UCICustomPainkillersData>(yaml)
            CustomItemType.JAILBIRD -> customUCIDecoder<UCICustomJailbirdData>(yaml)
            CustomItemType.EXPLOSIVE_GRENADE -> customUCIDecoder<UCICustomExplosiveGrenadeData>(yaml)
            CustomItemType.FLASH_GRENADE -> customUCIDecoder<UCICustomFlashGrenadeData>(yaml)
            CustomItemType.ADRENALINE -> customUCIDecoder<UCICustomAdrenalineData>(yaml)
            CustomItemType.SCP_ITEM -> retrieveCustomScpItemData(defaultItemType, customData)
        }
    }

    inline fun <reified T> toCustomData(defaultItemType: ItemType, itemType: CustomItemType, customData: T): UncomplicatedCustomItem {
        val yaml = Yaml.default.encodeToString<T>(customData)

        return customUCIDecoder<UncomplicatedCustomItem>(yaml)
    }

    private fun retrieveCustomScpItemData(itemType: ItemType, customData: UncomplicatedCustomItemData): Any? {
        val yaml = Yaml.default.encodeToString<UncomplicatedCustomItemData>(customData)

        return when(itemType) {
            ItemType.SCP500 -> customUCIDecoder<UCICustomScp500Data>(yaml)
            ItemType.SCP207 -> customUCIDecoder<UCICustomScp207>(yaml)
            ItemType.SCP018 -> customUCIDecoder<UCICustomScp018Data>(yaml)
            ItemType.SCP2176 -> customUCIDecoder<UCICustomScp217Data>(yaml)
            ItemType.SCP244a -> customUCIDecoder<UCICustomScp244Data>(yaml)
            ItemType.SCP244b -> customUCIDecoder<UCICustomScp244Data>(yaml)
            ItemType.SCP1853 -> customUCIDecoder<UCICustomScp1853Data>(yaml)
            ItemType.SCP1576 -> customUCIDecoder<UCICustomScp1576Data>(yaml)
            else -> {
                null
            }
        }
    }
}