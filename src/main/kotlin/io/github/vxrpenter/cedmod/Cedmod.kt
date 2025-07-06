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

package io.github.vxrpenter.cedmod

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import io.github.vxrpenter.cedmod.data.Player
import io.github.vxrpenter.cedmod.enums.AppealStateType
import io.github.vxrpenter.cedmod.enums.HandleAppealType
import io.github.vxrpenter.cedmod.enums.MuteType
import io.github.vxrpenter.cedmod.exceptions.CallFailureException
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import org.slf4j.LoggerFactory
import java.util.concurrent.TimeUnit

@Suppress("UNUSED_PARAMETER")
class Cedmod(private val instanceUrl: String, private val apiKey: String, readTimeout: Long = 60, writeTimeout: Long = 60) {
    private val logger = LoggerFactory.getLogger(Cedmod::class.java)
    private val client: OkHttpClient = OkHttpClient.Builder()
        .readTimeout(readTimeout, TimeUnit.SECONDS)
        .writeTimeout(writeTimeout, TimeUnit.SECONDS)
        .build()

    /**
     * An endpoint to query existing appeals
     *
     * Endpoint: `/Api/Appeal/Query`
     *
     * @param q the query, for example, a userId or a steamid with added @steam at the end
     * @param max the number of results to be returned, if this exceeds 200, the session will be revoked
     * @param page the page to search on
     * @param close return closed appeals when true and open appeals when false
     *
     * @return the query as JsonObject
     * @throws CallFailureException inherited from `CedmodException`
     */
    fun appealQuery(q: String, max: Int = 10, page: Int = 0, close: Boolean = false): JsonObject {
        val request = Request.Builder()
            .url("$instanceUrl/Api/Appeal/Query?$q&max=$max&page=$page&close=$close")
            .header("Authorization", "Bearer $apiKey")
            .build()

        try {
            client.newCall(request).execute().use { response ->
                logCall(request.url.toString(), response.isSuccessful, response.code, response.message)
                return JsonParser.parseString(response.body?.string()).asJsonObject
            }
        } catch (e: Exception) {
            throw CallFailureException("Failed to query Appeal from ${request.url}", e)
        }
    }

    /**
     * An endpoint for handling appeals
     *
     * Endpoint: `/Api/Appeal/{appealId}/Handle`
     *
     * @param appealId id of the appeal
     * @param handleType what action should be taken?
     * @param reason the reason for the action taken
     * @param duration only applies on `DURATIONCHANGE`, can be set to 0 for all other types
     *
     * @return the response code of the action
     * @throws CallFailureException inherited from `CedmodException`
     */
    fun appealHandle(appealId: String, handleType: HandleAppealType, reason: String, duration: Int): Int? {
        val status = when (handleType) {
            HandleAppealType.DENY -> 1
            HandleAppealType.DURATIONCHANGE -> 2
            HandleAppealType.APPROVED -> 3
            HandleAppealType.RETRY -> 4
        }

        val json = "{\n" +
                "  \"appealStatus\":$status,\n" +
                "  \"reason\": \"$reason\",\n" +
                "  \"newDuration\":$duration\n" +
                "}"

        val request = Request.Builder()
            .url("$instanceUrl/Api/Appeal/$appealId/Handle")
            .header("Authorization", "Bearer $apiKey")
            .patch(json.toRequestBody("application/json".toMediaTypeOrNull()))
            .build()

        try {
            client.newCall(request).execute().use { response ->
                logCall(request.url.toString(), response.isSuccessful, response.code, response.message)
                return response.code
            }
        } catch (e: Exception) {
            throw CallFailureException("Failed to patch handle Appeal to ${request.url}", e)
        }
    }

