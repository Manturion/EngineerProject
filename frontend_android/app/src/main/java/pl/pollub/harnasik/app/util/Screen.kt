package pl.pollub.harnasik.app.util

sealed class Screen(
    val route: String
) {
    object AllOffersScreen : Screen("all_offers_screen")
    object SingleOfferScreen : Screen("single_offer_screen")
    object AddEditOfferScreen: Screen("add_edit_offer_screen")
}
