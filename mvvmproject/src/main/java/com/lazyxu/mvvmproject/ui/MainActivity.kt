package com.lazyxu.mvvmproject.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.lazyxu.mvvmproject.R
import com.lazyxu.mvvmproject.base.BaseApplication
import com.lazyxu.mvvmproject.data.FilmUseCase
import com.lazyxu.mvvmproject.di.component.DaggerActivityComponent
import com.lazyxu.mvvmproject.utils.LogUtil
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

/**
 * User: xuyexiang
 * Date: 2019/06/06
 * Description:
 * FIXME
 */
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var mineUseCase: FilmUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerActivityComponent.builder().appComponent(BaseApplication.getInstance().appComponent).build().inject(this)
        mineUseCase!!.hotFilm().subscribe({ mtimeFilmeEntity -> }, { throwable -> })
        Log.d(LogUtil.TEST_DAGGER, "FilmUseCase地址=" + mineUseCase!!)
//        Log.d(LogUtil.TEST_DAGGER, "FilmUseCase地址=" + mineUseCaseTest!!)
        hideButton.text = "FilmUseCase地址=" + mineUseCase;
    }
}

