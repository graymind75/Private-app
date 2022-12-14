package com.benyaamin.privateapp.di

import android.content.Context
import androidx.room.Room
import com.benyaamin.privateapp.persistence.AppDatabase
import com.benyaamin.privateapp.persistence.NoteDao
import com.benyaamin.privateapp.persistence.PasswordDao
import com.benyaamin.privateapp.persistence.TodoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room
            .databaseBuilder(context, AppDatabase::class.java, "private_db")
            .build()
    }

    @Provides
    @Singleton
    fun providePasswordDao(appDatabase: AppDatabase): PasswordDao {
        return appDatabase.passwordDao()
    }

    @Provides
    @Singleton
    fun provideNoteDao(appDatabase: AppDatabase): NoteDao {
        return appDatabase.noteDao()
    }

    @Provides
    @Singleton
    fun provideTodoDao(appDatabase: AppDatabase): TodoDao {
        return appDatabase.todoDao()
    }

}