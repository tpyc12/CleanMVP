package com.myhome.android.clean.di

import com.myhome.android.clean.model.data.DataModel
import com.myhome.android.clean.model.datasource.DataSource
import com.myhome.android.clean.model.datasource.RetrofitImplementation
import com.myhome.android.clean.model.datasource.RoomDataBaseImplementation
import com.myhome.android.clean.model.repository.Repository
import com.myhome.android.clean.model.repository.RepositoryImplementation
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    @Named(NAME_REMOTE)
    internal fun provideRepositoryRemote(@Named(NAME_REMOTE) dataSourceRemote: DataSource<List<DataModel>>)
            : Repository<List<DataModel>> = RepositoryImplementation(dataSourceRemote)

    @Provides
    @Singleton
    @Named(NAME_LOCAL)
    internal fun provideRepositoryLocal(@Named(NAME_LOCAL) dataSourceLocal: DataSource<List<DataModel>>)
            : Repository<List<DataModel>> = RepositoryImplementation(dataSourceLocal)

    @Provides
    @Singleton
    @Named(NAME_REMOTE)
    internal fun provideDataSourceRemote()
            : DataSource<List<DataModel>> = RetrofitImplementation()

    @Provides
    @Singleton
    @Named(NAME_LOCAL)
    internal fun provideDataSourceLocal()
            : DataSource<List<DataModel>> = RoomDataBaseImplementation()
}