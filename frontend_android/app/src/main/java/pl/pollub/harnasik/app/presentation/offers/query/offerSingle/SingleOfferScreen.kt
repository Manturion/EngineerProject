package pl.pollub.harnasik.app.presentation.offers.query.offerSingle

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Image
import androidx.compose.material.icons.rounded.PinDrop
import androidx.compose.material.icons.rounded.ThumbDown
import androidx.compose.material.icons.rounded.ThumbUp
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import pl.pollub.harnasik.app.core.Drawer.drawerContent
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
    val drawerState = androidx.compose.material3.rememberDrawerState(DrawerValue.Closed)
    HarnasikTheme {

        ModalNavigationDrawer(
                modifier = Modifier.background(MaterialTheme.colorScheme.surface),
                drawerState = drawerState,
                drawerContent = {
                    drawerContent(navController = navController)
                }, content = {
            Column(
                    modifier = Modifier
                            .padding(8.dp)
                            .fillMaxSize(),
                    horizontalAlignment = CenterHorizontally
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
                            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.error),
                    ) {
                        Text(
                                text = "Zgłoś",
                                color = MaterialTheme.colorScheme.onError
                        )
                    }
                    Button(
                            onClick = {
                                navController.navigate(
                                        Screen.MapDisplay.passArgs(
                                                state.value.offer?.title,
                                                state.value.offer?.latitude.toString(),
                                                state.value.offer?.longitude.toString(),
                                        )
                                )
                            },
                            modifier = Modifier.padding(start = 5.dp),
                            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onTertiary),
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
                                imageVector = Icons.Rounded.PinDrop, contentDescription = "GeoLocation"
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
                            text = "${state.value.offer?.description} "
                    )
                }

                Row(
                        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
                ) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                                imageVector = Icons.Rounded.ThumbUp, contentDescription = "ThumbUp"
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                                imageVector = Icons.Rounded.ThumbDown, contentDescription = "ThumbUp"
                        )
                    }
                }
            }
        })
    }

}