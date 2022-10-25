package pl.pollub.harnasik.app.presentation.user.login

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pl.pollub.harnasik.app.presentation.user.signUp.SignUp
import pl.pollub.harnasik.app.presentation.user.forgotPassword.ForgotPassword
import pl.pollub.harnasik.app.util.Screen

@Composable
fun Login() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Login.route) {

        composable(Screen.Login.route) {
            LoginPage(navController = navController)
        }

        composable(Screen.SignUp.route) {
            SignUp(navController = navController)
        }

        composable(Screen.ForgotPassword.route) { navBackStack ->
            ForgotPassword(navController = navController)
        }
    }
}
