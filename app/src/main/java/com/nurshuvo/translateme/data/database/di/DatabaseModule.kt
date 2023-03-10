package com.nurshuvo.translateme.data.database.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nurshuvo.translateme.data.database.TranslationDatabase
import com.nurshuvo.translateme.data.database.dao.TranslationFavoritesDao
import com.nurshuvo.translateme.data.database.dao.TranslationHistoryDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideTranslationDatabase(@ApplicationContext appContext: Context): TranslationDatabase {
        return Room.databaseBuilder(appContext, TranslationDatabase::class.java, TranslationDatabase.DATABASE_NAME)
            .build()
    }
    @Provides
    @Singleton
    fun provideTranslationHistoryDao(translationDatabase: TranslationDatabase): TranslationHistoryDao {
        return translationDatabase.translationHistoryDao()
    }
    @Provides
    @Singleton
    fun provideTranslationFavoritesDao(translationDatabase: TranslationDatabase): TranslationFavoritesDao {
        return translationDatabase.translationFavoritesDao()
    }
}