package pl.pollub.harnasik.app.core.Drawer

import android.graphics.drawable.Icon
import androidx.compose.ui.graphics.vector.ImageVector

data class MenuItem(
    val id: String,
    val title: String,
    val icon: Icon
)
