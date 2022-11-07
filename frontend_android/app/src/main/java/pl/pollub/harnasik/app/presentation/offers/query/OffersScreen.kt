package pl.pollub.harnasik.app.presentation.offers.query

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import pl.pollub.harnasik.R
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
    }, floatingActionButton = {
        FloatingActionButton(
            onClick = {
                navController.navigate(
                    Screen.AddEditOfferScreen.route
                )
            },
            contentColor = MaterialTheme.colors.primary,
            backgroundColor = MaterialTheme.colors.primary
        ) {
            Icon(
                imageVector = Icons.Rounded.Add,
                contentDescription = stringResource(R.string.label_continue_to_courses),
                tint = MaterialTheme.colors.onPrimary,
            )
        }
    })
}





