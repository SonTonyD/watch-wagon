package com.tc.gamegallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tc.gamegallery.ui.theme.GameGalleryTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GameGalleryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GameCatalogue(
                        games = listOf("Mario", "Zelda", "Metroid", "Sonic", "Pac-Man", "Elden Ring", "Starfield", "Cyberpunk 2077")
                    )
                }
            }
        }
    }
}

@Composable
fun GameCatalogue(games: List<String>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(16.dp),
        contentPadding = PaddingValues(bottom = 16.dp), // Pour ajouter un peu d'espace au bas de la liste
        horizontalArrangement = Arrangement.spacedBy(8.dp) // espace entre les cartes sur l'axe horizontal
    ) {
        items(games) { game ->
            GameCard(game)
        }
    }
}

@Composable
fun GameCard(gameName: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth(0.5f) // Prend 50% de la largeur de l'écran
            .padding(4.dp), // Petite marge pour éviter que les cartes ne se collent entre elles
        elevation = 4.dp
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .background(generateRandomColor())
            )
            Text(
                text = gameName,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
fun generateRandomColor(): Color {
    return Color(
        Random.nextFloat(),
        Random.nextFloat(),
        Random.nextFloat(),
        1f // Alpha value is 1f which means opaque
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GameGalleryTheme {
        GameCatalogue(
            games = listOf("Mario", "Zelda", "Metroid", "Sonic", "Pac-Man", "Elden Ring", "Starfield", "Cyberpunk 2077")
        )
    }
}
