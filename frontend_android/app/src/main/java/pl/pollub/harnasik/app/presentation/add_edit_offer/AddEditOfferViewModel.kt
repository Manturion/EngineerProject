package pl.pollub.harnasik.app.presentation.add_edit_offer

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import pl.pollub.harnasik.app.domain.repository.OfferRepository
import javax.inject.Inject


@HiltViewModel
class AddEditOfferViewModel @Inject constructor(
    repository: OfferRepository
) : ViewModel() {

    private val _offerTitle = mutableStateOf(
        OfferTextFieldState(
            hint = "Enter title"
        )
    )
    val offerTitle: State<OfferTextFieldState> = _offerTitle

    private val _offerDescription = mutableStateOf(
        OfferTextFieldState(
            hint = "Enter description"
        )
    )
    val offerDescription: State<OfferTextFieldState> = _offerDescription

    private val _offerOldPrice = mutableStateOf(
        OfferTextFieldState(
            hint = "Enter old price"
        )
    )
    val offerOldPrice: State<OfferTextFieldState> = _offerOldPrice

    private val _offerNewPrice = mutableStateOf(
        OfferTextFieldState(
            hint = "Enter new price"
        )
    )
    val offerNewPrice: State<OfferTextFieldState> = _offerNewPrice

    private val _eventFlow = MutableSharedFlow<UiEvent>()

//
//    val eventFlow = _eventFlow.asSharedFlow()


    fun onEvent(event: AddEditOfferEvent) {
        when (event) {
            is AddEditOfferEvent.EnteredTitle -> {
                _offerTitle.value = offerTitle.value.copy(
                    text = event.value
                )
            }
            is AddEditOfferEvent.ChangeFocusTitle -> {
                _offerTitle.value = offerTitle.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            offerTitle.value.text.isBlank()
                )
            }

            is AddEditOfferEvent.EnteredDescription -> {
                _offerDescription.value = offerDescription.value.copy(
                    text = event.value
                )
            }
            is AddEditOfferEvent.ChangeFocusDescription -> {
                _offerDescription.value = offerDescription.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            offerDescription.value.text.isBlank()
                )
            }

            is AddEditOfferEvent.EnteredOldPrice -> {
                _offerOldPrice.value = offerOldPrice.value.copy(
                    text = event.value
                )
            }
            is AddEditOfferEvent.ChangeFocusOldPrice -> {
                _offerOldPrice.value = offerOldPrice.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            offerOldPrice.value.text.isBlank()
                )
            }

            is AddEditOfferEvent.EnteredNewPrice -> {
                _offerNewPrice.value = offerNewPrice.value.copy(
                    text = event.value
                )
            }
            is AddEditOfferEvent.ChangeFocusNewPrice -> {
                _offerNewPrice.value = offerNewPrice.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            offerNewPrice.value.text.isBlank()
                )
            }

            is AddEditOfferEvent.SaveNote -> {
//                viewModelScope.launch {
//                    try {
//                        noteUseCase.addNote(
//                            Note(
//                                title = offerTitle.value.text,
//                                content = offerDescription.value.text,
//                                timestamp = System.currentTimeMillis(),
//                                color = noteColor.value,
//                                id = currentNoteId
//                            )
//                        )
//                        _eventFlow.emit(UiEvent.SaveNote)
//                    } catch (e: InvalidNoteException) {
//                        _eventFlow.emit(
//                            UiEvent.ShowSnackbar(
//                                message = e.message ?: "Couldn't save note"
//                            )
//                        )
//                    }
//                }
            }
        }
    }


    sealed class UiEvent {
        data class ShowSnackbar(val message: String) : UiEvent()
        object SaveNote : UiEvent()
    }


}

