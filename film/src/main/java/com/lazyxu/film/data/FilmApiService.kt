package com.lazyxu.film.data

import com.lazyxu.film.data.entity.ComingFilmEntity
import com.lazyxu.film.data.entity.FilmDetailEntity
import com.lazyxu.film.data.entity.LoginBean
import com.lazyxu.film.data.entity.MtimeFilmeEntity
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.*

interface FilmApiService {
    /**
     * 玩安卓登录
     *
     * @param username 用户名
     * @param password 密码
     */
    @FormUrlEncoded
    @POST("user/login")
    fun login(@Field("username") username: String, @Field("password") password: String): Observable<LoginBean>

    /**
     * 玩安卓注册
     */
    @FormUrlEncoded
    @POST("user/register")
    fun register(@Field("username") username: String, @Field("password") password: String, @Field("repassword") repassword: String): Observable<LoginBean>


    /**
     * 时光网热映电影
     */
    @GET("https://api-m.mtime.cn/Showtime/LocationMovies.api?locationId=561")
    fun hotFilm(): Flowable<MtimeFilmeEntity>

    /**
     * 时光网即将上映电影
     */
    @GET("https://api-m.mtime.cn/Movie/MovieComingNew.api?locationId=561")
    fun comingFilm(): Flowable<ComingFilmEntity>

    /**
     * 获取电影详情
     */
    @GET("https://api-m.mtime.cn/movie/detail.api?locationId=561")
    fun getFilmDetail(@Query("movieId") movieId: Int): Flowable<FilmDetailEntity>
}
