package pl.pollub.harnasik.app.presentation.offerSingle

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import pl.pollub.harnasik.app.core.Resource
import pl.pollub.harnasik.app.domain.repository.OfferRepository
import javax.inject.Inject


@HiltViewModel
class SingleOfferViewModel @Inject constructor(
    repository: OfferRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(SingleOfferState())
    val state: State<SingleOfferState> = _state


    init {
        savedStateHandle.get<Long>("offerId")?.let { offerId ->
            _state.value = SingleOfferState(offerId = offerId)
        }

        println(state.value.offerId)

        repository.getOfferById(state.value.offerId!!)


//        repository.getOfferById(state.value.offerId!!).onEach { result ->
//            println(result.data!!.title)
//            when (result) {
//                is Resource.Success -> {
//                    _state.value = SingleOfferState(
//                        offerId = result.data.id,
//                        offer = result.data,
//                        loading = false,
//                        error = null
//                    )
//                }
//            }
//
//        }.launchIn(viewModelScope)
    }
}
