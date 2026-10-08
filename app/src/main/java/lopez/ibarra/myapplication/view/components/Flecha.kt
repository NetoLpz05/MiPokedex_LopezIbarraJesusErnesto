package lopez.ibarra.myapplication.view.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun OtherPkmn(
    posicion: String,
    imagen: Int,
    pkmnnombre: String,
    pkmnnumber: Int,
    modifier: Modifier = Modifier,
    onArrowClick: () -> Unit
) {
    val esizquierda = posicion.lowercase() == "izquierda"

    Row(
        modifier = modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 8.dp),
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
                modifier = Modifier.size(80.dp).padding(horizontal = 8.dp),
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
        modifier = Modifier
            .size(45.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Icon(
            imageVector = if (direction == "izquierda")
                Icons.AutoMirrored.Filled.ArrowBack
            else
                Icons.AutoMirrored.Filled.ArrowForward,
            contentDescription = direction,
            tint = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
private fun PokemonText(name: String, number: Int) {
    Column {
        Text(
            text = name, 
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onSurface
        )
        Text(
            text = "N.º ${String.format("%04d", number)}",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
        )
    }
}
