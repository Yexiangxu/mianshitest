package com.lazyxu.mvvmproject.data

import com.lazyxu.mvvmproject.data.entity.ComingFilmEntity
import com.lazyxu.mvvmproject.data.entity.FilmDetailEntity
import com.lazyxu.mvvmproject.data.entity.MtimeFilmeEntity
import com.lazyxu.mvvmproject.utils.RxUtils

import javax.inject.Inject

import io.reactivex.Flowable

class FilmRepositoryImp @Inject
constructor(private val filmApiService: FilmApiService) : FilmRepository {

    override fun hotFilm(): Flowable<MtimeFilmeEntity> {
        return filmApiService.hotFilm().compose(RxUtils.rxSchedulerHelper())
    }

    override fun comingFilm(): Flowable<ComingFilmEntity> {
        return filmApiService.comingFilm().compose(RxUtils.rxSchedulerHelper())
    }

    override fun getFilmDetail(movieId: Int): Flowable<FilmDetailEntity> {
        return filmApiService.getFilmDetail(movieId).compose(RxUtils.rxSchedulerHelper())
    }
}


