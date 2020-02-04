package com.islam.template.di

import android.app.Application
import android.content.SharedPreferences
import asia.fivejuly.securepreferences.SecurePreferences
import com.islam.template.data.Constants
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ContextModule::class])
class SharedPrefModule {

    @Singleton
    @Provides
    fun provideSharedPreferences(application: Application): SharedPreferences {
        return SecurePreferences.Builder(application)
            .password(Constants.ENCRYPT_KEY)
            .filename(Constants.PREFS_FILE)
            .build()
    }
}