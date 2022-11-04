package pl.pollub.harnasik.app.data.remote.Offer.dto

import kotlinx.serialization.Serializable
import pl.pollub.harnasik.app.domain.model.OfferModel


@Serializable
data class OfferResponse(
    val title: String,
    val description: String,
    val image: String,
    val oldPrice: Double,
    val newPrice: Double,
    val latitude: Long,
    val longitude: Long,
    val startDate: String,
    val expireDate: String,
    val categoryId: Long,
    val id: Long,
    val available: Boolean
)

fun OfferResponse.toOffer(): OfferModel {
    return OfferModel(
        title = title,
        description = description,
        image = image,
        oldPrice = oldPrice,
        newPrice = newPrice,
        latitude = latitude,
        longitude = longitude,
        startDate = startDate,
        expireDate = expireDate,
        categoryId = categoryId,
        id = id,
        available = available
    )
}
