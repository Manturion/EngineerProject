package pl.pollub.harnasik.app.presentation.offers.query

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import pl.pollub.harnasik.R
import pl.pollub.harnasik.app.core.Drawer.DrawerContent
import pl.pollub.harnasik.app.presentation.offers.AppBar
import pl.pollub.harnasik.app.presentation.offers.CategorySlideBar
import pl.pollub.harnasik.app.presentation.offers.GetAllOffers
import pl.pollub.harnasik.app.util.Screen

data class DrawerItem(val title: String, val iconPath: Int)

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AllOffersScreen(navController: NavController) {

    val viewModel = hiltViewModel<OffersViewModel>()
    val state = viewModel.state.value
    val drawerState = rememberDrawerState(DrawerValue.Closed)


    Scaffold(
        topBar = {
            AppBar(
                navController
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(Screen.AddEditOfferScreen.route) },
                contentColor = MaterialTheme.colorScheme.onPrimary,
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_add_24),
                    contentDescription = stringResource(R.string.label_continue_to_courses),
                    tint = MaterialTheme.colorScheme.onPrimary,
                )
            }
        }
    ) {
        ModalNavigationDrawer(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface)
                .padding(top = 64.dp),
            drawerState = drawerState,
            drawerContent = {
                DrawerContent(navController = navController)
            },
            content = {
                Column {
                    CategorySlideBar()
                    GetAllOffers(state, navController)
                }
            })
    }

//    ModalNavigationDrawer(
//            modifier = Modifier.background(MaterialTheme.colorScheme.surface),
//            drawerState = drawerState,
//            drawerContent = {
//                drawerContent(navController = navController)
//
//            },
//            content = {
//
//                Column {
//                    CategorySlideBar()
//                    GetAllOffers(state, navController)
//                }
//                FloatingActionButton(
//                        onClick = { navController.navigate(Screen.AddEditOfferScreen.route) },
//                        contentColor = MaterialTheme.colorScheme.onPrimary,
//                        containerColor = MaterialTheme.colorScheme.primary,
//                        modifier = Modifier.padding(top = 540.dp, start = 320.dp),
//                ) {
//                    Icon(
//                            painter = painterResource(id = R.drawable.ic_baseline_add_24),
//                            contentDescription = stringResource(R.string.label_continue_to_courses),
//                            tint = MaterialTheme.colorScheme.onPrimary,
//                    )
//                }
//            })
}





