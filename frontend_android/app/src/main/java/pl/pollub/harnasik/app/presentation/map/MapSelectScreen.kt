package pl.pollub.harnasik.app.presentation.map

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState
import pl.pollub.harnasik.ui.theme.HarnasikTheme

@Composable
fun MapSelectScreen() {


//    val lublin = LatLng(51.23426942850275, 22.539411038160324)
//
//    val cameraPositionState = rememberCameraPositionState {
//        position = CameraPosition.fromLatLngZoom(lublin, 18f)
//    }
//
//    HarnasikTheme {
//        GoogleMap(
//            modifier = Modifier.fillMaxSize(),
//            cameraPositionState = cameraPositionState
//        ) {
////            Marker(
////                state = MarkerState(position = lublin),
////                title = state.value.offer?.title,
////                snippet = "Cena promocyjna: ${state.value.offer?.newPrice} zł"
////            )
//        }
//    }
}