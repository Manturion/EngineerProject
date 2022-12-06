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
    object ForgotPassword : Screen("forgotpassword_screen")
    object SignUp : Screen("signup_screen")
    object AddEditOfferScreen : Screen("add_edit_offer_screen")
    object UserPanelScreen : Screen("user_panel_screen")
    object ModeratorPanelScreen : Screen("moderator_panel_screen")
    object SettingsScreen : Screen("settings_screen")
    object HelpScreen : Screen("help_screen")
    object AboutUsScreen : Screen("about_us_screen")
    object ContactScreen : Screen("contact_screen")
    object SearchScreen : Screen("search_screen")
    object NotificationsScreen : Screen("notifications_screen")
    object ReportedOffersScreen : Screen("reported_offers_screen")
    object BlockedUsersScreen : Screen("blocked_users_screen")

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
