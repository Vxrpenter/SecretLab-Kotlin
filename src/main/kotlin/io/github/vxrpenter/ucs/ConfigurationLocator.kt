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
import io.github.vxrpenter.ucs.exceptions.NoConfigurationPathFound
import io.github.vxrpenter.ucs.uci.data.UncomplicatedCustomItem
import io.github.vxrpenter.ucs.ucr.data.UncomplicatedCustomRole
import io.github.vxrpenter.ucs.uct.data.UncomplicatedCustomTeam
import java.nio.file.Path
import kotlin.io.path.Path

/**
 * Locates the configuration file(s) of UncomplicatedCustomServer plugins
 *
 * Example Usage:
 * ```kotlin
 * val path = getUncomplicatedCustomServerConfigurationPath<T>(loader, serverPath)
 * ```
 *
 * @param loader The loader of the plugin, deciding the exact location in the server files
 * @param serverPath The directory where the server is location e.g. `/home/serverUser/server/`
 * @return T as the entered object
 */
inline fun <reified T> getUncomplicatedCustomServerConfigurationPath(loader: PluginLoader, serverPath: Path): Path {
    if (serverPath == Path("Error")) throw NoConfigurationPathFound("Failed to locate configuration file(s)", Throwable("No possible path has been provided for config querying"))
    val exiledConfigPath = ".config/EXILED/Configs"
    val labApiConfigPath = ""

    var path = Path("")
    when(loader) {
        PluginLoader.EXILED -> {
            if (UncomplicatedCustomRole is T) path = Path("$exiledConfigPath/UncomplicatedCustomRoles")
            if (UncomplicatedCustomTeam is T) path = Path("$exiledConfigPath/UncomplicatedCustomTeams")
            if (UncomplicatedCustomItem is T) path = Path("$exiledConfigPath/UncomplicatedCustomItems")
        }
        PluginLoader.LAB_API -> {
            if (UncomplicatedCustomRole is T) path = Path("$labApiConfigPath/UncomplicatedCustomRoles")
            if (UncomplicatedCustomTeam is T) path = Path("$labApiConfigPath/UncomplicatedCustomTeams")
            if (UncomplicatedCustomItem is T) path = Path("$labApiConfigPath/UncomplicatedCustomItems")
        }
    }

    path.root?.let { return path }
    throw NoConfigurationPathFound("Failed to locate configuration file(s)", Throwable("Wrong type has been inferred, available types are <UncomplicatedCustomRole>, <UncomplicatedCustomTeam> or <UncomplicatedCustomItem> "))
}

