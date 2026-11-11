package lopez.ibarra.myapplication.sqllite

import android.provider.BaseColumns

object Contract {
    object Pokemones : BaseColumns {
        const val TABLE_NAME = "pokemones"
        const val COLUMN_NAME_NUMBER = "number"
        const val COLUMN_NAME_NAME = "name"
        const val COLUMN_NAME_TYPE = "type"
        const val COLUMN_NAME_DESCRIPTION = "description"
        const val COLUMN_NAME_ABILITY = "ability"
//        const val COLUMN_NAME_HEIGHT = "height"
//        const val COLUMN_NAME_WEIGHT = "weight"
//        const val COLUMN_NAME_IMAGE = "image"
//        const val COLUMN_NAME_FAVORITE = "is_favorite"
    }
}