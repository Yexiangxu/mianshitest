package com.lazyxu.user.data

import com.lazyxu.user.data.entity.LoginBean
import io.reactivex.Flowable

class UserUseCase(private val userRepository: UserRepository) : UserRepository {
    override fun register(username: String, password: String, repassword: String): Flowable<LoginBean> {
        return userRepository.register(username, password, repassword)
    }

    override fun login(username: String, password: String): Flowable<LoginBean> {
        return userRepository.login(username, password)
    }

}



