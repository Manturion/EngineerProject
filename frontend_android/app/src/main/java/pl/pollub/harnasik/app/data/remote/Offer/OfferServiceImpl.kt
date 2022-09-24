package pl.pollub.harnasik.app.data.remote.Offer

import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*
import pl.pollub.harnasik.app.data.remote.HttpRoutes
import pl.pollub.harnasik.app.data.remote.Offer.dto.OfferRequest
import pl.pollub.harnasik.app.data.remote.Offer.dto.OfferResponse

class OfferServiceImpl(
    private val client: HttpClient
) : OfferService {

    override suspend fun getOfferById(id: Long): OfferResponse? {
        return try {
            client.get{
                url(HttpRoutes.OFFER)
            }
        }catch (e: RedirectResponseException){
            println("Error: ${e.response.status.description}")
            null
        }
    }


    override suspend fun getAllOffers(): List<OfferResponse> {
        return try {
            client.get {
                url(HttpRoutes.ALL_OFFERS)
            }

        } catch (e: RedirectResponseException) {
            // 3xx- responses
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch (e: ClientRequestException) {
            // 4xx- responses
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch (e: ServerResponseException) {
            // 5xx- responses
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch (e: Exception) {
            // any response
            println("Error: ${e.message}")
            emptyList()
        }
        finally {
            client.close()
        }
    }

    override suspend fun createOffer(postRequest: OfferRequest): OfferResponse? {
        return try {
            client.post<OfferResponse> {
                url(HttpRoutes.ALL_OFFERS)
                contentType(ContentType.Application.Json)
                body = postRequest
            }
        } catch (e: RedirectResponseException) {
            // 3xx - responses
            println("Error: ${e.response.status.description}")
            null
        } catch (e: ClientRequestException) {
            // 4xx - responses
            println("Error: ${e.response.status.description}")
            null
        } catch (e: ServerResponseException) {
            // 5xx - responses
            println("Error: ${e.response.status.description}")
            null
        } catch (e: Exception) {
            println("Error: ${e.message}")
            null
        }
    }
}