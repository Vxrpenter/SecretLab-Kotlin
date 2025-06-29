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

package io.github.vxrpenter.ucs

import io.github.vxrpenter.ucs.enums.PluginLoader
import java.nio.file.Path
import kotlin.io.path.Path

/**
 * Locates the configuration file(s) of UncomplicatedCustomRoles plugin and returns them for
 * usage
 *
 * Example Usage:
 * ```kotlin
 * val encodedJsonString = getUncomplicatedCustomRolesContent(PluginLoader.EXILED, serverDirectory)
 * ```
 *
 * @param loader The loader of the plugin, deciding the exact location in the server files
 * @param serverDirectory The directory where the server is location e.g. `/home/serverUser/server/`
 * @return The Path of the configuration files
 */
fun getUncomplicatedCustomRolesConfigurationPath(loader: PluginLoader, serverDirectory: Path): Path {
    val uncomplicatedCustomRolesLabApiLocation = ""
    val uncomplicatedCustomRolesExiledLocation = ".config/EXILED/Configs/UncomplicatedCustomRoles"

    return when(loader) {
        PluginLoader.EXILED -> Path("$serverDirectory$uncomplicatedCustomRolesExiledLocation")

        PluginLoader.LAB_API -> Path("$serverDirectory$uncomplicatedCustomRolesLabApiLocation")
    }
}

