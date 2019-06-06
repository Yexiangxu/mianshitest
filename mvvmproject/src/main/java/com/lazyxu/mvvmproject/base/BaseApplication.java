package com.lazyxu.mvvmproject.base;

import android.app.Application;

import com.lazyxu.mvvmproject.di.component.AppComponent;
import com.lazyxu.mvvmproject.di.component.DaggerAppComponent;
import com.lazyxu.mvvmproject.di.module.AppModule;


public class BaseApplication extends Application {
    private static BaseApplication MINSTATCE = null;

    private static AppComponent appComponent = null;

    public static BaseApplication getInstance() {
        return MINSTATCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        MINSTATCE = this;
    }

    public AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(MINSTATCE))
                    .build();
        }
        return appComponent;
    }
}
