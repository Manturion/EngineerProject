package pl.pollub.harnasik.app.presentation.user

import android.annotation.SuppressLint
import androidx.compose.foundation.background
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
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import pl.pollub.harnasik.app.core.Drawer.DrawerContent
import pl.pollub.harnasik.app.presentation.offers.AppBar
import pl.pollub.harnasik.app.util.Screen

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UserPanel(
    navController: NavController, viewModel: AuthViewModel = hiltViewModel()
) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    Scaffold(topBar = {
        AppBar(
            navController
        )
    }) {
        ModalNavigationDrawer(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface),
            drawerState = drawerState,
            drawerContent = {
                DrawerContent(navController = navController)
            }, content = {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(80.dp))
                    Text(
                        text = "Panel u??ytkownika",
                        style = TextStyle(
                            fontSize = 40.sp, fontFamily = FontFamily.Default
                        )
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Email: " + "ssmszymon@gmail.com",
                        style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Default)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Wystawione oferty: " + "9",
                        style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Default)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Oceny pozytywne: " + "21",
                        style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Default)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Oceny negatywne: " + "37",
                        style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Default)
                    )
                    Spacer(modifier = Modifier.height(40.dp))
                    ManageText()
                    Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                        Button(
                            onClick = {
                                navController.navigate(Screen.ForgotPassword.route)
                            },
                            shape = RoundedCornerShape(50.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp),

                            ) {
                            PasswordResetText()
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                        Button(
                            onClick = {
                                navController.navigate(Screen.AllOffersScreen.route)
                            },
                            shape = RoundedCornerShape(50.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp),

                            ) {
                            MyOffersText()
                        }
                    }
                }
            })
    }
}

@Composable
fun ManageText() {
    Spacer(modifier = Modifier.height(20.dp))
    Text(
        "Zarz??daj kontem:",
        style = TextStyle(
            fontSize = 30.sp, fontFamily = FontFamily.Default
        )
    )
    Spacer(modifier = Modifier.height(20.dp))
}

@Composable
fun PasswordResetText() {
    Text(
        "Zresetuj has??o",
        fontFamily = fontFamily,
        fontSize = 16.sp,
        color = MaterialTheme.colorScheme.onPrimary
    )
}

@Composable
fun MyOffersText() {
    Text(
        "Moje oferty",
        fontFamily = fontFamily,
        fontSize = 16.sp,
        color = MaterialTheme.colorScheme.onPrimary
    )
}