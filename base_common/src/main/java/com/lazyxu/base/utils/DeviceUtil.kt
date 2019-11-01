package com.lazyxu.base.utils

import android.content.Context
import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.content.res.Resources
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.support.v4.content.pm.PackageInfoCompat
import android.util.DisplayMetrics
import android.util.Log
import android.view.WindowManager

import com.lazyxu.base.base.BaseApplication

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

object DeviceUtil {
    /**
     * 获取当前运行进程(效率最高)
     */
    val processName: String?
        get() {
            try {
                val file = File("/proc/" + android.os.Process.myPid() + "/" + "cmdline")
                val mBufferedReader = BufferedReader(FileReader(file))
                val processName = mBufferedReader.readLine().trim { it <= ' ' }
                mBufferedReader.close()
                return processName
            } catch (e: Exception) {
                e.printStackTrace()
                return null
            }

        }

    fun dp2px(resources: Resources, dpValue: Float): Int {
        val scale = resources.displayMetrics.density//BaseApplication.getInstance().getResources()
        return (dpValue * scale + 0.5f).toInt()
    }


    fun sp2px(resources: Resources, sp: Float): Float {
        val scale = resources.displayMetrics.scaledDensity
        return sp * scale
    }

    /**
     * 获取屏幕宽高
     */
    fun getDisplayMetrics(mContext: Context): DisplayMetrics {
        val wm = mContext.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val dm = DisplayMetrics()
        wm.defaultDisplay.getMetrics(dm)
        val width = dm.widthPixels         // 屏幕宽度（像素）
        val height = dm.heightPixels       // 屏幕高度（像素）
        val density = dm.density         // 屏幕密度（0.75 / 1.0 / 1.5）
        val densityDpi = dm.densityDpi     // 屏幕密度dpi（120 / 160 / 240）
        val screenWidth = (width / density).toInt()  // 屏幕宽度(dp)
        val screenHeight = (height / density).toInt()// 屏幕高度(dp)
        Log.d("device_info", "屏幕宽度（像素）：$width")
        Log.d("device_info", "屏幕高度（像素）：$height")
        Log.d("device_info", "屏幕密度（0.75 / 1.0 / 1.5）：$density")
        Log.d("device_info", "屏幕密度dpi（120 / 160 / 240）：$densityDpi")
        Log.d("device_info", "屏幕宽度（dp）：$screenWidth")
        Log.d("device_info", "屏幕高度（dp）：$screenHeight")
        return dm
    }

    fun getVersionName(context: Context): String {
        val pi: PackageInfo
        try {
            pi = context.packageManager.getPackageInfo(context.packageName, PackageManager.GET_CONFIGURATIONS)
            return pi.versionName
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return "1.0.0"
    }
    fun getVersionCode(context: Context):Long{
        var versionCode: Long=0
        try {
            val packageInfo:PackageInfo=context.applicationContext.packageManager.getPackageInfo(context.packageName,0)
            versionCode = if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.P){
                packageInfo.longVersionCode
            }else{
                packageInfo.versionCode.toLong()
            }
        } catch (e: Exception) {
        }
        return versionCode
    }




    //    public static void flushStackLocalLeaks(Looper looper) {
    //        final Handler handler = new Handler(looper);
    //        handler.post(() -> Looper.myQueue()
    //                .addIdleHandler(() -> {
    //                    handler.sendMessageDelayed(handler.obtainMessage(), 100);
    //                    return true;
    //                }));
    //    }


}
