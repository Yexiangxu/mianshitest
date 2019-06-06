package com.lazyxu.mvvmproject.di.component

import com.lazyxu.mvvmproject.di.module.ActivityModule
import com.lazyxu.mvvmproject.di.scope.ActivityScope
import com.lazyxu.mvvmproject.ui.MainActivity

import dagger.Component

@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)

}

