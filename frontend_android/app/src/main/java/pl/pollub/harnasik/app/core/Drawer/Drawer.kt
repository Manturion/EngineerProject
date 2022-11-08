package pl.pollub.harnasik.app.core.Drawer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material.icons.filled.Help
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import pl.pollub.harnasik.R
import pl.pollub.harnasik.app.di.App.Companion.AuthUser
import pl.pollub.harnasik.app.util.Screen


@Composable
fun DrawerHeader() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 64.dp),
        horizontalArrangement = Arrangement.Center

    ) {
        Text(
            text = "Harnasik", fontSize = 36.sp, fontWeight = FontWeight.Bold
        )
        Icon(imageVector = Icons.Rounded.AccountCircle, contentDescription = "LOGO")

    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 20.dp)
            .padding(bottom = 36.dp),
        horizontalArrangement = Arrangement.Center

    ) {
        if (AuthUser != null) {
            Text(text = "Witaj $AuthUser!")
        }
    }

}

@Composable
fun DrawerBody(
    modifier: Modifier = Modifier,
    itemTextStyle: TextStyle = TextStyle(fontSize = 18.sp),
    onItemClick: (MenuItem) -> Unit,
    navController: NavController
) {

    val menuItems = listOf(
        MenuItem(id = "myOffers", title = "Moje oferty", icon = Icons.Default.LocalOffer),
        MenuItem(id = "help", title = "Pomoc", icon = Icons.Default.Help),
        MenuItem(id = "aboutUs", title = "O nas", icon = Icons.Default.Book),
        MenuItem(id = "contact", title = "Kontakt", icon = Icons.Default.Contacts),
    )

    LazyColumn(modifier) {

        items(menuItems) { item ->
            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onItemClick(item)
                }
                .padding(16.dp)) {
                Icon(
                    imageVector = item.icon, contentDescription = item.title,

                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = item.title,
                    style = itemTextStyle,
                    modifier = Modifier.weight(1f),
                    fontFamily = FontFamily(Font(R.font.opensans))
                )
            }
        }
    }


    if (AuthUser == null) {
        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(100.dp), onClick = {
            navController.navigate(Screen.Login.route)
        }) {
            Text(text = "Zaloguj się")
        }
    } else {
        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(90.dp), onClick = {
            AuthUser = null
            navController.navigate(Screen.Login.route)
        }) {
            Text(text = "Wyloguj się")

        }
    }


}
