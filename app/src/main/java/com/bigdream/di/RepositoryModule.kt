package com.bigdream.di

import com.bigdream.data.repository.AuthRepositoryImpl
import com.bigdream.data.repository.PostRepositoryImpl
import com.bigdream.data.repository.UserRepositoryImpl
import com.bigdream.domain.repository.AuthRepository
import com.bigdream.domain.repository.PostRepository
import com.bigdream.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAuthRepository(impl: AuthRepositoryImpl): AuthRepository

    @Binds
    @Singleton
    abstract fun bindPostRepository(impl: PostRepositoryImpl): PostRepository

    @Binds
    @Singleton
    abstract fun bindUserRepository(impl: UserRepositoryImpl): UserRepository
}
