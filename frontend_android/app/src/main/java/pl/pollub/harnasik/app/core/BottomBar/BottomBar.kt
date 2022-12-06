package pl.pollub.harnasik.app.core.BottomBar


import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import pl.pollub.harnasik.R
import pl.pollub.harnasik.app.util.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomBar(navController: NavController) {

    val customModifier = Modifier
        .padding(start = 10.dp, end = 10.dp)
        .width(70.dp)
        .height(70.dp)

    BottomAppBar(
        modifier = Modifier.height(58.dp),
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        actions = {
            IconButton(
                onClick = {
                    navController.navigate(Screen.AllOffersScreen.route)
                },
                modifier = Modifier
                    .padding(start = 40.dp, end = 10.dp)
                    .width(70.dp)
                    .height(70.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_round_home_24),
                    contentDescription = "Strona_glowna",
                    tint = MaterialTheme.colorScheme.onPrimary,
                )
            }
            IconButton(
                onClick = {
                    navController.navigate(Screen.SearchScreen.route)
                },
                modifier = customModifier
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_round_search_24),
                    contentDescription = "Szukaj",
                    tint = MaterialTheme.colorScheme.onPrimary,
                )
            }
            IconButton(
                onClick = {
                          navController.navigate(Screen.NotificationsScreen.route)
                   },
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
                    .width(70.dp)
                    .height(70.dp)
            ) {
                BadgedBox(
                    badge = {
                        Badge {
                            val badgeNumber = "8"
                            Text(
                                badgeNumber,
                                modifier = Modifier.semantics {
                                    contentDescription = "$badgeNumber new notifications"
                                }
                            )
                        }
                    }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_round_notifications_24),
                        contentDescription = "powiadomienie",
                        tint = MaterialTheme.colorScheme.onPrimary,
                    )
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Screen.UserPanelScreen.route)
                },
                containerColor = MaterialTheme.colorScheme.onPrimary,
                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation(),
                modifier = Modifier.padding(bottom = 8.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_round_person_24),
                    contentDescription = stringResource(R.string.label_continue_to_courses),
                    tint = MaterialTheme.colorScheme.primary,
                )
            }
        }
    )
}