    /**
     *
     * Endpoint for changing the appeal state of the ban
     *
     * Endpoint: `/Api/Ban/{banId}/AppealState`
     *
     * @param banId id of the ban
     * @param logReason reason for appeal state change
     * @param appealType type to change the appeal to
     *
     * @return the response code
     * @throws CallFailureException inherited from `CedmodException`
     */
    fun banPatchAppealState(banId: String, logReason: String, appealType: AppealStateType): Int {
        val state = when (appealType) {
            AppealStateType.ALLOW -> 0
            AppealStateType.DENY -> 1
        }

        val json = "{\n" +
                "  \"logReason\": \"$logReason\",\n" +
                "  \"appealState\": $state\n" +
                "}"

        val request = Request.Builder()
            .url("$instanceUrl/Api/Ban/$banId/AppealState")
            .header("Authorization", "Bearer $apiKey")
            .patch(json.toRequestBody("application/json".toMediaTypeOrNull()))
            .build()

        try {
            client.newCall(request).execute().use { response ->
                logCall(request.url.toString(), response.isSuccessful, response.code, response.message)
                return response.code
            }
        } catch (e: Exception) {
            throw CallFailureException("Failed to patch Ban appeal to ${request.url}", e)
        }
    }

    /**
     * Endpoint for changing bypass ability of a ban
     *
     * Endpoint: `/Api/Ban/{banId}/Bypassable`
     *
     * @param banId id of the ban
     * @param logReason the reason for the bypass
     * @param bypassableIds list of userIds that should be able to bypass
     *
     * @return the response code
     * @throws CallFailureException inherited from `CedmodException`
     */
    fun banPatchBypassable(banId: String, logReason: String, bypassableIds: List<String>): Int {
        val jsonObject = JsonObject()
        jsonObject.addProperty("logReason", logReason)

        val jsonArray = JsonArray()
        bypassableIds.forEach { jsonArray.add(it) }

        jsonObject.add("bypassable", jsonArray)

        val request = Request.Builder()
            .url("$instanceUrl/Api/Ban/$banId/Bypassable")
            .header("Authorization", "Bearer $apiKey")
            .patch(jsonObject.toString().toRequestBody("application/json".toMediaTypeOrNull()))
            .build()

        try {
            client.newCall(request).execute().use { response ->
                logCall(request.url.toString(), response.isSuccessful, response.code, response.message)
                return response.code
            }
        } catch (e: Exception) {
            throw CallFailureException("Failed to patch Ban bypassable to ${request.url}", e)
        }
    }

    /**
     * Endpoint for changing the ban duration
     *
     * Endpoint: `/Api/Ban/{banId}/Duration`
     *
     * @param banId id of the ban
     * @param logReason the reason for the duration change
     * @param duration new duration for the ban in seconds
     *
     * @return the response code
     * @throws CallFailureException inherited from `CedmodException`
     */
    fun banPatchDuration(banId: String, logReason: String, duration: Int): Int {
        val json = "{\n" +
                "  \"logReason\": \"$logReason\",\n" +
                "  \"newDuration\": $duration\n" +
                "}\n"

        val request = Request.Builder()
            .url("$instanceUrl/Api/Ban/$banId/Duration")
            .header("Authorization", "Bearer $apiKey")
            .patch(json.toRequestBody("application/json".toMediaTypeOrNull()))
            .build()

        try {
            client.newCall(request).execute().use { response ->
                logCall(request.url.toString(), response.isSuccessful, response.code, response.message)
                return response.code
            }
        } catch (e: Exception) {
            throw CallFailureException("Failed to patch Ban duration to ${request.url}", e)
        }
    }

