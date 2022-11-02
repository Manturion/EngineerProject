package pl.pollub.harnasik.app.presentation

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.rememberScaffoldState

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import pl.pollub.harnasik.R
import pl.pollub.harnasik.app.core.BottomBar.BottomBar
import pl.pollub.harnasik.app.core.Drawer.DrawerBody
import pl.pollub.harnasik.app.core.Drawer.DrawerHeader
import pl.pollub.harnasik.app.presentation.offers.AppBar
import pl.pollub.harnasik.app.presentation.offers.CategorySlideBar
import pl.pollub.harnasik.app.presentation.offers.GetAllOffers
import pl.pollub.harnasik.app.presentation.offers.OffersViewModel
import pl.pollub.harnasik.app.util.Screen
import pl.pollub.harnasik.ui.theme.HarnasikTheme



@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AllOffersScreen(navController: NavController) {

    val viewModel = hiltViewModel<OffersViewModel>()
    val state = viewModel.state.value

    HarnasikTheme {

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
                    },
                    navController = navController
                )
            },
            content = {
                Column {
                    CategorySlideBar()
                    GetAllOffers(state, navController)
                }

            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        navController.navigate(
                            Screen.AddEditOfferScreen.route
                        )
                    },
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Add,
                        contentDescription = stringResource(R.string.label_continue_to_courses)
                    )
                }
            },
            bottomBar = { BottomBar() }
        )
    }
}





