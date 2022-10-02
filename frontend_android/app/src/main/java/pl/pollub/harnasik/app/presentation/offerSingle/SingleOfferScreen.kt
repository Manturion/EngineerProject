package pl.pollub.harnasik.app.presentation.offerSingle

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Image
import androidx.compose.material.icons.rounded.PinDrop
import androidx.compose.material.icons.rounded.ThumbDown
import androidx.compose.material.icons.rounded.ThumbUp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import pl.pollub.harnasik.R
import pl.pollub.harnasik.app.core.BottomBar.BottomBar
import pl.pollub.harnasik.app.core.Drawer.DrawerBody
import pl.pollub.harnasik.app.core.Drawer.DrawerHeader
import pl.pollub.harnasik.app.presentation.offers.AppBar
import pl.pollub.harnasik.ui.theme.HarnasikTheme


@ExperimentalMaterial3Api
@Composable
fun SingleOfferScreen(
    navController: NavController,
) {

    val viewModel = hiltViewModel<SingleOfferViewModel>()
    val state = viewModel.state

    HarnasikTheme() {

        val scaffoldState = rememberScaffoldState()
        val scope = rememberCoroutineScope()
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                AppBar(onNavigationIconClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                })
            },
            drawerContent = {
                DrawerHeader()
                DrawerBody(
                    onItemClick = {
                        println("Clicked on ${it.title}")
                    }
                )
            },
            content = {
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Image(
                            imageVector = Icons.Rounded.Image,
                            contentDescription = "ProfilePic"
                        )
                        Text(
                            text = "username",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .padding(start = 116.dp),
                            colors = ButtonDefaults.buttonColors(Color.Red),
                            border = BorderStroke(1.dp, color = Color.Black)

                        ) {
                            Text(text = "ReportOfferButton")
                        }
                    }
                    Row(
                        modifier = Modifier
                            .border(BorderStroke(1.dp, Color.Black))
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "${state.value.offer?.title}",
                            modifier = Modifier
                                .padding(12.dp),
                            style = MaterialTheme.typography.titleLarge
                        )

                        IconButton(
                            onClick = { /*TODO*/ },
                            Modifier.padding(start = 204.dp)

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
                            .border(BorderStroke(1.dp, Color.Black))
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_launcher_background),
                            contentDescription = "Offer Image",
                            modifier = Modifier
                                .height(200.dp)
                                .width(300.dp)
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                            .border(BorderStroke(1.dp, Color.Black))
                            .height(176.dp)
                    ) {
                        Text(
                            modifier = Modifier.padding(4.dp),
                            text = "${state.value.offer?.description}"
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Rounded.ThumbUp,
                                contentDescription = "ThumbUp"
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
            },
            bottomBar = { BottomBar() }
        )
    }

}