    /**
     * Endpoint for changing the ban reason
     *
     * Endpoint: `/Api/Ban/{banId}/Reason`
     *
     * @param banId the id of the ban
     * @param logReason reason of the change
     * @param banReason the new reason
     *
     * @return the response code
     * @throws CallFailureException inherited from `CedmodException`
     */
    fun banPatchReason(banId: String, logReason: String, banReason: String): Int {
        val json = "{\n" +
                "  \"logReason\": \"$logReason\",\n" +
                "  \"newReason\": \"$banReason\"\n" +
                "}"

        val request = Request.Builder()
            .url("$instanceUrl/Api/Ban/$banId/Reason")
            .header("Authorization", "Bearer $apiKey")
            .patch(json.toRequestBody("application/json".toMediaTypeOrNull()))
            .build()

        try {
            client.newCall(request).execute().use { response ->
                logCall(request.url.toString(), response.isSuccessful, response.code, response.message)
                return response.code
            }
        } catch (e: Exception) {
            throw CallFailureException("Failed to patch Ban reason ${request.url}", e)
        }
    }

    /**
     * Endpoint for changing a ban
     *
     * Endpoint: `/Api/Ban/{banId}`
     *
     * @param banId id of the ban
     * @param reason the reason for the change
     *
     * @return the response code
     * @throws CallFailureException inherited from `CedmodException`
     */
    fun banPutBan(banId: String, reason: String): Int {
        val json = "{\n" +
                "  \"logReason\": \"$reason\"\n" +
                "}"

        val request = Request.Builder()
            .url("$instanceUrl/Api/Ban/$banId")
            .header("Authorization", "Bearer $apiKey")
            .put(json.toRequestBody("application/json".toMediaTypeOrNull()))
            .build()

        try {
            client.newCall(request).execute().use { response ->
                logCall(request.url.toString(), response.isSuccessful, response.code, response.message)
                return response.code
            }
        } catch (e: Exception) {
            throw CallFailureException("Failed to put Ban to ${request.url}", e)
        }
    }

    /**
     * Endpoint for issuing a ban
     *
     * Endpoint: `/Api/Ban/Issue`
     *
     * @param userId id of the user
     * @param reason reason for the ban
     * @param duration duration of the ban
     * @param appealable should the ban be appealable?
     * @param banlists list of banlists to add this ban to
     *
     * @return the response code
     * @throws CallFailureException inherited from `CedmodException`
     */
    fun banPostIssue(userId: String, reason: String, duration: Int, appealable: Boolean, banlists: List<Int>): Int {
        val jsonObject = JsonObject()
        jsonObject.addProperty("userId", userId)
        jsonObject.addProperty("reason", reason)
        jsonObject.addProperty("duration", duration)
        jsonObject.addProperty("appealable", appealable)

        val jsonArray = JsonArray()
        banlists.forEach { jsonArray.add(it) }
        jsonObject.add("banLists", jsonArray)

        val request = Request.Builder()
            .url("$instanceUrl/Api/Ban/Issue")
            .header("Authorization", "Bearer $apiKey")
            .post(jsonObject.toString().toRequestBody("application/json".toMediaTypeOrNull()))
            .build()

        try {
            client.newCall(request).execute().use { response ->
                logCall(request.url.toString(), response.isSuccessful, response.code, response.message)
                return response.code
            }
        } catch (e: Exception) {
            throw CallFailureException("Failed to post Ban issue to ${request.url}", e)
        }
    }

    /**
     * Endpoint for querying bans
     *
     * Endpoint: `Api/Ban/Query`
     *
     * @param q the query, being the userId, for example, a steamId with added @steam
     * @param banList banlist the ban is on
     * @param max maximum object count
     * @param page define the page
     * @param idOnly only query userIds
     *
     * @return the query as JsonObject
     * @throws CallFailureException inherited from `CedmodException`
     */
    fun banQuery(q: String, banList: String, max: Int = 10, page: Int = 0, idOnly: Boolean = true): JsonObject? {
        val request = Request.Builder()
            .url("$instanceUrl/Api/Ban/Query?q=$q&banList=$banList&max=$max&page=$page&idOnly=$idOnly")
            .header("Authorization", "Bearer $apiKey")
            .build()

        try {
            client.newCall(request).execute().use { response ->
                logCall(request.url.toString(), response.isSuccessful, response.code, response.message)
                return JsonParser.parseString(response.body?.string()).asJsonObject
            }
        } catch (e: Exception) {
            throw CallFailureException("Failed to query Ban from ${request.url}", e)
        }
    }

