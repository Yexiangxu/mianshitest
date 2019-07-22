package com.lazyxu.mvvmproject;

import android.app.Activity;

import com.lazyxu.base.base.BaseApplication;
import com.lazyxu.base.di.module.AppModule;
import com.lazyxu.base.di.module.HttpModule;
import com.lazyxu.mvvmproject.di.component.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;


public class MainApplication extends BaseApplication implements HasActivityInjector {
    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;


    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder().appModule(new AppModule(this)).httpModule(new HttpModule()).build().inject(this);


    }


}
