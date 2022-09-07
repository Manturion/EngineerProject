package pl.pollub.harnasik

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import pl.pollub.harnasik.MainPage.AppBar
import pl.pollub.harnasik.MainPage.BottomBar
import pl.pollub.harnasik.MainPage.GenerateListOfAllOffersLoaded
import pl.pollub.harnasik.ui.theme.HarnasikTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HarnasikApp() {

    HarnasikTheme() {
        Scaffold(
            topBar = { AppBar() },
            content = { GenerateListOfAllOffersLoaded() },
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





