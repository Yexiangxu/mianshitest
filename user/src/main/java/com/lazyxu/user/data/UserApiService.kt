package com.lazyxu.user.data

import com.lazyxu.user.data.entity.LoginBean
import io.reactivex.Flowable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserApiService {
    /**
     * 玩安卓登录
     *
     * @param username 用户名
     * @param password 密码
     */
    @FormUrlEncoded
    @POST("user/login")
    fun login(@Field("username") username: String, @Field("password") password: String): Flowable<LoginBean>

    /**
     * 玩安卓注册
     */
    @FormUrlEncoded
    @POST("user/register")
    fun register(@Field("username") username: String, @Field("password") password: String, @Field("repassword") repassword: String): Flowable<LoginBean>


}
