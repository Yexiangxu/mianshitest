package com.lazyxu.base.base;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.facebook.stetho.Stetho;
import com.lazyxu.base.BuildConfig;
import com.lazyxu.base.di.component.AppComponent;
import com.lazyxu.base.di.component.DaggerAppComponent;
import com.lazyxu.base.di.module.AppModule;


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
        initDebug();
        ARouter.init(this); // 必须在initDebug后
    }

    /**
     * 调试
     */

    private void initDebug() {
        if (BuildConfig.DEBUG) {
            // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
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
