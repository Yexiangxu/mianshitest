package com.lazyxu.mvvmproject.di.component;

import com.lazyxu.base.di.module.AppModule;
import com.lazyxu.base.di.module.HttpModule;
import com.lazyxu.film.di.module.MineActivityModule;
import com.lazyxu.film.di.module.MineAppModule;
import com.lazyxu.mvvmproject.MainApplication;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

/**
 * User: Lazy_xu
 * Data: 2019/07/22
 * Description:
 * FIXME
 */
@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, HttpModule.class,
        MineActivityModule.class, MineAppModule.class})
public interface AppComponent extends AndroidInjector<MainApplication> {
    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<MainApplication> {
    }
}
