package pl.pollub.harnasik.app.data.remote.Offer


import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url
import pl.pollub.harnasik.app.data.remote.HttpRoutes
import pl.pollub.harnasik.app.data.remote.Offer.dto.OfferResponse

class OfferDaoImpl(private val client: HttpClient) : OfferDao {

    override suspend fun getOfferById(id: Long): OfferResponse? {
        return client.get {
            url(HttpRoutes.OFFER + id)
        }
    }

    override suspend fun getAllOffers(): List<OfferResponse> {
        return client.get {
            url(HttpRoutes.ALL_OFFERS)
        }
    }
}




