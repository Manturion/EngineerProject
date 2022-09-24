package pl.pollub.harnasik.app.presentation.offers

import pl.pollub.harnasik.app.domain.model.OfferModel

data class OffersState(
    val offers: List<OfferModel>? = null,
    val loading: Boolean = false,
    val error: String? = null
)