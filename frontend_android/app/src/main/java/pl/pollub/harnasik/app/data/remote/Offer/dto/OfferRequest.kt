package pl.pollub.harnasik.app.data.remote.Offer.dto

import kotlinx.serialization.Serializable

@Serializable
data class OfferRequest(
    val title: String,
    val description: String,
    val image: String,
    val oldPrice: Double,
    val newPrice: Double,
    val latitude: Double,
    val longitude: Double,
    val startDate: String,
    val expireDate: String,
    val categoryId: Long,
    val available: Boolean
)
