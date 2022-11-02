package pl.pollub.harnasik.app.presentation.user.offerSingle

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Image
import androidx.compose.material.icons.rounded.PinDrop
import androidx.compose.material.icons.rounded.ThumbDown
import androidx.compose.material.icons.rounded.ThumbUp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import kotlinx.coroutines.launch
import pl.pollub.harnasik.app.core.BottomBar.BottomBar
import pl.pollub.harnasik.app.core.Drawer.DrawerBody
import pl.pollub.harnasik.app.core.Drawer.DrawerHeader
import pl.pollub.harnasik.app.presentation.offers.AppBar
import pl.pollub.harnasik.app.util.Screen
import pl.pollub.harnasik.ui.theme.HarnasikTheme


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun SingleOfferScreen(
    navController: NavController,
) {

    val viewModel = hiltViewModel<SingleOfferViewModel>()
    val state = viewModel.state

    HarnasikTheme {
        val scaffoldState = rememberScaffoldState()
        val scope = rememberCoroutineScope()
        Scaffold(scaffoldState = scaffoldState, topBar = {
            AppBar(onNavigationIconClick = {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            })
        }, drawerContent = {
            DrawerHeader()
            DrawerBody(
                onItemClick = {
                    println("Clicked on ${it.title}")
                }, navController = navController
            )
        }, content = {
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        imageVector = Icons.Rounded.Image, contentDescription = "ProfilePic"
                    )
                    Text(
                        text = "username", style = MaterialTheme.typography.titleMedium
                    )
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.padding(start = 116.dp),
                        colors = ButtonDefaults.buttonColors(Color.Red),
                    ) {
                        Text(text = "Zgłoś")
                    }
                    Button(
                        onClick = { navController.navigate(Screen.Map.route+"?offerId=${state.value.offerId}") },
                        modifier = Modifier.padding(start = 5.dp),
                        colors = ButtonDefaults.buttonColors(Color.Cyan),
                    ) {
                        Text(text = "Mapa")
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "${state.value.offer?.title}",
                        modifier = Modifier.padding(12.dp),
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )

                    IconButton(
                        onClick = { /*TODO*/ }, Modifier.padding(start = 204.dp)

                    ) {
                        Icon(
                            imageVector = Icons.Rounded.PinDrop,
                            contentDescription = "GeoLocation"
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                        .align(CenterHorizontally)

                ) {
                    Image(
                        contentScale = ContentScale.FillWidth,
                        painter = rememberAsyncImagePainter("${state.value.offer?.image}"),
                        contentDescription = state.value.offer?.image,
                        modifier = Modifier
                            .height(200.dp)
                            .width(300.dp)
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                        .height(176.dp)
                ) {
                    Text(
                        modifier = Modifier.padding(4.dp),
                        text = "${state.value.offer?.description} " + "${state.value.offer?.image}"
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Rounded.ThumbUp, contentDescription = "ThumbUp"
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Rounded.ThumbDown,
                            contentDescription = "ThumbUp"
                        )
                    }
                }
            }
        }, bottomBar = { BottomBar() })
    }

}