package pl.pollub.harnasik.app.presentation.offers.query

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import pl.pollub.harnasik.app.core.Resource
import pl.pollub.harnasik.app.domain.repository.OfferRepository
import javax.inject.Inject

@HiltViewModel
class OffersViewModel @Inject constructor(
    repository: OfferRepository
) : ViewModel() {
    private val _state = mutableStateOf(OffersState())
    val state: State<OffersState> = _state

    init {
        repository.getAllOffers().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value =
                        OffersState(offers = result.data!!, loading = false, error = null)
                }

                is Resource.Loading -> {
                    _state.value = OffersState(offers = null, loading = true, error = null)
                }

                is Resource.Error -> {
                    _state.value = OffersState(offers = null, loading = false, error = result.message)
                }
            }
        }.launchIn(viewModelScope)
    }
}