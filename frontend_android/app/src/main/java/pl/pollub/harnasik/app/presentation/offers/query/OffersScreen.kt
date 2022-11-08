package pl.pollub.harnasik.app.presentation.offers.query

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import pl.pollub.harnasik.R
import pl.pollub.harnasik.app.core.Drawer.DrawerBody
import pl.pollub.harnasik.app.core.Drawer.DrawerHeader
import pl.pollub.harnasik.app.presentation.offers.CategorySlideBar
import pl.pollub.harnasik.app.presentation.offers.GetAllOffers
import pl.pollub.harnasik.app.util.Screen


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AllOffersScreen(navController: NavController) {

    val viewModel = hiltViewModel<OffersViewModel>()
    val state = viewModel.state.value

    Scaffold(content = {
        Column {
            CategorySlideBar()
            GetAllOffers(state, navController)
        }
    }, drawerContent = {
        DrawerHeader()
        DrawerBody(
            onItemClick = {
                println("Clicked on ${it.title}")
            }, navController = navController
        )
    }, floatingActionButton = {
        FloatingActionButton(
            onClick = {
                navController.navigate(
                    Screen.AddEditOfferScreen.route
                )
            },
            contentColor = MaterialTheme.colorScheme.onPrimary,
            backgroundColor = MaterialTheme.colorScheme.primary
        ) {
            Icon(
                imageVector = Icons.Rounded.Add,
                contentDescription = stringResource(R.string.label_continue_to_courses),
                tint = MaterialTheme.colorScheme.onPrimary,
            )
        }
    })
}





