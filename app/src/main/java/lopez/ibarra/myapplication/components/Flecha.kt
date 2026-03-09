package lopez.ibarra.myapplication.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OtherPkmn(posicion: String, imagen: Int, pkmnnombre: String, pkmnnumber: Int, onArrowClick: () -> Unit, modifier: Modifier = Modifier) {

    val esizquierda = posicion.lowercase() == "izquierda"

    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        if (esizquierda) {
            ArrowButton(direction = "izquierda", onClick = onArrowClick)
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.weight(1f)
        ) {

            if (!esizquierda) {
                PokemonText(pkmnnombre, pkmnnumber)
            }

            Image(
                painter = painterResource(imagen),
                contentDescription = pkmnnombre,
                modifier = Modifier.size(90.dp).padding(horizontal = 8.dp),
                contentScale = ContentScale.Fit
            )

            if (esizquierda) {
                PokemonText(pkmnnombre, pkmnnumber)
            }
        }

        if (!esizquierda) {
            ArrowButton(direction = "derecha", onClick = onArrowClick)
        }
    }
}

@Composable
private fun ArrowButton(direction: String, onClick: () -> Unit) {

    IconButton(
        onClick = onClick,
        modifier = Modifier.size(50.dp).clip(CircleShape).background(Color(0xFFE0E0E0))
    ) {
        Image(
            imageVector = if (direction == "izquierda")
                Icons.Filled.ArrowBack
            else
                Icons.Filled.ArrowForward,
            contentDescription = direction,
            modifier = Modifier.size(20.dp)
        )
    }
}

@Composable
private fun PokemonText(name: String, number: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(90.dp)
    ) {
        Text(
            text = name,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center
        )

        Text(
            text = "N.º ${String.format("%04d", number)}",
            fontSize = 12.sp
        )
    }
}