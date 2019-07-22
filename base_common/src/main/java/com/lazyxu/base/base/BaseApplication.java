package com.lazyxu.base.base;

import android.app.Activity;
import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.facebook.stetho.Stetho;
import com.lazyxu.base.BuildConfig;
import com.lazyxu.base.R;
import com.lazyxu.base.di.component.DaggerAppComponent;
import com.lazyxu.base.di.module.AppModule;
import com.lazyxu.base.di.module.HttpModule;
import com.lazyxu.base.utils.ScreenAdapterUtil;
import com.squareup.leakcanary.LeakCanary;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;


public class BaseApplication extends Application implements HasActivityInjector {
    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;
    private static BaseApplication MINSTATCE = null;


    public static BaseApplication getInstance() {
        return MINSTATCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder().appModule(new AppModule(this)).httpModule(new HttpModule()).build().inject(this);

        MINSTATCE = this;
        //今日头条屏幕适配（宽高不能同时适配，这里只做了宽度竖屏适配，如果有横竖屏切换还需处理）
        ScreenAdapterUtil.setDensity(this, 360);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/DroidSansFallback.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());
        initDebug();
        ARouter.init(this);

    }

    private void initDebug() {
        if (BuildConfig.DEBUG) {
            // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();
            ARouter.openDebug();
            Stetho.initializeWithDefaults(this);
            if (LeakCanary.isInAnalyzerProcess(this)) {
                return;
            }
            LeakCanary.install(this);
        }
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
