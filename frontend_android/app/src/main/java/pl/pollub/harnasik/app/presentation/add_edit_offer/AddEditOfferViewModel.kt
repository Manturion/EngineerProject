package pl.pollub.harnasik.app.presentation.add_edit_offer

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
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
}