package pl.pollub.harnasik.app.presentation.map

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import pl.pollub.harnasik.app.util.DETAIL_ARGUMENT_LAT
import pl.pollub.harnasik.app.util.DETAIL_ARGUMENT_LONG
import pl.pollub.harnasik.app.util.DETAIL_ARGUMENT_TITLE

@Composable
fun MapDisplayScreen(
    backStackEntry: NavBackStackEntry
) {


    val title = backStackEntry.arguments?.getString(DETAIL_ARGUMENT_TITLE).toString()
    val lat = backStackEntry.arguments?.getString(DETAIL_ARGUMENT_LAT)?.toDouble()
    val long = backStackEntry.arguments?.getString(DETAIL_ARGUMENT_LONG)?.toDouble()


    if (lat != null && long != null) {
        val point = LatLng(lat, long)

        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(point, 18f)
        }
        GoogleMap(
            modifier = Modifier.fillMaxSize(), cameraPositionState = cameraPositionState
        ) {
            Marker(
                state = MarkerState(position = point), title = title, snippet = ""
            )
        }
    }


}