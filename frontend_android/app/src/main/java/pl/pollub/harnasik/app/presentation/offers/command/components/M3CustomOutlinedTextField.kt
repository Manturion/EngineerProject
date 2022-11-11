package pl.pollub.harnasik.app.presentation.offers.command.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import pl.pollub.harnasik.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    leadingIconImageVector: Painter,
    leadingIconDescription: String = "",
    isPasswordField: Boolean = false,
    isPasswordVisible: Boolean = false,
    onVisibilityChange: (Boolean) -> Unit = {},
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    showError: Boolean = false,
    errorMessage: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = { onValueChange(it) },
            modifier = modifier
                .fillMaxWidth()
                .height(58.dp),
            label = { Text(text = (label)) },
            maxLines = 10,


            leadingIcon = {
                Icon(
                    painter = leadingIconImageVector,
                    contentDescription = leadingIconDescription,
                    tint = if (showError) {
                        MaterialTheme.colorScheme.error
                    } else {
                        MaterialTheme.colorScheme.onSurface
                    }
                )
            },
            isError = showError,
            trailingIcon = {
                if (showError && !isPasswordField) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_round_error_24),
                        contentDescription = "error",
                        tint = MaterialTheme.colorScheme.onPrimary,
                    )
                }
                if (isPasswordField) {
                    IconButton(onClick = { onVisibilityChange(!isPasswordVisible) }) {
                        if(isPasswordVisible){
                            Icon(
                                painter = painterResource(id = R.drawable.ic_round_visibility_24),
                                contentDescription = "wiadomosci",
                                tint = MaterialTheme.colorScheme.onPrimary,
                            )
                        }else{
                            Icon(
                                painter = painterResource(id = R.drawable.ic_round_visibility_off_24),
                                contentDescription = "wiadomosci",
                                tint = MaterialTheme.colorScheme.onPrimary,
                            )
                        }
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
        if (showError) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .offset(y = (-8).dp)
                    .fillMaxWidth(0.9f)
            )
        }
    }
}