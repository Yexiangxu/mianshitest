package com.lazyxu.mvvmproject.di.component;

import android.app.Application;

import com.lazyxu.base.di.module.AppModule;
import com.lazyxu.base.di.module.HttpModule;
import com.lazyxu.film.di.module.MineActivityModule;
import com.lazyxu.film.di.module.MineAppModule;
import com.lazyxu.mvvmproject.MainApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * User: Lazy_xu
 * Data: 2019/07/22
 * Description:
 * FIXME
 */
@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, HttpModule.class,
        MineActivityModule.class, MineAppModule.class})
public interface AppComponent {
    void inject(MainApplication mainApplication);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}


