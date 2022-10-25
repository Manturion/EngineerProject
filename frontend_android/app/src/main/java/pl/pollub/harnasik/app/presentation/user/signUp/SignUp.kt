package pl.pollub.harnasik.app.presentation.user.signUp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import pl.pollub.harnasik.R

var fontFamily: FontFamily = FontFamily(Font(R.font.opensans))

@Composable
fun SignUp(
    navController: NavHostController,
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        val username = remember { mutableStateOf(TextFieldValue()) }
        val password = remember { mutableStateOf(TextFieldValue()) }

        Text(
            text = "Sign up\nand\njoin our community!",
            style = TextStyle(fontSize = 36.sp, fontFamily = FontFamily.Cursive),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(30.dp))
        TextField(
            label = { Text(text = "Username", fontFamily = fontFamily) },
            value = username.value,
            onValueChange = { username.value = it },
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            label = { Text(text = "Email", fontFamily = fontFamily) },
            value = username.value,
            onValueChange = { username.value = it })

        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            label = { Text(text = "Password", fontFamily = fontFamily) },
            value = password.value,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = { password.value = it })
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            label = { Text(text = "Confirm password", fontFamily = fontFamily) },
            value = password.value,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = { password.value = it })
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
            modifier = Modifier
                .padding(40.dp, 0.dp, 40.dp, 0.dp)
        ) {
            Button(
                onClick = {},
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
    Text("SIGN UP", fontSize = 20.sp, fontFamily = fontFamily)
}

@Composable
fun AdultText() {
    Text("I am over 18 years old", fontSize = 20.sp, fontFamily = fontFamily)
}

@Composable
fun AcceptTermsText() {
    Text("I accept Terms and Conditions", fontSize = 20.sp, fontFamily = fontFamily)
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
