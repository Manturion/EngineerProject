package pl.pollub.harnasik.app.presentation.user

import android.annotation.SuppressLint
import android.util.Patterns
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import java.util.regex.Pattern
import pl.pollub.harnasik.R
import pl.pollub.harnasik.app.core.Drawer.DrawerContent
import pl.pollub.harnasik.app.presentation.offers.AppBar
import pl.pollub.harnasik.app.presentation.offers.command.components.CustomOutlinedTextField

var fontFamily: FontFamily = FontFamily(Font(R.font.opensans))

@Composable
fun ShowTextUnderField(text: String, color: Color) {
    Text(
        text = text,
        color = color,
        style = MaterialTheme.typography.labelSmall,
        fontSize = 12.sp,
        fontFamily = fontFamily
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SignUp(
    navController: NavHostController, viewModel: AuthViewModel = hiltViewModel()
) {
    val state = viewModel.state
    val context = LocalContext.current

    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var confirmPassword by rememberSaveable { mutableStateOf("") }

    var validateUsername by rememberSaveable { mutableStateOf(true) }
    var validatePassword by rememberSaveable { mutableStateOf(true) }
    var validatePasswordEqual by rememberSaveable { mutableStateOf(true) }

    var validateUsernameIsBlank by rememberSaveable { mutableStateOf(true) }
    var validatePasswordIsBlank by rememberSaveable { mutableStateOf(true) }
    var validateConfirmPasswordIsBlank by rememberSaveable { mutableStateOf(true) }

    val validateUsernameErrorMessage = "Wprowad?? prawid??owy email"
    val validatePasswordErrorMessage = "Wprowad?? prawid??owe has??o"
    val validateEqualPasswordErrorMessage = "Has??a musz?? by?? takie same"
    val validateBlankFieldErrorMessage = "To pole nie mo??e by?? puste"

    val hintMessageUsername = "To b??dzie Tw??j login"
    val hintMessagePassword = "Has??o min x znak??w"

    fun validateIfFieldsAreBlank(
        username: String, password: String, confirmPassword: String
    ): Boolean {
        validateUsernameIsBlank = username.isNotBlank()
        validatePasswordIsBlank = password.isNotBlank()
        validateConfirmPasswordIsBlank = confirmPassword.isNotBlank()

        return validateUsernameIsBlank && validatePasswordIsBlank && validateConfirmPasswordIsBlank
    }

    fun validateData(username: String, password: String, confirmPassword: String): Boolean {

        validateUsername = Patterns.EMAIL_ADDRESS.matcher(username).matches()

        validatePassword = Pattern.compile("^" +
                "(?=.*[0-9])" +         //at least 1 digit
                "(?=.*[a-z])" +         //at least 1 lower case letter
                "(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{3,}" +               //at least x characters
                "$").matcher(password).matches()

        validatePasswordEqual = password == confirmPassword

        return validateUsername && validatePassword && validatePasswordEqual
    }

    fun register(
        username: String, password: String, confirmPassword: String
    ) {
        if (!validateIfFieldsAreBlank(username, password, confirmPassword)) {
            if (validateData(username, password, confirmPassword)) {
                viewModel.onEvent(AuthUiEvent.SignUp)
            }
        }
    }

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
                        text = "Utw??rz konto\ni dziel si?? promocjami!",
                        style = TextStyle(fontSize = 26.sp, fontFamily = FontFamily.Default),
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(50.dp))

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
                        hintMessage = hintMessageUsername
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    CustomOutlinedTextField(
                        value = password,
                        onValueChange = {
                            password = it
                            viewModel.onEvent(AuthUiEvent.SignUpPasswordChanged(password))
                        },
                        label = "Has??o",
                        leadingIconImageVector = painterResource(id = R.drawable.ic_round_password_24),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text, imeAction = ImeAction.Next
                        ),
                        showBlankError = !validatePasswordIsBlank,
                        blankErrorMessage = validateBlankFieldErrorMessage,
                        showDataError = !validatePassword,
                        dataErrorMessage = validatePasswordErrorMessage,
                        isPasswordField = true,
                        hintMessage = hintMessagePassword
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    CustomOutlinedTextField(
                        value = confirmPassword,
                        onValueChange = { confirmPassword = it },
                        label = "Powt??rz has??o",
                        leadingIconImageVector = painterResource(id = R.drawable.ic_round_password_24),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text, imeAction = ImeAction.Next
                        ),
                        showBlankError = !validateConfirmPasswordIsBlank,
                        blankErrorMessage = validateBlankFieldErrorMessage,
                        showDataError = !validatePasswordEqual,
                        dataErrorMessage = validateEqualPasswordErrorMessage,
                        isPasswordField = true,
                        hintMessage = ""
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Box(
                    ) {
                        Text(
                            text = "Rejestruj??c si?? potwierdzasz, ??e:\n" +
                                    "- jeste?? osob?? pe??noletni??\n" +
                                    "- akceptujesz regulamin",
                            textAlign = TextAlign.Center,
                            color = MaterialTheme.colorScheme.primary,
                            fontSize = 13.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))
                    Box(
                        modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)
                    ) {
                        Button(
                            onClick = {
                                register(username, password, confirmPassword)
                            },
                            shape = RoundedCornerShape(50.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                        ) {
                            Text("Utw??rz konto", fontSize = 16.sp, fontFamily = fontFamily)
                        }
                    }
                }
            })
    }
}
