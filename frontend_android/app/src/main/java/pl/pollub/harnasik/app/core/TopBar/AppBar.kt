package pl.pollub.harnasik.app.presentation.offers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import pl.pollub.harnasik.R


@Composable
fun AppBar(
//        onNavigationIconClick: () -> Unit
        navController: NavController
) {


    Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
                    .background(color = MaterialTheme.colorScheme.primary)
    ) {

        var colorUndoButtonIfMainButtonActive = MaterialTheme.colorScheme.onPrimary 
        if (navController.currentBackStackEntry?.destination?.route == "all_offers_screen") {
            colorUndoButtonIfMainButtonActive = MaterialTheme.colorScheme.primary
        }

        IconButton(
                onClick = { navController.popBackStack() }
        ) {
            Icon(
                    painter = painterResource(id = R.drawable.ic_round_arrow_back_ios_new_24),
                    contentDescription = stringResource(R.string.label_continue_to_courses),
                    tint = colorUndoButtonIfMainButtonActive,
            )
        }

        Icon(
                painter = painterResource(id = R.drawable.ic_round_shopping_cart_24),
                contentDescription = "koszyk",
                tint = MaterialTheme.colorScheme.onPrimary,

        )
        Text(
                text = "Zaoszczędź z nami",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimary
        )
        IconButton(modifier = Modifier.padding(16.dp), onClick = { /* todo */ }) {
            Icon(
                    painter = painterResource(id = R.drawable.ic_round_settings_24),
                    contentDescription = "ustawienia",
                    tint = MaterialTheme.colorScheme.onPrimary,
            )
        }
    }

}