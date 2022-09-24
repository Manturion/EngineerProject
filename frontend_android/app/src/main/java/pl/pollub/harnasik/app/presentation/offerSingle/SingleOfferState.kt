package pl.pollub.harnasik.app.presentation.offerSingle

import pl.pollub.harnasik.app.domain.model.OfferModel

data class SingleOfferState(
    val offerId: Long? = null,
    val offers: OfferModel? = null,
    val loading: Boolean = false,
    val error: String? = null
)