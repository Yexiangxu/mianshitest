package com.lazyxu.mvvmproject.di.component

import com.lazyxu.mvvmproject.data.FilmUseCase
import com.lazyxu.mvvmproject.di.module.AppModule
import com.lazyxu.mvvmproject.di.module.HttpModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, HttpModule::class])
interface AppComponent {
    fun mineUseCase(): FilmUseCase

}




