package com.lazyxu.mine.data

import com.lazyxu.base.utils.RxUtils
import com.lazyxu.mine.data.entity.ComingFilmEntity
import com.lazyxu.mine.data.entity.FilmDetailEntity
import com.lazyxu.mine.data.entity.MtimeFilmeEntity
import io.reactivex.Flowable
import javax.inject.Inject

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


