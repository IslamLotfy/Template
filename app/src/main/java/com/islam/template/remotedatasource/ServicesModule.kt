package com.islam.template.remotedatasource

import com.islam.template.di.RetrofitModule
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [RetrofitModule::class])
class ServicesModule {
    @Provides
    @Singleton
    fun provideAccountApi(retrofit: Retrofit) = retrofit.create(AuthApi::class.java)
}