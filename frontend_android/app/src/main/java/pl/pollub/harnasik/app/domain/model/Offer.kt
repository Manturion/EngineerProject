package pl.pollub.harnasik.app.domain.model

data class OfferModel(
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
    val available: Boolean,
    val geolocation: OfferSpot? = null
)