package pl.pollub.harnasik.app.presentation.user.signUp

import android.util.Patterns
import android.view.Gravity
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
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
import androidx.navigation.NavHostController
import pl.pollub.harnasik.R

var fontFamily: FontFamily = FontFamily(Font(R.font.opensans))

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
    blankErrorMessage: String
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
            label = { Text(text = (label)) },
            leadingIcon = {
                Icon(
                    imageVector = leadingIconImageVector,
                    contentDescription = leadingIconDescription,
                    tint = if (showBlankError || showDataError) {
                        MaterialTheme.colors.error
                    } else {
                        MaterialTheme.colors.onSurface
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
                            },
                            contentDescription = "Toggle password visibility"
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
            Text(
                text = blankErrorMessage,
                color = MaterialTheme.colors.error,
                style = MaterialTheme.typography.caption
            )
        } else if (showDataError) {
            Text(
                text = dataErrorMessage,
                color = MaterialTheme.colors.error,
                style = MaterialTheme.typography.caption
            )
        }
    }
}

@Composable
fun SignUp(
    navController: NavHostController,
) {
    val context = LocalContext.current.applicationContext
    val focusManager = LocalFocusManager.current
    val scrollState = rememberScrollState()

    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var confirmPassword by rememberSaveable { mutableStateOf("") }

    var validateUsername by rememberSaveable { mutableStateOf(true) }
    var validatePassword by rememberSaveable { mutableStateOf(true) }
    var validatePasswordEqual by rememberSaveable { mutableStateOf(true) }

    var validateUsernameIsBlank by rememberSaveable { mutableStateOf(true) }
    var validatePasswordIsBlank by rememberSaveable { mutableStateOf(true) }
    var validateConfirmPasswordIsBlank by rememberSaveable { mutableStateOf(true) }

    var isPasswordVisible by rememberSaveable { mutableStateOf(false) }
    var isConfirmPasswordVisible by rememberSaveable { mutableStateOf(false) }

    val validateUsernameErrorMessage = "Wprowadź prawidłowy email"
    val validatePasswordErrorMessage = "Wprowadź prawidłowe hasło"
    val validateEqualPasswordErrorMessage = "Hasła muszą być takie same"
    val validateBlankFieldErrorMessage = "To pole nie może być puste"

    fun validateIfFieldsAreBlank(
        username: String,
        password: String,
        confirmPassword: String
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
        username: String,
        password: String,
        confirmPassword: String
    ) {
        if (!validateIfFieldsAreBlank(username, password, confirmPassword)) {
            if (validateData(username, password, confirmPassword)) {
                val toast = Toast.makeText(context, "Zarejestrowano!", Toast.LENGTH_LONG)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Utwórz konto\ni dziel się promocjami!",
            style = TextStyle(fontSize = 36.sp, fontFamily = FontFamily.Default),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(30.dp))
        Spacer(modifier = Modifier.height(20.dp))

        CustomOutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = "Nazwa użytkownika",
            leadingIconImageVector = Icons.Rounded.AccountCircle,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            showBlankError = !validateUsernameIsBlank,
            blankErrorMessage = validateBlankFieldErrorMessage,
            showDataError = !validateUsername,
            dataErrorMessage = validateUsernameErrorMessage
        )
        Spacer(modifier = Modifier.height(20.dp))
        CustomOutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = "Hasło",
            leadingIconImageVector = Icons.Default.VisibilityOff,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            showBlankError = !validatePasswordIsBlank,
            blankErrorMessage = validateBlankFieldErrorMessage,
            showDataError = !validatePassword,
            dataErrorMessage = validatePasswordErrorMessage
        )
        Spacer(modifier = Modifier.height(20.dp))
        CustomOutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = "Powtórz hasło",
            leadingIconImageVector = Icons.Default.VisibilityOff,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            showBlankError = !validateConfirmPasswordIsBlank,
            blankErrorMessage = validateBlankFieldErrorMessage,
            showDataError = !validatePasswordEqual,
            dataErrorMessage = validateEqualPasswordErrorMessage
        )

        Spacer(modifier = Modifier.height(20.dp))
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.Start,
        ) {
            AdultCheckbox()
            Spacer(modifier = Modifier.height(20.dp))
            TermsCheckbox()
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
                SignUpText()
            }
        }
    }
}

@Composable
fun SignUpText() {
    Text("ZAREJESTRUJ SIĘ", fontSize = 20.sp, fontFamily = fontFamily)
}

@Composable
fun AdultText() {
    Text("Jestem osobą pełnoletnią", fontSize = 20.sp, fontFamily = fontFamily)
}

@Composable
fun AcceptTermsText() {
    Text("Akceptuję regulamin", fontSize = 20.sp, fontFamily = fontFamily)
}

@Composable
fun AdultCheckbox() {
    Row(modifier = Modifier.padding(0.dp)) {
        val isChecked = remember { mutableStateOf(false) }
        Checkbox(
            checked = isChecked.value,
            onCheckedChange = { isChecked.value = it },
            enabled = true,
            colors = CheckboxDefaults.colors(MaterialTheme.colors.primary)
        )
        AdultText()
    }
}

@Composable
fun TermsCheckbox() {
    Row(modifier = Modifier.padding(0.dp)) {
        val isChecked = remember { mutableStateOf(false) }
        Checkbox(
            checked = isChecked.value,
            onCheckedChange = { isChecked.value = it },
            enabled = true,
            colors = CheckboxDefaults.colors(MaterialTheme.colors.primary)
        )
        AcceptTermsText()
    }
}
