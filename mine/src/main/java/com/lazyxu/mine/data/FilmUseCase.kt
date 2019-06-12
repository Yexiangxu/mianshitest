package com.lazyxu.mine.data

import com.lazyxu.mine.data.entity.ComingFilmEntity
import com.lazyxu.mine.data.entity.FilmDetailEntity
import com.lazyxu.mine.data.entity.MtimeFilmeEntity
import io.reactivex.Flowable

class FilmUseCase(private val filmRepository: FilmRepository) : FilmRepository {

    override fun hotFilm(): Flowable<MtimeFilmeEntity> {
        return filmRepository.hotFilm()
    }

    override fun comingFilm(): Flowable<ComingFilmEntity> {
        return filmRepository.comingFilm()
    }

    override fun getFilmDetail(movieId: Int): Flowable<FilmDetailEntity> {
        return filmRepository.getFilmDetail(movieId)
    }

}



