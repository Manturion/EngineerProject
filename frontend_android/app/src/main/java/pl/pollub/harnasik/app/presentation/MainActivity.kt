package pl.pollub.harnasik.app.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import pl.pollub.harnasik.app.core.BottomBar.BottomBar
import pl.pollub.harnasik.app.presentation.map.MapDisplayScreen
import pl.pollub.harnasik.app.presentation.map.MapSelectScreen
import pl.pollub.harnasik.app.presentation.offers.command.AddEditOfferScreen
import pl.pollub.harnasik.app.presentation.offers.query.AllOffersScreen
import pl.pollub.harnasik.app.presentation.offers.query.offerSingle.SingleOfferScreen
import pl.pollub.harnasik.app.presentation.user.SignUp
import pl.pollub.harnasik.app.presentation.user.forgotPassword.ForgotPassword
import pl.pollub.harnasik.app.presentation.user.login.Login
import pl.pollub.harnasik.app.presentation.user.login.LoginPage
import pl.pollub.harnasik.app.presentation.user.UserPanel
import pl.pollub.harnasik.app.presentation.user.ModeratorPanel
import pl.pollub.harnasik.app.presentation.user.SettingsScreen
import pl.pollub.harnasik.app.presentation.user.HelpScreen
import pl.pollub.harnasik.app.presentation.user.AboutUsScreen
import pl.pollub.harnasik.app.presentation.user.ContactScreen
import pl.pollub.harnasik.app.presentation.user.SearchScreen
import pl.pollub.harnasik.app.presentation.user.NotificationsScreen
import pl.pollub.harnasik.app.util.DETAIL_ARGUMENT_LAT
import pl.pollub.harnasik.app.util.DETAIL_ARGUMENT_LONG
import pl.pollub.harnasik.app.util.DETAIL_ARGUMENT_TITLE
import pl.pollub.harnasik.app.util.Screen
import pl.pollub.harnasik.ui.theme.HarnasikTheme

@ExperimentalMaterial3Api
@ExperimentalAnimationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HarnasikTheme {
                val navController = rememberNavController()

                Scaffold(topBar = {
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
                                MapDisplayScreen(backStackEntry, navController)
                            }
                            composable(
                                    route = Screen.MapSelect.route
                            ) {
                                MapSelectScreen()
                            }
                            composable(Screen.Login.route) {
                                LoginPage(navController = navController)
                            }

                            composable(Screen.SignUp.route) {
                                SignUp(navController = navController)
                            }

                            composable(Screen.ForgotPassword.route) { navBackStack ->
                                ForgotPassword(navController = navController)
                            }

                            composable(Screen.UserPanelScreen.route) { navBackStack ->
                                UserPanel(navController = navController)
                            }

                            composable(Screen.ModeratorPanelScreen.route) { navBackStack ->
                                ModeratorPanel(navController = navController)
                            }

                            composable(Screen.SettingsScreen.route) { navBackStack ->
                                SettingsScreen(navController = navController)
                            }

                            composable(Screen.HelpScreen.route) { navBackStack ->
                                HelpScreen(navController = navController)
                            }

                            composable(Screen.AboutUsScreen.route) { navBackStack ->
                                AboutUsScreen(navController = navController)
                            }

                            composable(Screen.ContactScreen.route) { navBackStack ->
                                ContactScreen(navController = navController)
                            }

                            composable(Screen.SearchScreen.route) { navBackStack ->
                                SearchScreen(navController = navController)
                            }

                            composable(Screen.NotificationsScreen.route) { navBackStack ->
                                NotificationsScreen(navController = navController)
                            }
                        }
                    }
                }, bottomBar = { BottomBar(navController) })
            }
        }
    }
}
