package com.lazyxu.mvvmproject.ui

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.lazyxu.mvvmproject.R
import com.lazyxu.mvvmproject.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

/**
 * User: xuyexiang
 * Date: 2019/06/06
 * Description:
 * FIXME
 */
class SplashActivity : AppCompatActivity() {
    lateinit var mdatabinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mdatabinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        hideButton.setOnClickListener {
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        }
    }
}
