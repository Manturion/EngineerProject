package pl.pollub.harnasik.app.presentation.offers

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import pl.pollub.harnasik.app.presentation.offers.query.OffersState
import pl.pollub.harnasik.app.util.Screen

@Composable
fun CategorySlideBar(
    categories: List<String> = listOf<String>(
        "Jedzenie",
        "Napoje",
        "Słodycze",
        "Przekąski",
        "Alkohole",
        "Inne"
    )
) {
    LazyRow {
        items(items = categories) { category ->
            SingleCategoryButton(name = category)
        }
    }
}

@Composable
fun SingleCategoryButton(name: String) {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .padding(all = 2.dp)
    ) {
        Text(text = name)
    }
}

@Composable
fun GetAllOffers(state: OffersState, navController: NavController) {
    GenerateListOfAllOffersLoaded(state, navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GenerateListOfAllOffersLoaded(
    state: OffersState,
    navController: NavController
) {
    if (state.offers == null) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Brak ofert lub błąd połączenia",
                modifier = Modifier,
                style = MaterialTheme.typography.titleLarge
            )
        }
    } else {
        LazyColumn {
            items(state.offers) {
                val expanded = remember { mutableStateOf(false) }

                Surface(
                    tonalElevation = 3.dp,
                    shape = RoundedCornerShape(16.dp),
                    color = MaterialTheme.colorScheme.surface,
                    onClick = {
                        navController.navigate(
                            Screen.SingleOfferScreen.route +
                                    "?offerId=${it.id}"
                        )
                    },
                    modifier = Modifier
                        .padding(vertical = 4.dp, horizontal = 8.dp),
                ) {
                    Row(
                        modifier = Modifier
                            .padding(
                                start = 16.dp,
                                top = 16.dp,
                                end = 4.dp,
                                bottom = 16.dp
                            )
                    ) {
                        Image(
                            contentScale = ContentScale.Crop,
                            painter = rememberAsyncImagePainter(it.image),
                            contentDescription = it.image,
                            modifier = Modifier
                                .height(75.dp)
                                .width(75.dp)
                        )
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(4.dp)
                        ) {
                            Text(
                                text = it.title,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Column {
                            OutlinedButton(
                                onClick = { expanded.value = !expanded.value },
                            ) {
                                Text(if (expanded.value) "+15" else "+${15 - 1}")
                            }
                        }
                    }
                }
            }
        }
    }
}
