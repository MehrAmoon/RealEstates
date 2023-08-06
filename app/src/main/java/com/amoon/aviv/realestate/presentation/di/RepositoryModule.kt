package com.amoon.aviv.realestate.presentation.di

import com.amoon.aviv.realestate.data.repositores.DatabaseRepositoryImpl
import com.amoon.aviv.realestate.data.repositores.NetworkRepositoryImpl
import com.amoon.aviv.realestate.domain.repositores.DatabaseRepository
import com.amoon.aviv.realestate.domain.repositores.NetworkRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindNetworkRepository(networkRepositoryImpl: NetworkRepositoryImpl): NetworkRepository

    @Binds
    abstract fun bindDatabaseRepository(databaseRepositoryImpl: DatabaseRepositoryImpl): DatabaseRepository
}