package com.lazyxu.base.utils

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.res.Resources
import android.text.TextUtils

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

    fun copy(content: String) {
        if (!TextUtils.isEmpty(content)) {
            val clipboard = BaseApplication.getInstance().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText(content, content)
            clipboard.primaryClip = clip
        }
    }
}
