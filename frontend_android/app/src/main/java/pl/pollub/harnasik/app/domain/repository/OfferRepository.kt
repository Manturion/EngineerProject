package pl.pollub.harnasik.app.domain.repository

import kotlinx.coroutines.flow.Flow
import pl.pollub.harnasik.app.core.Resource
import pl.pollub.harnasik.app.domain.model.OfferModel

interface OfferRepository {

    fun getOfferById(id: Long): Flow<Resource<OfferModel>>

    fun getAllOffers(): Flow<Resource<List<OfferModel>>>
}