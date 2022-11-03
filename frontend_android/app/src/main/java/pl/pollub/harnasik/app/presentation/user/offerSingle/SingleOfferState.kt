package pl.pollub.harnasik.app.presentation.user.offerSingle

import pl.pollub.harnasik.app.domain.model.OfferModel

data class SingleOfferState(
    val offerId: Long? = null,
    var offer: OfferModel? = null,
    val loading: Boolean = false,
    val error: String? = null
)