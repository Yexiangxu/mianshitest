package com.lazyxu.film.di.module


import com.lazyxu.film.HotFilmActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by amitshekhar on 14/09/17.
 */
@Module
abstract class MineActivityModule {
    @ContributesAndroidInjector
    internal abstract fun bindHotFilmActivity(): HotFilmActivity

}

