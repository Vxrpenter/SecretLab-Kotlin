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
import com.charleskorn.kaml.YamlConfiguration
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
    private val yaml = Yaml(configuration = YamlConfiguration(strictMode = false))
    inline fun <reified T> customUCIDecoder(yaml: String): T = Yaml(configuration = YamlConfiguration(strictMode = false)).decodeFromString<T>(yaml)

    fun toSplittetData(defaultItemType: ItemType, itemType: CustomItemType, customData: UncomplicatedCustomItem): UncomplicatedCustomItem? {
        val currentYaml = yaml.encodeToString<UncomplicatedCustomItemData>(customData.customData)


        when(itemType) {
            CustomItemType.ITEM -> customData.customItemData =  customUCIDecoder<UCICustomItemData>(currentYaml)
            CustomItemType.KEYCARD -> customData.customKeycardData =  customUCIDecoder<UCICustomKeycardData>(currentYaml)
            CustomItemType.ARMOR -> customData.customArmorData =  customUCIDecoder<UCICustomArmorData>(currentYaml)
            CustomItemType.WEAPON -> customData.customWeaponData =  customUCIDecoder<UCICustomWeaponData>(currentYaml)
            CustomItemType.MEDKIT -> customData.customMedkitDat =  customUCIDecoder<UCICustomMedkitData>(currentYaml)
            CustomItemType.PAINKILLERS -> customData.customPainkillersData =  customUCIDecoder<UCICustomPainkillersData>(currentYaml)
            CustomItemType.JAILBIRD -> customData.customJailbirdData =  customUCIDecoder<UCICustomJailbirdData>(currentYaml)
            CustomItemType.EXPLOSIVE_GRENADE -> customData.customExplosiveGrenadeData =  customUCIDecoder<UCICustomExplosiveGrenadeData>(currentYaml)
            CustomItemType.FLASH_GRENADE -> customData.customFlashGrenadeData =  customUCIDecoder<UCICustomFlashGrenadeData>(currentYaml)
            CustomItemType.ADRENALINE -> customData.customAdrenalineData =  customUCIDecoder<UCICustomAdrenalineData>(currentYaml)
            CustomItemType.SCP_ITEM -> return retrieveCustomScpItemData(defaultItemType, customData)
        }

        return customData
    }

    inline fun <reified T> toCustomData(defaultItemType: ItemType, itemType: CustomItemType, customData: T): UncomplicatedCustomItem {
        val currentYaml = Yaml(configuration = YamlConfiguration(strictMode = false)).encodeToString<T>(customData)

        return customUCIDecoder<UncomplicatedCustomItem>(currentYaml)
    }

    private fun retrieveCustomScpItemData(itemType: ItemType, customData: UncomplicatedCustomItem): UncomplicatedCustomItem? {
        val currentYaml = yaml.encodeToString<UncomplicatedCustomItemData>(customData.customData)

        when(itemType) {
            ItemType.SCP500 -> customData.customScp500Data = customUCIDecoder<UCICustomScp500Data>(currentYaml)
            ItemType.SCP207 -> customData.customScp207Data = customUCIDecoder<UCICustomScp207>(currentYaml)
            ItemType.SCP018 -> customData.customScp018Data = customUCIDecoder<UCICustomScp018Data>(currentYaml)
            ItemType.SCP2176 -> customData.customScp2176Data = customUCIDecoder<UCICustomScp217Data>(currentYaml)
            ItemType.SCP244a -> customData.customScp244Data = customUCIDecoder<UCICustomScp244Data>(currentYaml)
            ItemType.SCP244b -> customData.customScp244Data = customUCIDecoder<UCICustomScp244Data>(currentYaml)
            ItemType.SCP1853 -> customData.customScp1853Data = customUCIDecoder<UCICustomScp1853Data>(currentYaml)
            ItemType.SCP1576 -> customData.customScp1576Data = customUCIDecoder<UCICustomScp1576Data>(currentYaml)
            else -> {
                null
            }
        }

        return customData
    }
}