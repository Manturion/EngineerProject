package pl.pollub.harnasik.app.presentation.upsertOffer

import androidx.compose.ui.focus.FocusState

sealed class AddEditOfferEvent {
    data class EnteredTitle(val value: String) : AddEditOfferEvent()
    data class ChangeFocusTitle(val focusState: FocusState) : AddEditOfferEvent()

    data class EnteredDescription(val value: String) : AddEditOfferEvent()
    data class ChangeFocusDescription(val focusState: FocusState) : AddEditOfferEvent()

    data class EnteredOldPrice(val value: String) : AddEditOfferEvent()
    data class ChangeFocusOldPrice(val focusState: FocusState) : AddEditOfferEvent()

    data class EnteredNewPrice(val value: String) : AddEditOfferEvent()
    data class ChangeFocusNewPrice(val focusState: FocusState) : AddEditOfferEvent()

    object SaveNote : AddEditOfferEvent()
}
