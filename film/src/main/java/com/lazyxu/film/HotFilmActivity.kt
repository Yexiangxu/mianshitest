package com.lazyxu.film

import android.annotation.SuppressLint
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager

import com.alibaba.android.arouter.facade.annotation.Route
import com.lazyxu.base.arouter.RouterUrl
import com.lazyxu.base.base.BaseApplication
import com.lazyxu.film.data.FilmUseCase
import com.lazyxu.film.data.entity.MtimeFilmeEntity
import com.lazyxu.film.databinding.ActivityHotfilmBinding
import com.lazyxu.film.di.component.DaggerMineActivityComponent

import javax.inject.Inject

import io.reactivex.functions.Consumer

/**
 * User: xuyexiang
 * Date: 2019/06/13
 * Description:
 * FIXME
 */
@Route(path = RouterUrl.HOTFILM)
class HotFilmActivity : AppCompatActivity() {
    lateinit var mDatabinding: ActivityHotfilmBinding
    @Inject
    lateinit  var mineUseCase: FilmUseCase
    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDatabinding = DataBindingUtil.setContentView(this, R.layout.activity_hotfilm)
        DaggerMineActivityComponent.builder().appComponent(BaseApplication.getInstance().appComponent).build().inject(this)
        mineUseCase.hotFilm().subscribe({ mtimeFilmeEntity ->
            mDatabinding.rvHotfilm.layoutManager = LinearLayoutManager(this@HotFilmActivity)
            mDatabinding.rvHotfilm.adapter = HotFilmAdapter(R.layout.item_hotfilm, mtimeFilmeEntity.ms)
        }, { throwable ->

        })


    }
}
