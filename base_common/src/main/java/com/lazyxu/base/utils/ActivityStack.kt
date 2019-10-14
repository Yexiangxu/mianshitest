package com.lazyxu.base.utils

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import java.util.*

/**
 * User:Lazy_xu
 * Data:2019/10/10
 * Description: kotlin的静态内部类方式的单例模式
 * FIXME
 */
class ActivityStack private constructor() {
    //stack栈，先进后出
    private var mActivities = Stack<Activity>()

    companion object {
        fun getInstance(): ActivityStack {
            return Holder.INSTANCE
        }
    }

    private object Holder {
        val INSTANCE = ActivityStack()
    }

    fun addActivity(activity: Activity) {
        this.mActivities.add(activity)
    }

    fun removeActivity(activity: Activity?) {
        if (!this.mActivities.isEmpty() && this.mActivities.contains(activity)) {
            //hideSoftKeyBoard(activity);
            this.mActivities.remove(activity)
            activity?.finish()
        }
    }

    private fun hideSoftKeyBoard(activity: Activity) {
        val localView = activity.currentFocus
        val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        if (localView != null && imm != null) {
            imm.hideSoftInputFromWindow(localView.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }


    //    public void removeAllActivity() {
    //        if (this.mActivities != null && !this.mActivities.isEmpty()) {
    //            for (Activity activity : mActivities) {
    ////            hideSoftKeyBoard(activity);
    //                activity.finish();
    //            }
    //            mActivities.clear();
    //        }
    //    }
    //
    //
    //
    //
    //
    //
    //    public void popActivity() {
    //        if (this.mActivities != null && !this.mActivities.isEmpty()) {
    //            Activity activity = (Activity) this.mActivities.pop();
    //            if (activity != null) {
    //                activity.finish();
    //                activity = null;
    //            }
    //        }
    //
    //    }
    //    public Activity topActivity() {
    //        return this.mActivities.empty() ? null : (Activity) this.mActivities.lastElement();
    //    }
    //
    //
    //    public void popAllActivity(boolean isForceClose) {
    //        while (this.mActivities.size() > 0) {
    //            this.popActivity();
    //        }
    //
    //        if (isForceClose) {
    //            Process.killProcess(Process.myPid());
    //            System.exit(-1);
    //        }
    //
    //    }
    //
    //    public void popAllActivityExceptTop() {
    //        while (this.mActivities.size() > 1) {
    //            Activity activity = (Activity) this.mActivities.get(0);
    //            this.mActivities.remove(activity);
    //            if (activity != null) {
    //                activity.finish();
    //                activity = null;
    //            }
    //        }
    //
    //    }
    //
    //    public void reStartApp(Context mContext, Class<?> className) {
    //        Intent intent = new Intent(mContext, className);
    //        intent.addFlags(335544320);
    //        mContext.startActivity(intent);
    //        Process.killProcess(Process.myPid());
    //    }
    //
    //    public void popActivityUntilCls(Class<?> clz) {
    //        while (this.mActivities.size() > 1 && this.topActivity().getClass() != clz) {
    //            this.popActivity();
    //        }
    //
    //    }
    //
    //    public void popAllActivityExceptBottom() {
    //        int size = this.mActivities.size();
    //
    //        for (int i = size - 1; i >= 1; --i) {
    //            Activity activity = (Activity) this.mActivities.get(i);
    //            this.mActivities.remove(activity);
    //            if (activity != null) {
    //                activity.finish();
    //            }
    //        }
    //
    //    }
    //
    //    public int size() {
    //        return this.mActivities.size();
    //    }
    //
    //    public Activity activityAt(int position) {
    //        return position < this.mActivities.size() ? (Activity) this.mActivities.elementAt(position) : null;
    //    }
}
