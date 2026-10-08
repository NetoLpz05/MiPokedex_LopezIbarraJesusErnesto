package lopez.ibarra.myapplication.model.data

import androidx.compose.runtime.mutableStateListOf
import lopez.ibarra.myapplication.R
import lopez.ibarra.myapplication.model.domain.Pokemon

// Usamos mutableStateListOf para que la UI reaccione a los cambios en los favoritos
val pkmnList = mutableStateListOf(
    Pokemon(
        "Ogerpon", 1017, "Planta",
        "Es bromista y extremadamente curioso. A la hora de combatir, se sirve del tipo de energía que contenga la máscara que lleve puesta.",
        1.2f, 39.8f, true, "Competitivo", R.drawable.ogerpon, listOf(1017)
    ),
    Pokemon(
        "Litten", 725, "Fuego",
        "Un Pokémon gato muy orgulloso. Ataca con bolas de pelo ardiente que produce en su estómago.",
        0.4f, 4.3f, false, "Mar llamas", R.drawable.litten, listOf(725, 726, 727)
    ),
    Pokemon(
        "Torracat", 726, "Fuego",
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
        true,
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
        true,
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
        evolutions = listOf(807),
        megaEvoIds = listOf(8070)
    ),

    //MEGA ZERAORA
    Pokemon(
        "Mega Zeraora",
        8070,
        "Electrico",
        "La energía eléctrica que almacena en su cuerpo equivale a la de diez relámpagos. La electricidad se focaliza sobre todo en las protuberancias de su frente, pecho, espalda y manos.",
        1.5f,
        44.5f,
        true,
        "Sobrecarga",
        R.drawable.megazeraora,
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

    //Gengar
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
        evolutions = listOf(92, 93, 94),
        megaEvoIds = listOf(940)
    ),

    // Mega Gengar
    Pokemon(
        "Mega Gengar",
        940,
        "Fantasma/Veneno",
        "La energía de la Megaevolución ha abierto una entrada a otra dimensión en su cuerpo. Se dice que este Pokémon solo tiene interés en atacar a seres vivos.",
        1.4f,
        40.5f,
        false,
        "Sombra Trampa",
        R.drawable.megagengar,
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
        true,
        "Foco Interno",
        R.drawable.lucario,
        evolutions = listOf(447,448),
        megaEvoIds = listOf(4480, 4481)
    ),

    // Mega Lucario
    Pokemon(
        "Mega Lucario",
        4480,
        "Lucha/Acero",
        "Se concentra en su aura para prever los movimientos de sus oponentes. Su energía combativa se ha incrementado al máximo.",
        1.3f,
        57.5f,
        false,
        "Adaptable",
        R.drawable.megalucario,
        evolutions = listOf(447,448)
    ),

    //MEGA LUCARIO Z
    Pokemon(
        "Mega Lucario Z",
        4481,
        "Lucha/Acero",
        "El pelaje que le crece alrededor de la cabeza y la cintura, y su cola con forma de abanico, le permiten ocultar parcialmente sus agresivos movimientos",
        1.3f,
        49.4f,
        false,
        "Aura Protectora",
        R.drawable.lucarioz,
        evolutions = listOf(447,448)
    ),

    //Froakie
    Pokemon(
        "Froakie",
        656,
        "Agua",
        "Protege el cuerpo con una masa de burbujas muy finas. Pese a su aspecto, no pierde de vista lo que ocurre a su alrededor.",
        0.3f,
        7.0f,
        false,
        "Torrente",
        R.drawable.froakie,
        evolutions = listOf(656, 657, 658)
    ),

    //Frogadier (Evo de Froakie)
    Pokemon(
        "Frogadier",
        657,
        "Agua",
        "Su agilidad no tiene parangón. Es capaz de escalar una torre de más de 600 metros de altura en apenas un minuto.",
        0.6f,
        10.9f,
        false,
        "Torrente",
        R.drawable.frogadier,
        evolutions = listOf(656, 657, 658)
    ),

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
        evolutions = listOf(656,657,658),
        megaEvoIds = listOf(6580)
    ),

    //MEGA GRENINJA
    Pokemon(
        "Mega Greninja",
        6580,
        "Agua/Siniestro",
        "Queda suspendido de un shuriken de agua gigante creado a partir de una membrana gelatinosa que secreta su cuerpo.",
        1.5f,
        40.0f,
        false,
        "Mutatipo",
        R.drawable.megagreninja,
        evolutions = listOf(656,657,658),
    ),

    //Fennekin
    Pokemon(
        "Fennekin",
        653,
        "Fuego",
        "Mordisquea una ramita para saciarse y la usa para intimidar a sus enemigos expulsando aire caliente por las orejas.",
        0.4f,
        9.4f,
        false,
        "Mar Llamas",
        R.drawable.fennekin,
        evolutions = listOf(653, 654, 655)
    ),

    //Braixen (Evo de Fennekin)
    Pokemon(
        "Braixen",
        654,
        "Fuego",
        "Se saca una rama de la cola y la prende para combatir. Con las llamas de la rama, envía señales a sus compañeros.",
        1.0f,
        14.5f,
        true,
        "Mar Llamas",
        R.drawable.braixen,
        evolutions = listOf(653, 654, 655)
    ),

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
        evolutions = listOf(653,654,655),
        megaEvoIds = listOf(6550)
    ),

    //MEGA DELPHOX
    Pokemon(
        "Mega Delphox",
        6550,
        "Fuego/Psiquico",
        " Mega-Delphox controla las dos ramas que flotan junto a él, moviéndolas como si hubieran cobrado vida por arte de magia. Esto le permite desconcertar y confundir a sus rivales durante el combate",
        1.5f,
        39.0f,
        false,
        "Levitación",
        R.drawable.megadelphox,
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

    //Scorbunny
    Pokemon(
        "Scorbunny",
        813,
        "Fuego",
        "Desata su verdadera fuerza cuando su cuerpo entra en calor. Por eso hace ejercicios de calentamiento.",
        0.3f,
        4.5f,
        false,
        "Mar Llamas",
        R.drawable.scorbunny,
        evolutions = listOf(813,814,815)
    ),

    //Raboot
    Pokemon(
        "Raboot",
        814,
        "Fuego",
        "Su suave pelaje le permite calentar energía ígnea con mayor facilidad y así expulsar llamas todavía más potentes.",
        0.6f,
        9.0f,
        false,
        "Mar Llamas",
        R.drawable.raboot,
        evolutions = listOf(813,814,815)
    ),

    //Cincerace
    Pokemon(
        "Cinderace",
        815,
        "Fuego",
        "Un Pokémon muy competitivo que fortalece sus piernas corriendo y saltando. " +
                "Puede convertir una pequeña piedra en un balón de fuego.",
        1.4f,
        33.0f,
        true,
        "Mar Llamas",
        R.drawable.cinderace,
        evolutions = listOf(813,814,815)
    ),

    //Reshiram
    Pokemon(
        "Reshiram",
        643,
        "Dragón/Fuego",
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
    ),

    Pokemon(
        "Skitty",
        300,
        "Normal",
        "A Skitty le encanta mover cosas e ir detrás de ellas. Es de todos sabido que se dedica a ir detrás de su propia cola y que, al final, acaba mareándose",
        0.6f,
        11.0f,
        false,
        "Gran Encanto",
        R.drawable.skitty,
        evolutions = listOf(300,3001)
    ),

    Pokemon(
        "Delcatty",
        301,
        "Normal",
        "Delcatty prefiere llevar una vida independiente y hacer lo que se le antoje. Como este Pokémon come y duerme según vea en cada momento, no se puede decir que tenga unos hábitos regulares en el día a día",
        1.1f,
        32.6f,
        false,
        "Gran Encanto",
        R.drawable.delcatty,
        evolutions = listOf(300,3001)
    )
)

fun showAllPokemon(): List<Pokemon> = pkmnList

fun getPokemon(id: Int): Pokemon {
    return pkmnList.find { it.number == id } ?: pkmnList.first()
}

fun getFavoritePokemons(): List<Pokemon> {
    return pkmnList.filter { it.fav }
}

fun toggleFavorite(id: Int) {
    val index = pkmnList.indexOfFirst { it.number == id }
    if (index != -1) {
        val pkmn = pkmnList[index]
        pkmnList[index] = pkmn.copy(fav = !pkmn.fav)
    }
}
