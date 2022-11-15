package pl.pollub.harnasik.app.presentation.map

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import pl.pollub.harnasik.app.presentation.offers.AppBar
import pl.pollub.harnasik.app.util.DETAIL_ARGUMENT_LAT
import pl.pollub.harnasik.app.util.DETAIL_ARGUMENT_LONG
import pl.pollub.harnasik.app.util.DETAIL_ARGUMENT_TITLE

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MapDisplayScreen(
        backStackEntry: NavBackStackEntry,
        navController: NavController
) {

    val title = backStackEntry.arguments?.getString(DETAIL_ARGUMENT_TITLE).toString()
    val lat = backStackEntry.arguments?.getString(DETAIL_ARGUMENT_LAT)?.toDouble()
    val long = backStackEntry.arguments?.getString(DETAIL_ARGUMENT_LONG)?.toDouble()


    if (lat != null && long != null) {
        val point = LatLng(lat, long)

        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(point, 18f)
        }

        Scaffold(
                topBar = {
                    AppBar(
                            navController
                    )
                }
        ) {
            GoogleMap(
                    modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 64.dp),
                    cameraPositionState = cameraPositionState
            ) {
                Marker(
                        state = MarkerState(position = point), title = title
                )
            }
        }

    }
}