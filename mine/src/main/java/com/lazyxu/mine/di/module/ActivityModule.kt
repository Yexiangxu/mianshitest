package com.lazyxu.mine.di.module


import android.app.Activity
import com.lazyxu.mine.di.scope.ActivityScope
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * User: xuyexiang
 * Date: 2019/06/12
 * Description:
 * FIXME
 */
@Module
class ActivityModule(private val mActivity: Activity) {

    @Provides
    @ActivityScope
    fun provideActivity(): Activity {
        return mActivity
    }
}
