package pl.pollub.harnasik.app.data.remote.Offer.dto

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.math.BigDecimal
import java.sql.Date
import java.util.*


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
