package pl.pollub.harnasik.app.presentation.offers.query.offerSingle

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import pl.pollub.harnasik.R
import pl.pollub.harnasik.app.core.Drawer.DrawerContent
import pl.pollub.harnasik.app.util.Screen
import pl.pollub.harnasik.ui.theme.HarnasikTheme


@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun SingleOfferScreen(
        navController: NavController,
) {

    val viewModel = hiltViewModel<SingleOfferViewModel>()
    val state = viewModel.state
    val drawerState = androidx.compose.material3.rememberDrawerState(DrawerValue.Closed)
    HarnasikTheme {

        androidx.compose.material3.Scaffold(
                topBar = {
                    pl.pollub.harnasik.app.presentation.offers.AppBar(
                            navController
                    )
                }
        ) {

            ModalNavigationDrawer(
                    modifier = Modifier
                            .background(MaterialTheme.colorScheme.surface)
                            .padding(top = 64.dp),
                    drawerState = drawerState,
                    drawerContent = {
                        DrawerContent(navController = navController)
                    }, content = {
                Column(
                        modifier = Modifier
                                .padding(8.dp)
                                .fillMaxSize()
                                .background(MaterialTheme.colorScheme.surface)
                        ,
                        horizontalAlignment = CenterHorizontally
                ) {
                    Row(
                            modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(
                                painter = painterResource(id = R.drawable.ic_round_person_24),
                                contentDescription = stringResource(R.string.label_continue_to_courses),
                                tint = MaterialTheme.colorScheme.primary,
                        )
                        Text(
                                text = "username", style = MaterialTheme.typography.titleMedium
                        )
                        Button(
                                onClick = { /*TODO*/ },
                                modifier = Modifier.padding(start = 205.dp),

                                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.error),
                        ) {
                            Text(
                                    text = "Zgłoś",
                                    color = MaterialTheme.colorScheme.onError
                            )
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

                        Button(
                                onClick = { /*TODO*/ }, Modifier.padding(start = 204.dp)


                        ) {
                            Icon(
                                    painter = painterResource(id = R.drawable.ic_baseline_add_24),
                                    contentDescription = stringResource(R.string.label_continue_to_courses),
                                    tint = MaterialTheme.colorScheme.primary,
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
                            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.tertiary),
                    ) {
                        Icon(
                                painter = painterResource(id = R.drawable.ic_round_map_24),
                                contentDescription = stringResource(R.string.label_continue_to_courses),
                                tint = MaterialTheme.colorScheme.onTertiary,
                        )
                        Text(
                                text = "  Pokaż na mapie",
                                fontFamily = FontFamily(Font(R.font.opensans)),
                                color = MaterialTheme.colorScheme.onTertiary

                        )
                    }



                    Row(
                            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
                    ) {
                        IconButton(onClick = { /*TODO*/ }) {

                            Icon(
                                    painter = painterResource(id = R.drawable.ic_round_thumb_up_24),
                                    contentDescription = stringResource(R.string.label_continue_to_courses),
                                    tint = MaterialTheme.colorScheme.primary,
                            )
                        }
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                    painter = painterResource(id = R.drawable.ic_round_thumb_down_24),
                                    contentDescription = stringResource(R.string.label_continue_to_courses),
                                    tint = MaterialTheme.colorScheme.primary,
                            )
                        }
                    }
                }
            })
        }
    }
}