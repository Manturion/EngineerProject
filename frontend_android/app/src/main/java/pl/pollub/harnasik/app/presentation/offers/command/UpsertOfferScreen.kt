package pl.pollub.harnasik.app.presentation.offers.command

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import java.util.*
import pl.pollub.harnasik.app.presentation.offers.command.components.CustomOutlinedTextField
import pl.pollub.harnasik.app.util.Screen
import pl.pollub.harnasik.ui.theme.HarnasikTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditOfferScreen(
    navController: NavController, viewModel: UpsertOfferViewModel = hiltViewModel()
) {

    HarnasikTheme {

        val titleState = viewModel.offerTitle.value
        val descriptionState = viewModel.offerDescription.value
        val oldPriceState = viewModel.offerOldPrice.value
        val newPriceState = viewModel.offerNewPrice.value

        Scaffold(

            floatingActionButton = {
                FloatingActionButton(
                    onClick = {

                    },
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    containerColor = MaterialTheme.colorScheme.primary
                    ) {
                    Icon(
                        imageVector = Icons.Rounded.Save,
                        contentDescription = "Dodaj ofertę",

                    )

                }
            }


        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 24.dp, end = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Dodaj ofertę",
                        modifier = Modifier,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                }


                var title by rememberSaveable { mutableStateOf("") }
                val validateTitleMessage = "Tytuł nie może być pusty"
                var validateTitle by rememberSaveable { mutableStateOf(true) }

                CustomOutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = "Tytuł oferty",
                    showError = !validateTitle,
                    leadingIconImageVector = Icons.Rounded.Title,
                    errorMessage = validateTitleMessage,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text, imeAction = ImeAction.Next
                    )
                )

                val galleryLauncher =
                    rememberLauncherForActivityResult(ActivityResultContracts.GetMultipleContents()) { uriList ->
                        // process eith the received image uri
                    }

                Button(
                    onClick = { galleryLauncher.launch("image/*") },
                    modifier = Modifier
//                        .wrapContentSize()
                        .padding(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = MaterialTheme.colorScheme.onPrimary,
                        containerColor = MaterialTheme.colorScheme.primary,
                    ),

                    ) {
                    Text(text = "Wybierz zdjęcie")
                }

//                //dropdown categorie


                val options = listOf("Jedzenie", "Napoje", "Słodycze", "Przekąski", "Alkohole")
                var expanded by remember { mutableStateOf(false) }
                var selectedOptionText by remember { mutableStateOf(options[0]) }

                ExposedDropdownMenuBox(
                    expanded = expanded,
                    onExpandedChange = { expanded = !expanded },

                ) {
                    OutlinedTextField(
                        // The `menuAnchor` modifier must be passed to the text field for correctness.
                        modifier = Modifier
                            .menuAnchor()
                            .fillMaxWidth(),
                        readOnly = true,
                        value = selectedOptionText,
                        onValueChange = {},
                        label = { Text("Kategoria") },
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                        colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(
                            cursorColor = MaterialTheme.colorScheme.primary,
                            containerColor = MaterialTheme.colorScheme.onPrimary,
                            focusedLabelColor = MaterialTheme.colorScheme.primary,
                        ),


                        )
                    ExposedDropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                        Modifier.background(MaterialTheme.colorScheme.onPrimary)

                    ) {
                        options.forEach { selectionOption ->
                            DropdownMenuItem(
                                text = { Text(selectionOption) },
                                onClick = {
                                    selectedOptionText = selectionOption
                                    expanded = false
                                },
                                contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                            )
                        }
                    }
                }
                //End of dropdown categories


                var description by rememberSaveable { mutableStateOf("") }
                val validateDescriptionMessage = "Opis nie może być pusty"
                var validateDescription by rememberSaveable { mutableStateOf(true) }

                CustomOutlinedTextField(
                    value = description,
                    onValueChange = { description = it },
                    label = "Opis oferty",
                    showError = !validateTitle,
                    leadingIconImageVector = Icons.Rounded.Description,
                    errorMessage = validateDescriptionMessage,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text, imeAction = ImeAction.Next
                    ),
                    modifier = Modifier.height(144.dp)
                )

                //Calendar setup
                val c = Calendar.getInstance()
                val year = c.get(Calendar.YEAR)
                val month = c.get(Calendar.MONTH)
                val day = c.get(Calendar.DAY_OF_MONTH)
                val context = LocalContext.current
                var expireDate by rememberSaveable {
                    mutableStateOf("")
                }
                val datePickerDialog = DatePickerDialog(
                    context,
                    { d, year, month1, day ->
                        val month = month + 1
                        expireDate = "$day/$month/$year"
                    },
                    year, month, day,
                )


                var validateExpireDate by rememberSaveable { mutableStateOf(true) }

                CustomOutlinedTextField(
                    value = expireDate,
                    onValueChange = { expireDate = it },
                    label = "Data ważności oferty",
                    leadingIconImageVector = Icons.Rounded.DateRange,
                    errorMessage = validateTitleMessage,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text, imeAction = ImeAction.Next
                    )
                )
                Spacer(modifier = Modifier.height(2.dp))

                Row(modifier = Modifier.padding(8.dp)) {
                    Button(
                        onClick = { datePickerDialog.show() },
                        colors = ButtonDefaults.buttonColors(
                            contentColor = MaterialTheme.colorScheme.onPrimary,
                            containerColor = MaterialTheme.colorScheme.primary,
                        ),
                        modifier = Modifier
                            .width(164.dp)
                            .padding(end = 16.dp),

                        ) {
                        Text(text = "Wybierz datę ważności", textAlign = TextAlign.Center)
                    }

                    Button(
                        onClick = { navController.navigate(Screen.MapSelect.route) },
                        colors = ButtonDefaults.buttonColors(
                            contentColor = MaterialTheme.colorScheme.onPrimary,
                            containerColor = MaterialTheme.colorScheme.primary,
                        ),
                        modifier = Modifier
                            .width(164.dp)
                            .padding(start = 16.dp)

                    ) {
                        Text(text = "Wybierz na mapie", textAlign = TextAlign.Center)
                    }
                }


                //Old price
                var oldPrice by rememberSaveable { mutableStateOf("") }
                val validateOldPriceMessage = "Opis nie może być pusty"
                var validateOldPrice by rememberSaveable { mutableStateOf(true) }

                CustomOutlinedTextField(
                    value = oldPrice,
                    onValueChange = { oldPrice = it },
                    label = "Stara cena",
                    showError = !validateOldPrice,
                    leadingIconImageVector = Icons.Rounded.MoneyOff,
                    errorMessage = validateOldPriceMessage,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number, imeAction = ImeAction.Next
                    )
                )

                //New price

                var newPrice by rememberSaveable { mutableStateOf("") }
                val validateNewPriceMessage = "Opis nie może być pusty"
                var validateNewPrice by rememberSaveable { mutableStateOf(true) }

                CustomOutlinedTextField(
                    value = newPrice,
                    onValueChange = { newPrice = it },
                    label = "Nowa cena",
                    showError = !validateNewPrice,
                    leadingIconImageVector = Icons.Rounded.MonetizationOn,
                    errorMessage = validateNewPriceMessage,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number, imeAction = ImeAction.Next
                    )
                )
            }
        }
    }
}
