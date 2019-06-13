package com.lazyxu.film.di.module


import android.app.Activity
import com.lazyxu.film.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

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