    /**
     * Endpoint for querying banlists
     *
     * Endpoint: `/Api/Banlist/Query`
     *
     * @param q the query
     * @param page define the page
     * @param max maximum object count
     *
     * @return the query as JsonObject
     * @throws CallFailureException inherited from `CedmodException`
     */
    fun banlistQuery(q: String, page: Int = 0, max: Int= 0): JsonObject? {
        val url = "$instanceUrl/Api/Banlist/Query?q=$q&page=$page&max=$max".also {
            if (page == 0 ) it.replace("&page=0", "")
            if (max == 0) it.replace("&max=0", "")
        }

        val request = Request.Builder()
            .url(url)
            .header("Authorization", "Bearer $apiKey")
            .build()

        try {
            client.newCall(request).execute().use { response ->
                logCall(request.url.toString(), response.isSuccessful, response.code, response.message)
                return JsonParser.parseString(response.body?.string()).asJsonObject
            }
        } catch (e: Exception) {
            throw CallFailureException("Failed to query Banlist from ${request.url}", e)
        }
    }

    /**
     * Endpoint for creating banlists
     *
     * Endpoint: `/Api/Banlist/17339`
     *
     * @param banlistId the id of the banlist that is being created
     * @param queryServerId id of the query server being your SL server in cedmod
     * @param serverWriteBans a string of server ids that bans can be written from
     * @param serverReadBans a string of server ids that bans can be read from
     * @param serverWriteMutes a string of server ids that mutes can be written from
     * @param serverReadMutes a string of server ids that mutes can be read from
     * @param serverWriteWarns a string of server ids that warns can be written from
     * @param serverReadWarns a string of server ids that warns can be read from
     * @param name name of the banlist
     * @param isMaster is the banlist the primary banlist?
     * @param isDefaultPanel should it be the default for panel bans?
     * @param isDefaultViewPanel should it be the default for being viewed in ban/mute managers?
     *
     * @return the response code
     * @throws CallFailureException inherited from `CedmodException`
     */
    fun banlistPut(banlistId: String, queryServerId: String, serverWriteBans: String, serverReadBans: String, serverWriteMutes: String, serverReadMutes: String, serverWriteWarns: String, serverReadWarns: String, name: String, isMaster: Boolean = false, isDefaultPanel: Boolean = false, isDefaultViewPanel: Boolean = true): Int {
        val json = "{\n" +
                "  \"id\": $queryServerId,\n" +
                "  \"isMaster\": $isMaster,\n" +
                "  \"isDefaultPanel\": $isDefaultPanel,\n" +
                "  \"isDefaultViewPanel\": $isDefaultViewPanel,\n" +
                "  \"serversWriteBans\": \"$serverWriteBans\",\n" +
                "  \"serversReadBans\": \"$serverReadBans\",\n" +
                "  \"serversWriteMutes\": \"$serverWriteMutes\",\n" +
                "  \"serversReadMutes\": \"$serverReadMutes\",\n" +
                "  \"serversWriteWarns\": \"$serverWriteWarns\",\n" +
                "  \"serversReadWarns\": \"$serverReadWarns\",\n" +
                "  \"data\": \"$name\"\n" +
                "}"

        val request = Request.Builder()
            .url("$instanceUrl/Api/Banlist/$banlistId")
            .header("Authorization", "Bearer $apiKey")
            .put(json.toRequestBody("application/json".toMediaTypeOrNull()))
            .build()

        try {
            client.newCall(request).execute().use { response ->
                logCall(request.url.toString(), response.isSuccessful, response.code, response.message)
                return response.code
            }
        } catch (e: Exception) {
            throw CallFailureException("Failed to put Banlist to ${request.url}", e)
        }
    }

