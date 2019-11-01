package com.lazyxu.base.utils

import android.content.Context
import android.support.annotation.StringRes
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast

import com.lazyxu.base.R
import com.lazyxu.base.base.BaseApplication

object AppToast {
    private var oneTime: Long = 0
    private var twoTime: Long = 0
    private var oldMsg = ""
    private var toast: Toast? = null

    fun show(message: String) {
        val context = BaseApplication.getInstance().applicationContext
        if (toast == null) {
            toast = Toast(context)
        }
        getToastView(context, message)
        twoTime = System.currentTimeMillis()
        if (message == oldMsg) {
            if (twoTime - oneTime > Toast.LENGTH_SHORT) {
                toast!!.show()
            }
        } else {
            oldMsg = message
            toast!!.show()
        }
        oneTime = twoTime
    }

    private fun getToastView(context: Context, message: String) {
        val view = LayoutInflater.from(context).inflate(R.layout.toast_main, null)
        val textView = view.findViewById<TextView>(R.id.tv_toast)
        textView.gravity = Gravity.CENTER
        toast!!.view = view
        toast!!.setGravity(Gravity.CENTER, 0, 0)
        toast!!.duration = Toast.LENGTH_SHORT
        textView.text = message
    }

    fun show(@StringRes message: Int) {
        show(BaseApplication.getInstance().applicationContext.getString(message))
    }
}
