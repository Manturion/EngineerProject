package pl.pollub.harnasik.app.data.remote.Offer

import io.ktor.client.*
import io.ktor.client.engine.android.*

import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import pl.pollub.harnasik.app.data.remote.Offer.dto.OfferRequest

import pl.pollub.harnasik.app.data.remote.Offer.dto.OfferResponse

interface OfferService {

    suspend fun getOffers(): List<OfferResponse>

    suspend fun createPost(postRequest: OfferRequest): OfferResponse?

    companion object {
        fun create(): OfferService {
            return OfferServiceImpl(
                client = HttpClient(Android) {
                    install(Logging){
                        level = LogLevel.ALL
                    }
                    install(JsonFeature) {
                        serializer = KotlinxSerializer()
                    }
                }
            )
        }
    }
}