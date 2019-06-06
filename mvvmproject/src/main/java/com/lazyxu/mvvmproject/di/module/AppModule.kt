package com.lazyxu.mvvmproject.di.module

import com.lazyxu.mvvmproject.base.BaseApplication
import com.lazyxu.mvvmproject.data.FilmRepository
import com.lazyxu.mvvmproject.data.FilmRepositoryImp
import com.lazyxu.mvvmproject.data.FilmUseCase

import javax.inject.Singleton

import dagger.Module
import dagger.Provides

@Module
class AppModule(private val application: BaseApplication) {

    /**
     * @return BaseApplication 供 HttpModule中 provideOkHttpClient 方法使用
     */
    @Singleton
    @Provides
    internal fun provideApplication(): BaseApplication {
        return application
    }

    /**
     * @return FilmRepository 供下面 provideMineUseCase 方法使用
     */
    @Singleton
    @Provides
    internal fun provideMineRepositoryImp(mineRepositoryImp: FilmRepositoryImp): FilmRepository {
        return mineRepositoryImp
    }

    /**
     * @return FilmUseCase 供接口调用
     */
    @Singleton
    @Provides
    internal fun provideMineUseCase(filmRepository: FilmRepository): FilmUseCase {
        return FilmUseCase(filmRepository)
    }
}


