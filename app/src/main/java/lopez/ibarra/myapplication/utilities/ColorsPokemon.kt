package lopez.ibarra.myapplication.utilities

import androidx.compose.ui.graphics.Color
import lopez.ibarra.myapplication.ui.theme.*

fun getColorByType(type: String): Pair<Color, Color> {
    val mainType = type.split("/").first().trim().lowercase()

    val typeColor = when (mainType) {
        "eléctrico", "electrico", "electric" -> Electric
        "planta", "grass" -> Grass
        "fuego", "fire" -> Fire
        "agua", "water" -> Water
        "normal" -> Normal
        "bicho", "bug" -> Bug
        "veneno", "poison" -> Poison
        "tierra", "ground" -> Ground
        "roca", "rock" -> Rock
        "volador", "flying" -> Flying
        "lucha", "fight" -> Fight
        "psíquico", "psiquico", "psych", "psychic" -> Psych
        "fantasma", "ghost" -> Ghost
        "dragón", "dragon" -> Dragon
        "siniestro", "dark" -> Dark
        "hielo", "ice" -> Ice
        "hada", "fairy" -> Fairy
        else -> Normal
    }

    val textColor = when (mainType) {
        "eléctrico", "electrico", "electric",
        "hada", "fairy",
        "lucha", "fight",
        "volador", "flying" -> DarkGray
        else -> OffWhite
    }

    return Pair(typeColor, textColor)
}
