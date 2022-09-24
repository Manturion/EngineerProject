package pl.pollub.harnasik.app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import pl.pollub.harnasik.app.presentation.offerSingle.SingleOfferScreen
import pl.pollub.harnasik.app.util.Screen
import pl.pollub.harnasik.ui.theme.HarnasikTheme

@ExperimentalMaterial3Api
@ExperimentalAnimationApi
@AndroidEntryPoint
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
                    composable(
                        route = Screen.AllOffersScreen.route) {
                        AllOffersScreen(navController = navController)
                    }
                    composable(
                        route = Screen.SingleOfferScreen.route +
                                "?offerId={offerId}",
                        arguments = listOf(
                            navArgument(
                                name = "offerId"
                            ) {
                                type = NavType.LongType

                            }
                        )
                    ) {
                        SingleOfferScreen(navController)
                    }
                }

            }
        }
    }
}

