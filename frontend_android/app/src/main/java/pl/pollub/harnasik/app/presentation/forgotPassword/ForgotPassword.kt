package pl.pollub.harnasik.app.presentation.forgotPassword

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun ForgotPassword(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        ScaffoldWithTopBarForgotPass(navController)
    }
}

@Composable
fun ScaffoldWithTopBarForgotPass(navController: NavHostController) {
//    Scaffold(
//        topBar = {
//            CustomTopAppBar(navController, "Forgot Password", true)
//        }, content = {
//            Column(
//                modifier = Modifier
//                    .fillMaxSize(),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(
//                    text = "Forgot Password",
//                    fontSize = 30.sp,
//                    color = Color.Black
//                )
//            }
//        })
}