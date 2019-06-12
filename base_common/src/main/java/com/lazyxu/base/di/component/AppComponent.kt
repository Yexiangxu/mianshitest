package com.lazyxu.base.di.component

import android.app.Application
import com.lazyxu.base.di.module.AppModule
import com.lazyxu.base.di.module.HttpModule
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class,HttpModule::class])
interface AppComponent {
    val application: Application
    val retrofit: Retrofit
}




