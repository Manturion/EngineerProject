package pl.pollub.harnasik

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import pl.pollub.harnasik.ui.theme.HarnasikTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HarnasikTheme() {
                HarnasikApp()
            }
        }
    }
}

