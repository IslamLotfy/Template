package com.islam.template.di


import android.app.Application
import com.islam.template.app.EnterPrise
import com.islam.template.repository.RepositorySourceModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ViewModelFactory::class,
        ActivityBuildersModule::class,
        CacheModule::class,
        RepositorySourceModule::class,
        SharedPrefModule::class
    ]
)
interface AppComponent : AndroidInjector<EnterPrise> {


    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun contextModule(contextModule: ContextModule): Builder

        fun build(): AppComponent
    }
}