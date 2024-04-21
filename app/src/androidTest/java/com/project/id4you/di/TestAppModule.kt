package com.project.id4you.di

import com.project.id4you.data.remote.PocketBaseApi
import com.project.id4you.data.repository.impl.DocumentRepositoryImpl
import com.project.id4you.data.repository.impl.UserRepositoryImpl
import com.project.id4you.domain.repository.DocumentRepository
import com.project.id4you.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mocks.MockPocketBaseApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TestAppModule {
    @Provides
    @Singleton
    fun providePocketBaseApi(): PocketBaseApi {
        return MockPocketBaseApi()
    }

    @Provides
    @Singleton
    fun provideUserRepository(api: PocketBaseApi): UserRepository {
        return UserRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideIdCardRepository(api: PocketBaseApi): DocumentRepository {
        return DocumentRepositoryImpl(api)
    }
}
