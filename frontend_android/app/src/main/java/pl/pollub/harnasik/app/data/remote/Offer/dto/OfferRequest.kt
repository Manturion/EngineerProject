package pl.pollub.harnasik.app.data.remote.Offer.dto

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.math.BigDecimal
import java.util.*

@Serializable
data class OfferRequest(
    val title: String,
    val description: String,
    val image: String,
    @Contextual
    val oldPrice: BigDecimal,
    @Contextual
    val newPrice: BigDecimal,
    @Contextual
    val gps: BigDecimal,
    @Contextual
    val startDate: Date,
    @Contextual
    val expireDate: Date,
    val categoryId: Long,

    val available: Boolean
)
