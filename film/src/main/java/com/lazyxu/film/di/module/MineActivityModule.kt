package com.lazyxu.film.di.module


import com.lazyxu.film.HotFilmActivity
import com.lazyxu.film.di.component.BaseActivitySubComponent

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by amitshekhar on 14/09/17.
 */
@Module(subcomponents = [BaseActivitySubComponent::class])
abstract class MineActivityModule {
    @ContributesAndroidInjector(modules =[ MineActivityModule::class])
    internal abstract fun bindHotFilmActivity(): HotFilmActivity

}
