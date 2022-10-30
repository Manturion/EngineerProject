package pl.pollub.harnasik.app.presentation.add_edit_offer

import android.app.DatePickerDialog
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import pl.pollub.harnasik.app.presentation.add_edit_offer.components.TransparentHintTextField
import java.util.*

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun AddEditOfferScreen(
    navController: NavController, viewModel: AddEditOfferViewModel = hiltViewModel()
) {

    val scaffoldState = rememberScaffoldState()

    val titleState = viewModel.offerTitle.value
    val descriptionState = viewModel.offerDescription.value
    val oldPriceState = viewModel.offerOldPrice.value
    val newPriceState = viewModel.offerNewPrice.value


    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {

                },
                Modifier.background(color = MaterialTheme.colorScheme.primary),

//                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(
                    imageVector = Icons.Filled.Save,
                    contentDescription = "Dodaj ofertę"
                )
            }
        }, scaffoldState = scaffoldState
    ) {


        Column(
            modifier = Modifier
                .fillMaxSize()
//                .background(noteBackgroundAnimatable.value)
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
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

            Spacer(modifier = Modifier.height(16.dp))
            TransparentHintTextField(
                text = titleState.text,
                hint = titleState.hint,
                onValueChange = {
                    viewModel.onEvent(AddEditOfferEvent.EnteredTitle(it))
                },
                onFocusChange = {
                    viewModel.onEvent(AddEditOfferEvent.ChangeFocusTitle(it))
                },
                isHintVisible = titleState.isHintVisible,
                singleLine = true,
//                textStyle = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(16.dp))


            //dropdown categories
            val contextForToast = LocalContext.current.applicationContext

            val listItems = arrayOf("Jedzenie", "Napoje", "Słodycze", "Przekąski", "Alkohole", "Inne")

            var selectedItem by remember {
                mutableStateOf(listItems[0])
            }

            var expanded by remember {
                mutableStateOf(false)
            }
            // the box
            ExposedDropdownMenuBox(
                modifier = Modifier
                    .fillMaxWidth(),
                expanded = expanded,
                onExpandedChange = {
                    expanded = !expanded
                }) {

                // text field
                TextField(
                    value = selectedItem,
                    modifier = Modifier
                        .fillMaxWidth(),
                    onValueChange = {},
                    readOnly = true,
                    label = {
                        Text(
                            text = "Kategoria",
                            modifier = Modifier,
                            style = MaterialTheme.typography.labelSmall
                        )
                    }, trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(
                            expanded = expanded
                        )
                    }, colors = ExposedDropdownMenuDefaults.textFieldColors()
                )

                // menu
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }) {
                    listItems.forEach { selectedOption ->
                        // menu item
                        DropdownMenuItem(onClick = {
                            selectedItem = selectedOption
                            Toast.makeText(contextForToast, selectedOption, Toast.LENGTH_SHORT)
                                .show()
                            expanded = false
                        }) {
                            Text(text = selectedOption)
                        }
                    }
                }
            }
            //End of dropdown categories


            Spacer(modifier = Modifier.height(16.dp))
            TransparentHintTextField(
                text = descriptionState.text,
                hint = descriptionState.hint,
                onValueChange = {
                    viewModel.onEvent(AddEditOfferEvent.EnteredDescription(it))
                },
                onFocusChange = {
                    viewModel.onEvent(AddEditOfferEvent.ChangeFocusDescription(it))
                },
                isHintVisible = descriptionState.isHintVisible,
//                textStyle = MaterialTheme.typography.titleLarge,
                modifier = Modifier.height(256.dp)
            )

            //Calendar setup
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)
            val context = LocalContext.current
            var date by remember {
                mutableStateOf("")
            }
            val datePickerDialog = DatePickerDialog(
                context,
                { d, year, month1, day ->
                    val month = month + 1
                    date = "$day/$month/$year"
                },
                year, month, day,

                )

            Spacer(modifier = Modifier.height(16.dp))
            TransparentHintTextField(
                text = "Data ważności: $date",
                hint = "Data terminu spożycia",
                onValueChange = { },
                onFocusChange = { },
                isHintVisible = false,
//                textStyle = MaterialTheme.typography.titleLarge,
            )

            Button(
                onClick = { datePickerDialog.show() },
                colors = ButtonDefaults
                    .buttonColors(
                        backgroundColor = MaterialTheme.colorScheme.onPrimary
                    )
            ) {
                Text(text = "Wybierz datę ważności")
            }


            //Old price
            Spacer(modifier = Modifier.height(16.dp))
            TransparentHintTextField(
                text = oldPriceState.text,
                hint = oldPriceState.hint,
                onValueChange = {
                    viewModel.onEvent(AddEditOfferEvent.EnteredOldPrice(it))
                },
                onFocusChange = {
                    viewModel.onEvent(AddEditOfferEvent.ChangeFocusOldPrice(it))
                },
                isHintVisible = oldPriceState.isHintVisible,
//                textStyle = MaterialTheme.typography.titleLarge,
            )


//            New price
            Spacer(modifier = Modifier.height(16.dp))
            TransparentHintTextField(
                text = newPriceState.text,
                hint = newPriceState.hint,
                onValueChange = {
                    viewModel.onEvent(AddEditOfferEvent.EnteredNewPrice(it))
                },
                onFocusChange = {
                    viewModel.onEvent(AddEditOfferEvent.ChangeFocusNewPrice(it))
                },
                isHintVisible = newPriceState.isHintVisible,
//                textStyle = MaterialTheme.typography.titleLarge,
            )
        }
    }
}
