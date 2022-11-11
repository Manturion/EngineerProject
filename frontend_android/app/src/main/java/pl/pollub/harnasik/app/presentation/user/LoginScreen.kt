package pl.pollub.harnasik.app.presentation.user.login

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import pl.pollub.harnasik.R
import pl.pollub.harnasik.app.auth.AuthResult
import pl.pollub.harnasik.app.core.Drawer.DrawerContent
import pl.pollub.harnasik.app.presentation.user.AuthUiEvent
import pl.pollub.harnasik.app.presentation.user.AuthViewModel
import pl.pollub.harnasik.app.util.Screen

var fontFamily: FontFamily = FontFamily(Font(R.font.opensans))

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LoginPage(
    navController: NavController, viewModel: AuthViewModel = hiltViewModel()
) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)

    val context = LocalContext.current
    LaunchedEffect(viewModel, context) {
        viewModel.authResults.collect { result ->
            when (result) {
                is AuthResult.Authorized -> {
                    Toast.makeText(
                        context, "Pomyślnie zalogowano", Toast.LENGTH_LONG
                    ).show()

                    navController.navigate(Screen.AllOffersScreen.route)
                }
                is AuthResult.Unauthorized -> {
                    Toast.makeText(
                        context, "Niepomyślne logowanie", Toast.LENGTH_LONG
                    ).show()
                }
                is AuthResult.UnknownError -> {
                    Toast.makeText(
                        context, "Wystąpił nieznany błąd", Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
    ModalNavigationDrawer(
        modifier = Modifier.background(MaterialTheme.colorScheme.surface),
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(navController = navController)
        }, content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                val username = remember { mutableStateOf(TextFieldValue()) }
                val password = remember { mutableStateOf(TextFieldValue()) }

                Text(
                    text = "Witaj ponownie!",
                    style = TextStyle(fontSize = 50.sp, fontFamily = FontFamily.Cursive)
                )
                Spacer(modifier = Modifier.height(60.dp))
                TextField(colors = TextFieldDefaults.textFieldColors(
                    cursorColor = MaterialTheme.colorScheme.primary,
                    containerColor = MaterialTheme.colorScheme.onPrimary,
                    focusedLabelColor = MaterialTheme.colorScheme.primary
                ),
                    label = {
                        Text(
                            text = "Nazwa użytkownika",
                            fontFamily = fontFamily,
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.padding(bottom = 15.dp),
                            fontSize = 16.sp
                        )
                    },
                    textStyle = TextStyle(fontSize = 14.sp),
                    value = username.value,
                    onValueChange = {
                        username.value = it
                        viewModel.onEvent(AuthUiEvent.SignInUsernameChanged(username.value.text))
                    })

                Spacer(modifier = Modifier.height(20.dp))
                TextField(colors = TextFieldDefaults.textFieldColors(
                    cursorColor = MaterialTheme.colorScheme.primary,
                    containerColor = MaterialTheme.colorScheme.onPrimary,
                    focusedLabelColor = MaterialTheme.colorScheme.primary
                ),
                    label = {
                        Text(
                            text = "Hasło",
                            fontFamily = fontFamily,
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.padding(bottom = 15.dp),
                            fontSize = 16.sp
                        )
                    },
                    textStyle = TextStyle(fontSize = 14.sp),
                    value = password.value,
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    onValueChange = {
                        password.value = it
                        viewModel.onEvent(AuthUiEvent.SignInPasswordChanged(password.value.text))
                    })

                Spacer(modifier = Modifier.height(40.dp))
                Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                    Button(
                        onClick = {
                            viewModel.onEvent(AuthUiEvent.SignIn)
                        },
                        shape = RoundedCornerShape(50.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),

                        ) {
                        LogInText()
                    }
                }
                OrText()
                Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                    Button(
                        onClick = {
                            navController.navigate(Screen.SignUp.route)
                        },
                        colors = ButtonDefaults.buttonColors(
                            contentColor = MaterialTheme.colorScheme.onPrimary,
                            containerColor = MaterialTheme.colorScheme.primary,
                        ),
                        shape = RoundedCornerShape(50.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        SignUpText()
                    }

                }
                Spacer(modifier = Modifier.height(60.dp))
                ClickableText(
                    text = AnnotatedString("Nie pamiętam hasła"), onClick = {
                        navController.navigate(Screen.ForgotPassword.route)
                    }, style = TextStyle(
                        fontSize = 16.sp, fontFamily = fontFamily
                    )
                )
            }
        })
}

@Composable
fun LogInText() {
    Text(
        "Zaloguj się",
        fontFamily = fontFamily,
        fontSize = 16.sp,
        color = MaterialTheme.colorScheme.onPrimary
    )
}

@Composable
fun SignUpText() {
    Text(
        "Zarejestruj się",
        fontFamily = fontFamily,
        fontSize = 16.sp,
        color = MaterialTheme.colorScheme.onPrimary
    )
}

@Composable
fun OrText() {
    Spacer(modifier = Modifier.height(10.dp))
    Text(" LUB ", fontFamily = fontFamily, fontSize = 16.sp)
    Spacer(modifier = Modifier.height(10.dp))
}