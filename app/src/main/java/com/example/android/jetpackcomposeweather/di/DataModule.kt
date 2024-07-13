package com.example.android.jetpackcomposeweather.di

import android.content.Context
import com.example.android.jetpackcomposeweather.datastore.StoreFavoriteCity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Singleton
    @Provides
    fun provideDataStore(@ApplicationContext context: Context) = StoreFavoriteCity(context)
}