package pl.pollub.harnasik.app.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import pl.pollub.harnasik.app.core.BottomBar.BottomBar
import pl.pollub.harnasik.app.core.Drawer.DrawerBody
import pl.pollub.harnasik.app.core.Drawer.DrawerHeader
import pl.pollub.harnasik.app.presentation.map.MapDisplayScreen
import pl.pollub.harnasik.app.presentation.map.MapSelectScreen
import pl.pollub.harnasik.app.presentation.offers.AppBar
import pl.pollub.harnasik.app.presentation.offers.command.AddEditOfferScreen
import pl.pollub.harnasik.app.presentation.offers.query.AllOffersScreen
import pl.pollub.harnasik.app.presentation.user.login.Login
import pl.pollub.harnasik.app.presentation.offers.offerSingle.SingleOfferScreen
import pl.pollub.harnasik.app.util.DETAIL_ARGUMENT_LAT
import pl.pollub.harnasik.app.util.DETAIL_ARGUMENT_LONG
import pl.pollub.harnasik.app.util.DETAIL_ARGUMENT_TITLE
import pl.pollub.harnasik.app.util.Screen
import pl.pollub.harnasik.ui.theme.HarnasikTheme

@ExperimentalMaterial3Api
@ExperimentalAnimationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            HarnasikTheme {
                val navController = rememberNavController()
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
                    Box(modifier = Modifier.padding(bottom = 48.dp)) {
                        NavHost(
                            navController = navController,
                            startDestination = Screen.AllOffersScreen.route
                        ) {
                            composable(
                                route = Screen.AllOffersScreen.route
                            ) {
                                AllOffersScreen(navController = navController)
                            }
                            composable(route = Screen.SingleOfferScreen.route + "?offerId={offerId}",
                                arguments = listOf(navArgument(name = "offerId") {
                                    type = NavType.LongType
                                })
                            ) {
                                SingleOfferScreen(navController)
                            }
                            composable(
                                route = Screen.AddEditOfferScreen.route
                            ) {
                                AddEditOfferScreen(navController)
                            }
                            composable(
                                route = Screen.Login.route
                            ) {
                                Login()
                            }
                            composable(route = Screen.MapDisplay.route,
                                arguments = listOf(navArgument(DETAIL_ARGUMENT_TITLE) {
                                    type = NavType.StringType
                                }, navArgument(DETAIL_ARGUMENT_LAT) {
                                    type = NavType.StringType
                                }, navArgument(DETAIL_ARGUMENT_LONG) {
                                    type = NavType.StringType
                                })
                            ) { backStackEntry ->
                                MapDisplayScreen(backStackEntry)
                            }
                            composable(
                                route = Screen.MapSelect.route
                            ) {
                                MapSelectScreen()
                            }
                        }
                    }
                }, bottomBar = { BottomBar() })


            }
        }
    }
}
