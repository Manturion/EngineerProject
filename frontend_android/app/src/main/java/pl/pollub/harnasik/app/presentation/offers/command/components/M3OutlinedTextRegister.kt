package pl.pollub.harnasik.app.presentation.offers.command.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pl.pollub.harnasik.R
import pl.pollub.harnasik.app.presentation.user.ShowTextUnderField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun M3CustomOutlinedTextFieldReg(
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
    showDataError: Boolean = false,
    showBlankError: Boolean = false,
    dataErrorMessage: String,
    blankErrorMessage: String,
    hintMessage: String
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = { onValueChange(it) },
            modifier = Modifier.padding(bottom = 10.dp),
            label = {
                Text(
                    text = (label), fontSize = 12.sp
                )
            },
            leadingIcon = {
                Icon(
                    painter = leadingIconImageVector,
                    contentDescription = leadingIconDescription,
                    tint = if (showBlankError || showDataError) {
                        MaterialTheme.colorScheme.error
                    } else {
                        MaterialTheme.colorScheme.onSurface
                    }
                )
            },
            isError = showBlankError || showDataError,
            trailingIcon = {
                if ((showDataError || showBlankError) && !isPasswordField) {
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
                                contentDescription = "toggle_password_visibility",
                                tint = MaterialTheme.colorScheme.onPrimary,
                            )
                        }else{
                            Icon(
                                painter = painterResource(id = R.drawable.ic_round_visibility_off_24),
                                contentDescription = "toggle_password_visibility",
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
        if (showBlankError) {
            ShowTextUnderField(
                text = blankErrorMessage, color = MaterialTheme.colorScheme.error
            )
        } else if (showDataError) {
            ShowTextUnderField(
                text = dataErrorMessage, color = MaterialTheme.colorScheme.error
            )
        } else {
            ShowTextUnderField(
                text = hintMessage, color = MaterialTheme.colorScheme.onSecondary
            )
        }
    }
}