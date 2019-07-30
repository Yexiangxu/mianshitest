package com.lazyxu.user.data

import com.lazyxu.user.data.entity.LoginBean
import io.reactivex.Flowable
import io.reactivex.Observable

interface UserRepository {
    fun login(username: String, password: String): Flowable<LoginBean>


    fun register(username: String, password: String, repassword: String): Flowable<LoginBean>

}
