package com.lazyxu.film;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lazyxu.base.arouter.RouterUrl;
import com.lazyxu.film.data.FilmUseCase;
import com.lazyxu.film.data.entity.MtimeFilmeEntity;
import com.lazyxu.film.databinding.ActivityHotfilmBinding;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import io.reactivex.functions.Consumer;

/**
 * User: Lazy_xu
 * Data: 2019/07/22
 * Description:
 * FIXME
 */
@Route(path = RouterUrl.HOTFILM)
public class HotFilmActivity  extends AppCompatActivity   {
    @Inject
    FilmUseCase mineUseCase;
    private ActivityHotfilmBinding mDatabinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        mDatabinding = DataBindingUtil.setContentView(this, R.layout.activity_hotfilm);
        mineUseCase.hotFilm().subscribe(mtimeFilmeEntity -> {
            mDatabinding.rvHotfilm.setLayoutManager( new LinearLayoutManager(HotFilmActivity.this));
            mDatabinding.rvHotfilm.setAdapter(new HotFilmAdapter(R.layout.item_hotfilm, mtimeFilmeEntity.getMs()));
        }, throwable -> {

        });
    }

}
