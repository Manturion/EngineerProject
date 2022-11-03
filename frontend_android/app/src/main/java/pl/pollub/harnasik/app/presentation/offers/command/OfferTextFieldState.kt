package pl.pollub.harnasik.app.presentation.offers.command

data class OfferTextFieldState(
    val text: String = "",
    val hint: String = "",
    val isHintVisible: Boolean = true
)
