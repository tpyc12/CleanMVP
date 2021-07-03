package com.myhome.android.clean.view.main

import com.myhome.android.clean.model.data.AppState
import com.myhome.android.clean.model.data.DataModel
import com.myhome.android.clean.model.repository.Repository
import com.myhome.android.clean.viewmodel.Interactor
import io.reactivex.Observable

class MainInteractor(
    private val remoteRepository: Repository<List<DataModel>>,
    private val localRepository: Repository<List<DataModel>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            if (fromRemoteSource) {
                remoteRepository
            } else {
                localRepository
            }.getData(word)
        )
    }
}