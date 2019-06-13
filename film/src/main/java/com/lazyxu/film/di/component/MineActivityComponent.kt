package com.lazyxu.film.di.component

import com.lazyxu.base.di.component.AppComponent
import com.lazyxu.film.HotFilmActivity
import com.lazyxu.film.LoginActivity
import com.lazyxu.film.data.FilmUseCase
import com.lazyxu.film.di.module.ActivityModule
import com.lazyxu.film.di.module.MineAppModule
import com.lazyxu.film.di.scope.ActivityScope
import dagger.Component

@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [MineAppModule::class, ActivityModule::class])
interface MineActivityComponent {
    fun inject(hotFilmActivity: HotFilmActivity)
}

