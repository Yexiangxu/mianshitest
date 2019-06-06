package com.lazyxu.mvvmproject.di.module

import android.util.Log

import com.lazyxu.mvvmproject.BuildConfig
import com.lazyxu.mvvmproject.base.BaseApplication
import com.lazyxu.mvvmproject.data.Config
import com.lazyxu.mvvmproject.data.FilmApiService
import com.lazyxu.mvvmproject.utils.LogUtil

import java.util.concurrent.TimeUnit

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author xuyexiang
 */
@Module
class HttpModule {
    /**
     * @return HttpLoggingInterceptor 供下面 provideOkHttpClient 方法使用
     */
    @Singleton
    @Provides
    internal fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        //log查看网络请求（请求参数、返回结果、网络请求时长等信息）
        return HttpLoggingInterceptor { message -> Log.d(LogUtil.HTTPLOG, message) }.setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE)
    }

    /**
     * @return OkHttpClient 供下面 provideRetrofit 方法使用
     */
    @Singleton
    @Provides
    internal fun provideOkHttpClient(application: BaseApplication, httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .cache(Cache(application.cacheDir, (1024 * 1024 * 50).toLong()))
                .connectTimeout(120, TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .addNetworkInterceptor(httpLoggingInterceptor).build()
    }

    /**
     * @return Retrofit 供下面 provideMineApiService 方法使用
     */
    @Singleton
    @Provides
    internal fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(Config.HOST)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
    }

    /**
     * @return FilmApiService 供FilmRepositoryImp中使用
     */
    @Singleton
    @Provides
    internal fun provideMineApiService(retrofit: Retrofit): FilmApiService {
        return retrofit.create(FilmApiService::class.java)
    }
}


