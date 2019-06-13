package com.lazyxu.film.di.module

import com.lazyxu.film.data.FilmApiService
import com.lazyxu.film.data.FilmRepository
import com.lazyxu.film.data.FilmRepositoryImp
import com.lazyxu.film.data.FilmUseCase
import com.lazyxu.film.di.scope.ActivityScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class MineAppModule {


    /**
     * @return FilmApiService 供FilmRepositoryImp中使用
     */
    @ActivityScope
    @Provides
    fun provideMineApiService(retrofit: Retrofit): FilmApiService {
        return retrofit.create(FilmApiService::class.java)
    }

    /**
     * @return FilmRepository 供下面 provideMineUseCase 方法使用
     */
    @ActivityScope
    @Provides
    fun provideMineRepositoryImp(mineRepositoryImp: FilmRepositoryImp): FilmRepository {
        return mineRepositoryImp
    }

    /**
     * @return FilmUseCase 供接口调用
     */
    @ActivityScope
    @Provides
    fun provideMineUseCase(filmRepository: FilmRepository): FilmUseCase {
        return FilmUseCase(filmRepository)
    }
}


