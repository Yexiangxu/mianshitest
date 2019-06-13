package com.lazyxu.film

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.lazyxu.base.arouter.RouterUrl
import com.lazyxu.base.base.BaseApplication
import com.lazyxu.base.utils.SpUtil
import com.lazyxu.film.data.FilmUseCase
import com.lazyxu.film.databinding.ActivityLoginBinding
import com.lazyxu.film.di.component.DaggerMineActivityComponent
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

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
