package com.lazyxu.base.di.component;

import android.app.Application;

import com.lazyxu.base.base.BaseApplication;
import com.lazyxu.base.di.module.AppModule;
import com.lazyxu.base.di.module.HttpModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import retrofit2.Retrofit;

/**
 * User: Lazy_xu
 * Data: 2019/07/22
 * Description:
 * FIXME
 */
@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, HttpModule.class})
public interface AppComponent {
    Application getApplication();
    Retrofit getRetrofit();
    void inject(BaseApplication baseApplication);
}
