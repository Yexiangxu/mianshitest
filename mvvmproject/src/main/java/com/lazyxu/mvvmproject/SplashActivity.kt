package com.lazyxu.mvvmproject

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.alibaba.android.arouter.launcher.ARouter
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
}
