package lopez.ibarra.myapplication.dummies

import lopez.ibarra.composePokedex.R
import lopez.ibarra.myapplication.utilities.Pokemon

val pkmnList = listOf(
    //Ogerpon (Legendario, no tiene evo)
    Pokemon(
    "Ogerpon",
    1017,
    "Planta",
    "Es bromista y extremadamente curioso. A la hora de combatir, " +
            "se sirve del tipo de energía que contenga la máscara que lleve puesta.",
    1.2f,
    39.8f,
    true,
    "Competitivo",
    R.drawable.ogerpon,
        evolutions = listOf(1017)
    ),

    //Litten
    Pokemon(
        "Litten",
        725,
        "Fuego",
        "Un Pokémon gato muy orgulloso. Ataca con bolas de pelo ardiente que produce en su estómago.",
        0.4f,
        4.3f,
        false,
        "Mar llamas",
        R.drawable.litten,
        evolutions = listOf(725, 726, 727)
    ),

    //Torracat (Evo de Litten)
    Pokemon(
        "Torracat",
        726,
        "Fuego",
        "Posee un cascabel de fuego en el cuello que tintinea y desprende llamas cuando se prepara para atacar.",
        0.7f,
        25.0f,
        false,
        "Mar llamas",
        R.drawable.torracat,
        evolutions = listOf(725, 726, 727)
    ),

    //Incineroar (Evo de Torracat)
    Pokemon(
        "Incineroar",
        727,
        "Fuego / Siniestro",
        "Su espíritu luchador aumenta cuando el público se entusiasma. Expulsa llamaradas por su ombligo.",
        1.8f,
        83.0f,
        false,
        "Mar llamas",
        R.drawable.incineroar,
        evolutions = listOf(725, 726, 727)
    ),

    //Rockruff
    Pokemon(
        "Rockruff",
        744,
        "Roca",
        "Es sociable y valiente. A medida que crece, se vuelve más independiente.",
        0.5f,
        9.2f,
        false,
        "Vista Lince",
        R.drawable.rockruff,
        evolutions = listOf(744, 745)
    ),

    //Lycanroc (Evo de Rockruff)
    Pokemon(
        "Lycanroc",
        745,
        "Roca",
        "Forma diurna: Un Pokémon tranquilo y con nervios de acero. Se acerca rápidamente a sus presas y las hace trizas con su melena de piedra.\n" +
                "Forma nocturna: No le importa sufrir heridas si eso le permite abatir a su oponente.\n" +
                "Forma crepuscular: Un Pokémon tranquilo y agresivo por igual. Dicen que los que presentan esta forma son los más difíciles de criar.\n",
        0.8f,
        25f,
        false,
        "Garra dura",
        R.drawable.lycanroc,
        evolutions = listOf(744, 745)
    ),

    //Zeraora (Legendario, no tiene evo)
    Pokemon(
        "Zeraora",
        807,
        "Electrico",
        "Se mueve a la velocidad del rayo y desata descargas eléctricas devastadoras.",
        1.5f,
        44.5f,
        true,
        "Absorbe Electricidad",
        R.drawable.zeraora,
        evolutions = listOf(807)
    ),

    //Gastly
    Pokemon(
        "Gastly",
        92,
        "Fantasma/Veneno",
        "Utiliza su lengua gaseosa para absorberles la vida a sus víctimas. Acecha a sus presas en la oscuridad.",
        1.3f,
        0.1f,
        false,
        "Levitación",
        R.drawable.gastly,
        evolutions = listOf(92, 93, 94)
    ),

    //Haunter (Evo de Gastly)
    Pokemon(
        "Haunter",
        93,
        "Fantasma/Veneno",
        "Utiliza su lengua gaseosa para absorberles la vida a sus víctimas. Acecha a sus presas en la oscuridad.",
        1.6f,
        0.1f,
        false,
        "Levitación",
        R.drawable.haunter,
        evolutions = listOf(92, 93, 94)
    ),

    //Gengar (Evo de Haunter)
    Pokemon(
        "Gengar",
        94,
        "Fantasma/Veneno",
        "Se esconde en las sombras y absorbe el calor corporal de sus víctimas.",
        1.5f,
        40.5f,
        false,
        "Cuerpo Maldito",
        R.drawable.gengar,
        evolutions = listOf(92, 93, 94)
    ),

    //Riolu
    Pokemon(
        "Riolu",
        447,
        "Lucha",
        "Tiene un poder peculiar: puede ver emociones como el odio y la alegría en forma de ondas.",
        1.2f,
        54.0f,
        false,
        "Foco Interno",
        R.drawable.riolu,
        evolutions = listOf(447,448)
    ),

    //Lucario (Evo de Riolu)
    Pokemon(
        "Lucario",
        448,
        "Lucha/Acero",
        "Puede detectar y manipular el aura. Es leal y extremadamente fuerte.",
        1.2f,
        54.0f,
        false,
        "Foco Interno",
        R.drawable.lucario,
        evolutions = listOf(447,448)
    ),

    //Froakie

    //Frogadier (Evo de Froakie)

    //Greninja (Evo de Frogadier)
    Pokemon(
        "Greninja",
        658,
        "Agua/Siniestro",
        "Se mueve como un ninja y derrota a sus rivales antes de que puedan reaccionar.",
        1.5f,
        40.0f,
        false,
        "Torrente",
        R.drawable.greninja,
        evolutions = listOf(656,657,658)
    ),

    //Fennekin

    //Braixen (Evo de Fennekin)

    //Delphox (Evo de Braixen)
    Pokemon(
        "Delphox",
        655,
        "Fuego/Psiquico",
        "Utiliza la rama que sostiene para enfocar su poder psíquico y lanzar llamas.",
        1.5f,
        39.0f,
        false,
        "Mar llamas",
        R.drawable.delphox,
        evolutions = listOf(653,654,655)
    ),

    //Mimikyu
    Pokemon(
        "Mimikyu",
        778,
        "Fantasma/Hada",
        "Se oculta bajo un disfraz para hacerse pasar por Pikachu y así ganar amigos.",
        0.2f,
        0.7f,
        false,
        "Disfraz",
        R.drawable.mimikyu,
        evolutions = listOf(778)
    ),

    //Cincerace
    Pokemon(
        "Cinderace",
        815,
        "Fuego",
        "Un Pokémon muy competitivo que fortalece sus piernas corriendo y saltando. " +
                "Puede convertir una pequeña piedra en un balón de fuego.",
        33.0f,
        1.4f,
        false,
        "Mar Llamas",
        R.drawable.cinderace,
        evolutions = listOf(813,814,815)
    ),

    //Reshiram
    Pokemon(
        "Reshiram",
        643,
        "Dragon",
        "Pokémon omnipresente en leyendas. Hace brotar llamas de su cola y consume todo lo que se le pone por delante.",
        3.2f,
        330.0f,
        false,
        "Turbollama",
        R.drawable.reshiram,
        evolutions = listOf(643)
    ),

    Pokemon(
        "Vaporeon",
        134,
        "Agua",
        "La composición celular de su cuerpo es tan similar a la estructura molecular del agua que se vuelve invisible al fundirse en ella.",
        1.0f,
        29.0f,
        false,
        "Absorbe Agua",
        R.drawable.vaporeon,
        evolutions = listOf(133,134)
    )
)
fun showAllPokemon(): List<Pokemon> {
    return pkmnList
}

fun getOnePokemon(): Pokemon{
    return pkmnList.get((0..9).random())
}

fun getPokemon(id:Int): Pokemon{
    return pkmnList.filter { pokemon -> pokemon.number == id }.get(0)
}