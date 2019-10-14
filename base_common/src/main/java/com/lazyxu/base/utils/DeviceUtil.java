package com.lazyxu.base.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;

import com.lazyxu.base.base.BaseApplication;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

public class DeviceUtil {

    /**
     * 获取当前运行进程
     */


    /**
     * 获取当前运行进程(效率最高)
     */
    public static String getProcessName() {
        try {
            File file = new File("/proc/" + android.os.Process.myPid() + "/" + "cmdline");
            BufferedReader mBufferedReader = new BufferedReader(new FileReader(file));
            String processName = mBufferedReader.readLine().trim();
            mBufferedReader.close();
            return processName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(float dpValue) {
        final float scale = BaseApplication.getInstance().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(float pxValue) {
        final float scale = BaseApplication.getInstance().getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 sp
     */
    public static int px2sp(float pxValue) {
        float fontScale = BaseApplication.getInstance().getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 sp 的单位 转成为 px
     */
    public static int sp2px(float spValue) {
        float fontScale = BaseApplication.getInstance().getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * 获取屏幕密度
     */
    public static float getDensity() {
        DisplayMetrics dm = BaseApplication.getInstance().getResources().getDisplayMetrics();
        return dm.density;
    }

    /**
     * 获取屏幕宽度
     */
    public static int getScreenW() {
        DisplayMetrics dm = new DisplayMetrics();
        dm = BaseApplication.getInstance().getResources().getDisplayMetrics();
        int w = dm.widthPixels;
        return w;
    }

    /**
     * 获取屏幕高度
     */
    public static int getScreenH() {
        DisplayMetrics dm = new DisplayMetrics();
        dm = BaseApplication.getInstance().getResources().getDisplayMetrics();
        int h = dm.heightPixels;
        return h;
    }

    /**
     * 小米mix3检查是否存在 NavigationBar
     * 原理是拿到 横屏时候的允许宽度与 内屏的真实高度进行对比来推算是否存在NavigationBar
     */
    public static boolean isNavigationBarShow(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point outSmallestSize = new Point();
        Point outLargestSize = new Point();
        display.getCurrentSizeRange(outSmallestSize, outLargestSize);
        display.getRealSize(outSmallestSize);
        return outSmallestSize.y != outLargestSize.x;
    }

    public static int getNavigationBarHeight() {
        Resources resources = BaseApplication.getInstance().getResources();
        int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        int height = resources.getDimensionPixelSize(resourceId);
        return height;
    }

    public static int getNavigationBarHeight(@NotNull Activity activity) {
        if (!isNavigationBarShow(activity)) {
            return 0;
        }
        Resources resources = BaseApplication.getInstance().getResources();
        int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        return resources.getDimensionPixelSize(resourceId);
    }

    public static int getStatusHeight() {
        Resources resources = BaseApplication.getInstance().getResources();
        int statusHeight = -1;
        //获取status_bar_height资源的ID
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            //根据资源ID获取响应的尺寸值
            statusHeight = resources.getDimensionPixelSize(resourceId);
        }
        return statusHeight;
    }

    public void restartApp() {
        final Intent intent = BaseApplication.getInstance().getPackageManager().getLaunchIntentForPackage(BaseApplication.getInstance().getPackageName());
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        BaseApplication.getInstance().startActivity(intent);
    }

    public static void flushStackLocalLeaks(Looper looper) {
        final Handler handler = new Handler(looper);
        handler.post(() -> Looper.myQueue()
                .addIdleHandler(() -> {
                    handler.sendMessageDelayed(handler.obtainMessage(), 100);
                    return true;
                }));
    }


}
