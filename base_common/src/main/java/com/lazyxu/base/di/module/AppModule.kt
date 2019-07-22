package com.lazyxu.base.di.module


import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class AppModule(private val application: Application) {

    /**
     * @return Application 供 HttpModule中 provideOkHttpClient 方法使用
     */
    @Singleton
    @Provides
    open fun provideApplication() = application

//    @Singleton
//    @Provides
//    open fun provideCalligraphyConfig(): CalligraphyConfig {
//        return CalligraphyConfig.Builder()
//                .setDefaultFontPath("fonts/DroidSansFallback.ttf")
//                .setFontAttrId(R.attr.fontPath)
//                .build()
//    }


}
