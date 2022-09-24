package pl.pollub.harnasik.app.data.remote.Offer

import pl.pollub.harnasik.app.data.remote.Offer.dto.OfferResponse

interface OfferDao {

    suspend fun getOfferById(id: Long): OfferResponse?

    suspend fun getAllOffers(): List<OfferResponse>

    companion object {

    }
}