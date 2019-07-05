package com.lazyxu.film.ui.login

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.lazyxu.base.arouter.RouterUrl
import com.lazyxu.base.utils.SpUtil
import com.lazyxu.film.R
import com.lazyxu.film.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_login.*

/**
 * User: xuyexiang
 * Date: 2019/06/10
 * Description:
 * FIXME
 */
@Route(path = RouterUrl.LOGIN)
class LoginActivity : AppCompatActivity() {
    lateinit var mdatabinding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mdatabinding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        SpUtil.getInstance(this).put("pretest", "hhhh")
        btnLogin.setText(SpUtil.getInstance(this).getString("pretest", ""))

    }
}