    /**
     * Endpoint for deleting banlists
     *
     * Endpoint: `/Api/Banlist/{id}`
     *
     * @param banlist the banlist to delete
     * @param migrateList the banlist to migrate the bans to
     *
     * @return the response code
     * @throws CallFailureException inherited from `CedmodException`
     */
    fun banlistDelete(banlist: String, migrateList: String): Int {
        val request = Request.Builder()
            .url("$instanceUrl/Api/Banlist/$banlist/$migrateList")
            .header("Authorization", "Bearer $apiKey")
            .build()

        try {
            client.newCall(request).execute().use { response ->
                logCall(request.url.toString(), response.isSuccessful, response.code, response.message)
                return response.code
            }
        } catch (e: Exception) {
            throw CallFailureException("Failed to delete Banlist to ${request.url}", e)
        }
    }

    /**
     * Endpoint for adding ban-logs
     *
     * Endpoint: `/Api/BanLog/{banId}`
     *
     * @param banId id of the ban
     * @param logReason reason of the log
     *
     * @return the response code
     * @throws CallFailureException inherited from `CedmodException`
     */
    fun banLogPut(banId: String, logReason: String): Int {
        val json = "{\n" +
                "  \"logReason\": \"$logReason\"\n" +
                "}"

        val request = Request.Builder()
            .url("$instanceUrl/Api/BanLog/$banId")
            .header("Authorization", "Bearer $apiKey")
            .put(json.toRequestBody("application/json".toMediaTypeOrNull()))
            .build()

        try {
            client.newCall(request).execute().use { response ->
                logCall(request.url.toString(), response.isSuccessful, response.code, response.message)
                return response.code
            }
        } catch (e: Exception) {
            throw CallFailureException("Failed to put BanLog to ${request.url}", e)
        }
    }

    /**
     * Endpoint for querying banLogs
     *
     * Endpoint: `/Api/BanLog/Query`
     *
     * @param q the query being a userId most of the time
     * @param banList id of the banlist
     * @param max maximum number of results to return
     * @param page define the page
     * @param idOnly query only for userIds?
     *
     * @return the query as a JsonObject
     * @throws CallFailureException inherited from `CedmodException`
     */
    fun banLogQuery(q: String, banList: String, max: Int = 10, page: Int = 0, idOnly: Boolean = false): JsonObject? {
        val request = Request.Builder()
            .url("$instanceUrl/Api/BanLog/Query?q=$q&banList=$banList&max=$max&page=$page&idOnly=$idOnly")
            .header("Authorization", "Bearer $apiKey")
            .build()

        try {
            client.newCall(request).execute().use { response ->
                logCall(request.url.toString(), response.isSuccessful, response.code, response.message)
                return JsonParser.parseString(response.body?.string()).asJsonObject
            }
        } catch (e: Exception) {
            throw CallFailureException("Failed to query BanLog from ${request.url}", e)
        }
    }

    /**
     * Endpoint for getting the cedmod changelog
     *
     * Endpoint: `/Api/Changelog/Get`
     *
     * @return the changelog as JsonArray
     * @throws CallFailureException inherited from `CedmodException`
     */
    fun changelogGet(): JsonArray? {
        val request = Request.Builder()
            .url("$instanceUrl/Api/Changelog/Get")
            .header("Authorization", "Bearer $apiKey")
            .build()

        try {
            client.newCall(request).execute().use { response ->
                logCall(request.url.toString(), response.isSuccessful, response.code, response.message)
                return JsonParser.parseString(response.body?.string()).asJsonArray
            }
        } catch (e: Exception) {
            throw CallFailureException("Failed to get Changelog from ${request.url}", e)
        }
    }

