package com.myhome.android.clean.di

import com.myhome.android.clean.model.data.DataModel
import com.myhome.android.clean.model.datasource.RetrofitImplementation
import com.myhome.android.clean.model.datasource.RoomDataBaseImplementation
import com.myhome.android.clean.model.repository.Repository
import com.myhome.android.clean.model.repository.RepositoryImplementation
import com.myhome.android.clean.view.main.MainInteractor
import com.myhome.android.clean.view.main.MainViewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val application = module {
    single<Repository<List<DataModel>>>(named(NAME_REMOTE)) {
        RepositoryImplementation(
            RetrofitImplementation()
        )
    }
    single<Repository<List<DataModel>>>(named(NAME_LOCAL)) {
        RepositoryImplementation(
            RoomDataBaseImplementation()
        )
    }
}

val mainScreen = module {
    factory { MainInteractor(get(named(NAME_REMOTE)), get(named(NAME_LOCAL))) }
    factory { MainViewModel(get()) }
}
