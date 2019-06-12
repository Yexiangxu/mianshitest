package com.lazyxu.mine

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.lazyxu.base.arouter.RouterUrl
import com.lazyxu.base.base.BaseApplication
import com.lazyxu.mine.data.FilmUseCase
import com.lazyxu.mine.databinding.ActivityLoginBinding
import com.lazyxu.mine.di.component.DaggerMineActivityComponent
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
    @Inject
    lateinit var mineUseCase: FilmUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mdatabinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        DaggerMineActivityComponent.builder().appComponent(BaseApplication.getInstance().appComponent).build().inject(this)

        mineUseCase.hotFilm().subscribe({ mtimeFilmeEntity -> }, { throwable -> })

    }
}
