package io.github.vxrpenter.scplist

import io.github.vxrpenter.scplist.data.ScpListServers
import io.github.vxrpenter.scplist.data.Server
import io.github.vxrpenter.scplist.exceptions.CallFailureException
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.slf4j.LoggerFactory
import java.util.concurrent.TimeUnit

@Serializable
private data class Info(
    val search: String,
    val countryFilter: List<String>,
    val hideEmptyServer: Boolean,
    val hideFullServer: Boolean,
    val friendlyName: Boolean,
    val whitelist: Boolean,
    val modded: Boolean,
    val sort: String)

class ScpList(readTimeout: Long = 60, writeTimeout: Long = 60) {
    private val logger = LoggerFactory.getLogger(ScpList::class.java)
    private val json = Json { ignoreUnknownKeys = true }
    private val client: OkHttpClient = OkHttpClient.Builder()
        .readTimeout(readTimeout, TimeUnit.SECONDS)
        .writeTimeout(writeTimeout, TimeUnit.SECONDS)
        .build()

    /**
     * Endpoint for getting information about al servers
     *
     * Endpoint: `/api/servers`
     *
     * @param search the search quote
     * @param countryFilter what countries to filter
     * @param hideEmptyServer hide empty servers?
     * @param hideFullServer hide full servers?
     * @param friendlyFire show friendly fire servers
     * @param whitelist show whitelisted servers?
     * @param modded show modded servers?
     * @param sort how to sort?
     *
     * @return the ScpListServers
     * @throws CallFailureException inherited from `ScpListException`
     */
    fun serverPost(search: String, countryFilter: List<String>, hideEmptyServer: Boolean = true, hideFullServer: Boolean = true, friendlyFire: Boolean = true, whitelist: Boolean = true, modded: Boolean = true, sort: String = "PLAYERS_DESC"): ScpListServers? {
        val data = Info(search, countryFilter, hideEmptyServer, hideFullServer, friendlyFire, whitelist, modded, sort)

        val request = Request.Builder()
            .url("https://api.scplist.kr/api/servers")
            .post(json.encodeToString(data).toRequestBody("application/json".toMediaTypeOrNull()))
            .build()

        try {
            client.newCall(request).execute().use { response ->
                logCall(request.url.toString(), response.isSuccessful, response.code, response.message)
                return Json.decodeFromString<ScpListServers>(response.body!!.string())
            }
        } catch (e: Exception) {
            throw CallFailureException("Failed to post server to ${request.url}", e)
        }
    }

    /**
     * Endpoint for getting a specific server
     *
     * Endpoint: `/api/servers/{serverId}`
     *
     * @param serverId id of the servers
     *
     * @return the Server
     * @throws CallFailureException inherited from `ScpListException`
     */
    fun serverGet(serverId: String): Server {

        val request = Request.Builder()
            .url("https://api.scplist.kr/api/servers/$serverId")
            .build()

        try {
            client.newCall(request).execute().use { response ->
                logCall(request.url.toString(), response.isSuccessful, response.code, response.message)
                return json.decodeFromString<Server>(response.body!!.string())
            }
        } catch (e: Exception) {
            throw CallFailureException("Failed to get server from ${request.url}", e)
        }
    }

    private fun logCall(requestUrl: String, successful: Boolean, exitCode: Int, statusMessage: String) {
        if (successful) {
            logger.debug("Request to $requestUrl was successful with exitcode $exitCode $statusMessage")
        } else {

            logger.debug("Request to $requestUrl has failed with exitcode $exitCode $statusMessage")
        }
    }
}