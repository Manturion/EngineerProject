package pl.pollub.harnasik.app.presentation.user.forgotPassword

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

var fontFamily: FontFamily = FontFamily(Font(R.font.opensans))

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPassword(navController: NavHostController) {

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

                    val username = remember { mutableStateOf(TextFieldValue()) }

                    Text(
                        text = "Możesz zresetować swoje hasło poniżej",
                        fontFamily = fontFamily,
                        style = TextStyle(
                            fontSize = 26.sp, fontFamily = FontFamily.Default
                        ),
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(60.dp))

                    Spacer(modifier = Modifier.height(20.dp))
                    TextField(label = {
                        Text(
                            text = "Twój email (login)", fontFamily = fontFamily
                        )
                    }, value = username.value, onValueChange = { username.value = it })

                    Spacer(
                        modifier = Modifier.height(20.dp)
                    )
                    PasswordWillBeSentOnEmailText()
                    Spacer(
                        modifier = Modifier.height(40.dp)
                    )
                    Box(
                        modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)
                    ) {
                        Button(
                            onClick = {},
                            shape = RoundedCornerShape(50.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp),
                        ) {
                            PasswordResetText()
                        }
                    }
                }
            })
    }
}

@Composable
fun PasswordResetText() {
    Text(
        "Resetuj hasło", fontSize = 16.sp, fontFamily = fontFamily
    )
}

@Composable
fun PasswordWillBeSentOnEmailText() {
    Text(
        "Hasło zostanie wysłane na ten email", fontSize = 16.sp, fontFamily = fontFamily
    )
}
