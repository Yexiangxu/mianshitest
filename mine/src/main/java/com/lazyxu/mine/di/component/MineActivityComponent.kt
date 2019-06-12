package com.lazyxu.mine.di.component

import com.lazyxu.base.di.component.AppComponent
import com.lazyxu.mine.LoginActivity
import com.lazyxu.mine.di.module.ActivityModule
import com.lazyxu.mine.di.module.MineAppModule
import com.lazyxu.mine.di.scope.ActivityScope
import dagger.Component

@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [MineAppModule::class, ActivityModule::class])
interface MineActivityComponent {
    fun inject(loginActivity: LoginActivity)
}

