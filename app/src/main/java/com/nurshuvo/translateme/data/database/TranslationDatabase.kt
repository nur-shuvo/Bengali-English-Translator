package com.nurshuvo.translateme.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nurshuvo.translateme.data.database.dao.TranslationFavoritesDao
import com.nurshuvo.translateme.data.database.dao.TranslationHistoryDao
import com.nurshuvo.translateme.data.database.entity.TranslationFavorites
import com.nurshuvo.translateme.data.database.entity.TranslationHistory

// Annotates class to be a Room Database with a table (entity) of the TranslationHistory class
@Database(entities = [TranslationHistory::class, TranslationFavorites::class], version = 1, exportSchema = false)
abstract class TranslationDatabase : RoomDatabase() {

    abstract fun translationHistoryDao(): TranslationHistoryDao
    abstract fun translationFavoritesDao(): TranslationFavoritesDao

    companion object {
        const val DATABASE_NAME = "word_database"
    }
}
