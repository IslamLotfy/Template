package com.islam.template.repository

import com.islam.template.remotedatasource.AuthApi
import com.islam.template.remotedatasource.ServicesModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ServicesModule::class])
class RepositorySourceModule {
    @Provides
    @Singleton
    fun provideAuthRemoteRepository(
        authApi: AuthApi
    ): AuthRepository = AuthRepositoryImplementer(
        authApi
    )
}