package com.islam.template.di

import com.islam.template.view.activity.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeHomeActivity(): HomeActivity

}