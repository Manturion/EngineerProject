package pl.pollub.harnasik.app.data.remote.Offer.dto

import kotlinx.serialization.Serializable


@Serializable
data class OfferResponse(
    val title: String,
    val description: String,
    val image: String,
    val oldPrice: Double,
    val newPrice: Double,
    val gps: Double,
    val startDate: String,
    val expireDate: String,
    val categoryId: Long,
    val id: Long,
    val available: Boolean
)
