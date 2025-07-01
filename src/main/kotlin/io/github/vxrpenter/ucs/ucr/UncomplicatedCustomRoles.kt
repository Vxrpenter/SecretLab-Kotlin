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

package io.github.vxrpenter.ucs.ucr

import com.charleskorn.kaml.Yaml
import io.github.vxrpenter.ucs.enums.PluginLoader
import io.github.vxrpenter.ucs.exceptions.CouldNotLocateFileException
import io.github.vxrpenter.ucs.exceptions.FileIsNotDirectoryException
import io.github.vxrpenter.ucs.getUncomplicatedCustomRolesConfigurationPath
import io.github.vxrpenter.ucs.ucr.data.UncomplicatedCustomRole
import kotlinx.serialization.encodeToString
import java.io.File
import java.nio.file.Path
import kotlin.io.path.Path
import kotlin.io.path.createFile
import kotlin.io.path.isDirectory
import kotlin.io.path.writeText

/**
 * Various methods to query and write UncomplicatedCustomRoles configuration files
 *
 * @param serverPath The absolute path that the server is located in, e.g. `/home/testserver/server/`
 * @param overridePath Overrides the path found by the ConfigurationFinder
 */
class UncomplicatedCustomRoles(val serverPath: Path, val overridePath: Path? = null) {
    private val yaml = Yaml.default

    private val fileIsNotDirectoryException = FileIsNotDirectoryException("Failed to locate UncomplicatedCustomRole configuration file", Throwable("Entered path for server files is not a directory/does not exist"))
    private val couldNotLocationFileException = CouldNotLocateFileException("Failed to locate UncomplicatedCustomRole configuration file", Throwable("No configuration file was found in directory"))

    /**
     * Finds a specific UncomplicatedCustomRoles configuration file
     *
     * @param name The name of the configuration without the extension
     * @param loader The loader that the plugin is installed with
     * @return the configuration in serialized UncomplicatedCustomRole form
     */
    fun getConfiguration(name: String, loader: PluginLoader): UncomplicatedCustomRole {
        // Get the filepath
        var uncomplicatedCustomRolesPath = getUncomplicatedCustomRolesConfigurationPath(loader, serverPath)
        overridePath?.let { uncomplicatedCustomRolesPath = overridePath }
        if (!uncomplicatedCustomRolesPath.isDirectory()) throw fileIsNotDirectoryException

        // Check files in the filepath for configuration to serialize the correct file
        var currentFile: File? = null
        uncomplicatedCustomRolesPath.toFile().walk().forEach { file -> if (file.name.replace(".yml", "") == name) currentFile = file }

        // Serialize the found file to return it to the user
        if (currentFile == null) throw couldNotLocationFileException
        val decodedYaml = yaml.decodeFromString(UncomplicatedCustomRole.serializer(), currentFile.readText())

        return decodedYaml
    }

    /**
     * Finds all UncomplicatedCustomRoles configurations in the entered folder
     *
     * @param loader The loader that the plugin is installed with
     * @return a lust if configurations in serialized UncomplicatedCustomRole form
     */
    fun getConfigurations(loader: PluginLoader): List<UncomplicatedCustomRole> {
        // Get the filepath
        var uncomplicatedCustomRolesPath = getUncomplicatedCustomRolesConfigurationPath(loader, serverPath)
        overridePath?.let { uncomplicatedCustomRolesPath = overridePath }
        if (!uncomplicatedCustomRolesPath.isDirectory()) throw fileIsNotDirectoryException

        //Get a list of configuration files in the folder for serialization
        val fileList = emptyList<File>().toMutableList()
        uncomplicatedCustomRolesPath.toFile().walk().forEach { file -> if (file.extension == "yml") fileList.add(file) }

        // Check if no files were found to proceed without any errors
        if (fileList.isEmpty()) throw couldNotLocationFileException

        // Serialize the found files to return them to the user
        val configurationList = emptyList<UncomplicatedCustomRole>().toMutableList()
        for (file in fileList) configurationList.add(yaml.decodeFromString(UncomplicatedCustomRole.serializer(), file.readText()))

        return configurationList.toList()
    }

    /**
     * Writes a specific UncomplicatedCustomRoles configuration to the entered configuration folder
     *
     * @param configuration The serialized configuration to be written
     * @param filename The name of the file to be written to without an extension
     * @param loader The loader that the plugin is installed with
     */
    fun writeConfiguration(configuration: UncomplicatedCustomRole, filename: String, loader: PluginLoader) {
        // Get the filepath
        var uncomplicatedCustomRolesPath = getUncomplicatedCustomRolesConfigurationPath(loader, serverPath)
        overridePath?.let { uncomplicatedCustomRolesPath = overridePath }
        if (!uncomplicatedCustomRolesPath.isDirectory()) throw fileIsNotDirectoryException

        //Get a list of configuration files in the folder for checking for existing configuration
        val fileList = emptyList<File>().toMutableList()
        uncomplicatedCustomRolesPath.toFile().walk().forEach { file -> if (file.extension == "yml") fileList.add(file) }

        // Check if there is already an existing configuration file for overwriting available
        for (file in fileList) {
            if (file.name.replace(".yml", "") != filename.replace(".yml", "")) continue
            file.writeText(yaml.encodeToString(configuration))
            return
        }

        // Create a new file and write the new content in it
        val file = Path("$uncomplicatedCustomRolesPath/$filename.yml")
        file.createFile()
        file.writeText(yaml.encodeToString(configuration))
    }

    /**
     * Writes a list (hashmap) of UncomplicatedCustomRoles configuration to the entered configuration folder
     *
     * @param configurations A hashmap of configuration files, having filename, without an extension, as a key value
     * and the serialized configuration as the value
     * @param loader The loader that the plugin is installed with
     */
    fun writeConfigurations(configurations: HashMap<String, UncomplicatedCustomRole>, loader: PluginLoader) {
        // Get the filepath
        var uncomplicatedCustomRolesPath = getUncomplicatedCustomRolesConfigurationPath(loader, serverPath)
        overridePath?.let { uncomplicatedCustomRolesPath = overridePath }
        if (!uncomplicatedCustomRolesPath.isDirectory()) throw fileIsNotDirectoryException

        //Get a list of configuration files in the folder for checking for existing configuration
        val fileList = emptyList<File>().toMutableList()
        uncomplicatedCustomRolesPath.toFile().walk().forEach { file -> if (file.extension == "yml") fileList.add(file) }

        // Check if there are already existing configuration files for overwriting available
        for (file in fileList) {
            if (configurations[file.name.replace(".yml", "")] == null) continue
            file.writeText(yaml.encodeToString(configurations[file.name.replace(".yml", "")]))
            return
        }

        // Create new configuration files and write the content to them
        configurations.forEach { currentConfiguration ->
            val fileName = currentConfiguration.key
            val configuration = currentConfiguration.value

            val file = Path("$uncomplicatedCustomRolesPath/$fileName.yml")
            file.createFile()
            file.writeText(yaml.encodeToString(configuration))
        }
    }
}