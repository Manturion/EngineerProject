package pl.pollub.harnasik.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import pl.pollub.harnasik.R

// Set of Material typography styles to start with
val font = FontFamily(Font(R.font.opensans))
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.opensans)),
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 22.sp,
        letterSpacing = 0.2.sp
    ),
    titleMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.opensans))
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.opensans))
    ),
    titleLarge = TextStyle(
        fontWeight = FontWeight.W600,
        fontSize = 20.sp,
        fontFamily = FontFamily(Font(R.font.opensans))

    )


    /*  Other default text styles to override
     titleLarge = TextStyle(
         fontFamily = FontFamily.Default,
         fontWeight = FontWeight.Normal,
         fontSize = 22.sp,
         lineHeight = 28.sp,
         letterSpacing = 0.sp
     ),
     labelSmall = TextStyle(
         fontFamily = FontFamily.Default,
         fontWeight = FontWeight.Medium,
         fontSize = 11.sp,
         lineHeight = 16.sp,
         letterSpacing = 0.5.sp
     )
     */
)