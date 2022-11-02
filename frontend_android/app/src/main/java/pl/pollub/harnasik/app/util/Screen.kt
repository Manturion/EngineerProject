package pl.pollub.harnasik.app.util

sealed class Screen(
    val route: String
) {
    object AllOffersScreen : Screen("all_offers_screen")
    object SingleOfferScreen : Screen("single_offer_screen")
    object Login : Screen("login_screen")
    object SignUp : Screen("signup_screen")
    object ForgotPassword : Screen("forgotpassword_screen")
    object AddEditOfferScreen : Screen("add_edit_offer_screen")
    object Map : Screen("map_screen")
}