    /**
     * Endpoint for getting server stats
     *
     * Endpoint: `/Api/Instance/Stats`
     *
     * @return the stats as JsonObject
     * @throws CallFailureException inherited from `CedmodException`
     */
    fun instanceGetStats(): JsonObject {
        val request = Request.Builder()
            .url("$instanceUrl/Api/Instance/Stats")
            .header("Authorization", "Bearer $apiKey")
            .build()

        try {
            client.newCall(request).execute().use { response ->
                logCall(request.url.toString(), response.isSuccessful, response.code, response.message)
                return JsonParser.parseString(response.body?.string()).asJsonObject
            }
        } catch (e: Exception) {
            throw CallFailureException("Failed to get Instance stats to ${request.url}", e)
        }
    }

    /**
     * Endpoint for submitting feedback
     *
     * Endpoint: `/Api/Feedback/Submit`
     *
     * @param feedback the feedback to submit
     * @param contact include contact?
     * @param credit include credit?
     *
     * @return the response code
     * @throws CallFailureException inherited from `CedmodException`
     */
    fun feedbackPostSubmit(feedback: String, contact: Boolean = true, credit: Boolean = true): Int {
        val json = "{\n" +
                "  \"feedbackText\": \"$feedback\",\n" +
                "  \"contact\": $contact,\n" +
                "  \"credit\": $credit\n" +
                "}"

        val request = Request.Builder()
            .url("$instanceUrl/Api/Feedback/Submit")
            .header("Authorization", "Bearer $apiKey")
            .post(json.toRequestBody("application/json".toMediaTypeOrNull()))
            .build()

        try {
            client.newCall(request).execute().use { response ->
                logCall(request.url.toString(), response.isSuccessful, response.code, response.message)
                return response.code
            }
        } catch (e: Exception) {
            throw CallFailureException("Failed to post Feedback submit to ${request.url}", e)
        }
    }

    /**
     * Endpoint for changing the mute type
     *
     * Endpoint: `/Api/Mute/{banId}/Type`
     *
     * @param muteId id of the mute
     * @param logReason reason for the change
     * @param muteType the new mute type
     *
     * @return the response code
     * @throws CallFailureException inherited from `CedmodException`
     */
    fun mutePatchType(muteId: String, logReason: String, muteType: MuteType): Int {
        val type = when (muteType) {
            MuteType.INTERCOM -> 0
            MuteType.GLOBAL -> 1
        }

        val json = "{\n" +
                "  \"logReason\": \"$logReason\",\n" +
                "  \"type\": $type\n" +
                "}"

        val request = Request.Builder()
            .url("$instanceUrl/Api/Mute/$muteId/Type")
            .header("Authorization", "Bearer $apiKey")
            .patch(json.toRequestBody("application/json".toMediaTypeOrNull()))
            .build()

        try {
            client.newCall(request).execute().use { response ->
                logCall(request.url.toString(), response.isSuccessful, response.code, response.message)
                return response.code
            }
        } catch (e: Exception) {
            throw CallFailureException("Failed to patch Mute type to ${request.url}", e)
        }
    }

    /**
     * Endpoint for changing mute duration
     *
     * Endpoint: `/Api/Mute/{banId}/Duration`
     *
     * @param muteId of the mute
     * @param logReason reason for the change
     * @param duration the new duration of the mute
     *
     * @return the response code
     * @throws CallFailureException inherited from `CedmodException`
     */
    fun mutePatchDuration(muteId: String, logReason: String, duration: Int): Int {
        val json = "{\n" +
                "  \"logReason\": \"$logReason\",\n" +
                "  \"newDuration\": $duration\n" +
                "}"

        val request = Request.Builder()
            .url("$instanceUrl/Api/Mute/$muteId/Duration")
            .header("Authorization", "Bearer $apiKey")
            .patch(json.toRequestBody("application/json".toMediaTypeOrNull()))
            .build()

        try {
            client.newCall(request).execute().use { response ->
                logCall(request.url.toString(), response.isSuccessful, response.code, response.message)
                return response.code
            }
        } catch (e: Exception) {
            throw CallFailureException("Failed to patch Mute duration to ${request.url}", e)
        }
    }

