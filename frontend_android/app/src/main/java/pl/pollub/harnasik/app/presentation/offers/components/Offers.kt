package pl.pollub.harnasik.app.presentation.offers

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import pl.pollub.harnasik.app.util.Screen

@Composable
fun CategorySlideBar(categories: List<String> = listOf<String>("Food","Drinks","Candies","Snacks")) {
    LazyRow() {
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
            .padding(all = 4.dp)
    ) {
        Text(text = name)
    }
}

@Composable
fun GetAllOffers(state: OffersState, navController: NavController) {

    GenerateListOfAllOffersLoaded(state, navController)
}

@OptIn(ExperimentalCoilApi::class)
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
                text = "Nothing to show or connection refused",
                modifier = Modifier,
                style = MaterialTheme.typography.titleLarge
            )
        }
    } else {

        LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {

            items(state.offers) {

                val expanded = remember { mutableStateOf(false) }
                Surface(
                    onClick = {
                        navController.navigate(
                            Screen.SingleOfferScreen.route +
                                    "?offerId=${it.id}"
                        )
                    },
                    modifier = Modifier
                        .padding(vertical = 4.dp, horizontal = 8.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(24.dp)
                    ) {
                        Image(
                            contentScale = ContentScale.Crop,
                            painter = rememberImagePainter("${it.image}"),
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
                                text = "Offer ${it.title}",
                                fontWeight = FontWeight.Bold

                            )
                        }
                        Column() {
                            OutlinedButton(
                                onClick = { expanded.value = !expanded.value }
                            ) {
                                Text(if (expanded.value) "+1" else "-1")
                            }
                        }
                    }
                }
            }
        }
    }
}
