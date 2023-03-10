package pl.pollub.harnasik.app.presentation.user

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import pl.pollub.harnasik.R
import pl.pollub.harnasik.app.core.Drawer.DrawerContent
import pl.pollub.harnasik.app.presentation.offers.AppBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutUsScreen(navController: NavHostController) {

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    Scaffold(topBar = {
        AppBar(
            navController
        )
    }) {
        ModalNavigationDrawer(modifier = Modifier.background(MaterialTheme.colorScheme.surface),
            drawerState = drawerState,
            drawerContent = {
                DrawerContent(navController = navController)
            },
            content = {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = "O nas",
                        fontFamily = fontFamily,
                        style = TextStyle(
                            fontSize = 26.sp, fontFamily = FontFamily.Default
                        ),
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(80.dp))
                    TextField(label = {
                        Text(
                            text = "Wysokie ceny produkt??w spo??ywczych w ostatnich latach stanowi ??r??d??o stresu dla\n" +
                                    "ok. 32% Polak??w [1]. W??r??d nich s?? studenci na co dzie?? korzystaj??cy ze smartfon??w oraz\n" +
                                    "medi??w spo??eczno??ciowych, nie dysponuj??cy du???? ilo??ci?? wolnego czasu. Rodzi si?? wi??c\n" +
                                    "potrzeba szukania promocji, ??atwo dost??pnych i przejrzystych.\n" +
                                    "Odpowiedzi?? jest aplikacja umo??liwiaj??ca znalezienie najlepszych ofert sprzeda??y\n" +
                                    "produkt??w spo??ywczych, cechuj??ca si?? przyst??pno??ci?? i praktycznym zastosowaniem.\n" +
                                    "Dzi??ki wykorzystaniu lokalizacji, u??ytkownik oszcz??dza czas, por??wnuj??c oferty w swojej\n" +
                                    "okolicy. Aplikacja ma charakterystyk?? forum gdzie u??ytkownicy s?? odpowiedzialni za\n" +
                                    "tre????. W celu zminimalizowania oszustw, system umo??liwia na prost?? ocen?? ofert przez\n" +
                                    "innych u??ytkownik??w."
                            , fontFamily = fontFamily
                        )
                    }, value = "", onValueChange = {})

                }
            })
    }
}
