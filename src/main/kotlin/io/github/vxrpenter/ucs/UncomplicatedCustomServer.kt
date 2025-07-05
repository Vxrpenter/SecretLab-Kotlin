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

import com.charleskorn.kaml.Yaml
import com.charleskorn.kaml.YamlConfiguration
import io.github.vxrpenter.ucs.enums.PluginLoader
import io.github.vxrpenter.ucs.exceptions.CouldNotLocateFileException
import io.github.vxrpenter.ucs.exceptions.FileIsNotDirectoryException
import io.github.vxrpenter.ucs.uci.UncomplicatedCustomItems
import io.github.vxrpenter.ucs.uci.data.UncomplicatedCustomItem
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import java.io.File
import java.nio.file.Path
import kotlin.io.path.Path
import kotlin.io.path.createFile
import kotlin.io.path.isDirectory
import kotlin.io.path.writeText
import kotlin.io.readText

/**
 * @param serverPath The path that the SCP: Secret Laboratory server is located at
 * @param overridePath An absolute path that overrides all path queries and forces the functions to use this path instead
 * @since 0.5.0
 * @author Vxrpenter
 */
class UncomplicatedCustomServer(val serverPath: Path? = null, val overridePath: Path? = null) {
    /**
     * Finds a specific UncomplicatedCustomServer's plugin's configuration file
     *
     * Example Usage:
     * ```kotlin
     * val config = UncomplicatedCustomServer(Path("/home/serverUser/server/")).get<UncomplicatedCustomRole>("test_role", PluginLoader.EXILED)
     * ```
     *
     * @param name The name of the configuration without the extension
     * @param loader The loader that the plugin is installed with
     * @return T as the entered object
     */
    @Suppress("UNUSED_PARAMETER")
    inline fun <reified T> get(name: String, loader: PluginLoader, returnRawUCICustomData: Boolean = false): T {
        val yaml = Yaml(configuration = YamlConfiguration(strictMode = false))

        // Get the filepath
        val path: Path = overridePath ?: getUncomplicatedCustomServerConfigurationPath<T>(loader, serverPath ?: Path("Error"))

        if (!path.isDirectory()) throw FileIsNotDirectoryException("Failed to locate configuration file(s)", Throwable("Path for server files is not a directory (does not exist)"))

        // Check files in the filepath for configuration to serialize the correct file
        var currentFile: File? = null
        path.toFile().walk().forEach { file -> if (file.name.replace(".yml", "") == name) currentFile = file }

        // Serialize the found file to return it to the user
        if (currentFile == null) throw CouldNotLocateFileException("Failed to locate configuration file(s)", Throwable("No configuration file found in directory"))
        var decodedYaml = yaml.decodeFromString<T>(currentFile.readText())

        if (UncomplicatedCustomItem::class.simpleName == T::class.simpleName && !returnRawUCICustomData) {
            val currentYaml = decodedYaml as UncomplicatedCustomItem
            decodedYaml = UncomplicatedCustomItems().toSplittetData(currentYaml.item, currentYaml.customItemType, currentYaml) as T
        }

        return decodedYaml
    }

    /**
     * Finds all UncomplicatedCustomServer's plugin's configurations in the entered folder
     *
     * Example Usage:
     * ```kotlin
     * val configs = UncomplicatedCustomServer(Path("/home/serverUser/server/")).getAll<UncomplicatedCustomRole>(PluginLoader.EXILED)
     * ```
     *
     * @param loader The loader that the plugin is installed with
     * @return a list of T as the entered object
     */
    @Suppress("UNUSED_PARAMETER")
    inline fun <reified T> getAll(loader: PluginLoader, returnRawUCICustomData: Boolean = false): List<T> {
        val yaml = Yaml(configuration = YamlConfiguration(strictMode = false))

        // Get the filepath
        val path: Path = overridePath ?: getUncomplicatedCustomServerConfigurationPath<T>(loader, serverPath?: Path("Error"))

        if (!path.isDirectory()) throw FileIsNotDirectoryException("Failed to locate configuration file(s)", Throwable("Path for server files is not a directory (does not exist)"))

        //Get a list of configuration files in the folder for serialization
        val fileList = emptyList<File>().toMutableList()
        path.toFile().walk().forEach { file -> if (file.extension == "yml") fileList.add(file) }

        // Check if no files were found to proceed without any errors
        if (fileList.isEmpty()) throw CouldNotLocateFileException("Failed to locate configuration file(s)", Throwable("No configuration file found in directory"))

        // Serialize the found files to return them to the user
        val configurationList = emptyList<T>().toMutableList()
        for (file in fileList) {
            var decodedYaml = yaml.decodeFromString<T>(file.readText())

            if (UncomplicatedCustomItem::class.simpleName == T::class.simpleName && !returnRawUCICustomData) {
                val currentYaml = decodedYaml as UncomplicatedCustomItem
                decodedYaml = UncomplicatedCustomItems().toSplittetData(currentYaml.item, currentYaml.customItemType, currentYaml) as T
            }
            configurationList.add(decodedYaml)
        }

        return configurationList.toList()
    }

