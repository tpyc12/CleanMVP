package com.myhome.android.clean.view.main

import com.myhome.android.clean.di.NAME_LOCAL
import com.myhome.android.clean.di.NAME_REMOTE
import com.myhome.android.clean.model.data.AppState
import com.myhome.android.clean.model.data.DataModel
import com.myhome.android.clean.model.repository.Repository
import com.myhome.android.clean.viewmodel.Interactor
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Named

class MainInteractor @Inject constructor(
    @Named(NAME_REMOTE) val remoteRepository: Repository<List<DataModel>>,
    @Named(NAME_LOCAL) val localRepository: Repository<List<DataModel>>
) : Interactor<AppState> {

    override fun getData(word: String, fromRemoteSource: Boolean): Observable<AppState> {
        if (word.isBlank()) return Observable.error(Throwable())
        if (word.contains(";")) return Observable.error(Throwable())

        return if (fromRemoteSource) {
            remoteRepository.getData(word).map { AppState.Success(it) }
        } else {
            localRepository.getData(word).map { AppState.Success(it) }
        }
    }
}