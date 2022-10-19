package pl.pollub.harnasik.app.presentation.add_edit_offer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import pl.pollub.harnasik.app.presentation.add_edit_offer.components.TransparentHintTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditOfferScreen(
    navController: NavController,
    viewModel: AddEditOfferViewModel = hiltViewModel()
) {

    val scaffoldState = rememberScaffoldState()

    val titleState = viewModel.offerTitle.value
    val descriptionState = viewModel.offerDescription.value


    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
//                    viewModel.onEvent(AddEditNoteEvent.SaveNote)
                },
                Modifier.background(color = MaterialTheme.colorScheme.primary)
//                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.Save, contentDescription = "Save note")
            }
        },
        scaffoldState = scaffoldState
    ) {


        Column(
            modifier = Modifier
                .fillMaxSize()
//                .background(noteBackgroundAnimatable.value)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Add new Offer",
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
                textStyle = MaterialTheme.typography.titleLarge
            )
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
                textStyle = MaterialTheme.typography.titleLarge,
                modifier = Modifier.fillMaxHeight()
            )
        }
    }
}