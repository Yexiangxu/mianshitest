package com.lazyxu.base.utils

import android.content.res.Resources

import com.lazyxu.base.base.BaseApplication

/**
 * User: xuyexiang
 * Date: 2019/06/13
 * Description:
 * FIXME
 */
object CommonUtils {
    /**
    public static Resources getResoure() {
    return BaseApplication.getInstance().getResources();
    }

    public static float getDimens(int resId) {
    return getResoure().getDimension(resId);
    }
     */
    val resoure: Resources
        get() = BaseApplication.getInstance().resources

    fun getDimens(resId: Int): Float {
        return resoure.getDimension(resId)
    }
}
