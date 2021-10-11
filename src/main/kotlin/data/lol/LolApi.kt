package data.lol

import data.NetworkResource
import data.lol.model.RawPlayerInfo
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.Json
import io.ktor.client.engine.apache.*
import io.ktor.client.features.logging.*
import nl.altindag.ssl.SSLFactory
import nl.altindag.ssl.util.PemUtils

private const val BASE_URL = "https://127.0.0.1:2999"



object LolApi{

    private val client = HttpClient(Apache){
        engine {
            sslContext = SSLFactory.builder().withTrustMaterial(
                PemUtils.loadTrustMaterial("private/riotgames.pem", )
            ).build().sslContext
        }
        install(JsonFeature){
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                prettyPrint = true
                coerceInputValues = true
                ignoreUnknownKeys = true
                explicitNulls = false
            })
        }
        install(Logging)
    }
    private val JSON = Json {
        coerceInputValues = true
        ignoreUnknownKeys = true
    }

    fun getPlayerInfo(): Flow<NetworkResource<RawPlayerInfo>> =
        flow {
            try {
                emit(NetworkResource.Success(
                    client.get<RawPlayerInfo>("$BASE_URL/liveclientdata/activeplayer")
                ))
            }catch(e: Exception){ //TODO handle RedirectResponseException, ClientRequestException, ServerResponseException differently
                emit(NetworkResource.Failure(e.message))
            }
        }

}