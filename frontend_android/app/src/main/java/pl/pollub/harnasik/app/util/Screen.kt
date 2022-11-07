package pl.pollub.harnasik.app.util

const val DETAIL_ARGUMENT_TITLE = "Title"
const val DETAIL_ARGUMENT_LAT = "Lat"
const val DETAIL_ARGUMENT_LONG = "Long"

sealed class Screen(
    val route: String
) {
    object AllOffersScreen : Screen("all_offers_screen")
    object SingleOfferScreen : Screen("single_offer_screen")
    object Login : Screen("login_screen")
    object SignUp : Screen("signup_screen")
    object ForgotPassword : Screen("forgotpassword_screen")
    object AddEditOfferScreen : Screen("add_edit_offer_screen")
    object MapDisplay :
        Screen("map_display_screen/{$DETAIL_ARGUMENT_TITLE}/{$DETAIL_ARGUMENT_LAT}/{$DETAIL_ARGUMENT_LONG}") {
        fun passArgs(
            title: String? = "",
            latitude: String? = "",
            longitude: String? = ""
        ): String {
            return "map_display_screen/$title/$latitude/$longitude"
        }
    }

    object MapSelect : Screen("map_select_screen")
}
