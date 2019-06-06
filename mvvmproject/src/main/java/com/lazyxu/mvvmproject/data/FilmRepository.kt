package com.lazyxu.mvvmproject.data

import com.lazyxu.mvvmproject.data.entity.ComingFilmEntity
import com.lazyxu.mvvmproject.data.entity.FilmDetailEntity
import com.lazyxu.mvvmproject.data.entity.MtimeFilmeEntity

import io.reactivex.Flowable

interface FilmRepository {
    fun hotFilm(): Flowable<MtimeFilmeEntity>

    fun comingFilm(): Flowable<ComingFilmEntity>

    fun getFilmDetail(movieId: Int): Flowable<FilmDetailEntity>
}
