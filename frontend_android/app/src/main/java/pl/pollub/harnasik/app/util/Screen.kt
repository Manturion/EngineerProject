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
    object MapDisplay : Screen("map_display_screen/{title}/{latitude}/{longitude}") {
        fun passArgs(
            title: String? = "",
            latitude: Long? = 0,
            longitude: Long? = 0
        ): String {
            return "map_display_screen/$title/$latitude/$longitude"
        }
    }

    object MapSelect : Screen("map_select_screen")
}
