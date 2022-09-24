package pl.pollub.harnasik.app.presentation.offerSingle

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel

import androidx.navigation.NavController
import kotlinx.coroutines.launch
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
                Text(text = "ID: ${state.value.offerId}")

            },

            bottomBar = { BottomBar() }
        )
    }

}