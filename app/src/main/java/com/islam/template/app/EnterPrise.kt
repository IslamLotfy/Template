package com.islam.template.app

import com.islam.template.di.ContextModule
import com.islam.template.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class EnterPrise: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().contextModule(ContextModule(this)).application(this).build()
    }
}