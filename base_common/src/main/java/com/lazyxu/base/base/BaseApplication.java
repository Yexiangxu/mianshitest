package com.lazyxu.base.base;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.facebook.stetho.Stetho;
import com.lazyxu.base.BuildConfig;
import com.lazyxu.base.di.component.AppComponent;
import com.lazyxu.base.di.component.DaggerAppComponent;
import com.lazyxu.base.di.module.AppModule;
import com.lazyxu.base.utils.ScreenAdapterUtil;
import com.squareup.leakcanary.LeakCanary;


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
        //今日头条屏幕适配（宽高不能同时适配，这里只做了宽度竖屏适配，如果有横竖屏切换还需处理）
        ScreenAdapterUtil.setDensity(this, 360);
        initDebug();
        ARouter.init(this);
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }

    private void initDebug() {
        if (BuildConfig.DEBUG) {
            // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();
            ARouter.openDebug();
            Stetho.initializeWithDefaults(this);
        }
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
