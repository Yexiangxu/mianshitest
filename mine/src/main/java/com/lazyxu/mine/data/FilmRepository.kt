package com.lazyxu.mine.data

import com.lazyxu.mine.data.entity.ComingFilmEntity
import com.lazyxu.mine.data.entity.FilmDetailEntity
import com.lazyxu.mine.data.entity.MtimeFilmeEntity
import io.reactivex.Flowable

interface FilmRepository {
    fun hotFilm(): Flowable<MtimeFilmeEntity>

    fun comingFilm(): Flowable<ComingFilmEntity>

    fun getFilmDetail(movieId: Int): Flowable<FilmDetailEntity>
}
