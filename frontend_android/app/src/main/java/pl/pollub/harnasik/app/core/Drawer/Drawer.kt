package pl.pollub.harnasik.app.core.Drawer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pl.pollub.harnasik.R

@Composable
fun DrawerHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 64.dp),

        ) {
        Text(text = "Harnasik", fontSize = 36.sp)
        Icon(imageVector = Icons.Rounded.AccountCircle, contentDescription = "LOGO")
    }
}

@Composable
fun DrawerBody(
    modifier: Modifier = Modifier,
    itemTextStyle: TextStyle = TextStyle(fontSize = 18.sp),
    onItemClick: (MenuItem) -> Unit
) {

    val menuItems = listOf(
        MenuItem(id = "myOffers", title = "My Offers", icon = Icons.Default.LocalOffer),
        MenuItem(id = "help", title = "Help", icon = Icons.Default.Help),
        MenuItem(id = "aboutUs", title = "About Us", icon = Icons.Default.Book),
        MenuItem(id = "contact", title = "Contact", icon = Icons.Default.Contacts),
        MenuItem(id = "logout", title = "Logout", icon = Icons.Default.Logout),
        MenuItem(id = "login", title = "Log In", icon = Icons.Default.Login)
    )

    LazyColumn(modifier) {
        items(menuItems) { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onItemClick(item)
                    }
                    .padding(16.dp)
            ) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = item.title
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
}