    /**
     * Endpoint for changing mute reason
     *
     * Endpoint: `/Api/Mute/{banId}/Reason`
     *
     * @param muteId the id of the mute
     * @param logReason reason for the change
     * @param newReason new reason for the mute
     *
     * @return the response code
     * @throws CallFailureException inherited from `CedmodException`
     */
    fun mutePatchReason(muteId: String, logReason: String, newReason: String): Int {
        val json = "{\n" +
                "  \"logReason\": \"$logReason\",\n" +
                "  \"newReason\": \"$newReason\"\n" +
                "}"

        val request = Request.Builder()
            .url("$instanceUrl/Api/Mute/$muteId/Reason")
            .header("Authorization", "Bearer $apiKey")
            .patch(json.toRequestBody("application/json".toMediaTypeOrNull()))
            .build()

        try {
            client.newCall(request).execute().use { response ->
                logCall(request.url.toString(), response.isSuccessful, response.code, response.message)
                return response.code
            }
        } catch (e: Exception) {
            throw CallFailureException("Failed to patch Mute reason to ${request.url}", e)
        }
    }

    /**
     * Endpoint for issuing mutes
     *
     * Endpoint: `/Api/Mute/Issue`
     *
     * @param userId id of the user
     * @param reason reason for the mute
     * @param duration duration of the mute in seconds
     * @param appealable should the mute be appealable?
     * @param banlists list of banlists to use
     * @param muteType which type of mute to choose
     *
     * @return the response body as a JsonObject
     * @throws CallFailureException inherited from `CedmodException`
     * */
    fun mutePostIssue(userId: String, reason: String, duration: Int, appealable: Boolean, banlists: List<Int>, muteType: MuteType): JsonObject? {
        val type = when (muteType) {
            MuteType.INTERCOM -> 0
            MuteType.GLOBAL -> 1
        }

        val jsonObject = JsonObject()
        jsonObject.addProperty("userId", userId)
        jsonObject.addProperty("reason", reason)
        jsonObject.addProperty("duration", duration)
        jsonObject.addProperty("appealable", appealable)

        val jsonArray = JsonArray()
        banlists.forEach { jsonArray.add(it) }
        jsonObject.add("banLists", jsonArray)
        jsonObject.addProperty("type", type)

        val request = Request.Builder()
            .url("$instanceUrl/Api/Mute/Issue")
            .header("Authorization", "Bearer $apiKey")
            .post(jsonObject.toString().toRequestBody("application/json".toMediaTypeOrNull()))
            .build()

        try {
            client.newCall(request).execute().use { response ->
                logCall(request.url.toString(), response.isSuccessful, response.code, response.message)
                return JsonParser.parseString(response.body?.string()).asJsonObject
            }
        } catch (e: Exception) {
            throw CallFailureException("Failed to post Mute issue to ${request.url}", e)
        }
    }

    /**
     * Endpoint for querying mutes
     *
     * Endpoint: `/Api/Mute/Query`
     *
     * @param q the query being mostly user ids
     * @param banList the banlist to query from
     * @param max the maximum number of objects
     * @param page the page
     * @param idOnly should only user ids be queried?
     *
     * @return the response body as JsonObject
     * @throws CallFailureException inherited from `CedmodException`
     */
    fun muteQuery(q: String, banList: String, max: Int = 10, page: Int = 0, idOnly: Boolean = false): JsonObject? {
        val request = Request.Builder()
            .url("$instanceUrl/Api/Mute/Query?q=$q&banList=$banList&max=$max&page=$page&idOnly=$idOnly")
            .header("Authorization", "Bearer $apiKey")
            .build()

        try {
            client.newCall(request).execute().use { response ->
                logCall(request.url.toString(), response.isSuccessful, response.code, response.message)
                return JsonParser.parseString(response.body?.string()).asJsonObject
            }
        } catch (e: Exception) {
            throw CallFailureException("Failed to query mute from ${request.url}", e)
        }
    }

