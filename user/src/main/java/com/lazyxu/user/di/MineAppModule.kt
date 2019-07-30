package com.lazyxu.user.di

import com.lazyxu.user.data.UserApiService
import com.lazyxu.user.data.UserRepository
import com.lazyxu.user.data.UserRepositoryImp
import com.lazyxu.user.data.UserUseCase
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class MineAppModule {
    /**
     * @return UserApiService 供FilmRepositoryImp中使用
     */
    @Singleton
    @Provides
    fun provideUserApiService(retrofit: Retrofit): UserApiService {
        return retrofit.create(UserApiService::class.java)
    }

    /**
     * @return UserRepository 供下面 provideMineUseCase 方法使用
     */
    @Singleton
    @Provides
    fun provideUserRepositoryImp(userRepositoryImp: UserRepositoryImp): UserRepository {
        return userRepositoryImp
    }

    /**
     * @return UserUseCase 供接口调用
     */
    @Singleton
    @Provides
    fun provideUserUseCase(userRepository: UserRepository): UserUseCase {
        return UserUseCase(userRepository)
    }
}


