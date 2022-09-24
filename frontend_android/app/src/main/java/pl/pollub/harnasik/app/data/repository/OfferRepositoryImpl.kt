package pl.pollub.harnasik.app.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import pl.pollub.harnasik.app.core.Resource
import pl.pollub.harnasik.app.data.remote.Offer.OfferDao
import pl.pollub.harnasik.app.data.remote.Offer.dto.toOffer
import pl.pollub.harnasik.app.domain.model.OfferModel
import pl.pollub.harnasik.app.domain.repository.OfferRepository

class OfferRepositoryImpl(private val api: OfferDao) : OfferRepository {

    override fun getOfferById(id: Long): Flow<Resource<OfferModel>> = flow {
        try {
            emit(Resource.Loading())
            val post = api.getOfferById(id)!!.toOffer()
            emit(Resource.Success(data = post))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message ?: "Error"))
        }
    }

    override fun getAllOffers(): Flow<Resource<List<OfferModel>>> = flow {
        try {
            emit(Resource.Loading())
            val posts = api.getAllOffers().map { it.toOffer() }
            emit(Resource.Success(data = posts))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message ?: "Error"))
        }
    }

}