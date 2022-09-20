package pl.pollub.harnasik.app.presentation.AllOffersPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import pl.pollub.harnasik.R

@Composable
fun CategorySlideBar(categories: List<String> = List(10){"Category $it"}){
    LazyRow(){
        items(items = categories){ category ->
            SingleCategoryButton(name = category)
            
        }
    }
}

@Composable
fun SingleCategoryButton(name:String) {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .padding(all = 4.dp)
    ) {
        Text(text = name)
    }
}


@Composable
fun GenerateListOfAllOffersLoaded(names: List<String> = List(10) { "$it" }) {
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        items(items = names) { name ->
            GenerateBlocksWithSingleOffer(name = name)
        }
    }
}

@Composable
private fun GenerateBlocksWithSingleOffer(name: String) {

    val expanded = remember { mutableStateOf(false) }

    Surface(
        onClick = {},
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)

    ) {
        Row(modifier = Modifier.padding(24.dp)) {

            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "Offer description",
                modifier = Modifier
                    .height(75.dp)
                    .width(75.dp)
            )
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = "Oferta $name",
                    fontWeight = FontWeight.Bold
                )
                Text(text = "Opis oferty trala lala laa")

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