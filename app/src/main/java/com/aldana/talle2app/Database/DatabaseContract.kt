package com.aldana.talle2app.Database

import android.provider.BaseColumns

object DatabaseContract {

    object CoinEntry : BaseColumns { // Se guardan los datos relevantes de la tabla, como su nombre y sus campos.

        const val TABLE_NAME = "coin"

        // Se crea una constante por cada columna de la tabla.
        const val COLUMN_ID = "_id"
        const val COLUMN_NOMBRE = "nombre"
        const val COLUMN_VALUE = "value"


    }
}