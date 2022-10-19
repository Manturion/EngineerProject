package pl.pollub.harnasik.app.presentation.add_edit_offer

import androidx.compose.ui.focus.FocusState

sealed class AddEditOfferEvent {
    data class EnteredTitle(val value: String) : AddEditOfferEvent()
    data class ChangeFocusTitle(val focusState: FocusState) : AddEditOfferEvent()

    data class EnteredDescription(val value: String) : AddEditOfferEvent()
    data class ChangeFocusDescription(val focusState: FocusState) : AddEditOfferEvent()

    object SaveNote : AddEditOfferEvent()
}
