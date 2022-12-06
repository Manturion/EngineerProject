package pl.pollub.harnasik.app.presentation.user

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import pl.pollub.harnasik.R
import pl.pollub.harnasik.app.core.Drawer.DrawerContent
import pl.pollub.harnasik.app.presentation.offers.AppBar

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BlockedUsersScreen(
    navController: NavController, viewModel: AuthViewModel = hiltViewModel()
) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)

    Scaffold(topBar = {
        AppBar(
            navController
        )
    }) {
        ModalNavigationDrawer(
            modifier = Modifier.background(MaterialTheme.colorScheme.surface),
            drawerState = drawerState,
            drawerContent = {
                DrawerContent(navController = navController)
            }, content = {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(15.dp, 0.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    BlockedUSersText()
                    Spacer(modifier = Modifier.height(40.dp))
                    BlockedUsersListItemPreview()
                }
            })
    }
}

@Composable
fun BlockedUsersListItem(userText: String, onItemClick: (String) -> Unit) {
    Row(
        modifier = Modifier
            .clickable(onClick = { onItemClick(userText) })
            .height(57.dp)
            .background(Color(0xFFED4420))
            .fillMaxWidth()
            .padding(8.dp, 17.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_people_24),
            contentDescription = "Blocked user",
            tint = MaterialTheme.colorScheme.onPrimary,
        )
        Spacer(modifier = Modifier.width(3.dp))
        Icon(
            painter = painterResource(id = R.drawable.ic_round_thumb_up_alt_24),
            contentDescription = "Unblock",
            tint = Color(0xFF0A810C),
        )
        Text(text = userText, fontSize = 20.sp, color = Color.White)
    }
    Spacer(modifier = Modifier.height(20.dp))
}

@Preview(showBackground = true)
@Composable
fun BlockedUsersListItemPreview() {
    BlockedUsersListItem(userText = "pawlakjan@o2.pl",
        onItemClick = {})
    BlockedUsersListItem(userText = "misuszatek00@o2.pl",
        onItemClick = {})
    BlockedUsersListItem(userText = "jamestheSullivan@gmail.com",
        onItemClick = {})
    BlockedUsersListItem(userText = "fakekonto@pollub.edu.pl",
        onItemClick = {})
}

@Preview(showBackground = true)
@Composable
fun BlockedUsersListPreview() {
    val navController = rememberNavController()
}

@Composable
fun BlockedUSersText() {
    Spacer(modifier = Modifier.height(20.dp))
    Text(
        "Zablokowani użytkownicy:",
        style = TextStyle(
            fontSize = 30.sp, fontFamily = FontFamily.Default
        )
    )
    Spacer(modifier = Modifier.height(20.dp))
}

