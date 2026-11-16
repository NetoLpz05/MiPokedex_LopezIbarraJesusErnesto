package lopez.ibarra.myapplication.sqllite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VER) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createPokemons = "CREATE TABLE ${Contract.Pokemones.TABLE_NAME} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "${Contract.Pokemones.COLUMN_NAME_NUMBER} INTEGER," +
                "${Contract.Pokemones.COLUMN_NAME_NAME} TEXT," +
                "${Contract.Pokemones.COLUMN_NAME_DESCRIPTION} TEXT," +
                "${Contract.Pokemones.COLUMN_NAME_TYPE} TEXT)".trimIndent()
        db?.execSQL(createPokemons)
    }

    override fun onUpgrade(
        db: SQLiteDatabase?,
        oldVersion: Int,
        newVersion: Int
    ) {
        val dropTablePokemons = "DROP TABLE IF EXISTS ${Contract.Pokemones.TABLE_NAME}"
        db?.execSQL(dropTablePokemons)
        onCreate(db)
    }

    companion object {
        private const val DATABASE_NAME = "pokedex.db"
        private const val DATABASE_VER = 1
    }
}
