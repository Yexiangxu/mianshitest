package com.lazyxu.base.di.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * User: Lazy_xu
 * Data: 2019/07/23
 * Description:
 * FIXME
 */
@Module
public class AppModule {
    @Singleton
    @Provides
    Context provideApplication(Application application) {
        return application;
    }


}
