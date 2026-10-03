package lopez.ibarra.myapplication.utilities

import androidx.compose.ui.graphics.Color
import lopez.ibarra.myapplication.ui.theme.*

fun getColorByType(type: String): Pair<Color, Color> {
    val typeColor = when (type.lowercase()) {
        "electric" -> Electric
        "grass" -> Grass
        "fire" -> Fire
        "water" -> Water
        "normal" -> Normal
        "bug" -> Bug
        "poison" -> Poison
        "ground" -> Ground
        "rock" -> Rock
        "flying" -> Flying
        "fight" -> Fight
        "psych" -> Psych
        "ghost" -> Ghost
        "dragon" -> Dragon
        "dark" -> Dark
        "ice" -> Ice
        "fairy" -> Fairy
        else -> Normal
    }

    val textColor = when (type.lowercase()) {
        "electric", "fairy", "fight", "flying" -> DarkGray
        else -> OffWhite
    }

    return Pair(typeColor, textColor)
}
