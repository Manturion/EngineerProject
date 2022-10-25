package pl.pollub.harnasik.app.presentation.user.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import pl.pollub.harnasik.R
import pl.pollub.harnasik.app.util.Screen

var fontFamily: FontFamily = FontFamily(Font(R.font.opensans))

@Composable
fun LoginPage(navController: NavHostController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val username = remember { mutableStateOf(TextFieldValue()) }
        val password = remember { mutableStateOf(TextFieldValue()) }

        Text(
            text = "Welcome back!",
            style = TextStyle(fontSize = 50.sp, fontFamily = FontFamily.Cursive)
        )
        Spacer(modifier = Modifier.height(60.dp))
        TextField(label = { Text(text = "Username", fontFamily = fontFamily) },
            value = username.value,
            onValueChange = { username.value = it })

        Spacer(modifier = Modifier.height(20.dp))
        TextField(label = { Text(text = "Password", fontFamily = fontFamily) },
            value = password.value,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = { password.value = it })

        Spacer(modifier = Modifier.height(40.dp))
        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
            Button(
                onClick = {},
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
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
            text = AnnotatedString("Forgot password?"), onClick = {
                navController.navigate(Screen.ForgotPassword.route)
            }, style = TextStyle(
                fontSize = 20.sp, fontFamily = fontFamily
            )
        )
    }
}

@Composable
fun LogInText() {
    Text("Log in", fontFamily = fontFamily, fontSize = 22.sp)
}

@Composable
fun SignUpText() {
    Text("Sign up", fontFamily = fontFamily, fontSize = 22.sp)
}

@Composable
fun OrText() {
    Spacer(modifier = Modifier.height(10.dp))
    Text(" OR ", fontFamily = fontFamily, fontSize = 16.sp)
    Spacer(modifier = Modifier.height(10.dp))
}