package pl.pollub.harnasik.app.presentation.map

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng

import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState

import com.google.maps.android.compose.rememberCameraPositionState
import pl.pollub.harnasik.app.presentation.user.offerSingle.SingleOfferViewModel

@Composable
fun MapDisplayScreen() {
    val viewModel = hiltViewModel<SingleOfferViewModel>()
    val state = viewModel.state

    val geolocation = state.value.offer?.geolocation
    var point = LatLng(51.23426942850275, 22.539411038160324)

    if (geolocation != null) {
        val lat = geolocation.lat
        val long = geolocation.lng
        point = LatLng(lat, long)
    }

    val lublin = LatLng(51.23426942850275, 22.539411038160324)

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(lublin, 18f)
    }
    GoogleMap(
    modifier = Modifier.fillMaxSize(),
    cameraPositionState = cameraPositionState
    ) {
        Marker(
            state = MarkerState(position = lublin),
            title = state.value.offer?.title,
            snippet = "Cena promocyjna: ${state.value.offer?.newPrice} zł"
        )
    }
}