    /**
     * Endpoint for adding mute logs
     *
     * Endpoint: `/Api/MuteLog/{banId}`
     *
     * @param muteId id of the mute
     * @param logReason reason of the log
     *
     * @return the response code
     * @throws CallFailureException inherited from `CedmodException`
     */
    fun muteLogPut(muteId: String, logReason: String): Int {
        val json = "{\n" +
                "  \"logReason\": \"$logReason\"\n" +
                "}"

        val request = Request.Builder()
            .url("$instanceUrl/Api/MuteLog/$muteId")
            .header("Authorization", "Bearer $apiKey")
            .put(json.toRequestBody("application/json".toMediaTypeOrNull()))
            .build()

        try {
            client.newCall(request).execute().use { response ->
                logCall(request.url.toString(), response.isSuccessful, response.code, response.message)
                return response.code
            }
        } catch (e: Exception) {
            throw CallFailureException("Failed to put MuteLog to ${request.url}", e)
        }
    }

    /**
     * Endpoint for querying mute logs
     *
     * Endpoint: `/Api/MuteLog/Query`
     *
     * @param q the query being a userId most of the time
     * @param banList id of the banlist
     * @param max maximum number of results to return
     * @param page define the page
     * @param idOnly query only for userIds?
     *
     * @return the query as a JsonObject
     * @throws CallFailureException inherited from `CedmodException`
     */
    fun muteLogQuery(q: String, banList: String, max: Int = 10, page: Int = 0, idOnly: Boolean = false): JsonObject? {
        val request = Request.Builder()
            .url("$instanceUrl/Api/MuteLog/Query?q=$q&banList=$banList&max=$max&page=$page&idOnly=$idOnly")
            .header("Authorization", "Bearer $apiKey")
            .build()

        try {
            client.newCall(request).execute().use { response ->
                logCall(request.url.toString(), response.isSuccessful, response.code, response.message)
                return JsonParser.parseString(response.body?.string()).asJsonObject
            }
        } catch (e: Exception) {
            throw CallFailureException("Failed to query MuteLog from ${request.url}", e)
        }
    }

    /**
     * Endpoint for querying player stats
     *
     * Endpoint: `/Api/Player/Query`
     *
     * @param q the query being a userId most of the time
     * @param max maximum number of results to return
     * @param page define the page
     * @param staffOnly only return staff users
     * @param create create player
     * @param sortLabel label to sort to
     * @param sortDirection direction of sort
     * @param activityMin minimum activity to query from. If set to 10, it queries data from the last 10 days
     * @param basicStats should base stats be returned?
     * @param moderationData should moderation data be returned?
     *
     * @return a 'Player' object
     * @throws CallFailureException inherited from `CedmodException`
     */
    fun playerQuery(q: String, max: Int = 10, page: Int = 0, staffOnly: Boolean = false, create: Boolean = false, sortLabel: String = "id_field", sortDirection: Int? = null, activityMin: Int = 14, basicStats: Boolean = true, moderationData: Boolean = false): Player {
        val request = Request.Builder()
            .url("$instanceUrl/Api/Player/Query?q=$q&max=$max&page=$page&staffOnly=$staffOnly&create=$create&sortLabel=$sortLabel&activityMin=$activityMin&basicStats=$basicStats&moderationData=$moderationData")
            .header("Authorization", "Bearer $apiKey")
            .build()

        try {
            client.newCall(request).execute().use { response ->
                logCall(request.url.toString(), response.isSuccessful, response.code, response.message)
                val obj = Json.decodeFromString<Player>(response.body!!.string())

                obj.response = getResponseTime(response)
                return obj
            }
        } catch (e: Exception) {
            throw CallFailureException("Failed to query player from ${request.url}", e)
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