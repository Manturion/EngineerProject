package pl.pollub.harnasik.app.presentation.user

import android.annotation.SuppressLint
import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import pl.pollub.harnasik.R
import pl.pollub.harnasik.app.auth.AuthResult
import pl.pollub.harnasik.app.core.Drawer.drawerContent
import pl.pollub.harnasik.app.presentation.offers.AppBar
import pl.pollub.harnasik.app.util.Screen

var fontFamily: FontFamily = FontFamily(Font(R.font.opensans))

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomOutlinedTextField(
        value: String,
        onValueChange: (String) -> Unit,
        label: String,
        leadingIconImageVector: ImageVector,
        leadingIconDescription: String = "",
        isPasswordField: Boolean = false,
        isPasswordVisible: Boolean = false,
        onVisibilityChange: (Boolean) -> Unit = {},
        keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
        keyboardActions: KeyboardActions = KeyboardActions.Default,
        showDataError: Boolean = false,
        showBlankError: Boolean = false,
        dataErrorMessage: String,
        blankErrorMessage: String,
        hintMessage: String
) {
    Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
                value = value,
                onValueChange = { onValueChange(it) },
                modifier = Modifier
                        .padding(bottom = 10.dp),
                label = {
                    Text(
                            text = (label),
                            fontSize = 12.sp
                    )
                },
                leadingIcon = {
                    Icon(
                            imageVector = leadingIconImageVector,
                            contentDescription = leadingIconDescription,
                            tint = if (showBlankError || showDataError) {
                                MaterialTheme.colorScheme.error
                            } else {
                                MaterialTheme.colorScheme.onSurface
                            }
                    )
                },
                isError = showBlankError || showDataError,
                trailingIcon = {
                    if ((showDataError || showBlankError) && !isPasswordField) {
                        Icon(imageVector = Icons.Filled.Error, contentDescription = "Show error icon")
                    }
                    if (isPasswordField) {
                        IconButton(onClick = { onVisibilityChange(!isPasswordVisible) }) {
                            Icon(
                                    imageVector = if (isPasswordVisible) {
                                        Icons.Default.Visibility
                                    } else {
                                        Icons.Default.VisibilityOff
                                    }, contentDescription = "Toggle password visibility"
                            )
                        }
                    }
                },
                visualTransformation = when {
                    isPasswordField && isPasswordVisible -> VisualTransformation.None
                    isPasswordField -> PasswordVisualTransformation()
                    else -> VisualTransformation.None
                },
                keyboardOptions = keyboardOptions,
                keyboardActions = keyboardActions,
                singleLine = true
        )
        if (showBlankError) {
            showTextUnderField(
                    text = blankErrorMessage,
                    color = MaterialTheme.colorScheme.error)
        } else if (showDataError) {
            showTextUnderField(
                    text = dataErrorMessage,
                    color = MaterialTheme.colorScheme.error)
        } else {
            showTextUnderField(
                    text = hintMessage,
                    color = MaterialTheme.colorScheme.onSecondary)
        }
    }
}

@Composable
fun showTextUnderField(text: String, color: Color) {
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

    LaunchedEffect(viewModel, context) {
        viewModel.authResults.collect { result ->
            when (result) {
                is AuthResult.Authorized -> {
                    navController.navigate(Screen.AllOffersScreen.route)
                }
                is AuthResult.Unauthorized -> {
                    Toast.makeText(
                            context, "Niepomyślnie", Toast.LENGTH_LONG
                    ).show()
                }
                is AuthResult.UnknownError -> {
                    Toast.makeText(
                            context, "Wystąpił błąd", Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }


//    val context = LocalContext.current.applicationContext

    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var confirmPassword by rememberSaveable { mutableStateOf("") }

    var validateUsername by rememberSaveable { mutableStateOf(true) }
    var validatePassword by rememberSaveable { mutableStateOf(true) }
    var validatePasswordEqual by rememberSaveable { mutableStateOf(true) }

    var validateUsernameIsBlank by rememberSaveable { mutableStateOf(true) }
    var validatePasswordIsBlank by rememberSaveable { mutableStateOf(true) }
    var validateConfirmPasswordIsBlank by rememberSaveable { mutableStateOf(true) }

    val validateUsernameErrorMessage = "Wprowadź prawidłowy email"
    val validatePasswordErrorMessage = "Wprowadź prawidłowe hasło"
    val validateEqualPasswordErrorMessage = "Hasła muszą być takie same"
    val validateBlankFieldErrorMessage = "To pole nie może być puste"

    val hintMessageUsername = "To będzie Twój login"
    val hintMessagePassword = "Hasło min x znaków"

    fun validateIfFieldsAreBlank(
            username: String, password: String, confirmPassword: String
    ): Boolean {
        validateUsernameIsBlank = username.isNotBlank()
        validatePasswordIsBlank = password.isNotBlank()
        validateConfirmPasswordIsBlank = confirmPassword.isNotBlank()

        return validateUsernameIsBlank && validatePasswordIsBlank && validateConfirmPasswordIsBlank
    }

    fun validateData(username: String, password: String, confirmPassword: String): Boolean {
//        val passwordRegex = "xxx"
        validateUsername = Patterns.EMAIL_ADDRESS.matcher(username).matches()

        validatePassword = true // TODO PASSWORD VALIDATION
//        validatePassword = passwordRegex.matches(password.)
        validatePasswordEqual = password == confirmPassword

        return validateUsername && validatePassword && validatePasswordEqual
    }

    fun register(
            username: String, password: String, confirmPassword: String
    ) {
        if (!validateIfFieldsAreBlank(username, password, confirmPassword)) {
            if (validateData(username, password, confirmPassword)) {
//                val toast = Toast.makeText(context, "Zarejestrowano!", Toast.LENGTH_LONG)
//                toast.setGravity(Gravity.CENTER, 0, 0)
//                toast.show()

                viewModel.onEvent(AuthUiEvent.SignUp)
            }
        }
    }

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    Scaffold(
            topBar = {
                AppBar(
                        navController
                )
            }
    ) {
        ModalNavigationDrawer(
                modifier = Modifier.background(MaterialTheme.colorScheme.surface),
                drawerState = drawerState,
                drawerContent = {
                    drawerContent(navController = navController)
                },
                content = {
                    Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                                text = "Utwórz konto\ni dziel się promocjami!",
                                style = TextStyle(fontSize = 26.sp, fontFamily = FontFamily.Default),
                                textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(30.dp))
                        Spacer(modifier = Modifier.height(20.dp))

                        CustomOutlinedTextField(
                                value = username,
                                onValueChange = {
                                    username = it
                                    viewModel.onEvent(AuthUiEvent.SignUpUsernameChanged(username))
                                },
                                label = "Email",
                                leadingIconImageVector = Icons.Default.Email,
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
                                label = "Hasło",
                                leadingIconImageVector = Icons.Default.Password,
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
                                label = "Powtórz hasło",
                                leadingIconImageVector = Icons.Default.Password,
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
                                modifier = Modifier
                                        .fillMaxWidth()
                                        .align(CenterHorizontally)
                                        .padding(start = 20.dp, end = 20.dp)
                        ) {
                            Text(
                                    text = "Rejestrując się potwierdzasz,że jesteś osobą pełnoletnią oraz akceptujesz regulamin",
                                    textAlign = TextAlign.Center,
                                    color = MaterialTheme.colorScheme.primary, fontSize = 12.sp
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
                                Text("Utwórz konto", fontSize = 16.sp, fontFamily = fontFamily)
                            }
                        }
                    }
                })
    }
}
