package com.lazyxu.film.ui

import android.annotation.SuppressLint
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.lazyxu.base.arouter.RouterUrl
import com.lazyxu.film.R
import com.lazyxu.film.data.FilmUseCase
import com.lazyxu.film.databinding.ActivityHotfilmBinding
import dagger.android.AndroidInjection
import javax.inject.Inject

/**
 * User: Lazy_xu
 * Data: 2019/07/22
 * Description:
 * FIXME
 */
@Route(path = RouterUrl.HOTFILM)
class HotFilmActivity : AppCompatActivity() {
    @Inject
    lateinit var mineUseCase: FilmUseCase
    lateinit var mDatabinding: ActivityHotfilmBinding

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        mDatabinding = DataBindingUtil.setContentView(this, R.layout.activity_hotfilm)
        mineUseCase.hotFilm().subscribe({ mtimeFilmeEntity ->
            mDatabinding.rvHotfilm.layoutManager = LinearLayoutManager(this@HotFilmActivity)
            mDatabinding.rvHotfilm.adapter = HotFilmAdapter(R.layout.item_hotfilm, mtimeFilmeEntity.ms)
        }, { throwable ->

        })
    }

}
