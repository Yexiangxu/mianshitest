package com.lazyxu.mvvmproject

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.widget.Toast
import com.alibaba.android.arouter.launcher.ARouter
import com.lazyxu.base.utils.ActivityStack
import com.lazyxu.base.utils.RouterUrl
import com.lazyxu.mvvmproject.databinding.ActivitySplashBinding
import kotlinx.android.synthetic.main.activity_splash.*

/**
 * User: xuyexiang
 * Date: 2019/06/11
 * Description:
 * FIXME
 */
class SplashActivity : AppCompatActivity() {
    lateinit var mdatabinding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mdatabinding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        tvSkip.setOnClickListener { ARouter.getInstance().build(RouterUrl.LOGIN).navigation() }

    }

    var exitTime = 0L
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {//
                // 如果两次按键时间间隔大于2000毫秒，则不退出
                Toast.makeText(this, "再按退出", Toast.LENGTH_SHORT).show()
                exitTime = System.currentTimeMillis()// 更新mExitTime
            } else {
                val startMain = Intent(Intent.ACTION_MAIN)
                startMain.addCategory(Intent.CATEGORY_HOME);
                startMain.flags = Intent.FLAG_ACTIVITY_NEW_TASK;
                startActivity(startMain)
//                ActivityStack.instance.popAllActivity(false)
            }
            return true
        }
        return super.onKeyDown(keyCode, event);
    }
}
