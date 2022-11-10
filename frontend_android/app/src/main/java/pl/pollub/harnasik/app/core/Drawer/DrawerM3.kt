package pl.pollub.harnasik.app.core.Drawer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import pl.pollub.harnasik.R
import pl.pollub.harnasik.app.di.App
import pl.pollub.harnasik.app.presentation.offers.query.DrawerItem
import pl.pollub.harnasik.app.util.Screen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun drawerContent(navController: NavController) {

    val itemsList = listOf(
            DrawerItem("Moje oferty", R.drawable.ic_round_sell_24),
            DrawerItem("Pomoc", R.drawable.ic_baseline_help_24),
            DrawerItem("O nas", R.drawable.ic_baseline_people_24),
            DrawerItem("Kontakt", R.drawable.ic_baseline_chat_bubble_24),
    )

    ModalDrawerSheet {

        Row(
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 64.dp),
                horizontalArrangement = Arrangement.Center

        ) {
            Text(
                    text = "Harnasik", fontSize = 36.sp, fontWeight = FontWeight.Bold
            )
//            Icon(painter = painterResource(id = R.drawable.), contentDescription = "LOGO")

        }
        Spacer(Modifier.height(60.dp))

        itemsList.forEach {
            NavigationDrawerItem(modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 8.dp), icon = {
                Icon(
                        painter = painterResource(id = it.iconPath),
                        contentDescription = stringResource(R.string.label_continue_to_courses),
                        tint = MaterialTheme.colorScheme.onTertiaryContainer,

                        )
            }, label = {
                Text(
                        text = it.title,
                        modifier = Modifier.weight(1f),
                        fontFamily = FontFamily(Font(R.font.opensans)),
                        fontSize = 18.sp)
            }, onClick = {}, selected = false)
        }


        if (App.AuthUser == null) {
            Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(85.dp), onClick = {
                navController.navigate(Screen.Login.route)
            }) {
                Text(text = "Zaloguj się")
            }
        } else {
            Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(90.dp), onClick = {
                App.AuthUser = null
                navController.navigate(Screen.Login.route)
            }) {
                Text(text = "Wyloguj się")

            }
        }
    }

}
