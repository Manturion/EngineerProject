package pl.pollub.harnasik.app.presentation.user.forgotPassword

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun ForgotPassword(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        val username = remember { mutableStateOf(TextFieldValue()) }
        val password = remember { mutableStateOf(TextFieldValue()) }

        Text(
            text = "You may reset your password below",
            style = TextStyle(fontSize = 40.sp, fontFamily = FontFamily.Default),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(60.dp))

        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            label = { Text(text = "Your email (username)") },
            value = username.value,
            onValueChange = { username.value = it })

        Spacer(modifier = Modifier.height(20.dp))
        PasswordWillBeSentOnEmailText()
        Spacer(modifier = Modifier.height(40.dp))
        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
            Button(
                onClick = {},
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                PasswordResetText()
            }
        }
    }
}

@Composable
fun PasswordResetText() {
    Text("Reset", fontSize = 22.sp)
}

@Composable
fun PasswordWillBeSentOnEmailText() {
    Text("Password will be sent on this email", fontSize = 22.sp)
}
