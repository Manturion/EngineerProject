package pl.pollub.harnasik.app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import pl.pollub.harnasik.app.presentation.singleOffer.SingleOfferScreen
import pl.pollub.harnasik.app.util.Screen
import pl.pollub.harnasik.ui.theme.HarnasikTheme


@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HarnasikTheme() {

                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.AllOffersScreen.route
                    ) {
                        composable(route = Screen.AllOffersScreen.route) {
                            AllOffersScreen(navController = navController)
                        }
                        composable(
                            route = Screen.SingleOfferScreen.route +
                                    "?id={id}",
                            arguments = listOf(
                                navArgument(
                                    name = "id"
                                ) {
                                    type = NavType.IntType

                                }
                            )
                        ) {
                            SingleOfferScreen(id = id)
                        }
                    }

            }
        }
    }
}

