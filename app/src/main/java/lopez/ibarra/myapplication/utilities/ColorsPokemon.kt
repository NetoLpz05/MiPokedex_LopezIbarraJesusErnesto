package lopez.ibarra.myapplication.utilities

import androidx.compose.ui.graphics.Color
import lopez.ibarra.myapplication.ui.theme.*

fun getColorByType(pokemon: Pokemon): Pair<Color, Color>{
    var color: Color
    var dark = true

    when{
        pokemon.type.lowercase().contains("normal") -> color = normal_gray;
        pokemon.type.lowercase().contains("electrico") -> {
            color = electric_yellow
            dark = false
        }

        pokemon.type.lowercase().contains("agua") -> {
            color = water_blue
        }

        pokemon.type.lowercase().contains("fuego") -> color = fire_red;
        pokemon.type.lowercase().contains("hada") -> {
            color = fairy_pink
            dark = false
        }

        pokemon.type.lowercase().contains("electrico") -> {
            color = electric_yellow
            dark = false
        }

        pokemon.type.lowercase().contains("psiquico") -> color = psychic_pink;
        pokemon.type.lowercase().contains("lucha") -> {
            color = fighting_brown
            dark = false
        }

        pokemon.type.lowercase().contains("fantasma") -> color = ghost_purple;
        pokemon.type.lowercase().contains("bicho") -> color = bug_green;
        pokemon.type.lowercase().contains("veneno") -> color = poison_purple;
        pokemon.type.lowercase().contains("tierra") -> color = ground_brown;
        pokemon.type.lowercase().contains("roca") -> color = rock_brown;
        pokemon.type.lowercase().contains("dragon") -> color = dragon_purple;
        pokemon.type.lowercase().contains("planta") -> color = leaf_green;
        pokemon.type.lowercase().contains("siniestro") -> color = dark_brown;
        pokemon.type.lowercase().contains("hielo") -> color = ice_blue;
        pokemon.type.lowercase().contains("acero") -> color = steel_gray;
        pokemon.type.lowercase().contains("volador") -> {
            color = flying_blue
            dark = false
        }

        else -> color = normal_gray
    }

    return Pair(color, if (dark) OffWhite else DarkGray)
}