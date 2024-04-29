package com.example.kotlinbaba.di

import android.app.Application
import com.example.kotlinbaba.data.manager.LocalUserManagerImp
import com.example.kotlinbaba.domain.manager.LocalUserManager
import com.example.kotlinbaba.domain.useCases.AppEntryUseCases
import com.example.kotlinbaba.domain.useCases.ReadAppEntry
import com.example.kotlinbaba.domain.useCases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class )
object AppModule {
    @Provides
    @Singleton
    fun providerLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImp(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        saveAppEntry = SaveAppEntry(localUserManager),
        readAppEntry = ReadAppEntry(localUserManager)
    )
}