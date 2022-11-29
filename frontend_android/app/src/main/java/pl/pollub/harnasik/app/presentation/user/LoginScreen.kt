package pl.pollub.harnasik.app.presentation.user.login

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
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import pl.pollub.harnasik.R
import pl.pollub.harnasik.app.core.Drawer.DrawerContent
import pl.pollub.harnasik.app.presentation.offers.AppBar
import pl.pollub.harnasik.app.presentation.offers.command.components.CustomOutlinedTextField
import pl.pollub.harnasik.app.presentation.user.AuthUiEvent
import pl.pollub.harnasik.app.presentation.user.AuthViewModel
import pl.pollub.harnasik.app.util.Screen

var fontFamily: FontFamily = FontFamily(Font(R.font.opensans))

@Composable
fun ShowTextUnderField(text: String, color: Color) {
    Text(
        text = text,
        color = color,
        style = MaterialTheme.typography.labelSmall,
        fontSize = 12.sp,
        fontFamily = pl.pollub.harnasik.app.presentation.user.fontFamily
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginPage(
    navController: NavController, viewModel: AuthViewModel = hiltViewModel()
) { 
    val context = LocalContext.current

    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    var validateUsername by rememberSaveable { mutableStateOf(true) }
    var validatePassword by rememberSaveable { mutableStateOf(true) }

    var validateUsernameIsBlank by rememberSaveable { mutableStateOf(true) }
    var validatePasswordIsBlank by rememberSaveable { mutableStateOf(true) }

    val validateUsernameErrorMessage = "Wprowadź prawidłowy email"
    val validatePasswordErrorMessage = "Wprowadź prawidłowe hasło"
    val validateBlankFieldErrorMessage = "To pole nie może być puste"

    fun validateIfFieldsAreBlank(
        username: String, password: String
    ): Boolean {
        validateUsernameIsBlank = username.isNotBlank()
        validatePasswordIsBlank = password.isNotBlank()

        return validateUsernameIsBlank && validatePasswordIsBlank
    }

    fun login(
        username: String, password: String
    ) {
        if (!validateIfFieldsAreBlank(username, password)) {
            viewModel.onEvent(AuthUiEvent.SignUp)
        }
    }

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
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Witaj ponownie!",
                        style = TextStyle(fontSize = 50.sp, fontFamily = FontFamily.Cursive)
                    )
                    Spacer(modifier = Modifier.height(60.dp))

                    CustomOutlinedTextField(
                        value = username,
                        onValueChange = {
                            username = it
                            viewModel.onEvent(AuthUiEvent.SignUpUsernameChanged(username))
                        },
                        label = "Email",
                        leadingIconImageVector = painterResource(id = R.drawable.ic_round_mail_24),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text, imeAction = ImeAction.Next
                        ),
                        showBlankError = !validateUsernameIsBlank,
                        blankErrorMessage = validateBlankFieldErrorMessage,
                        showDataError = !validateUsername,
                        dataErrorMessage = validateUsernameErrorMessage,
                        hintMessage = ""
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    CustomOutlinedTextField(
                        value = password,
                        onValueChange = {
                            password = it
                            viewModel.onEvent(AuthUiEvent.SignUpPasswordChanged(password))
                        },
                        label = "Hasło",
                        leadingIconImageVector = painterResource(
                            id = R.drawable.ic_round_password_24),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text, imeAction = ImeAction.Next
                        ),
                        showBlankError = !validatePasswordIsBlank,
                        blankErrorMessage = validateBlankFieldErrorMessage,
                        showDataError = !validatePassword,
                        dataErrorMessage = validatePasswordErrorMessage,
                        isPasswordField = true,
                        hintMessage = ""
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                        Button(
                            onClick = {
                                login(username, password)
                                //viewModel.onEvent(AuthUiEvent.SignIn)
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