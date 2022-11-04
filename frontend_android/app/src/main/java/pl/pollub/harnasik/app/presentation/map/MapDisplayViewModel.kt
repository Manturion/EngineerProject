package pl.pollub.harnasik.app.presentation.map.MapDisplayViewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MapDisplayViewModel @Inject constructor(

): ViewModel() {
    private val _state = mutableStateOf(MapState())
    val state: State<MapState> = _state

    init {

    }

}
