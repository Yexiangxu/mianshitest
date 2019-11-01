package com.lazyxu.user.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.lazyxu.base.utils.RouterUrl
import com.lazyxu.user.R

/**
 * User:Lazy_xu
 * Data:2019/10/30
 * Description:
 * FIXME
 */
@Route(path = RouterUrl.SETTING)
class SettingActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

    }
}
