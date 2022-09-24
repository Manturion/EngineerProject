package pl.pollub.harnasik.app.presentation.offers

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
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
import pl.pollub.harnasik.R

@Composable
fun AppBar(
    onNavigationIconClick: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .background(color = MaterialTheme.colorScheme.primary)


    ) {

        IconButton(onClick = onNavigationIconClick) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Toggle drawer"
            )
        }

        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            modifier = Modifier.padding(16.dp)
        )
        Text(text = "Navbar")
        IconButton(
            modifier = Modifier.padding(16.dp),
            onClick = { /* todo */ }
        ) {
            Icon(
                imageVector = Icons.Filled.Settings,
                contentDescription = stringResource(R.string.label_settings)
            )
        }
    }
}