    /**
     * Writes a specific UncomplicatedCustomServer's plugin's configuration to the entered configuration folder
     *
     * Example Usage:
     * ```kotlin
     * UncomplicatedCustomServer(Path("/home/serverUser/server/")).set<UncomplicatedCustomRole>(uncomplicatedCustomRole,"test_role",PluginLoader.EXILED)
     * ```
     *
     * @param configuration The serialized configuration to be written
     * @param filename The name of the file to be written to without an extension
     * @param loader The loader that the plugin is installed with
     */
    @Suppress("UNUSED_PARAMETER")
    inline fun <reified T> set(configuration: T, filename: String, loader: PluginLoader) {
        val yaml = Yaml(configuration = YamlConfiguration(strictMode = false))

        // Get the filepath
        val path: Path = overridePath ?: getUncomplicatedCustomServerConfigurationPath<T>(loader, serverPath?: Path("Error"))

        if (!path.isDirectory()) throw FileIsNotDirectoryException("Failed to locate configuration file(s)", Throwable("Path for server files is not a directory (does not exist)"))

        //Get a list of configuration files in the folder for checking for existing configuration
        val fileList = emptyList<File>().toMutableList()
        path.toFile().walk().forEach { file -> if (file.extension == "yml") fileList.add(file) }

        // Check if there is already an existing configuration file for overwriting available
        for (file in fileList) {
            if (file.name.replace(".yml", "") != filename.replace(".yml", "")) continue
            file.writeText(yaml.encodeToString<T>(configuration))
            return
        }

        // Create a new file and write the new content in it
        val file = Path("$path/$filename.yml")
        file.createFile()
        file.writeText(yaml.encodeToString<T>(configuration))
    }


    /**
     * Writes a list (hashmap) of UncomplicatedCustomServer's plugin's configuration to the entered configuration folder
     *
     * Example Usage:
     * ```kotlin
     * val configurations = hashMapOf<String, UncomplicatedCustomRole>()
     * configurations.put("test_1", uncomplicatedCustomRole1)
     * configurations.put("test_1", uncomplicatedCustomRole2)
     *
     * UncomplicatedCustomServer(Path("/home/serverUser/server/")).setAll<UncomplicatedCustomRole>(configurations, PluginLoader.EXILED)
     * ```
     *
     * @param configurations A hashmap of configuration files, having filename, without an extension, as a key value
     * and the serialized configuration as the value
     * @param loader The loader that the plugin is installed with
     */
    @Suppress("UNUSED_PARAMETER")
    inline fun <reified T> setAll(configurations: HashMap<String, T>, loader: PluginLoader) {
        val yaml = Yaml(configuration = YamlConfiguration(strictMode = false))

        // Get the filepath
        val path: Path = overridePath ?: getUncomplicatedCustomServerConfigurationPath<T>(loader, serverPath?: Path("Error"))

        if (!path.isDirectory()) throw FileIsNotDirectoryException("Failed to locate configuration file(s)", Throwable("Path for server files is not a directory (does not exist)"))

        //Get a list of configuration files in the folder for checking for existing configuration
        val fileList = emptyList<File>().toMutableList()
        path.toFile().walk().forEach { file -> if (file.extension == "yml") fileList.add(file) }

        // Check if there are already existing configuration files for overwriting available
        for (file in fileList) {
            val mapValue = configurations[file.name.replace(".yml", "")]
            if (mapValue == null) continue
            file.writeText(yaml.encodeToString<T>(mapValue))
            return
        }

        // Create new configuration files and write the content to them
        configurations.forEach { currentConfiguration ->
            val fileName = currentConfiguration.key
            val configuration = currentConfiguration.value

            val file = Path("$path/$fileName.yml")
            file.createFile()
            file.writeText(yaml.encodeToString<T>(configuration))
        }
    }
}