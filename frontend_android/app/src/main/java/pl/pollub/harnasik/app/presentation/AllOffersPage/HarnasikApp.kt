package pl.pollub.harnasik.app.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.stringResource
import kotlinx.coroutines.launch
import pl.pollub.harnasik.R
import pl.pollub.harnasik.app.core.Drawer.DrawerBody
import pl.pollub.harnasik.app.core.Drawer.DrawerHeader
import pl.pollub.harnasik.app.core.Drawer.MenuItem
import pl.pollub.harnasik.app.presentation.AllOffersPage.AppBar
import pl.pollub.harnasik.app.core.BottomBar.BottomBar
import pl.pollub.harnasik.app.presentation.AllOffersPage.CategorySlideBar
import pl.pollub.harnasik.app.presentation.AllOffersPage.GenerateListOfAllOffersLoaded
import pl.pollub.harnasik.ui.theme.HarnasikTheme


@ExperimentalMaterial3Api
@Composable
fun HarnasikApp() {

    HarnasikTheme {

        val scaffoldState = rememberScaffoldState()
        val scope = rememberCoroutineScope()
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                AppBar(onNavigationIconClick = {

                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                })
            },
            drawerContent = {
                DrawerHeader()
                DrawerBody(
                    items = listOf(
                        MenuItem(id = "myOffers", title = "My Offers", icon = Icons.Default.Add),
                        MenuItem(id = "help", title = "Help", icon = Icons.Default.Add),
                        MenuItem(id = "aboutUs", title = "About Us", icon = Icons.Default.Add),
                        MenuItem(id = "contact", title = "Contact", icon = Icons.Default.Add),
                        MenuItem(id = "logout", title = "Logout", icon = Icons.Default.Add),
                    ), onItemClick = {
                        println("Clicked on ${it.title}")
                    }
                )
            },
            content = {
                Column() {
                    CategorySlideBar()
                    GenerateListOfAllOffersLoaded()
                }

                      },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { },
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Add,
                        contentDescription = stringResource(R.string.label_continue_to_courses)
                    )
                }
            },
            bottomBar = { BottomBar() }
        )
    }
}





