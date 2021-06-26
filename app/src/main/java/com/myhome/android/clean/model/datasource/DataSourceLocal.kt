package com.myhome.android.clean.model.datasource

import com.myhome.android.clean.model.data.DataModel
import io.reactivex.Observable

class DataSourceLocal(
    private val remoteProvider: RoomDataBaseImplementation =
        RoomDataBaseImplementation()
) : DataSource<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> =
        remoteProvider.getData(word)
}