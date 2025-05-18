package io.github.vxrpenter.secretlab
import io.github.vxrpenter.secretlab.exceptions.CallFailureException
import io.github.vxrpenter.secretlab.data.ServerInfo
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.slf4j.LoggerFactory
import java.util.concurrent.TimeUnit

class SecretLab(private val apiKey: String, private val accountId: String, readTimeout: Long = 60, writeTimeout: Long = 60) {
    private val logger = LoggerFactory.getLogger(SecretLab::class.java)
    private val client: OkHttpClient = OkHttpClient.Builder()
        .readTimeout(readTimeout, TimeUnit.SECONDS)
        .writeTimeout(writeTimeout, TimeUnit.SECONDS)
        .build()

    /**
     * Endpoint for getting server info
     *
     * @param lo query last login?
     * @param players query player count?
     * @param list query player list?
     * @param info query basic info?
     * @param pastebin query pastebin id?
     * @param version query version?
     * @param flags query flags like whitelist or friendly fire?
     * @param nicknames query player nicknames in the player list?
     * @param online query online status?
     *
     * @return the Server info
     * @throws CallFailureException inherited from `SecretLabException`
     */
    fun serverInfo(lo: Boolean = true, players: Boolean = true, list: Boolean = true, info: Boolean = true, pastebin: Boolean = true, version: Boolean = true, flags: Boolean = true, nicknames: Boolean = true, online: Boolean = true): ServerInfo {
        val request = Request.Builder()
            .url("https://api.scpslgame.com/serverinfo.php?id=$accountId&key=$apiKey&lo=$lo&players=$players&list=$list&info=$info&pastebin=$pastebin&version=$version&flags=$flags&nicknames=$nicknames&online=$online")
            .build()

        try {
            client.newCall(request).execute().use { response ->
                logCall(request.url.toString(), response.isSuccessful, response.code, response.message)
                val obj = Json.decodeFromString<ServerInfo>(response.body!!.string())

                obj.response = getResponseTime(response)
                return obj
            }
        } catch (e: Exception) {
            throw CallFailureException("Failed to get server info from ${request.url}", e)
        }
    }

    /**
     * Endpoint for getting current ip
     *
     * @return current ip
     * @throws CallFailureException inherited from `SecretLabException`
     */
    fun ip(): String {
        val request = Request.Builder()
            .url("https://api.scpslgame.com/ip.php")
            .build()

        try {
            client.newCall(request).execute().use { response ->
                logCall(request.url.toString(), response.isSuccessful, response.code, response.message)
                return response.body!!.string()
            }
        } catch (e: Exception) {
            throw CallFailureException("Failed to get ip from ${request.url}", e)
        }
    }

    private fun getResponseTime(response: Response): Long {
        val sent = response.sentRequestAtMillis
        val received = response.receivedResponseAtMillis

        return (received-sent)
    }

    private fun logCall(requestUrl: String, successful: Boolean, exitCode: Int, statusMessage: String) {
        if (successful) {
            logger.debug("Request to $requestUrl was successful with exitcode $exitCode $statusMessage")
        } else {

            logger.debug("Request to $requestUrl has failed with exitcode $exitCode $statusMessage")
        }
    }
}
