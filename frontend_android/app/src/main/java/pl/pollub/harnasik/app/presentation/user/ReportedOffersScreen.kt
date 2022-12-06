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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import java.util.Locale
import pl.pollub.harnasik.R
import pl.pollub.harnasik.app.core.Drawer.DrawerContent
import pl.pollub.harnasik.app.presentation.offers.AppBar

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ReportedOffersScreen(
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
                    ReportedOffersText()
                    Spacer(modifier = Modifier.height(40.dp))
                    ReportedOffersListItemPreview()
                }
            })
    }
}

@Composable
fun ReportedOffersListItem(countryText: String, onItemClick: (String) -> Unit) {
    Row(
        modifier = Modifier
            .clickable(onClick = { onItemClick(countryText) })
            .height(57.dp)
            .background(Color(0xFF930D00))
            .fillMaxWidth()
            .padding(13.dp, 17.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_round_error_24),
            contentDescription = "Reported offer",
            tint = MaterialTheme.colorScheme.onPrimary,
        )
        Spacer(modifier = Modifier.width(20.dp))
        Text(text = countryText, fontSize = 20.sp, color = Color.White)
    }
    Spacer(modifier = Modifier.height(20.dp))
}

@Preview(showBackground = true)
@Composable
fun ReportedOffersListItemPreview() {
    ReportedOffersListItem(countryText = "Super oferta!!!!!11!1223",
        onItemClick = {})
    ReportedOffersListItem(countryText = "Mleko tańsze niż",
        onItemClick = {})
    ReportedOffersListItem(countryText = "ppppdpadadad",
        onItemClick = {})
    ReportedOffersListItem(countryText = "Parówki Berlinki 3 zł",
        onItemClick = {})
}

@Preview(showBackground = true)
@Composable
fun ReportedOffersListPreview() {
    val navController = rememberNavController()
}


@Composable
fun ReportedOffersText() {
    Spacer(modifier = Modifier.height(20.dp))
    Text(
        "Zgłoszone oferty:",
        style = TextStyle(
            fontSize = 30.sp, fontFamily = FontFamily.Default
        )
    )
    Spacer(modifier = Modifier.height(20.dp))
}

