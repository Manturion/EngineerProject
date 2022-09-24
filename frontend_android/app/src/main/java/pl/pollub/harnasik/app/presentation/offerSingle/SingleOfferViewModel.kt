package pl.pollub.harnasik.app.presentation.offerSingle

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import pl.pollub.harnasik.app.data.remote.Offer.OfferDao
import pl.pollub.harnasik.app.domain.model.OfferModel
import javax.inject.Inject


@HiltViewModel
class SingleOfferViewModel @Inject constructor(
    offerDao: OfferDao,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(SingleOfferState())
    val state: State<SingleOfferState> = _state


    init {
//        savedStateHandle.get<Long>("offerId")?.let { offerId ->
//            if (offerId != -1L) {
//                viewModelScope.launch {
//                    offerDao.getOfferById(offerId.toLong())?.also { offer ->
//                        currentOfferId = offer.id
//                    }
//                }
//            }
//        }
        savedStateHandle.get<Long>("offerId")?.let { offerId ->
            _state.value = SingleOfferState(offerId = offerId)
        }

        
    }
}
